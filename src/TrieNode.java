// Modified from code by Tyler Hinkie in September and October 2024
public class TrieNode {
    // Instance variables
    private boolean isWord;
    private TrieNode[] next;

    // Constructor
    public TrieNode() {
        isWord = false;
        next = new TrieNode[255];
    }

    // Methods
    public boolean isWord() {
        return isWord;
    }

    public void setWord() {
        isWord = true;
    }

    public TrieNode[] getNext() {
        return next;
    }
}
