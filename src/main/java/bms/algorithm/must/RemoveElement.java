package bms.algorithm.must;
import org.junit.jupiter.api.Test;

/**
 * LeetCode # 27. Remove Element
 */
public class RemoveElement {

    // Constraint
    // C1. nums.length range from 0 to 50
    // C2. nums[i] range from 0 to 50
    // C3. val range from 0 to 100
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;

        int leftPtr = 0;
        int rightPtr = nums.length-1;
        while (leftPtr <= rightPtr) {
            if (nums[leftPtr] != val) {
                leftPtr++;
            } else {
                while(rightPtr > leftPtr) {
                    if (nums[rightPtr] != val) {
                        nums[leftPtr] = nums[rightPtr];
                        break;
                    }
                    rightPtr--;
                }
                rightPtr--;
                leftPtr++;
            }
        }
        if (nums[0] == val) return 0;
        return rightPtr+1;
    }

    @Test
    public void checkCase() {


        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        assert removeElement(nums, val) == 5;

        nums = new int[]{3,2,2,3};
        val = 3;
        assert removeElement(nums, val) == 2;

        nums = new int[]{2,2,2,3};
        val = 3;
        assert removeElement(nums, val) == 3;

        nums = new int[]{2,2,2,2};
        val = 2;
        assert removeElement(nums, val) == 0;

        nums = new int[]{2,2,1,1};
        val = 2;
        assert removeElement(nums, val) == 2;

        nums = new int[]{1,1,2,2};
        val = 2;
        assert removeElement(nums, val) == 2;

        nums = new int[]{2,3,3,3};
        val = 2;
        assert removeElement(nums, val) == 3;

        nums = new int[]{2};
        val = 3;
        assert removeElement(nums, val) == 1;
        nums = new int[0];
        val = 3;
        assert removeElement(nums, val) == 0;
    }

}
