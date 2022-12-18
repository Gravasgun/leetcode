package leetcode.arrayList.singleNumber;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LeetCode_137 {
    /**
     * 137.只出现一次的数字II
     * 题目描述：给你一个整数数组nums，除某个元素仅出现一次外，其余每个元素都恰出现三次。请你找出并返回那个只出现了一次的元素。
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        /**
         * 思路：用hashmap，将数组中的值作为key,这个数字在数组中出现的次数作为value。
         */
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            //如果map中找不到这个数字,就把这个数字放进map,设置value(出现的次数)为1
            if (map.get(num) == null) {
                map.put(num, 1);
            } else {
                //map中找到了这个数字，说明这个数字是重复的，就要把value(出现的次数)加一，再放入map，因为map中的key重复了，所以value的值会被替换掉
                int count = map.get(num);
                map.put(num, ++count);
            }
            //map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        //遍历map，寻找value=1的key
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            if (entry.getValue() == 1) {
                result = entry.getKey();
                break;
            }
        }
        return result;
    }
}
