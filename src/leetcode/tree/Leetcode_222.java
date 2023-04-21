package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 222.完全二叉树的节点个数
 * 给你一棵完全二叉树的根节点root，求出该树的节点个数。
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含1~ 2h个节点。
 */
public class Leetcode_222 {
    /**
     * 方法一：广度优先遍历(层序遍历)
     *
     * @param root
     * @return
     */
    public int countNodesMethodOne(TreeNode root) {
        // 1. 如果根节点为空，直接返回0。
        if (root == null) {
            return 0;
        }
        int result = 0; // 计数器，用于记录节点总数
        Queue<TreeNode> queue = new LinkedList<>(); // 初始化一个队列，用于层序遍历二叉树
        TreeNode temp = root; // 定义一个临时节点，初始值为根节点
        queue.offer(temp); // 将根节点入队
        while (!queue.isEmpty()) { // 当队列不为空时，循环执行以下操作：
            int size = queue.size(); // 获取队列中的节点数，记为size。
            List<TreeNode> list = new ArrayList<>(); // 初始化一个列表，用于存储当前层的所有节点。
            while (size-- > 0) { // 循环size次，每次从队列中取出一个节点
                temp = queue.poll(); // 取出队头节点
                list.add(temp); // 将节点加入到列表中
                if (temp.left != null) { // 如果节点有左子节点，将其加入到队列中
                    queue.offer(temp.left);
                }
                if (temp.right != null) { // 如果节点有右子节点，将其加入到队列中
                    queue.offer(temp.right);
                }
            }
            result += list.size(); // 将当前层的节点数加到计数器中
        }
        return result; // 返回节点总数
    }

    /**
     * 方法二：深度优先搜索(递归)
     *
     * @param root
     * @return
     */
    public int countNodesMethodTwo(TreeNode root) {
        // 如果根节点为空，直接返回 0，表示节点数为 0
        if (root == null) {
            return 0;
        }
        // 递归计算左子树节点数
        int leftNum = countNodesMethodTwo(root.left);
        // 递归计算右子树节点数
        int rightNum = countNodesMethodTwo(root.right);
        // 返回左子树节点数、右子树节点数和根节点（1）的和
        return leftNum + rightNum + 1;
    }

    /**
     * 方法三：利用满二叉树的特性
     *
     * @param root
     * @return
     */
    public int countNodesMethodThree(TreeNode root) {
        if (root == null) {  // 如果根节点为空，返回0
            return 0;
        }
        TreeNode left = root.left;  // 获取当前节点的左节点
        TreeNode right = root.right;  // 获取当前节点的右节点
        int leftCount = 0;  // 左子树深度
        int rightCount = 0;  // 右子树深度
        while (left != null) {  // 循环计算左子树深度
            left = left.left;
            leftCount++;
        }
        while (right != null) {  // 循环计算右子树深度
            right = right.right;
            rightCount++;
        }
        if (leftCount == rightCount) {  // 如果左右子树深度相等
            return (2 << leftCount) - 1;  // 完全二叉树节点数公式
        }
        int leftNum = countNodesMethodThree(root.left);  // 递归计算左子树节点数
        int rightNum = countNodesMethodThree(root.right);  // 递归计算右子树节点数
        return leftNum + rightNum + 1;  // 返回总节点数
    }

}
