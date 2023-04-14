package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 589.N叉树的前序遍历
 * 给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 */
public class Leetcode_589 {
    // 定义一个方法，用于对N叉树进行前序遍历，并返回遍历结果列表
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        // 调用递归方法实现前序遍历，并将遍历结果添加到列表中
        pre(root, list);
        return list;
    }

    // 定义一个递归方法，用于实现前序遍历
    private void pre(Node temp, List<Integer> list) {
        // 如果当前节点为空，直接返回
        if (temp == null) {
            return;
        }
        // 将当前节点的值添加到列表中
        list.add(temp.val);
        // 遍历当前节点的所有子节点
        for (Node node : temp.children) {
            // 对每个子节点递归调用pre方法，实现前序遍历
            pre(node, list);
        }
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


