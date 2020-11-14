//package com.leetcode;
//
//import com.alibaba.fastjson.JSON;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Description: 单向链表测试
// *
// * @author 10014994
// * @since 2020/10/8
// */
//public class SingleListTest {
//
//    public static void main(String[] args) {
//
//        List<Integer> numList = new ArrayList<>();
//        for (int i = 1; i < 11; i++) {
//            numList.add(i);
//        }
//
//        ListNode empNode = new ListNode();
//        for (int i = 1; i < 11; i++) {
//            empNode = new ListNode(i + 1);
//            ListNode listNode = new ListNode(i);
//            listNode.setNext(empNode);
//        }
//
//        ListNode listNode = new ListNode(1);
//        listNode(listNode, 2);
//        System.out.println(JSON.toJSON(listNode));
//    }
//
//    public static void listNode(ListNode listNode, int i) {
//        if (i > 2800) {
//            return;
//        } else {
//            ListNode listNodeT = new ListNode(i);
//            listNode.setNext(listNodeT);
//            listNode(listNodeT, ++i);
//        }
//        return;
//    }
//}
