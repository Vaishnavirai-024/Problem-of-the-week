//                            1. Brute-Force Approach – Sort-Based Anagram Check

import java.util.*;

public class BruteForceStepWords {
    public static List<String> findStepWords(String base, Set<String> dictionary) {
        List<String> result = new ArrayList<>();
        char[] baseArr = base.toCharArray();
        Arrays.sort(baseArr);

        for (String word : dictionary) {
            if (word.length() != base.length() + 1) continue;

            char[] wordArr = word.toCharArray();
            Arrays.sort(wordArr);

            // Check if baseArr is a subset of wordArr by removing one char
            for (int i = 0; i < wordArr.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < wordArr.length; j++) {
                    if (j != i) sb.append(wordArr[j]);
                }
                if (sb.toString().equals(new String(baseArr))) {
                    result.add(word);
                    break;
                }
            }
        }

        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String base = sc.nextLine();
        int n = Integer.parseInt(sc.nextLine());
        Set<String> dict = new HashSet<>();
        for (int i = 0; i < n; i++) dict.add(sc.nextLine());

        List<String> stepWords = findStepWords(base, dict);
        for (String word : stepWords) System.out.println(word);
    }
}

// .........................................................................................................................

//                                   2. Optimized Frequency Count Approach (Best)

import java.util.*;

public class StepWordsFrequency {
    public static List<String> findStepWords(String base, List<String> dictionary) {
        int[] baseFreq = getFrequency(base);
        List<String> result = new ArrayList<>();

        for (String word : dictionary) {
            if (word.length() != base.length() + 1) continue;

            int[] wordFreq = getFrequency(word);
            int diffCount = 0;
            boolean valid = true;

            for (int i = 0; i < 26; i++) {
                if (wordFreq[i] < baseFreq[i]) {
                    valid = false;
                    break;
                }
                int diff = wordFreq[i] - baseFreq[i];
                if (diff > 1) {
                    valid = false;
                    break;
                }
                if (diff == 1) diffCount++;
            }

            if (valid && diffCount == 1) result.add(word);
        }

        Collections.sort(result);
        return result;
    }

    private static int[] getFrequency(String word) {
        int[] freq = new int[26];
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }
        return freq;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String base = sc.nextLine();
        int n = Integer.parseInt(sc.nextLine());
        List<String> dict = new ArrayList<>();
        for (int i = 0; i < n; i++) dict.add(sc.nextLine());

        List<String> stepWords = findStepWords(base, dict);
        for (String word : stepWords) System.out.println(word);
    }
}


