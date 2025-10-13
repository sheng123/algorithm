package trie_tree;

public class Trie {
    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null) {
            return;
        }

        char[] chs = word.toCharArray();
        TrieNode node = root;
        node.pass++;
        for (int i = 0; i < chs.length; i++) {
            int index = chs[i] - 'a';
            if (node.nexts[index] == null) {
                node.nexts[index] = new TrieNode();
            }
            node = node.nexts[index];
            node.pass++;
        }
        node.end++;
    }

    public void delete(String word) {
        if (search(word) != 0) {
            char[] chs = word.toCharArray();
            TrieNode node = root;
            node.pass--;
            for(int i = 0; i < chs.length; i++) {
                int index = chs[i] - 'a';
                if (--node.nexts[index].pass == 0) {
                    node.nexts[index] = null;
                    return;
                }
                node = node.nexts[index];
            }
            node.end--;
        }
    }

    // 所有加入的字符串中，有几个是以pre这个字符串作为前缀的
    public int prefixNumber(String pre) {
        if (pre == null) {
            return 0;
        }
        char[] chs = pre.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < chs.length; i++) {
            int index = chs[i] - 'a';
            if (node.nexts[index] == null) {
                return 0; // 说明该字符串没有加入过前缀树
            }
            node = node.nexts[index];
        }
        return node.pass;
    }

    // 查看一个单词之前加入过几次
    public int search(String word) {
        if (word == null) {
            return 0;
        }
        char[] chs = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < chs.length; i++) {
            int index = chs[i] - 'a';
            if (node.nexts[index] == null) {
                return 0; // 说明该字符串没有加入过前缀树
            }
            node = node.nexts[index];
        }
        return node.end;
    }
}
