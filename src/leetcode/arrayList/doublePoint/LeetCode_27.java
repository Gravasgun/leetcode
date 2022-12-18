package leetcode.arrayList.doublePoint;

public class LeetCode_27 {
    /**
     * 27.移除元素
     * 给你一个数组 nums和一个值val，你需要原地移除所有数值等于val的元素，并返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须仅使用O(1)额外空间并原地修改输入数组。
     *
     * @param nums
     * @param val
     * @return
     */
    //双指针
    public int removeElementMethodOne(int[] nums, int val) {
        //慢指针，从左到右更新数组的元素
        int slow = 0;
        //快指针，寻找不含有目标元素的元素
        for (int fast = 0; fast < nums.length; fast++) {
            //当快指针所指的数不等于val的时候(找到了)，将fast指针所指的值赋值给slow指针（更新slow指针的值）
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    //暴力解法：
    public int removeElementMethodTwo(int[] nums, int val) {
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            //发现需要移除的元素，就将数组集体向前移动一位
            if (nums[i] == val) {
                for (int j = i + 1; j < nums.length; j++) {
                    nums[j - 1] = nums[j];
                }
                //因为下标i以后的数值都向前移动了一位，所以i也向前移动一位
                i--;
                //此时数组的大小-1
                length--;
            }
        }
        return length;
    }
}
