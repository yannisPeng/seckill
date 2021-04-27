package com.leetcode;

public class LengthString {

    public static int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int end = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            end   = Math.max(end, i - start + 1);
            last[index] = i;
        }

        return end;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("ababcbb"));
    }

}
