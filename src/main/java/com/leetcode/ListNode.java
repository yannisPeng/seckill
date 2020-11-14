package com.leetcode;

import lombok.Data;

/**
 * Description:
 *
 * @author 10014994
 * @since 2020/10/9
 */
public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
