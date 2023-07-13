package algorithm.datastructure;/**
 *
 */



/**
 *@ClassName TrieNode
 *@Description 前缀树
 *@Author wuhao51
 *@Date 2023/1/13 17:27
 *@Version 1.0
 **/
public class TrieNode {
    private TrieNode[] children;
    private boolean isEnd;

    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }

    public void insert(String word) {
        TrieNode root = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (root.children[index] == null) root.children[index] = new TrieNode();
            root = root.children[index];
        }
        root.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    private TrieNode searchPrefix(String word) {
        TrieNode root = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (root.children[index] == null) return null;
            root = root.children[index];
        }
        return root;
    }
}
