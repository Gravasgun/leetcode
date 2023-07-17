package leetcode.tree;

public class Leetcode_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildSearchTree(nums, 0, nums.length - 1);
    }

    /**
     * 递归构建二叉搜索树
     *
     * @param nums  有序数组
     * @param left  当前子数组的起始索引
     * @param right 当前子数组的结束索引
     * @return 构建得到的二叉搜索树的根节点
     */
    private TreeNode buildSearchTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildSearchTree(nums, left, mid - 1);
        root.right = buildSearchTree(nums, mid + 1, right);
        return root;
    }
}
