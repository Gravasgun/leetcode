package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 590.N叉树的后序遍历
 * 给定一个n叉树的根节点root，返回其节点值的后序遍历 。
 * n叉树在输入中按层序遍历进行序列化表示，每组子节点由空值null分隔（请参见示例）。
 */
public class Leetcode_590 {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>(); // 创建一个空列表，用于存储遍历结果
        post(root, list); // 调用私有的递归方法，对树进行后序遍历
        return list; // 返回遍历结果列表
    }

    private void post(Node temp, List<Integer> list) {
        if (temp == null) { // 如果节点为空，直接返回
            return;
        }
        for (Node node : temp.children) { // 遍历当前节点的所有子节点
            post(node, list); // 递归遍历子节点
        }
        list.add(temp.val); // 将当前节点的值添加到遍历结果列表中
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
