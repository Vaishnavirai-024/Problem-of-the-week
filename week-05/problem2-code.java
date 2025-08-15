// Approach1_DFS.java
import java.util.*;

public class Approach1_DFS {

    public static void floodFillDFS(char[][] image, int sr, int sc, char newColor) {
        char originalColor = image[sr][sc];

        // If starting pixel already has the new color, no change is needed
        if (originalColor == newColor) return;

        dfs(image, sr, sc, originalColor, newColor);
    }

    private static void dfs(char[][] image, int r, int c, char originalColor, char newColor) {
        // Boundary check
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length) return;

        // Only fill pixels of the original color
        if (image[r][c] != originalColor) return;

        // Change the color
        image[r][c] = newColor;

        // Explore in 4 directions
        dfs(image, r - 1, c, originalColor, newColor); // up
        dfs(image, r + 1, c, originalColor, newColor); // down
        dfs(image, r, c - 1, originalColor, newColor); // left
        dfs(image, r, c + 1, originalColor, newColor); // right
    }

    // Testing
    public static void main(String[] args) {
        char[][] image = {
            {'B', 'B', 'W'},
            {'W', 'W', 'W'},
            {'W', 'W', 'W'},
            {'B', 'B', 'B'}
        };
        int sr = 2, sc = 2;
        char newColor = 'G';

        System.out.println("Before Fill:");
        printImage(image);

        floodFillDFS(image, sr, sc, newColor);

        System.out.println("\nAfter DFS Fill:");
        printImage(image);
    }

    private static void printImage(char[][] image) {
        for (char[] row : image) {
            System.out.println(Arrays.toString(row));
        }
    }
}


// ....................................................................................................................

// Approach2_BFS.java
import java.util.*;

public class Approach2_BFS {

    public static void floodFillBFS(char[][] image, int sr, int sc, char newColor) {
        char originalColor = image[sr][sc];

        // If starting pixel already has the new color, no change
        if (originalColor == newColor) return;

        int rows = image.length;
        int cols = image[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});

        while (!queue.isEmpty()) {
            int[] pixel = queue.poll();
            int r = pixel[0], c = pixel[1];

            // Only fill pixels of the original color
            if (image[r][c] == originalColor) {
                image[r][c] = newColor;

                // 4-directional movement
                if (r > 0) queue.add(new int[]{r - 1, c}); // up
                if (r < rows - 1) queue.add(new int[]{r + 1, c}); // down
                if (c > 0) queue.add(new int[]{r, c - 1}); // left
                if (c < cols - 1) queue.add(new int[]{r, c + 1}); // right
            }
        }
    }

    // Testing
    public static void main(String[] args) {
        char[][] image = {
            {'B', 'B', 'W'},
            {'W', 'W', 'W'},
            {'W', 'W', 'W'},
            {'B', 'B', 'B'}
        };
        int sr = 2, sc = 2;
        char newColor = 'G';

        System.out.println("Before Fill:");
        printImage(image);

        floodFillBFS(image, sr, sc, newColor);

        System.out.println("\nAfter BFS Fill:");
        printImage(image);
    }

    private static void printImage(char[][] image) {
        for (char[] row : image) {
            System.out.println(Arrays.toString(row));
        }
    }
}
