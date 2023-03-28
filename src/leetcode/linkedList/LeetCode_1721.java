package leetcode.linkedList;

/**
 * 1721.交换链表中的节点
 * 给你链表的头节点head和一个整数k，交换 链表正数第k个节点和倒数第k个节点的值后，返回链表的头节点
 */
public class LeetCode_1721 {
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

    class Solution {
        public ListNode swapNodes(ListNode head, int k) {
            ListNode left = head;//正数第k个节点
            ListNode right = head;//倒数第k个节点
            //利用循环找到正数第k个节点
            for (int i = 1; i < k; i++) {
                left = left.next;
            }
            //定义另一个变量current保存left指针，因为不能移动left指针
            ListNode current = left;
            //让两个指针一起移动，当正数第k个指针移动到链表末尾时，right指针刚好移动到倒数第k个节点
            while (current.next != null) {
                right = right.next;
                current = current.next;
            }
            //交换两个节点的值
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
            return head;
        }
    }
}
