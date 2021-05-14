package com.leetcode.digital;

/**
 * 给定一个非负整数c，你要判断是否存在两个整数 a 和 b，使得a^2 + b^2 = c 。
 * <p>
 * 示例 1：
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * <p>
 * 示例 2：
 * 输入：c = 3
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：c = 4
 * 输出：true
 * 示例 4：
 * 输入：c = 2
 * 输出：true
 * 示例 5：
 * 输入：c = 1
 * 输出：true
 * <p>
 * 提示： 0 <= c <= 2^31 - 1
 */
public class Test00633 {

    public boolean judgeSquareSum(int c) {
        if (c == 0 || c == 1) {
            return true;
        }
        int first = 0;
        int last = (int) Math.sqrt(c);
        while (first <= last) {
            double sum = Math.pow(first, 2) + Math.pow(last, 2);
            if (sum > c) {
                last--;
            } else if (sum < c) {
                first++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Test00633().judgeSquareSum(3));
    }

}
