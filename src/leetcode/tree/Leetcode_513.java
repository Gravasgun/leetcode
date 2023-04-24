package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode_513 {
    /**
     * 513.找树左下角的值
     * 给定一个二叉树的根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
     * 假设二叉树中至少有一个节点。
     *
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        // 检查根节点是否为null
        if (root == null) {
            return -1;
        }
        // 创建一个列表来存储二叉树中每一层最左侧的值
        List<Integer> list = new ArrayList<>();
        // 创建一个队列来存储遍历过的节点
        Queue<TreeNode> queue = new LinkedList<>();
        // 将根节点添加到队列中
        TreeNode temp = root;
        queue.offer(temp);
        // 当队列不为空时，继续遍历
        while (!queue.isEmpty()) {
            // 获取队列的大小
            int size = queue.size();
            // 开关变量，用于判断当前节点是否为每一层最左边的节点
            boolean on = true;
            while (size-- > 0) {
                // 取出队列中的头节点
                temp = queue.poll();
                // 如果当前节点是该层第一个被访问的节点，将其值加入列表中，并将开关变量设置为false
                if (on) {
                    list.add(temp.val);
                    on = false;
                }
                // 如果该节点的左节点不为null，则将其加入队列中
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                // 如果该节点的右节点不为null，则将其加入队列中
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
        // 返回列表中最后一个值，即二叉树中最底层的左边的节点的值
        return list.get(list.size() - 1);
    }
}
