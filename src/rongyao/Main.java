package rongyao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 给定一个包含数字和其他字符的字符串，你需要从中提取数字字符，并按照升序排列输出这些数字。
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        List<Integer> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 判断字符是否为数字
            if (Character.isDigit(chars[i])) {
                // 将数字字符转换为整数并添加到列表中
                list.add(Integer.parseInt(String.valueOf(chars[i])));
            }
        }
        // 将列表中的整数转换为整数数组
        int[] nums = list.stream().mapToInt(Integer::intValue).toArray();
        // 对整数数组进行升序排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 打印排序后的数字
            System.out.print(nums[i]);
        }
    }
}
