package algorithm.codetop;/**
 *
 */

/**
 *@ClassName LeetCode208
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/1/17 15:14
 *@Version 1.0
 **/
public class LeetCode208 {
    class Trie {
        private Trie[] children;
        private boolean isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie root = this;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (root.children[index] == null) root.children[index] = new Trie();
                root = root.children[index];
            }
            root.isEnd = true;
        }

        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            Trie node = searchPrefix(prefix);
            return node != null;
        }

        private Trie searchPrefix(String word) {
            Trie root = this;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (root.children[index] == null) return null;
                root = root.children[index];
            }
            return root;
        }

    }
}
