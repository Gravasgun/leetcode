package leetcode.linkedList;

import java.util.HashSet;

public class LeetCode_160 {
    /**
     * 160.相交链表
     * 给你两个单链表的头节点headA和headB，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回null。
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        //将每个节点添加进set中
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        //遍历B链表
        while (headB != null) {
            //如果set中包含了headB,则说明从这个节点开始，就是相交的部分
            if (set.contains(headB)) {
                return headB;
            }
            //如果不包含，往后移位
            headB = headB.next;
        }
        //没找到，返回null
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
