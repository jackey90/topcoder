package org.jackey.datastructure.tree;

public class Trie {

    private Node root;

    public Trie(){
        root = new Node();
    }

    void addWord(String word){
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int index = c - 'a';
            Node child = node.children[index];
            if(node.children[index] == null){
                child = new Node();
                node.children[index] = child;
                node = child;
            }
            node = child;
        }
        node.isEnd = true;
    }

    boolean search(String word){
        Node node = findNode(word,root,0);
        return node != null && node.isEnd;
    }

    boolean startWith(String word){
        Node node = findNode(word,root,0);
        return node != null;
    }

    /**
     * 从cur这个node开始，查找从i开始是否存在这个Node
     * @param word
     * @param cur
     * @param i
     * @return
     */
    private Node findNode(String word, Node cur, int i){
        Node node = cur;
        for(; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c == '.'){
                for(int j = 0; j < 26; j++){
                    Node child = node.children[j];
                    if(child != null){
                        Node find = findNode(word,child, i + 1);
                        if(find != null){
                            return find;
                        }
                    }
                }
                return null;
            } else {
                int index = c - 'a';
                Node child = node.children[index];
                if (child == null) {
                    return null;
                }
                node = child;
            }
        }
        return node;
    }

    class Node{
        boolean isEnd;
        Node[] children;

        public Node(){
            this.isEnd = false;
            children = new Node[26];
        }

        public Node(boolean isEnd){
            this.isEnd = isEnd;
            children = new Node[26];
        }
    }

}
