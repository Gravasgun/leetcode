package leetcode;

public class LeetCode_704 {
    /**
     * 704.二分查找
     * 给定一个n个元素有序的（升序）整型数组nums和一个目标值target，写一个函数搜索nums中的target，如果目标值存在返回下标，否则返回-1。
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (target < nums[middle]) {
                //target在左区间，所以[left, middle - 1]
                right = middle - 1;
            } else if (target > nums[middle]) {
                //target在右区间，所以[middle + 1, right]
                left = middle + 1;
            } else {
                //nums[middle] == target
                //数组中找到目标值，直接返回下标
                return middle;
            }
        }
        //未找到目标值
        return -1;
    }
}
