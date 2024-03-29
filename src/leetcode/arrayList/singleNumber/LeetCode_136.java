package leetcode.arrayList.singleNumber;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode_136 {
    /**
     * 136.只出现一次的数字
     * 题目描述：给你一个非空整数数组nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * @param nums
     * @return
     */
    //方法一:hashSet，这种方法只适用于重复的数字出现了偶数次,只能找出 出现奇数次的数字
    public int singleNumberMethodOne(int[] nums) {
        //思路：在hashset集合中，如果一个数不能被添加进集合，说明这个数在set集合中已经存在了，这个时候只要删除集合中的这个数字，就可以得到数组中出现奇数次数的数字
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }
        return (int) set.toArray()[0];
    }

    //方法二:^，异或运算，这种方法只适用于重复的数字出现了偶数次
    public int singleNumberMethodTwo(int[] nums) {
        //思路：使用位运算^，让数组中的每一个元素都与0做^运算。
        //如果一个数字出现偶数次，这个数字与0进行异或运算，那么结果为0。
        //如果一个数字出现奇数次，这个数字与0进行异或运算，那么结果为这个数本身。
        //再结合交换律,可以把一堆乱序的异或运算变成有序的异或运算,比如：0^(a^a^a^a)^(b^b^b)=(a^a^a^a)^(b^b^b)=b。
        //4个a异或运算结果为0，3个b异或运算结果为b，最后化简为:a^b=0^b=b。
        int temp = 0;
        for (int num : nums) {
            temp ^= num;
        }
        return temp;
    }

    //方法三：与法一相同的思路，只不过调用了不同的api
    public int singleNumberMethodThree(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return (int) set.toArray()[0];
    }

    //方法四：HashMap，数字作为map的key，数字出现的次数作为map的value。最后遍历map，找出次数为一的数字。
    public int singleNumberMethodFour(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) == null) {
                map.put(num, 1);
            } else {
                int count = map.get(num);
                map.put(num, ++count);
            }
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

