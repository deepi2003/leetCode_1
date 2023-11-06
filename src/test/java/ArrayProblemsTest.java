import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayProblemsTest {

    ArrayProblems arrayProblems = new ArrayProblems();
    @Test
    void twoSum() {
        assertArrayEquals( new int[]{0,1}, arrayProblems.twoSum(new int[]{2, 7, 11, 15}, 9 ));
    }


    @Test
    void twoSum_2() {
        assertArrayEquals( new int[]{1,2}, arrayProblems.twoSum(new int[]{3, 2, 4}, 6 ));
        assertArrayEquals( new int[]{0,1}, arrayProblems.twoSum(new int[]{3,3}, 6 ));
    }

    @Test
    void searchInsert() {
        assertEquals(2 ,arrayProblems.searchInsert(new int[] {4, 8, 9}, 9));
        assertEquals(1 ,arrayProblems.searchInsert(new int[] {4, 8, 9}, 7));
        assertEquals(4 ,arrayProblems.searchInsert(new int[] {1,3,5,6}, 7));

    }
}