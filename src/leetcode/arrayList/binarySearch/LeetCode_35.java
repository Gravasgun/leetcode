package leetcode.arrayList.binarySearch;

public class LeetCode_35 {
    /**
     * 35.搜索插入位置
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
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
        //执行到这里，说明数组中不存在target这个值，并且right比left小1，相当于[right,left]，nums[right]<target<nums[left],此时返回right+1或者left都可以
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int num = searchInsert(nums, 7);
        System.out.println(num);
    }
}
