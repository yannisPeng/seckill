package com.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 10014994
 * @since 2020/10/8
 */
public class Test0003 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<String> l1List = new ArrayList<>();
        l1List.add(String.valueOf(l1.val));
        while (l1.next != null) {
            l1List.add(String.valueOf(l1.next.val));
            l1 = l1.next;
        }
        List<String> l2List = new ArrayList<>();
        l2List.add(String.valueOf(l2.val));
        while (l2.next != null) {
            l2List.add(String.valueOf(l2.next.val));
            l2 = l2.next;
        }

        StringBuilder s1 = new StringBuilder();
        for (int i = l1List.size() - 1; i >= 0; i--) {
            s1.append(l1List.get(i));
        }

        StringBuilder s2 = new StringBuilder();
        for (int i = l2List.size() - 1; i >= 0; i--) {
            s2.append(l2List.get(i));
        }

        String[] strs1 = s1.toString().split("");
        String[] strs2 = s2.toString().split("");
        // todo 两个大数相加

        String[] split = new String[]{};

        ListNode head = new ListNode(Integer.parseInt(split[split.length - 1]));
        ListNode other = head;
        for (int i = split.length - 2; i >= 0; i--) {
            ListNode temp = new ListNode(Integer.parseInt(split[i]));
            other.next = temp;
            other = other.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode1_4 = new ListNode(4);
        listNode1.next = listNode1_4;
        ListNode listNode1_3 = new ListNode(3);
        listNode1_4.next = listNode1_3;

        ListNode listNode2 = new ListNode(5);
        ListNode listNode2_4 = new ListNode(6);
        listNode2.next = listNode2_4;
        ListNode listNode2_3 = new ListNode(4);
        listNode2_4.next = listNode2_3;
        System.out.println(JSON.toJSON(new Test0003().addTwoNumbers(listNode1, listNode2)));
    }


}
