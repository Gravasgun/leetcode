package leetcode.arrayList.doublePoint;

public class LeetCode_283 {
    /**
     * 283.移动零
     * 给定一个数组nums，编写一个函数将所有0移动到数组的末尾，同时保持非零元素的相对顺序。
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int left=0;
        for (int right=0;right< nums.length;right++){
            if (nums[right]!=0){
                nums[left]=nums[right];
                left++;
            }
        }
        //剩下的全是0
        for (;left< nums.length;left++){
            nums[left]=0;
        }
    }
}
