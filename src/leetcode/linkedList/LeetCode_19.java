package leetcode.linkedList;

public class LeetCode_19 {
    /**
     * 19.删除链表中倒数第N个元素
     * 给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(0, head);
        ListNode temp = newHead;
        //得到这个链表的size
        int length = getLength(head);
        //移动temp到删除元素的前一个元素
        for (int i = 1; i < length - n + 1; i++) {
            temp = temp.next;
        }
        //删除
        temp.next = temp.next.next;
        return newHead.next;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
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
