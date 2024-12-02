package bms.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class nextGreaterElement {

    public int[] nextGreatestElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[]{};
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            ans[i] = stack.empty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return ans;
    }

    @Test
    public void checkCase() {


    }
}
