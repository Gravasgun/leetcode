package leetcode.singleNumber;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LeetCode_260 {
    /**
     * 260.只出现一次的数字III
     * 题目描述：给你一个整数数组nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。找出只出现一次的那两个元素。你可以按任意顺序返回答案。
     *
     * @param nums
     * @return
     */
    //方法一：用hashmap，将数组中的值作为key,这个数字在数组中出现的次数作为value。
    public int[] singleNumberMethodOne(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] list = new int[2];
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

        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        //遍历map，寻找value=1的key
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            if (entry.getValue() == 1) {
                list[index++] = entry.getKey();
            }
        }
        return list;
    }

    //方法二：位运算：^
    public int[] twoSingleNumberMethodTwo(int[] nums) {
        int num1 = 0;
        for (int num : nums) {
            num1 ^= num;
        }
        //num1=a^b，因为a和b是两个不同的数 -> num1不等于0(^运算,相同为0) -> num1的某一位上一定是1,说明a和b在这一位上的值不同
        int rightOne = num1 & (~num1 + 1);//提取出num1这个数字最右侧的1
        int type1 = 0;//用来保存a或者b
        int type2;//用来保存a或者b
        for (int num : nums) {
            //把nums中的所有元素分成两类，其中一类包含所有二进制表示的第m位为0的数，另一类包含所有二进制表示的第m位为1的数
            //对于任意一个在数组nums中出现两次的元素，该元素的两次出现会被包含在同一类中,再进行一次异或运算,也会被抵消掉
            //对于任意一个在数组nums中只出现了一次的元素，即a,b 它们会被包含在不同类中，再进行一次异或运算，就会得到其中的一个数字
            if ((num & rightOne) == 0) {
                type1 ^= num;
            }
            //type1要么为a要么为b
        }
        //type2=a^b^a=b(type1=a的情况) || type2=a^b^b=a(type1=b的情况)
        type2 = num1 ^ type1;
        return new int[]{type1, type2};
    }
}
