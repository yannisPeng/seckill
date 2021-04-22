package com.newcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Description:
 *
 * @author 10014994
 * @since 2021/1/30
 */
public class Main2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String nextLine = scanner.nextLine();
        String[] split = nextLine.split(" ");

        int[] params = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            params[i] = Integer.parseInt(split[i]);
        }

        System.out.println(method(params));

    }

    public static int[] method(int[] numbers) {
        int[] tryingNumbers = findWaitTryingNumbers(numbers);
        for (int i = 0; i < tryingNumbers.length; i++) {
            int[] fourteenNumbers;
            fourteenNumbers = numbers;
            fourteenNumbers[14] = i;

            if (ifFitPeace(fourteenNumbers)) {

            }

        }
        return tryingNumbers;
    }

    private static boolean ifFitPeace(int[] fourteenNumbers) {
        return true;
    }

    private static int[] findWaitTryingNumbers(int[] numbers) {

        int fourTime = 0;

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            Integer integer = countMap.get(numbers[i]);
            if (integer == null) {
                countMap.put(numbers[i], 1);
            } else {
                if (integer == 3) {
                    fourTime++;
                }
                countMap.put(numbers[i], integer + 1);
            }
        }

        int k = 0;
        int[] waitTryingArray = new int[10 - fourTime];
        for (int i = 0; i <= 9; i++) {
            if (countMap.get(i) == null || countMap.get(i) < 4) {
                waitTryingArray[k] = i;
                ++k;
            }
        }
        return waitTryingArray;
    }

}
