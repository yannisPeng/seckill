package com.leetcode;

public class FindMiddleNum {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 总长度
        int length = nums1.length + nums2.length;
        // 相对有序数组
        int[] result = new int[length];

        for (int i = 0; i < nums1.length; i++) {
            result[i] = nums1[i];
        }
        for (int j = 0; j < nums2.length; j++) {
            result[j + nums1.length] = nums2[j];
        }



        return 0;
    }

}
