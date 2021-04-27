package com.leetcode;


/**
 * Description: 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额
 *
 * 示例 1：
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 *
 * 示例 2：
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：0
 *
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 *
 * 思路：
 * 1、选取不可连续
 * 2、总额最大
 *
 * 动态规划
 *
 *
 * @author 10014994
 * @since 2021/4/12
 */
public class Test00213 {

    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];

        if(nums.length == 2)
            return Math.max(nums[0],nums[1]);

        int[] maxM1 = new int[nums.length], maxM2 = new int[nums.length];
        maxM1[0] = nums[0];
        maxM1[1] = Math.max(nums[1],nums[0]);

        //maxM2[0] = 0;
        maxM2[1] = nums[1];
        maxM2[2] = Math.max(nums[1],nums[2]);

        for(int i=2; i<nums.length-1; i++) {
            maxM1[i] = Math.max(maxM1[i-2] + nums[i],maxM1[i-1]);
        }
        for(int i=3; i<nums.length; i++) {
            maxM2[i] = Math.max(maxM2[i-2] + nums[i],maxM2[i-1]);
        }
        return Math.max(maxM1[nums.length-2],maxM2[nums.length-1]);
    }

    public static void main(String[] args) {

    }

}
