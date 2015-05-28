import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class TypesArraysStrings {

    public final int getOddOccurrence(final int[] arr) {
        final int len = arr.length;
        int oddNumber = 0;
        for (int i = len - 1; i >= 0; i--) {
            oddNumber = oddNumber ^ arr[i];
        }
        return oddNumber;
    }

    public final int maxSpan(final int[] numbers) {
        int largest = 1;
        for (int i = 0; i < numbers.length; i++) {
            if (largest >= numbers.length - i)
                break;
            for (int j = numbers.length - 1; j > i - 1; j--) {
                if (j - i + 1 < largest)
                    break;
                if (numbers[i] == numbers[j]) {
                    largest = Math.max(largest, j - i + 1);
                    break;
                }
            }
        }
        return largest;
    }

    public final boolean canBalance(final int[] arr) {
        int rightSum = 0, leftSum = 0;
        for (int i = 0; i < arr.length >> 1; i++) {
            leftSum += arr[i];
        }

        for (int i = arr.length >> 1; i < arr.length; i++) {
            rightSum += arr[i];
        }

        if (leftSum == rightSum)
            return true;

        if ((leftSum + rightSum) % 2 != 0)
            return false;

        if (leftSum > rightSum) {
            for (int i = arr.length >> 1; i > 0; i--) {
                rightSum += arr[i];
                leftSum -= arr[i];
                if (rightSum == leftSum)
                    return true;
                if (rightSum > leftSum)
                    break;
            }
        }

        else {
            for (int i = arr.length >> 1; i < arr.length; i++) {
                rightSum -= arr[i];
                leftSum += arr[i];
                if (rightSum == leftSum)
                    return true;
                if (leftSum > rightSum)
                    break;
            }
        }

        return false;
    }

    public final boolean hasAnagramOf(String a, String b) {
        if (a.length() > b.length())
            return false;
        int counter = a.length();
        ArrayList<Character> bSet = new ArrayList<Character>();
        for (char bc : b.toLowerCase().toCharArray()) {
            bSet.add(bc);
        }

        for (char ac : a.toLowerCase().toCharArray()) {
            if (bSet.contains(ac))
                counter--;
        }

        return counter == 0;
    }

    public final String reverseEveryChar(final String arg) {
        StringBuilder reversed = new StringBuilder(arg.length());
        StringBuilder helper = new StringBuilder(arg.length());
        final char[] charss = arg.toCharArray();

        for (char c : charss) {
            if (c != ' ' && c != charss.length - 1) {
                helper.append(c);
            } else {
                reversed.append(helper.reverse().toString());
                reversed.append(' ');
                helper.setLength(0);
            }
        }
        reversed.append(helper.reverse().toString());

        return reversed.toString();
    }

    public final String copyEveryChar(final String input, final int k) {
        StringBuilder copied = new StringBuilder(input.length() * k);
        final char[] ch = input.toCharArray();
        for (char c : ch) {
            for (int i = 0; i < k; i++) {
                copied.append(c);
            }
        }
        return copied.toString();
    }

    public final int sumOfNumbers(final String input) {
        int answer = 0;
        final char[] ch = input.toCharArray();
        StringBuilder sb = new StringBuilder(input.length());
        for (char c : ch) {
            if (!Character.isDigit(c) && c != '-')
                sb.append(' ');
            else
                sb.append(c);
        }
        final String[] numbers = sb.toString().split(" ");
        for (String s : numbers) {
            if (isNumeric(s)) {
                answer += Integer.parseInt(s);
            }
        }
        return answer;
    }

    public final boolean anagram(final String a, final String b) {
        if (a.length() != b.length())
            return false;
        final char[] aChar = a.toLowerCase().toCharArray();
        final char[] bChar = b.toLowerCase().toCharArray();
        Arrays.sort(aChar);
        Arrays.sort(bChar);
        return Arrays.equals(aChar, bChar);
    }

    public final long maximalScalarSum(final int[] a, final int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        long maxScalarSum = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            maxScalarSum += a[i] * b[i];
        }
        return maxScalarSum;
    }

    public final int getPalindromeLength(final String input) {
        int counter = 0;
        final int zeroInd = input.indexOf('*');

        if (zeroInd == 0)
            return 0;

        for (int i = 1; i < input.length() - zeroInd; i++) {
            if (counter >= zeroInd)
                break;
            if (input.charAt(zeroInd + i) == input.charAt(zeroInd - i))
                counter++;
            else
                break;
        }
        return counter;
    }

    public final long greatestCommonDivisor(final long a, final long b) {
        return b == 0 ? a : greatestCommonDivisor(b, a % b);
    }

    public final long leastCommonMultiple(final long a, final int b) {
        return Math.abs(a * b) / greatestCommonDivisor(a, b);
    }

    public final long getSmallestMultiple(final int upperBound) {
        long smallestMultiple = 1;
        for (int i = 1; i <= upperBound; i++) {
            smallestMultiple = leastCommonMultiple(smallestMultiple, i);
        }
        return smallestMultiple;
    }

    public final long pow(final int a, final int b) {
        if (b == 0)
            return 1;
        else if (b % 2 == 1)
            return a * pow(a, b - 1);
        else {
            long p = pow(a, b >> 1);
            return p * p;
        }
    }

    public final int kthMin(final int k, final int[] arr) {
        Arrays.sort(arr);
        return arr[k - 1];
    }

    public final double getAvarage(final int[] arr) {
        double total = 0;
        for (int i : arr) {
            total += i;
        }
        return total / arr.length;
    }

    public final long doubleFac(final int n) {
        long doubleFactorial = 1;
        for (int i = n; i > 1; i--) {
            doubleFactorial *= i;
        }
        for (int i = (int) doubleFactorial; i > n; i--) {
            doubleFactorial *= i;
        }
        return doubleFactorial;
    }

    public final long kthFac(final int k, final int n) {
        long kthFact = 1;
        for (int i = n; i > 0; i -= k) {
            kthFact *= i;
        }
        return kthFact;
    }

    public final String reverseMe(final String argument) {
        return new StringBuilder(argument).reverse().toString();
    }

    public final boolean isOdd(final int n) {
        return (n % 2 != 0) ? true : false;
    }

    public final boolean isPrime(final int n) {
        if (n <= 3) {
            return n > 0;
        } else if (n % 2 == 0 || n % 3 == 0) {
            return false;
        } else {
            final double sqrtN = Math.floor(Math.sqrt(n));
            for (int i = 5; i <= sqrtN; i += 6) {
                if (n % i == 0 || n % (i + 2) == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public final int min(final int... arr) {
        int min = Integer.MAX_VALUE;
        for (int currentElement : arr) {
            if (currentElement < min)
                min = currentElement;
        }
        return min;
    }

    public final long getLargestPalindrome(final long n) {
        long largest = n - 1;
        while (!isPalindrome(largest)) {
            largest--;
        }
        return largest;
    }

    public final boolean isPalindrome(final long n) {
        return isPalindrome(Long.toString(n));
    }

    public final boolean isPalindrome(final String arg) {
        for (int i = 0; i < arg.length() >> 1; i++) {
            if (arg.charAt(i) != arg.charAt(arg.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public final String decodeURL(final String input) {
        return input.replaceAll("%20", " ").replaceAll("%3A", ":").replaceAll("%3D", "?").replaceAll("%2F", "/");
    }

    public final boolean isNumeric(final String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public final int countOcurrences(final String needle, final String haystack) {
        return (haystack.length() - haystack.replace(needle, "").length()) / needle.length();
    }

    public final int[] histogram(final short[][] image) {
        int[] arr = new int[256];
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                arr[image[i][j]]++;
            }
        }
        return arr;
    }

    public final void convertToGrayscale(Path imgPath) throws IOException {
        Color imgColor, newColor;
        final File inputImage = new File(imgPath.toString());
        final BufferedImage bufferImage = ImageIO.read(inputImage);
        final int imgHeight = bufferImage.getHeight();
        final int imgWidth = bufferImage.getWidth();
        for (int i = 0; i < imgWidth; i++) {
            for (int j = 0; j < imgHeight; j++) {
                imgColor = new Color(bufferImage.getRGB(i, j));
                int colorSum = (int) (imgColor.getRed() * 0.2126) + (int) (imgColor.getBlue() * 0.0722)
                        + (int) (imgColor.getGreen() * 0.7152);
                newColor = new Color(colorSum, colorSum, colorSum);
                bufferImage.setRGB(i, j, newColor.getRGB());
            }
        }
        final File outputImage = new File("inputFileGrayscale.jpg");
        if (imgPath.toString().endsWith(".jpg"))
            ImageIO.write(bufferImage, "jpg", outputImage);
        else if (imgPath.toString().endsWith(".bmp"))
            ImageIO.write(bufferImage, "bmp", outputImage);
        else if (imgPath.toString().endsWith(".png"))
            ImageIO.write(bufferImage, "png", outputImage);
    }

    public final int[][] rescale(final int[][] original, final int newWidth, final int newHeight) {
        final int[][] rescaled = new int[newWidth][newHeight];
        final int widthRatio = original.length / newWidth;
        final int heightRatio = original[0].length / newHeight;
        for (int i = 0; i < widthRatio; i++) {
            for (int j = 0; j < heightRatio; j++) {
                rescaled[i][j] = original[widthRatio * i][heightRatio * j];
            }
        }
        return rescaled;
    }
}
