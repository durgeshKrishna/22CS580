import java.util.Arrays;
public class Main2{

    public static void findRepeatedWords(String S) {
        String[] words = S.split("\\s+");
        int[] wordCount = new int[words.length];
        Arrays.fill(wordCount, 1);

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    wordCount[i]++;
                    words[j] = "";
                }
            }
        }

        String[] repeatedWords = new String[words.length];
        int index = 0;
        for (int i = 0; i < words.length; i++) {
            if (wordCount[i] > 1 && !words[i].isEmpty()) {
                repeatedWords[index++] = words[i];
            }
        }

        if (index == 0) {
            System.out.println(-1);
            return;
        }

        String[] result = new String[index];
        System.arraycopy(repeatedWords, 0, result, 0, index);
        bubbleSort(result, words);

        for (String word : result) {
            System.out.print(word + " ");
        }
    }

    public static void bubbleSort(String[] repeatedWords, String[] words) {
        int n = repeatedWords.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (shouldSwap(repeatedWords[j], repeatedWords[j + 1], words)) {
                    String temp = repeatedWords[j];
                    repeatedWords[j] = repeatedWords[j + 1];
                    repeatedWords[j + 1] = temp;
                }
            }
        }
    }

    public static boolean shouldSwap(String word1, String word2, String[] words) {
        if (word1.length() < word2.length()) {
            return true;
        }
        if (word1.length() == word2.length()) {
            return indexOf(words, word1) > indexOf(words, word2);
        }
        return false;
    }

    public static int indexOf(String[] words, String target) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String S1 = "when there is a will there is a way";
        String S2 = "Adversity and loss make a man wise";
        String S3 = "If You are not part of the solution you are part of the problem";

        findRepeatedWords(S1);
        System.out.println();
        findRepeatedWords(S2);
        System.out.println();
        findRepeatedWords(S3);
    }
}
