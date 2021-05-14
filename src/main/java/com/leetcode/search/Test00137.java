package com.leetcode.search;

/**
 * 只出现一次的数字 II
 * <p>
 * 给你一个整数数组nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 *
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 */
public class Test00137 {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                count += ((num >> i) & 1);
            }
            if(count % 3 != 0){
                ans = ans | (i >> 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Test00137().singleNumber(new int[]{1, 2, 2, 2}));
    }

}
