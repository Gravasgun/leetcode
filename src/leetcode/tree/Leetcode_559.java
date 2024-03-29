package leetcode.tree;

import java.util.*;

/**
 * 559.N叉树的最大深度
 * 给定一个 N 叉树，找到其最大深度。
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 */
public class Leetcode_559 {
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

    /**
     * 方法一：层序遍历(广度优先)
     * @param root
     * @return
     */
    public int maxDepthMethodOne(Node root) {
        // 判断根节点是否为空，若为空则返回0
        if (root == null) {
            return 0;
        }
        // 定义一个队列，用于保存待处理的节点
        Queue<Node> queue = new LinkedList<>();
        // 将根节点加入队列
        queue.offer(root);
        // 初始化最大深度为0
        int result = 0;
        // 开始遍历树
        while (!queue.isEmpty()) {
            // 获取当前层节点的数量
            int size = queue.size();
            // 处理当前层的所有节点
            while (size-- > 0) {
                // 从队列中取出一个节点
                Node temp = queue.poll();
                // 获取该节点的子节点列表
                List<Node> children = temp.children;
                // 将子节点添加到队列中
                for (Node node : children) {
                    queue.offer(node);
                }
            }
            // 当前层节点已处理完，更新最大深度
            result++;
        }
        // 返回最大深度
        return result;
    }

    /**
     * 方法二：递归(深度优先)
     * @param root
     * @return
     */
    public int maxDepthMethodTwo(Node root) {
        // 判断根节点是否为空，若为空则返回0
        if (root == null) {
            return 0;
        }
        // 获取当前节点的所有子节点
        List<Node> children = root.children;
        // 定义一个变量来存储每个子节点的深度，初始值为0
        int result = 0;
        // 遍历每个子节点
        for (Node node : children) {
            // 递归调用maxDepthMethodTwo方法来计算子节点的深度
            int temp = maxDepthMethodTwo(node);
            // 取所有子节点中深度最大的一个作为当前节点的深度
            result = Math.max(result, temp);
        }
        // 返回当前节点的深度（当前节点的深度等于最深子节点的深度加1）
        return 1 + result;
    }
}
