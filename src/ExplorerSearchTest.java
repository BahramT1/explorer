import static org.junit.Assert.*;
import org.junit.Test;

public class ExplorerSearchTest {
    @Test
    public void testReachableArea_someUnreachable() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(14, actual);
    }

    // Add more tests here!
    // Come up with varied cases


    //Test forr all reachable area
    @Test
    public void reachableArea_allReachAble(){
       int[][] island = {
        {0,1,1},
        {1,1,1},
        {1,1,1}
       };

       int actual = ExplorerSearch.reachableArea(island);
       assertEquals(9, actual);
    }

    @Test
    public void testReachableArea_onlyStart() {
       int[][] island = {
            {0}
        };

        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    @Test
    public void testReachableArea_surroundedByWaterAndMountain() {
        int[][] island = {
            {2,2,2},
            {2,0,3},
            {2,3,2}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual); 
    }

    @Test
    public void testReachableArea_mazeLike() {
        int[][] island = {
            {3,1,3,3,3},
            {3,1,2,2,3},
            {0,1,1,1,1},
            {3,3,3,3,1}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(8, actual);
    }

    @Test
    public void testReachableArea_noWalkablePath() {
        int[][] island = {
            {0, 2},
            {2, 3}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    @Test
    public void testHorizontalLinePath() {
    int[][] island = {
        {0, 1, 1, 1, 1}
    };
    int actual = ExplorerSearch.reachableArea(island);
    assertEquals(5, actual); 
    }

    @Test
    public void testVerticalLinePath() {
    int[][] island = {
        {0},
        {1},
        {1},
        {1},
        {1}
    };
    int actual = ExplorerSearch.reachableArea(island);
    assertEquals(5, actual); 
    }

    @Test
    public void testOnlyStartNoLand() {
    int[][] island = {
        {0, 2, 2},
        {2, 3, 2},
        {2, 2, 2}
    };
    int actual = ExplorerSearch.reachableArea(island);
    assertEquals(1, actual); 
    }

    @Test
    public void testStartOnEdgeReachable() {
    int[][] island = {
        {0, 1, 1},
        {2, 3, 1},
        {2, 2, 1}
    };
    int actual = ExplorerSearch.reachableArea(island);
    assertEquals(5, actual);
    }
}