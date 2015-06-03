package smallestSubstringContainingTheAlphabet;

import java.util.HashSet;

class SmallestSubstringContainingTheAlphabet {
	private static final HashSet<Character> ALPHABET_CHARS = new HashSet<Character>();
	private static final char[] ALPHABET = { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
			'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
			'u', 'v', 'w', 'x', 'y', 'z' };

	private static String subString;
	private static char[] strChar;

	private final static String smallestSubstrContTheAlphabet(String inputString) {
		inputString = inputString.toLowerCase();
		String smallest = null;

		final int strLength = inputString.length();
		int index, secInd;
		int curMin = Integer.MAX_VALUE;

		for (index = strLength - 1; index >= 0; index--) {
			for (secInd = strLength - index; secInd > 1; secInd--) {

				subString = inputString.substring(index, index + secInd);

				final int sLen = subString.length();

				boolean isLarger = sLen >= 26;
				boolean firstChar = Character.isAlphabetic(subString.charAt(0));
				boolean lastChar = Character.isAlphabetic(subString
						.charAt(sLen - 1));

				if (isLarger && firstChar && lastChar) {
					if (sLen < curMin) {
						if (containsAlphabet(subString)) {
							curMin = sLen;
							smallest = subString;
						}
					}

				}
			}

		}

		return smallest;
	}

	private final static boolean containsAlphabet(final String inputSubstring) {
		strChar = inputSubstring.toCharArray();
		for (Character ch : ALPHABET) {
			ALPHABET_CHARS.add(ch);
		}

		for (Character ch : strChar) {
			if (ALPHABET_CHARS.contains(ch))
				ALPHABET_CHARS.remove(ch);
		}

		return ALPHABET_CHARS.isEmpty() ? true : false;

	}

	public static final void main(String[] args) {
		String in = "abcdefghijklmn1215tai54hppmatpoclalwypepw[q362732m211hmyewov,weotowahaoiysoapwfp2166[pqlamsortev245fokr@#$%^&*opq5fokr@#$%^&*"
				+ "opq5fokr@#$%^&*opq345678!osfookrqok5fokr@#$%^&*opq5fokr@#$%^&*op5fokr@#$%^&*op5fokr@#$%^&*o5fokr@#$%^&*opqpqqq21ok5ook1o51ok1"
				+ "9gsgsskepparewqwtptl5fokr@#$%^&*opqgjgismknxvhguapa205fokr@#$%^&*opqrstuvw11hmy5fokr@#$%^&*opqewov,w5fokr@#$%^&*opqeotowahxyz!*abcdefghijklmn";
		long start = System.currentTimeMillis();
		System.out.println(smallestSubstrContTheAlphabet(in));
        System.out.println(System.currentTimeMillis() - start);
    }
}
