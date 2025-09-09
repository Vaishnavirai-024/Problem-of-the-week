import java.util.*;

public class AutocompleteSystem {

    // Approach 1: Brute-force search
    public static List<String> autocompleteBruteForce(String[] dict, String prefix) {
        List<String> result = new ArrayList<>();
        for (String word : dict) {
            if (word.startsWith(prefix)) {
                result.add(word);
            }
        }
        return result;
    }

    // Approach 2: Trie-based efficient search
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord = false;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        // Insert word into Trie
        public void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                node = node.children.computeIfAbsent(ch, k -> new TrieNode());
            }
            node.isEndOfWord = true;
        }

        // Search for words with given prefix
        public List<String> searchWithPrefix(String prefix) {
            List<String> result = new ArrayList<>();
            TrieNode node = root;
            for (char ch : prefix.toCharArray()) {
                if (!node.children.containsKey(ch)) {
                    return result; // no words found
                }
                node = node.children.get(ch);
            }
            // DFS from this node
            dfs(node, new StringBuilder(prefix), result);
            return result;
        }

        private void dfs(TrieNode node, StringBuilder path, List<String> result) {
            if (node.isEndOfWord) {
                result.add(path.toString());
            }
            for (char ch : node.children.keySet()) {
                path.append(ch);
                dfs(node.children.get(ch), path, result);
                path.deleteCharAt(path.length() - 1); // backtrack
            }
        }
    }

    public static List<String> autocompleteTrie(String[] dict, String prefix) {
        Trie trie = new Trie();
        for (String word : dict) {
            trie.insert(word);
        }
        return trie.searchWithPrefix(prefix);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int n = sc.nextInt();
        String[] dict = new String[n];
        for (int i = 0; i < n; i++) {
            dict[i] = sc.next();
        }
        String prefix = sc.next();

        // Output for both approaches
        List<String> bruteForceResult = autocompleteBruteForce(dict, prefix);
        System.out.println("Brute Force Output:");
        for (String word : bruteForceResult) {
            System.out.print(word + " ");
        }
        System.out.println();

        List<String> trieResult = autocompleteTrie(dict, prefix);
        System.out.println("Trie-based Output:");
        for (String word : trieResult) {
            System.out.print(word + " ");
        }
        System.out.println();

        sc.close();
    }
}
