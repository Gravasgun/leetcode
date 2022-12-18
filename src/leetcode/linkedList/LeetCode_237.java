package leetcode.linkedList;

public class LeetCode_237 {
    /**
     * 237.删除链表中的节点
     * 有一个单链表的head，删除它其中的一个节点node。
     * 给你一个需要删除的节点node。你将无法访问第一个节点head。
     * 链表的所有值都是唯一的，并且保证给定的节点node不是链表中的最后一个节点。
     * 删除给定的节点。注意，删除节点并不是指从内存中删除它。这里的意思是：
     * 给定节点的值不应该存在于链表中。
     * 链表中的节点数应该减少 1。
     * node 前面的所有值顺序相同。
     * node 后面的所有值顺序相同。
     * @param node
     */
    public void deleteNode(ListNode node) {
        //下一个节点的值覆盖掉这个节点的值
        node.val=node.next.val;
        //这个节点和下个节点的值就一样了，我们的目的是删除这个节点，但这个节点的上一个节点无法访问
        //因为这两个结点的值一样，所以删除这个节点的下一个节点也是一样的
        node.next=node.next.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
