package leetcode.hashTable;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_202 {
    /**
     * 202.快乐数
     * 编写一个算法来判断一个数n是不是快乐数。
     *「快乐数」定义为：
     *  对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
     *  然后重复这个过程直到这个数变为1，也可能是无限循环但始终变不到1。
     *  如果这个过程结果为1，那么这个数就是快乐数。
     *  如果n是快乐数就返回true,不是则返回false。
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        //用来判断是否出现无限循环
        Set<Integer> set = new HashSet<>();
        //当n=1或者出现无限循环时，跳出while循环
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            //取这个数组的最后一位
            int num = n % 10;
            //做求和运算
            sum += num * num;
            //舍弃掉最后一位数字，再进入循环
            n = n / 10;
        }
        return sum;
    }
}
