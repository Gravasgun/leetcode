package leetcode.linkedList;

public class LeetCode_24 {
    /**
     * 24.两两交换链表中的节点
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(0,head);
        ListNode temp = newHead;
        while (temp.next != null && temp.next.next != null) {
            //用node1来保存temp.next
            ListNode node1 = temp.next;
            //用node2来保存temp.next.net
            ListNode node2 = temp.next.next;
            ////用node3来保存node2.next
            ListNode node3 = node2.next;
            //将temp.next指向node2(node2此时是temp.next.next)
            temp.next = node2;
            //将node2.next指向node1(node1此时是temp.next)
            node2.next = node1;
            //将node1.next指向之前node2的next(也就是node3）
            //之所以单独定义一个node3变量，是因为在上一步node2.next会发生变化,所以在变化之前要用node3保存未变之前的next)
            node1.next = node3;
            //最后将temp往后移动两位
            temp = node2.next;
        }
        return newHead.next;
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
