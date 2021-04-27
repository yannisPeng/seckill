package com.leetcode;

public class FactorialZero {

    public static int trailingZeroes(int n) {
        int count = 0;
        while(n > 0){
            count += count /5;
            n /= 5;
        }
        return count;
    }

    public static void main(String[] args) {
        trailingZeroes(30);
    }

}
