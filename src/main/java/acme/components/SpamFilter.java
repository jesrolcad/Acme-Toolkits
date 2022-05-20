
package acme.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpamFilter {

	public static Boolean spamValidator(final String text, final String weakSpamWords, final String strongSpamWords,final double weakThreshold,final double strongThreshold) {
		Boolean res;
		Boolean weakSpamCondition;
		Boolean strongSpamCondition;

		String[] weak = weakSpamWords.trim().split(",");
		List<String> weakList = new ArrayList<String>();
		for (String s : weak) {
			weakList.add(s);
		}
		String[] strong = strongSpamWords.trim().split(",");
		List<String> strongList = new ArrayList<String>();
		for (String s : strong) {
			strongList.add(s);
		}

		final String myRegexStrong = SpamFilter.regexBuilder(strongList);
		final String myRegexWeak = SpamFilter.regexBuilder(weakList);

		final Double strongPercentage = SpamFilter.percentageSpamWords(myRegexStrong, text);
		final Double weakPercentage = SpamFilter.percentageSpamWords(myRegexWeak, text);
		strongSpamCondition=strongPercentage<=strongThreshold;
		weakSpamCondition=weakPercentage<=weakThreshold;
		res = weakSpamCondition && strongSpamCondition;
		return res;
	}
	private static double percentageSpamWords(final String myRegex, final String text) {
		final Pattern pattern = Pattern.compile(myRegex, Pattern.CASE_INSENSITIVE);
		final Matcher matchResult = pattern.matcher(text);
		final int totalNumberOfWords = SpamFilter.wordsInText(text);
		final int totalMatches = SpamFilter.countMatches(matchResult);
		return ((double) totalMatches / (double) totalNumberOfWords) * 100.0;
	}
	private static int countMatches(final Matcher matchResult) {
		int count = 0;
		while (matchResult.find()) {
			count++;
		}
		return count;
	}
	private static int wordsInText(final String text) {
		String[] resultArray = Arrays.stream(text.split(",")).filter(e -> e.trim().length() > 0).toArray(String[]::new);
		return resultArray.length;

	}
	private static String regexBuilder(final List<String> spamWords) {
		final StringBuilder regexBuilder = new StringBuilder();
		for (int i = 0; i < spamWords.size(); i++) {
			final String word = spamWords.get(i);
			final String[] parts = word.split(" ");
			if (parts.length > 1) {
				final StringBuilder auxBuilder = new StringBuilder();
				for (int j = 0; j < parts.length; j++) {
					if (j == parts.length - 1) {
						auxBuilder.append(parts[j]);
					} else {
						auxBuilder.append(parts[j] + "[^\\w]*");
					}
				}
				if (i == spamWords.size() - 1) {
					regexBuilder.append(auxBuilder.toString());
				} else {
					regexBuilder.append(auxBuilder.toString() + "|");
				}
			} else {
				if (i == spamWords.size() - 1) {
					regexBuilder.append(word);
				} else {
					regexBuilder.append(word + "|");
				}
			}
		}
		return regexBuilder.toString();
	}
}
