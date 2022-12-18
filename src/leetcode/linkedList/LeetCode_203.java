package leetcode.linkedList;

public class LeetCode_203 {
    /**
     * 203.移除链表元素
     * 给你一个链表的头节点head和一个整数val，请你删除链表中所有满足Node.val==val的节点，并返回新的头节点。
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        //创建一个新的节点，这个节点的next指向head
        ListNode newHead = new ListNode(0, head);
        //因为之后需要用到这个节点的next，所以创建一个临时节点用来移动
        ListNode temp = newHead;
        //temp是头节点的前一个节点，这样就会排除头节点的值也满足删除条件的情况
        while (temp.next != null) {
            //如果当前节点的next的val满足条件
            if (temp.next.val == val) {
                //删除节点
                temp.next = temp.next.next;
            } else {
                //向后移动一位
                temp = temp.next;
            }
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
