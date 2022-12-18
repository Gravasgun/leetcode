package leetcode.arrayList.binarySearch;

public class LeetCode_34 {
    /**
     * 34.在排序数组中查找元素的第一个和最后一个位置
     * 给你一个按照非递减顺序排列的整数数组nums，和一个目标值target。请你找出给定目标值在数组中的开始位置和结束位置。
     * 如果数组中不存在目标值 target，返回[-1, -1]。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        //先找数组中是否存在这个数字
        int index = search(nums, target);
        //如果index=-1，说明数组中不存在这个数字，那么直接返回[-1, -1]
        if (index == -1) {
            return new int[]{-1, -1};
        }
        //执行到这里，说明数组中存在这个数字，这时就要寻找左边界和右边界
        int left = index;
        int right = index;
        //在left左边的数字中找，找左边界
        //防止数组越界。逻辑短路，两个条件顺序不能换
        while (left - 1 >= 0 && nums[left - 1] == target) {
            left--;
        }
        //在right右边的数字找，找右边界
        //防止数组越界。逻辑短路，两个条件顺序不能换
        while (right + 1 < nums.length && nums[right + 1] == target) {
            right++;
        }
        return new int[]{left, right};
    }

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
