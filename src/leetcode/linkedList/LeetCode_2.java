package leetcode.linkedList;

import org.junit.Test;

import java.util.Stack;

public class LeetCode_2 {
    /**
     * 2.两数相加
     * 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
     * 请你将两个数相加，并以逆序返回一个表示和的链表。
     * 这两个数都不会以0开头。
     * <p>
     * 这个方法在数字超过long型的时候不适用
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //stack1存放l1
        Stack<ListNode> stack1 = new Stack<>();
        //stack2存放l2
        Stack<ListNode> stack2 = new Stack<>();
        //stack3存放l1与l2的和
        Stack<ListNode> stack3 = new Stack<>();
        //str1用来拼接l1
        StringBuilder str1 = new StringBuilder();
        //str2用来拼接l2
        StringBuilder str2 = new StringBuilder();
        //l1入栈
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        //l2入栈
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        //l1出栈
        while (!stack1.isEmpty()) {
            //出栈的时候拼接
            str1.append(stack1.pop().val);
        }

        while (!stack2.isEmpty()) {
            //出栈的时候拼接
            str2.append(stack2.pop().val);
        }
        //求和
        long sum = Long.parseLong(String.valueOf(str1)) + Long.parseLong(String.valueOf(str2));
        //将和反转
        char[] sumChars = String.valueOf(sum).toCharArray();
        for (int i = 0; i < sumChars.length; i++) {
            stack3.push(new ListNode(Integer.parseInt(String.valueOf(sumChars[i]))));
        }
        ListNode first = stack3.pop();
        ListNode temp = first;
        while (!stack3.isEmpty()) {
            temp.next = stack3.pop();
            temp = temp.next;
        }
        return first;
    }

    class ListNode {
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

    @Test
    public void test() {
        ListNode list1 = new ListNode(9, new ListNode(9, new ListNode(9, null)));
        ListNode list2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(1, null))));
        ListNode first = addTwoNumbers(list1, list2);
        while (first != null) {
            System.out.print(first.val + " ");
            first = first.next;
        }
    }
}
