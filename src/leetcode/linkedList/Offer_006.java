package leetcode.linkedList;

import java.util.Stack;

public class Offer_006 {
    /**
     * 剑指offer_006.从尾到头打印链表
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        /**
         * 栈的特点是后进先出，即最后压入栈的元素最先弹出。考虑到栈的这一特点，使用栈将链表元素顺序倒置（反转链表）。
         * 从链表的头节点开始，依次将每个节点压入栈内，然后依次弹出栈内的元素并存储到数组中。
         */
        //创建一个栈，用于存储链表的节点
        Stack<ListNode> stack = new Stack<>();
        //当指针指向的元素非空时，重复下列操作：
        while (head != null) {
            //将指针指向的节点压入栈内
            stack.push(head);
            //将指针移到当前节点的下一个节点
            head = head.next;
        }
        //获得栈的大小size
        int size = stack.size();
        //创建一个数组nums，其大小为size
        int[] nums = new int[size];
        //遍历数组
        for (int i = 0; i < size; i++) {
            nums[i] = stack.pop().val;
        }
        return nums;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
