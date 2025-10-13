package trie_tree;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("hello");

        int times = trie.search("hello");
        System.out.println("search: " + times);
        times = trie.prefixNumber("hell");
        System.out.println("prefix number: " + times);

        trie.delete("hello");
        times = trie.search("hello");
        System.out.println("search: " + times);
    }
}
