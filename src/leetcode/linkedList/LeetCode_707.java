package leetcode.linkedList;

public class LeetCode_707 {
    /**
     * 707.设计链表
     * 设计链表数据结构
     *
     * @param index
     * @return
     */
    int size;
    ListNode head;

    public LeetCode_707() {
        this.size = 0;
        head = new ListNode(0);
    }

    /**
     * 获取链表中第index个节点的值。如果索引无效，则返回-1。
     *
     * @param index
     * @return
     */
    public int get(int index) {
        //如果index非法，返回-1
        if (index >= size || index < 0) {
            return -1;
        }
        ListNode temp = head;
        for (int i = 0; i <= index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    /**
     * 在链表的第一个元素之前添加一个值为val的节点。插入后，新节点将成为链表的第一个节点。
     *
     * @param val
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * 将值为val的节点追加到链表的最后一个元素。
     *
     * @param val
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * 在链表中的第 index个节点之前添加值为val的节点。如果index等于链表的长度，则该节点将附加到链表的末尾。
     * 如果index大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
     *
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            size = 0;
        }
        size++;
        ListNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        ListNode newAdd = new ListNode(val);
        newAdd.next = temp.next;
        temp.next = newAdd;
    }

    /**
     * 如果索引index有效，则删除链表中的第index个节点。
     * @param index
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        ListNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

}
