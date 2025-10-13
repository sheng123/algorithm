package trie_tree;

public class TrieNode {
    public int pass; // 表示有多少个字符串加入
    public int end; // 表示在该节点结束的字符串有多少个
    public TrieNode[] nexts; // 表示下一跳的路径

    public TrieNode() {
        pass = 0;
        end = 0;
        // nexts[0] == null 表示没有走向 a 的路
        nexts = new TrieNode[26];
    }
}
