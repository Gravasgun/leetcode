package leetcode.arrayList.doublePoint;

import java.util.Arrays;

public class LeetCode_88 {
    /**
     * 88.合并两个有序数组
     * 给你两个按非递减顺序排列的整数数组nums1和nums2，另有两个整数m和n，分别表示nums1和nums2中的元素数目。
     * 请你合并nums2到nums1中，使合并后的数组同样按非递减顺序排列。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    //方法一：双指针
    public void mergeMethodOne(int[] nums1, int m, int[] nums2, int n) {
        //nums1的指针
        int point1 = 0;
        //nums2的指针
        int point2 = 0;
        //新数组
        int[] result = new int[m + n];
        for (int i = 0; i < result.length; i++) {
            //防止point1越界(当一个数组的元素遍历完的时候，数组下标因为自增的原因，会出现越界的情况)
            if (point1 >= m) {
                result[i] = nums2[point2++];
                //防止破point2越界(当一个数组的元素遍历完的时候，数组下标因为自增的原因，会出现越界的情况)
            } else if (point2 >= n) {
                result[i] = nums1[point1++];
                //如果第一个数组的元素比第二个数组的元素小
            } else if (nums1[point1] < nums2[point2]) {
                //把第一个数组的元素赋值给新数组
                result[i] = nums1[point1++];
            } else {
                //把第二个数组的元素赋值给新数组
                result[i] = nums2[point2++];
            }
        }

        for (int i = 0; i < result.length; i++) {
            nums1[i] = result[i];
        }
    }

    //方法二：合并后排序
    public void mergeMethodTwo(int[] nums1, int m, int[] nums2, int n) {
        //nums2的指针
        int j = 0;
        //合并这两个数组
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[j++];
        }
        //合并完成，直接排序
        Arrays.sort(nums1);
    }
}
