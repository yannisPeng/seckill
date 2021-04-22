package com.newcoder;

import java.util.Scanner;

/**
 * Description:
 *
 * @author 10014994
 * @since 2021/1/30
 */
public class Main1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] split = text.split(" ");

        String positionText = scanner.nextLine();
        String[] position = positionText.split(" ");

        int[] positions = new int[position.length];
        for (int i = 0; i < position.length; i++) {
            positions[i] = Integer.parseInt(position[i]);
        }

        System.out.println(method(Integer.parseInt(split[0]), Integer.parseInt(split[1]), positions));

    }

    public static long method(int N, int D, int[] positions) {
        long sum = 0L;
        int mod = 99997867;

        for (int i = 0, j = 0; i < N; i++) {
            while (i >= 2 && positions[i] - positions[j] > D) {
                j++;
            }
            sum += (long) (i - j) * (long) (i - j - 1) / 2;
        }
        return sum % mod;
    }

}
