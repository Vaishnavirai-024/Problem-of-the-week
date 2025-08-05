                                                                  // Approach 1: Optimized using HashSet
 
import java.util.*;

public class FirstRecurringCharacter {

  
    public static Character firstRecurringCharSet(String s) {
        Set<Character> seen = new HashSet<>();
        for (char ch : s.toCharArray()) {
            if (seen.contains(ch)) {
                return ch;
            }
            seen.add(ch);
        }
        return null;
    }

  // ...........................................................................................................................................

    //                                                        Approach 2: Using HashMap to track first index
  
    public static Character firstRecurringCharMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int minSecondIndex = s.length();
        Character result = null;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (i < minSecondIndex) {
                    minSecondIndex = i;
                    result = ch;
                }
            } else {
                map.put(ch, i);
            }
        }
        return result;
    }

  // ...........................................................................................................................................
  

    //                                                                 Approach 3: Brute Force (O(n^2))
  
    public static Character firstRecurringCharBrute(String s) {
        int minSecondIndex = s.length();
        Character result = null;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j < minSecondIndex) {
                        minSecondIndex = j;
                        result = s.charAt(i);
                    }
                    break; // stop after first repeat
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(" Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("\n--- Results from Different Approaches ---");

        Character resultSet = firstRecurringCharSet(input);
        System.out.println(" Using HashSet (Optimized): " + (resultSet != null ? resultSet : "null"));

        Character resultMap = firstRecurringCharMap(input);
        System.out.println(" Using HashMap with Index: " + (resultMap != null ? resultMap : "null"));

        Character resultBrute = firstRecurringCharBrute(input);
        System.out.println(" Brute Force Approach: " + (resultBrute != null ? resultBrute : "null"));

        scanner.close();
    }
}
