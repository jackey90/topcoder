package org.jackey.datastructure.tree;

public class TestTrie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.addWord("abc");
        System.out.println(trie.search("abc"));
        System.out.println(trie.startWith(".."));
        System.out.println(trie.search("..c"));
    }

}
