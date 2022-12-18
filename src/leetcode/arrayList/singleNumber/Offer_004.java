package leetcode.arrayList.singleNumber;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Offer_004 {
    /**
     * 剑指Offer004
     * 题目：给你一个整数数组nums，除某个元素仅出现一次外，其余每个元素都恰出现三次。请你找出并返回那个只出现了一次的元素。
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        /**
         * 思路：用hashmap，将数组中的值作为key,这个数字出现的次数作为value。
         */
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            //将数组中的元素一一放入map，这个元素作为key,出现的次数作为value。
            //map.getOrDefault(num, 0) + 1)这个方法表示：
            //如果map中存在key为num的value,那么这个方法的返回值就是value，如果不存在，就把第二个参数设置成value,返回值也设置成value。
            //例如：第一次拿key=num的元素，肯定不存在,那么默认值就是0
            //第二次拿key=value的元素，存在了，value=1
            if (map.get(num) == null) {
                map.put(num, 1);
            } else {
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
