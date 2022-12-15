package leetcode.singleNumber;

import java.util.HashSet;
import java.util.Set;

public class Offer_003 {
    /**
     * 剑指Offer003.数组中重复的数字
     * 找出数组中重复的数字。
     * 在一个长度为n的数组nums里的所有数字都在0～n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int num:nums){
            //如果set中不能添加这个数了，说明在set中已经存在了
            //这个时候直接返回这个数字即可
            if (!set.add(num)){
                return num;
            }
        }
        return -1;
    }
}
