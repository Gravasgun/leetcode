package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429.N叉树的层序遍历
 * 给定一个N叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 */
public class Leetcode_429 {
    // 定义树节点类
    class Node {
        public int val; // 节点的值
        public List<Node> children; // 子节点列表

        public Node() {
        } // 无参构造函数

        public Node(int val) { // 带值参数的构造函数
            this.val = val;
        }

        public Node(int val, List<Node> children) { // 带值和子节点列表参数的构造函数
            this.val = val;
            this.children = children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) { // 定义层序遍历方法
        List<List<Integer>> result = new ArrayList<>(); // 用于存储结果的列表
        Queue<Node> queue = new LinkedList<>(); // 定义队列，用于存储待遍历的节点
        if (root == null) { // 如果根节点为空，则返回空列表
            return result;
        }
        queue.offer(root); // 将根节点加入队列
        Node temp = root; // 定义一个临时节点，用于存储每次从队列中取出的节点
        while (!queue.isEmpty()) { // 只要队列不为空，就继续遍历
            int size = queue.size(); // 记录当前队列的大小
            List<Integer> list = new ArrayList<>(); // 定义列表，用于存储当前层的节点值
            while (size-- > 0) { // 遍历当前层的所有节点
                temp = queue.poll(); // 取出队列头部的节点，并将其赋值给临时节点
                list.add(temp.val); // 将临时节点的值加入列表中
                List<Node> children = temp.children; // 获取临时节点的子节点列表
                if (!children.isEmpty()) { // 如果子节点列表不为空
                    for (int i = 0; i < children.size(); i++) { // 遍历所有子节点
                        queue.offer(children.get(i)); // 将子节点加入队列
                    }
                }
            }
            result.add(list); // 将当前层的节点值列表加入结果列表中
        }
        return result; // 返回结果列表
    }
}
