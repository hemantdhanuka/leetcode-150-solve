import java.util.HashMap;
import java.util.Map;

class Trie {
    private final Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node current = root;
        for(int i =0;i<word.length();i++){
            char ch = word.charAt(i);

           Map<Character, Node> edges =  current.getEdges();

           if(!edges.containsKey(ch)){
               Node node = new Node();
               // if word
               edges.put(ch, node);
           }

           current = edges.get(ch);
            if(i == word.length()-1){
                current.setWord(true);
            }
        }
    }

    public boolean search(String word) {
        Node current = root;

        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            Map<Character, Node> edges = current.getEdges();

            Node edge = edges.get(ch);
            if(edge == null){
                return false;
            }

            if(i == word.length()-1 && !edge.isWord()){
                return false;
            }

            current = edge;
        }

        return true;
    }

    public boolean startsWith(String prefix) {
        Node current = root;

        for(int i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            Map<Character, Node> edges = current.getEdges();

            Node edge = edges.get(ch);
            if(edge == null){
                return false;
            }

            current = edge;
        }

        return true;
    }


    class Node {
        private Map<Character, Node> edges;
        private boolean isWord;

        public Node() {
            this.edges = new HashMap<>();
            this.isWord = false;
        }

        public void setWord(boolean word) {
            isWord = word;
        }

        public Map<Character, Node> getEdges() {
            return edges;
        }

        public boolean isWord() {
            return isWord;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));

    }
}

