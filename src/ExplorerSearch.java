import java.util.ArrayList;
import java.util.List;

public class ExplorerSearch {

    /**
     * Returns how much land area an explorer can reach on a rectangular island.
     * 
     * The island is represented by a rectangular int[][] that contains
     * ONLY the following nunbers:
     * 
     * '0': represents the starting location of the explorer
     * '1': represents a field the explorer can walk through
     * '2': represents a body of water the explorer cannot cross
     * '3': represents a mountain the explorer cannot cross
     * 
     * The explorer can move one square at a time: up, down, left, or right.
     * They CANNOT move diagonally.
     * They CANNOT move off the edge of the island.
     * They CANNOT move onto a a body of water or mountain.
     * 
     * This method should return the total number of spaces the explorer is able
     * to reach from their starting location. It should include the starting
     * location of the explorer.
     * 
     * For example
     * 
     * @param island the locations on the island
     * @return the number of spaces the explorer can reach
     */
    public static int reachableArea(int[][] island) {
        // Implement your method here!
        // Please also make more test cases
        // I STRONGLY RECOMMEND testing some helpers you might make too

        int rows = island.length;
        int cols = island[0].length;


        int startRow = 0;
        int startCol = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (island[r][c] == 0) {
                    startRow = r;
                    startCol = c;
                    break;
                }
            }
        }

        boolean[][] visited = new boolean[rows][cols];

        return explore(island, visited, startRow, startCol);
    }


    // A method that explores the map and counts reachable land
    public static int explore(int[][] island, boolean[][] visited, int r, int c) {
        // If out of bounds, return 0
        if (r < 0 || r >= island.length || c < 0 || c >= island[0].length) {
            return 0;
        }
        
        if (visited[r][c] || island[r][c] == 2 || island[r][c] == 3) {
            return 0;
        }


        visited[r][c] = true;


        int count = 1;

        // Check all 4 directions
        count += explore(island, visited, r + 1, c);
        count += explore(island, visited, r - 1, c);
        count += explore(island, visited, r, c + 1);
        count += explore(island, visited, r, c - 1);

        return count;
    }
}
