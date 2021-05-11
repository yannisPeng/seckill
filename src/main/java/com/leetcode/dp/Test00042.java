package com.leetcode.dp;

/**
 * Description: 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 * <p>
 * 示例1:
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释:连续子数组[4,-1,2,1] 的和最大，为6。
 * <p>
 * 提示：
 * 1 <=arr.length <= 10^5
 * -100 <= arr[i] <= 100
 *
 * @author 10014994
 * @since 2021/5/8
 */
public class Test00042 {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 1], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        new Test00042().maxSubArray(new int[]{-1, 2, -3, 4, -1, 2, 1, -5, 4});
    }

}
