package leetcode.linkedList;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_142 {
    /**
     * 142.环形链表II
     *给定一个链表的头节点head，返回链表开始入环的第一个节点。如果链表无环，则返回null。
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            //如果添加失败，说明当前节点就是入环的第一个节点
            if (!set.add(head)) {
                return head;
            }
            //往后移位
            head = head.next;
        }
        //无环的情况就会跳出while循环
        return null;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
