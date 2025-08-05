//  1. Approach: Brute Force (Adjacency Matrix + DFS)

import java.util.*;

public class FriendGroupsMatrixDFS {

    // Function to count friend groups using matrix and DFS
    public static int countGroups(int N, Map<Integer, List<Integer>> friendship) {
        int[][] matrix = new int[N][N]; // Create adjacency matrix

        // Fill the matrix using the friendship map
        for (int i = 0; i < N; i++) {
            for (int friend : friendship.getOrDefault(i, new ArrayList<>())) {
                matrix[i][friend] = 1;
                matrix[friend][i] = 1; // Because friendship is mutual
            }
        }

        boolean[] visited = new boolean[N]; // Track visited students
        int groups = 0; // Count of friend groups

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(i, visited, matrix, N); // Explore group using DFS
                groups++; // One full group found
            }
        }

        return groups;
    }

    // DFS to explore connected friends
    private static void dfs(int student, boolean[] visited, int[][] matrix, int N) {
        visited[student] = true;

        for (int i = 0; i < N; i++) {
            if (matrix[student][i] == 1 && !visited[i]) {
                dfs(i, visited, matrix, N);
            }
        }
    }
}


// ...............................................................................................................................

//   2. Approach: DFS with Adjacency List

import java.util.*;

public class FriendGroupsDFS {

    // Count groups using DFS and adjacency list
    public static int countGroups(int N, Map<Integer, List<Integer>> friendship) {
        boolean[] visited = new boolean[N];
        int groups = 0;

        // Go through each student
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(i, friendship, visited); // Start DFS
                groups++; // One group complete
            }
        }

        return groups;
    }

    // Recursive DFS to visit all friends in the group
    private static void dfs(int student, Map<Integer, List<Integer>> graph, boolean[] visited) {
        visited[student] = true;

        for (int friend : graph.getOrDefault(student, new ArrayList<>())) {
            if (!visited[friend]) {
                dfs(friend, graph, visited);
            }
        }
    }
}

// ...............................................................................................................................

//  3. Approach: BFS with Adjacency List

import java.util.*;

public class FriendGroupsBFS {

    // Count groups using BFS (queue-based)
    public static int countGroups(int N, Map<Integer, List<Integer>> friendship) {
        boolean[] visited = new boolean[N];
        int groups = 0;

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                bfs(i, friendship, visited); // Start BFS
                groups++; // One group complete
            }
        }

        return groups;
    }

    // BFS to explore all connected friends
    private static void bfs(int start, Map<Integer, List<Integer>> graph, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int student = queue.poll();

            for (int friend : graph.getOrDefault(student, new ArrayList<>())) {
                if (!visited[friend]) {
                    visited[friend] = true;
                    queue.offer(friend); // Visit friend
                }
            }
        }
    }
}

// ...............................................................................................................................


//  4. Approach: Union-Find (Disjoint Set)

import java.util.*;

public class FriendGroupsUnionFind {

    // DSU class to manage union-find logic
    static class DSU {
        int[] parent;

        // Initialize each student as their own parent
        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        // Find function with path compression
        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        // Union two groups (students)
        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py)
                parent[px] = py;
        }
    }

    // Count groups using Union-Find
    public static int countGroups(int N, Map<Integer, List<Integer>> friendship) {
        DSU dsu = new DSU(N);

        // Union all friends
        for (int student : friendship.keySet()) {
            for (int friend : friendship.get(student)) {
                dsu.union(student, friend);
            }
        }

        // Count unique parents → unique groups
        Set<Integer> uniqueParents = new HashSet<>();
        for (int i = 0; i < N; i++) {
            uniqueParents.add(dsu.find(i));
        }

        return uniqueParents.size();
    }
}
