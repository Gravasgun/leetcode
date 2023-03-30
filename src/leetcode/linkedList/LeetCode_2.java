package leetcode.linkedList;

import org.junit.Test;

import java.util.Stack;

public class LeetCode_2 {
    /**
     * 2.两数相加
     * 给你两个非空的链表，表示两个非负整数。它们每位数字都是按照逆序方式存储的，
     * 并且每个节点只能存储一位数字。请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * 解法：
     * 我们可以模拟人工加法的过程，从低位到高位逐位相加，记录下进位值。
     * 在遍历完成后，如果还有进位，那么需要将进位值添加到结果的最高位。
     * 时间复杂度：O(max(m,n))，其中 m 和 n 分别为两个链表的长度。
     * 空间复杂度：O(max(m,n))，新建链表的长度为较长链表长度 + 1。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(); // 创建一个空链表节点，作为结果链表的头部节点
        ListNode temp = pre; // 用于遍历结果链表的指针，初始指向头部节点
        int carry = 0; // 进位值，初始为 0
        while (l1 != null || l2 != null) { // 从低位到高位逐位相加
            int x = l1 == null ? 0 : l1.val; // 获取当前位的数值，如果链表节点已经遍历完，那么数值为 0
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry; // 相加并加上进位值
            carry = sum / 10; // 计算进位值
            temp.next = new ListNode(sum % 10); // 创建一个新的节点，存储当前位的数值
            temp = temp.next; // 指针向前移动
            if (l1 != null) { // 如果链表 l1 还有节点，指针向前移动
                l1 = l1.next;
            }
            if (l2 != null) { // 如果链表 l2 还有节点，指针向前移动
                l2 = l2.next;
            }
        }
        if (carry > 0) { // 如果还有进位，那么需要将进位值添加到结果的最高位
            temp.next = new ListNode(carry);
        }
        return pre.next; // 返回结果链表的头部节点的下一个节点
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
}
