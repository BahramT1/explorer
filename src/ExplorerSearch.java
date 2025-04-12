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

        int[] start = findStartPoint(island);
        boolean[][] visited = new boolean[island.length][island[0].length];
        return exploreArea(island, start[0], start[1], visited);
    }


    public static int exploreArea(int[][] island, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= island.length || col < 0 || col >= island[0].length) {
            return 0;
        }

        if (visited[row][col] || island[row][col] == 2 || island[row][col] == 3) {
            return 0;
        }

        visited[row][col] = true;

        int count = 1;

        // Move Up
        if (row - 1 >= 0 && (island[row - 1][col] == 1 || island[row - 1][col] == 0)) {
            count += exploreArea(island, row - 1, col, visited);
        }

        // Move Down
        if (row + 1 < island.length && (island[row + 1][col] == 1 || island[row + 1][col] == 0)) {
            count += exploreArea(island, row + 1, col, visited);
        }

        // Move Left
        if (col - 1 >= 0 && (island[row][col - 1] == 1 || island[row][col - 1] == 0)) {
            count += exploreArea(island, row, col - 1, visited);
        }

        // Move Right
        if (col + 1 < island[0].length && (island[row][col + 1] == 1 || island[row][col + 1] == 0)) {
            count += exploreArea(island, row, col + 1, visited);
        }

        return count;
    }

    //finding the starting location
    private static int[] findStartPoint(int[][] island) {
        for (int r = 0; r < island.length; r++) {
            for (int c = 0; c < island[0].length; c++) {
                if (island[r][c] == 0) {
                    return new int[] { r, c };
                }
            }
        }
        throw new IllegalArgumentException("No starting point (0) found in island.");
    }
}
