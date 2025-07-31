//                          Approach 1: Convert Rows and Columns to Strings

// WordSearch.java – Approach 1
// Time Complexity: O(M × N)
// Space Complexity: O(1)

public class WordSearch {

    // Main function to check word in matrix
    public static boolean wordExists(char[][] matrix, String word) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Step 1: Check row-wise (left to right)
        for (int i = 0; i < rows; i++) {
            StringBuilder rowStr = new StringBuilder();
            for (int j = 0; j < cols; j++) {
                rowStr.append(matrix[i][j]);
            }
            // Check if word exists in the current row string
            if (rowStr.toString().contains(word)) return true;
        }

        // Step 2: Check column-wise (top to bottom)
        for (int j = 0; j < cols; j++) {
            StringBuilder colStr = new StringBuilder();
            for (int i = 0; i < rows; i++) {
                colStr.append(matrix[i][j]);
            }
            // Check if word exists in the current column string
            if (colStr.toString().contains(word)) return true;
        }

        // If not found in any row or column
        return false;
    }

    // Test case
    public static void main(String[] args) {
        char[][] matrix = {
            {'F', 'A', 'C', 'I'},
            {'O', 'B', 'Q', 'P'},
            {'A', 'N', 'O', 'B'},
            {'M', 'A', 'S', 'S'}
        };

        String word = "FOAM";

        boolean result = wordExists(matrix, word);
        System.out.println("Word found: " + result);
    }
}

// ...............................................................................................................................

//                        Approach 2: Manual Char-by-Char Match Without Converting to Strings

// WordSearchManual.java – Approach 2
// Time Complexity: O(M × N × L), where L is word length

public class WordSearchManual {

    public static boolean wordExists(char[][] matrix, String word) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int len = word.length();

        // Step 1: Check each row
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= cols - len; j++) {
                int k = 0;
                while (k < len && matrix[i][j + k] == word.charAt(k)) {
                    k++;
                }
                if (k == len) return true; // Found horizontally
            }
        }

        // Step 2: Check each column
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i <= rows - len; i++) {
                int k = 0;
                while (k < len && matrix[i + k][j] == word.charAt(k)) {
                    k++;
                }
                if (k == len) return true; // Found vertically
            }
        }

        return false; // Not found
    }

    public static void main(String[] args) {
        char[][] matrix = {
            {'F', 'A', 'C', 'I'},
            {'O', 'B', 'Q', 'P'},
            {'A', 'N', 'O', 'B'},
            {'M', 'A', 'S', 'S'}
        };

        String word = "MASS";
        System.out.println("Word found: " + wordExists(matrix, word));
    }
}
