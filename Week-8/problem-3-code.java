// Approach 1: DFS with Subtree Sizes (Efficient)


import java.util.*;

public class EvenTreeDFS {
    static List<List<Integer>> graph;
    static int removableEdges = 0;

    public static int dfs(int node, int parent) {
        int size = 1; // count current node
        for (int child : graph.get(node)) {
            if (child != parent) {
                int subtreeSize = dfs(child, node);
                if (subtreeSize % 2 == 0) {
                    // valid edge to cut
                    removableEdges++;
                } else {
                    size += subtreeSize;
                }
            }
        }
        return size;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(1, -1);
        System.out.println(removableEdges);
    }
}



// Approach 2: Brute Force (Not Recommended but for learning)


import java.util.*;

public class EvenTreeBrute {
    static List<List<Integer>> graph;
    static int N;

    // DFS to count subtree size
    static int dfsCount(int node, int parent) {
        int count = 1;
        for (int child : graph.get(node)) {
            if (child != parent) {
                count += dfsCount(child, node);
            }
        }
        return count;
    }

    // Check if all subtrees have even size after removing edge
    static boolean isValidRemoval(int u, int v) {
        // Remove edge u-v
        graph.get(u).remove((Integer) v);
        graph.get(v).remove((Integer) u);

        int size1 = dfsCount(u, -1);
        int size2 = dfsCount(v, -1);

        // Restore edge
        graph.get(u).add(v);
        graph.get(v).add(u);

        return size1 % 2 == 0 && size2 % 2 == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int removableEdges = 0;
        for (int u = 1; u <= N; u++) {
            for (int v : new ArrayList<>(graph.get(u))) {
                if (u < v && isValidRemoval(u, v)) {
                    removableEdges++;
                }
            }
        }

        System.out.println(removableEdges);
    }
}
