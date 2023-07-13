package leetcode.tree;

public class Leetcode_654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // 如果数组为空，则返回 null
        if (nums.length == 0) {
            return null;
        }
        // 找到数组中的最大值和其下标
        int[] array = findMaxNum(nums);
        int maxIndex = array[1];
        TreeNode root = new TreeNode(array[0]);
        // 创建左子树的数组
        int[] left = new int[maxIndex];
        for (int i = 0; i < left.length; i++) {
            left[i] = nums[i];
        }
        // 创建右子树的数组
        int[] right = new int[nums.length - 1 - maxIndex];
        int rightIndex = 0;
        for (int i = maxIndex + 1; i < nums.length; i++) {
            right[rightIndex++] = nums[i];
        }
        // 递归构建左右子树
        TreeNode leftNode = constructMaximumBinaryTree(left);
        TreeNode rightNode = constructMaximumBinaryTree(right);
        // 将左右子树连接到根节点
        root.left = leftNode;
        root.right = rightNode;
        // 返回根节点
        return root;
    }

    // 找到数组中的最大值和其下标
    public int[] findMaxNum(int[] nums) {
        int maxIndex = 0;
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // 如果找到比当前最大值还大的数，则更新最大值和下标
            if (nums[i] > maxNum) {
                maxNum = nums[i];
                maxIndex = i;
            }
        }
        return new int[]{maxNum, maxIndex};
    }
}
