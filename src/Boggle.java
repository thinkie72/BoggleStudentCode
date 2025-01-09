import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Boggle {

    public static String[] findWords(char[][] board, String[] dictionary) {

        ArrayList<String> goodWords = new ArrayList<String>();

        // TODO: Complete the function findWords(). Add all words that are found both on the board
        //  and in the dictionary.
        HashMap<Character, Integer[]> lettersToLocations = new HashMap<>();
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                lettersToLocations.put(board[i][j], new Integer[]{i, j});
            }
        }

        // Create a Trie for the dictionary
        Trie dict = new Trie();
        // Insert each word in the dictionary into the trie version
        for (String word : dictionary) dict.insert(word);

        // Convert the list into a sorted array of strings, then return the array.
        String[] sol = new String[goodWords.size()];
        goodWords.toArray(sol);
        Arrays.sort(sol);
        return sol;
    }

    public static void dfs(int row, int col, int word) {
//        if we have been here before, return
//        if this word is not a valid prefix, return
//                mark this square as visited
//        recurse up, down, left, right with updated word
//        mark this square as not visited
    }
}
