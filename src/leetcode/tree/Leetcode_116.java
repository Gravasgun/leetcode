package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 116.填充每个节点的下一个右侧节点指针
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 */
public class Leetcode_116 {
    public Node connect(Node root) {
        // 创建一个队列，用于层序遍历
        Queue<Node> queue = new LinkedList<>();
        if (root == null) {
            return null;
        }
        // 将根节点入队
        Node temp = root;
        queue.offer(temp);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Node> list = new ArrayList<>();
            // 遍历当前层的所有节点
            while (size-- > 0) {
                temp = queue.poll();
                list.add(temp);
                // 如果有左孩子，则将左孩子入队
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                // 如果有右孩子，则将右孩子入队
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            // 将当前层的节点的next指针指向下一个节点
            for (int i = 0; i < list.size(); i++) {
                if (i == list.size() - 1) {
                    // 如果当前节点是该层最后一个节点，则将其next指针指向null
                    list.get(i).next = null;
                } else {
                    // 否则，将当前节点的next指针指向下一个节点
                    list.get(i).next = list.get(i + 1);
                }
            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}