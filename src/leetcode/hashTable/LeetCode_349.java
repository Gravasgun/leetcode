package leetcode.hashTable;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_349 {
    /**
     * 349.两个数组的交集
     * 给定两个数组nums1和nums2，返回它们的交集。输出结果中的每个元素一定是唯一的。我们可以不考虑输出结果的顺序。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        // 存放结果，之所以用set是为了给结果集去重
        Set<Integer> result = new HashSet<>();

        //将nums1中的每个元素放入set,目的是去重
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            //如果set中包含了nums2中的元素
            if (set.contains(nums2[i])) {
                //往result中添加，目的是去重
                result.add(nums2[i]);
            }
        }
        //将result转换为数组
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
