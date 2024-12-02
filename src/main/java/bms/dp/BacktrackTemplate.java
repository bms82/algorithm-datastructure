package bms.dp;

public class BacktrackTemplate {

    int result;
    void backtrack(int[] nums, int i, int rest) {
        // base case
        if (i == nums.length) {
            if (rest == 0) {
                result++;
            }
            return;
        }
        //nums[i]에 - 부호
        rest += nums[i];
        // nums[i + 1] 무차별 탐색
        backtrack(nums, i+1, rest);
        // 선택해제
        rest -= nums[i];

        // nums[i]에 + 부호
        rest -= nums[i];
        // nums[i + 1] 무차별 탐색
        backtrack(nums, i + 1, rest);
        // 선택해제
        rest += nums[i];
    }


}
