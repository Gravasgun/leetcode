package leetcode.arrayList.singleNumber;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Offer_003 {
    /**
     * 剑指Offer003.数组中重复的数字
     * 找出数组中重复的数字。
     * 在一个长度为n的数组nums里的所有数字都在0～n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     *
     * @param nums
     * @return
     */
    public int findRepeatNumberMethodOne(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            //如果set中不能添加这个数了，说明在set中已经存在了
            //这个时候直接返回这个数字即可
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }

    //方法二：hashMap
    public int findRepeatNumberMethodTwo(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) == null) {
                map.put(num, 1);
            } else {
                int count = map.get(num);
                map.put(num, ++count);
            }
        }
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            if (entry.getValue() != 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
