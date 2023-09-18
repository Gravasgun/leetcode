package meituan;
import java.util.*;

/**
 * 题目描述：
 * 小美现在有一串彩带，假定每一厘米的彩带上都是一种色彩。
 * 因为任务的需要，小美希望从彩带上截取一段，使得彩带中的颜色数量不超过K种。
 * 显然，这样的截取方法可能非常多。于是小美决定尽量长地截取一段。
 * 你的任务是帮助小美截取尽量长的一段，使得这段彩带上不同的色彩数量不超过K种。
 *
 * 输入描述：第一行两个整数N,K，以空格分开，分别表示彩带有N厘米长，你截取的一段连续的彩带不能超过K种颜色。
 * 接下来一行N个整数，每个整数表示一种色彩，相同的整数表示相同的色彩。
 * 1≤N,K≤5000，彩带上的颜色数字介于[1, 2000]之间。
 * 输出描述：一行，一个整数，表示选取的彩带的最大长度。
 */

public class Main2 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        Scanner input = new Scanner(System.in);
        // 输入彩带的长度
        int length = input.nextInt();
        // 输入彩带中不同颜色的数量限制
        int count = input.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            // 输入每个厘米的颜色
            list.add(input.nextInt());
        }
        // 最终截取的最大长度
        int result = 0;
        for (int left = 0; left < list.size() - 1; left++) {
            // 清空当前的颜色集合
            set.clear();
            // 添加第一个厘米的颜色
            set.add(list.get(left));
            for (int temp = left + 1; temp < list.size(); temp++) {
                // 添加下一个厘米的颜色
                set.add(list.get(temp));
                // 如果颜色种类超过了限制
                if (set.size() == count + 1) {
                    // 计算当前截取的长度并更新最大长度
                    result = Math.max(result, temp - left);
                    // 跳出内层循环
                    break;
                }
            }
        }
        // 输出结果，即最大长度
        System.out.println(result);
    }
}
