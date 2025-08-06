import java.util.*;

public class PredictiveTyping {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEnd = false;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node = node.children.computeIfAbsent(c, k -> new TrieNode());
            }
            node.isEnd = true;
        }

        List<String> suggest(String prefix) {
            List<String> results = new ArrayList<>();
            TrieNode node = root;

            for (char c : prefix.toCharArray()) {
                node = node.children.get(c);
                if (node == null) return results;
            }

            dfs(node, prefix, results);
            return results;
        }

        void dfs(TrieNode node, String path, List<String> list) {
            if (node.isEnd) list.add(path);
            for (char c : node.children.keySet()) {
                dfs(node.children.get(c), path + c, list);
            }
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] corpus = {"hello", "hell", "heat", "heavy", "hero", "heron", "her"};
        for (String word : corpus) trie.insert(word);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter prefix: ");
        String input = sc.nextLine();

        List<String> suggestions = trie.suggest(input);
        if (suggestions.isEmpty()) {
            System.out.println("No suggestions.");
        } else {
            System.out.println("Suggestions: " + suggestions);
        }
    }
}
