                                     // 1. Split + Reconstruct Approach

import java.util.*;

public class ReverseWordsSplit {
    public static String reverseWords(String s) {
        // Split words using regex (non-letters are delimiters)
        String[] words = s.split("[^a-z]+");
        List<String> wordList = new ArrayList<>();
        for (String w : words) {
            if (!w.isEmpty()) wordList.add(w);
        }
        Collections.reverse(wordList);

        StringBuilder result = new StringBuilder();
        int wordIndex = 0;
        for (int i = 0; i < s.length();) {
            if (Character.isLetter(s.charAt(i))) {
                // append next reversed word
                result.append(wordList.get(wordIndex++));
                // skip this word in original string
                while (i < s.length() && Character.isLetter(s.charAt(i))) i++;
            } else {
                result.append(s.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("hello/world:here")); // here/world:hello
        System.out.println(reverseWords("hello/world:here/")); // here/world:hello/
        System.out.println(reverseWords("hello//world:here")); // here//world:hello
    }
}



// .
// 2. Stack-based Approach


import java.util.*;

public class ReverseWordsStack {
    public static String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder temp = new StringBuilder();

        // Extract words into stack
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                temp.append(c);
            } else {
                if (temp.length() > 0) {
                    stack.push(temp.toString());
                    temp.setLength(0);
                }
            }
        }
        if (temp.length() > 0) stack.push(temp.toString());

        StringBuilder result = new StringBuilder();
        temp.setLength(0);

        // Reconstruct
        for (int i = 0; i < s.length();) {
            if (Character.isLetter(s.charAt(i))) {
                String word = stack.pop(); // pop reversed word
                result.append(word);
                // skip original word
                while (i < s.length() && Character.isLetter(s.charAt(i))) i++;
            } else {
                result.append(s.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("hello/world:here"));
        System.out.println(reverseWords("hello/world:here/"));
        System.out.println(reverseWords("hello//world:here"));
    }
}



// 3. Two-Pointer Parsing Approach

import java.util.*;

public class ReverseWordsTwoPointer {
    public static String reverseWords(String s) {
        List<String> words = new ArrayList<>();
        StringBuilder temp = new StringBuilder();

        // Collect words
        for (int i = 0; i < s.length();) {
            if (Character.isLetter(s.charAt(i))) {
                temp.setLength(0);
                while (i < s.length() && Character.isLetter(s.charAt(i))) {
                    temp.append(s.charAt(i));
                    i++;
                }
                words.add(temp.toString());
            } else {
                i++;
            }
        }
        Collections.reverse(words);

        StringBuilder result = new StringBuilder();
        int idx = 0;

        // Rebuild using two pointers
        for (int i = 0; i < s.length();) {
            if (Character.isLetter(s.charAt(i))) {
                result.append(words.get(idx++));
                while (i < s.length() && Character.isLetter(s.charAt(i))) i++;
            } else {
                result.append(s.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("hello/world:here"));
        System.out.println(reverseWords("hello/world:here/"));
        System.out.println(reverseWords("hello//world:here"));
    }
}
