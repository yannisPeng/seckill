package com.newcoder;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * Description:
 *
 * @author 10014994
 * @since 2021/1/30
 */
public class Main {

    public static void main(String[] args) {

        // 输入行数
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();

        // 输入待修正字符串
        for (int i = 0; i < line; i++) {
            String next = scanner.next();
            System.out.println(method(next));
        }
    }

    public static String method(String text) {

        char[] chars = text.toCharArray();

        StringBuilder result = new StringBuilder();

        int k = 0;
        for (int i = 0; i < chars.length; i++) {
            chars[k] = chars[i];
            result.append(chars[k]);
            k++;

            if (k >= 3 && chars[k - 1] == chars[k - 2] && chars[k - 1] == chars[k - 3]) {
                result.deleteCharAt(k - 1);
                k--;
            }

            if (k >= 4 && chars[k - 1] == chars[k - 2] && chars[k - 3] == chars[k - 4]) {
                result.deleteCharAt(k - 1);
                k--;
            }
        }

        return result.toString();
    }
}
