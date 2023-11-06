import java.util.HashMap;
import java.util.Map;

public class ArrayProblems {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> numberIndexMapping = new HashMap<>(nums.length);

        for(int i = 0; i < nums.length ; i++) {
            int temp = target- nums[i];
            if(numberIndexMapping.containsKey(temp)) {
                return new int[]{numberIndexMapping.get(temp), i};
            }
            numberIndexMapping.put(nums[i], i);
        }
        return new int[2];
    }

    public int searchInsert(int[] nums, int target) {
       for(int i = 0; i < nums.length; i++) {
           if(nums[i] == target || nums[i] > target) {
               return i;
           }
        }

        return nums.length;
    }
}
