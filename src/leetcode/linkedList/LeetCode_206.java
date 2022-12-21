package leetcode.linkedList;

import java.util.Stack;

public class LeetCode_206 {
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

    /**
     * 206.反转链表
     * 给你单链表的头节点head，请你反转链表，并返回反转后的链表。
     *
     * @param head
     * @return
     */
    //方法一：栈
    public ListNode reverseListMethodOne(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        //入栈
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        //弹出第一个节点，这个节点是反转后的第一个节点
        ListNode temp = stack.pop();
        //用一个新的节点变量保存temp，因为最后需要返回temp
        ListNode first = temp;
        while (!stack.isEmpty()) {
            ListNode next = stack.pop();
            temp.next = next;
            temp = temp.next;
        }
        //将最后一个节点的next指向null，不然可能会出现环
        temp.next = null;
        return first;
    }

    //方法二：双指针
    public ListNode reverseListMethodTwo(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode temp = head;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = pre;
            pre = temp;
            temp = next;
        }
        return pre;
    }

    //方法三：递归(也是双指针的思路)
    public ListNode reverseListMethodThree(ListNode head) {
        return reverseLinkedList(null, head);
    }

    public ListNode reverseLinkedList(ListNode pre, ListNode temp) {
        if (temp == null) {
            return pre;
        }
        //记录下一个节点的位置
        ListNode next = temp.next;
        //反转
        temp.next = pre;
        //移位的同时递归
        return reverseLinkedList(temp, next);
    }
}
