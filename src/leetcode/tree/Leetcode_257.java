package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 257.二叉树的所有路径
 * 给你一个二叉树的根节点root，按任意顺序 ，返回所有从根节点到叶子节点的路径。
 */
public class Leetcode_257 {
    /**
     * 方法一：迭代
     * @param root
     * @return
     */
    public List<String> binaryTreePathsMethodOne(TreeNode root) {
        // 创建一个空的列表来存储结果
        List<String> result = new ArrayList<>();
        // 如果根节点为空，直接返回结果列表
        if (root == null) {
            return result;
        }
        // 创建一个栈用于保存遍历到的节点和路径信息
        Stack<Object> stack = new Stack<>();
        // 将根节点和根节点值的字符串形式压入栈中
        stack.push(root);
        stack.push(root.val + "");
        // 当栈非空时进行循环
        while (!stack.isEmpty()) {
            // 从栈顶弹出一个路径
            String path = (String) stack.pop();
            // 从栈顶弹出一个节点
            TreeNode node = (TreeNode) stack.pop();
            // 如果该节点是叶子节点，将路径加入结果列表
            if (node.left == null && node.right == null) {
                result.add(path);
            }
            // 如果该节点有右子节点，将右子节点和路径信息压入栈中
            if (node.right != null) {
                stack.push(node.right);
                stack.push(path + "->" + node.right.val);
            }
            // 如果该节点有左子节点，将左子节点和路径信息压入栈中
            if (node.left != null) {
                stack.push(node.left);
                stack.push(path + "->" + node.left.val);
            }
        }
        // 返回结果列表
        return result;
    }

    /**
     * 方法二：递归
     * @param root
     * @return
     */
    public List<String> binaryTreePathsMethodTwo(TreeNode root) {
        List<String> result = new ArrayList<>(); // 用于存储结果的列表
        if (root == null) {
            return result; // 如果根节点为空，直接返回结果列表
        }
        List<Integer> paths = new ArrayList<>(); // 用于存储当前路径的列表
        traversal(root, result, paths); // 开始遍历二叉树，查找所有路径
        return result; // 返回结果列表
    }

    // 递归函数，用于遍历二叉树
    private void traversal(TreeNode temp, List<String> result, List<Integer> paths) {
        paths.add(temp.val); // 将当前节点添加到路径列表中
        if (temp.left == null && temp.right == null) { // 如果当前节点是叶子节点，说明已经遍历到了一条完整的路径
            StringBuilder sb = new StringBuilder(); // 创建一个StringBuilder对象
            for (int i = 0; i < paths.size() - 1; i++) { // 遍历路径列表，将所有节点的值添加到StringBuilder对象中
                sb.append(paths.get(i)).append("->"); // 添加节点值和箭头符号"->"
            }
            sb.append(paths.get(paths.size() - 1)); // 添加最后一个节点的值
            result.add(sb.toString()); // 将StringBuilder对象转换为字符串并添加到结果列表中
            return; // 返回
        }
        if (temp.left != null) { // 如果左子节点不为空，继续遍历左子树
            traversal(temp.left, result, paths);
            paths.remove(paths.size() - 1); // 移除路径列表中的最后一个元素，回溯到上一个节点
        }
        if (temp.right != null) { // 如果右子节点不为空，继续遍历右子树
            traversal(temp.right, result, paths);
            paths.remove(paths.size() - 1); // 移除路径列表中的最后一个元素，回溯到上一个节点
        }
    }
}
