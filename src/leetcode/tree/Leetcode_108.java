package leetcode.tree;

/**
 * 108.将有序数组转换为二叉搜索树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 */
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
        // 递归终止条件：如果左索引大于右索引，说明当前子数组为空，返回null
        if (left > right) {
            return null;
        }
        // 计算中间元素的索引
        int mid = (left + right) / 2;
        // 创建当前中间元素作为根节点的二叉树节点
        TreeNode root = new TreeNode(nums[mid]);
        // 递归构建左子树，左子数组范围是从left到mid-1
        root.left = buildSearchTree(nums, left, mid - 1);
        // 递归构建右子树，右子数组范围是从mid+1到right
        root.right = buildSearchTree(nums, mid + 1, right);
        // 返回构建得到的二叉搜索树的根节点
        return root;
    }
}
