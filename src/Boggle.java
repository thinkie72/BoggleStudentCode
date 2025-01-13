import java.util.ArrayList;
import java.util.Arrays;

public class Boggle {
    // These are all global variables to work for both methods, without passing in extra parameters
    private static Trie dict;
    private static char[][] board;
    private static boolean[][] visited;
    private static ArrayList<String> goodWords;

    public static String[] findWords(char[][] board, String[] dictionary) {
        Boggle.board = board;
        // Visited needs to be the same size as the board to ensure each boolean corresponds to a square on the board
        visited = new boolean[board.length][board[0].length];
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited[i][j] = false;
            }
        }

        goodWords = new ArrayList<>();

        // Create a Trie for the dictionary
        Boggle.dict = new Trie();
        // Insert each word in the dictionary into the trie version
        for (String word : dictionary) dict.insert(word);

        // Runs dfs from each square on the board
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(i, j, "");
            }
        }

        // Convert the list into a sorted array of strings, then return the array.
        String[] sol = new String[goodWords.size()];
        goodWords.toArray(sol);
        Arrays.sort(sol);
        return sol;
    }

    //
    public static void dfs(int row, int col, String word) {
        // Checks if given row and col values are within the bounds of the board
        if (row >= board.length || col >= board[0].length || row < 0 || col < 0) return;

        // Stops this search if the node has already been visited
        if (visited[row][col]) return;

        TrieNode prefix = dict.lookup(word);

        // Stops search if not valid prefix
        if (prefix == null) return;

        // If prefix is a word and isn't in the arraylist, put in the arraylist
        if (prefix.isWord() && !goodWords.contains(word)) goodWords.add(word);

        // Set to visited
        visited[row][col] = true;

        // Add the next letter to the prefix
        word += board[row][col];

        // Search down, up, right, and left
        dfs(row + 1, col, word);
        dfs(row - 1, col, word);
        dfs(row, col + 1, word);
        dfs(row, col - 1, word);

        // Set to unvisited
        visited[row][col] = false;
    }
}
