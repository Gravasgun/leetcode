package leetcode.arrayList.singleNumber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode_217 {
    /**
     * 217.存在重复元素
     * 给你一个整数数组nums。如果任一值在数组中出现至少两次，返回true；如果数组中每个元素互不相同，返回false 。
     *
     * @param nums
     * @return
     */
    //方法一：哈希set
    public boolean containsDuplicateMethodOne(int[] nums) {
        /**
         * 思路：对于数组中每个元素，我们将它放入到哈希表中。如果插入一个元素时发现该元素已经存在于哈希表中，则说明存在重复的元素。
         */
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    //方法二：排序
    public boolean containsDuplicateMethodTwo(int[] nums) {
        /**
         * 思路：在对数字从小到大排序之后，数组的重复元素一定出现在相邻位置中。因此，我们可以扫描已排序的数组，每次判断相邻的两个元素是否相等，如果相等则说明存在重复的元素。
         */
        Arrays.sort(nums);
        //循环条件是nums.length - 1，两两比较时循环次数会少1
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
