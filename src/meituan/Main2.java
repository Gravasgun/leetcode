package meituan;

import java.util.*;

/**
 * 题目描述：
 * 小美现在有一串彩带，假定每一厘米的彩带上都是一种色彩。
 * <p>
 * 因为任务的需要，小美希望从彩带上截取一段，使得彩带中的颜色数量不超过K种。
 * <p>
 * 显然，这样的截取方法可能非常多。于是小美决定尽量长地截取一段。
 * <p>
 * 你的任务是帮助小美截取尽量长的一段，使得这段彩带上不同的色彩数量不超过K种。
 */

/**
 * 输入描述：第一行两个整数N,K，以空格分开，分别表示彩带有N厘米长，你截取的一段连续的彩带不能超过K种颜色。
 * <p>
 * 接下来一行N个整数，每个整数表示一种色彩，相同的整数表示相同的色彩。
 * <p>
 * 1≤N,K≤5000，彩带上的颜色数字介于[1, 2000]之间。
 * <p>
 * 输出描述：一行，一个整数，表示选取的彩带的最大长度。
 */
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(); // 用于存放窗口内不同的颜色
        Scanner input = new Scanner(System.in);
        int length = input.nextInt(); // 彩带的长度
        int count = input.nextInt(); // 截取的彩带中不同颜色的最大数量
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(input.nextInt());
        }
        int result = 0; // 最终结果
        for (int left = 0; left < list.size() - 1; left++) { // 枚举左端点
            set.clear(); // 清空集合，准备处理下一个窗口
            set.add(list.get(left)); // 加入左端点的颜色
            for (int temp = left + 1; temp < list.size(); temp++) { // 枚举右端点
                set.add(list.get(temp)); // 加入右端点的颜色
                if (set.size() == count + 1) { // 如果窗口中不同的颜色数量超过了k，则停止右移
                    result = Math.max(result, temp - left); // 记录当前窗口的长度
                    break;
                }
            }
        }
        System.out.println(result); // 输出结果
    }
}
