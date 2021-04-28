package com.leetcode.search;

import java.util.Arrays;

/**
 * Description: 在 D 天内送达包裹的能力
 * <p>
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 *  
 * 示例 1：
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 * <p>
 * 请注意，货物必须按照给定的顺序装运，此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 * <p>
 * 示例 2：
 * 输入：weights = [3,2,2,4,1,4], D = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 * <p>
 * 示例 3：
 * 输入：weights = [1,2,3,1,1], D = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 * <p>
 * 提示：
 * 1 <= D <= weights.length <= 50000
 * 1 <= weights[i] <= 500
 *
 * @author 10014994
 * @since 2021/4/26
 */
public class Test01011 {

    //判断最低运载能力为H的时候能否在D天内送达
    public boolean verification(int[] weights, int D, int H) {
        //天数计数，初始化为1
        int count = 1;
        //每天的包裹总量
        int singleWeight = 0;
        for (int i = 0; i < weights.length; ++i) {
            //累计包裹总量
            singleWeight += weights[i];
            //如果累计包裹总量singleWeight > H，天数+1
            if (singleWeight > H) {
                ++count;
                singleWeight = weights[i];
            }
            //如果当前累计的天数count > D，说明当前H不满足条件，返回false
            if (count > D) {
                return false;
            }
        }
        //说明当前H满足条件，返回true
        return true;
    }

    //从数组的最大元素开始遍历判断值i是否满足verification
    public int shipWithinDays(int[] weights, int D) {
        //二分查找 r = 数组的总和， l = 数组的最大值
        int r = Arrays.stream(weights).sum();
        int l = Arrays.stream(weights).max().getAsInt();
        //l < r
        while (l < r) {
            //取中间值
            int mid = (l + r) >> 1;
            //如果mid满足verification，则逼近右指针
            if (verification(weights, D, mid)) {
                //包括mid
                r = mid;
            } else {
                //逼近左指针，mid + 1
                l = mid + 1;
            }
        }
        //返回当前l就是最小的满足条件的值，即最低运载能力
        return l;
    }
}
