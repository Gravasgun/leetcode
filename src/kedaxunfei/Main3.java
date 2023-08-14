package kedaxunfei;

import java.util.*;
/**
 * 题目描述：
 * 给定两个不含重复元素的整数列表list1和list2，
 * 求出这两个集合中不重复的连续子集的数量，
 * 连续：在原集合中连续
 *
 * 输入描述：
 * 第一行包含一个整数N，表示list1和list2的长度。
 * 第二行包含N个不重复的整数，表示list1的元素。
 * 第三行包含N个不重复的整数，表示list2的元素。
 *
 * 输出描述：
 * 输出一个整数，表示满足条件的不同连续子序列的总数。
 */

public class Main3 {
    static Set<List> set = new HashSet<>();
    static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // 输入列表长度
        int length = input.nextInt();
        // 存储 list1 的元素
        List<Integer> list1 = new ArrayList<>(length);
        // 存储 list2 的元素
        List<Integer> list2 = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            // 读取 list1 的元素
            list1.add(input.nextInt());
        }
        for (int i = 0; i < length; i++) {
            // 读取 list2 的元素
            list2.add(input.nextInt());
        }
        // 对 list1 进行连续子集的查找
        test(list1);
        // 对 list2 进行连续子集的查找
        test(list2);
        // 输出不同连续子集的数量
        System.out.println(set.size());
    }

    // 连续子集查找函数
    private static void test(List list) {
        if (list == null || list.size() == 0) {
            return;
        }
        // 调用回溯算法查找连续子集
        backTracking(list, 0);
    }

    // 回溯算法查找连续子集
    private static void backTracking(List<Integer> list, int startIndex) {
        for (int i = startIndex; i < list.size(); i++) {
            // 获取当前元素在原集合中的索引
            int index1 = getIndex(list, list.get(i));
            int index2 = 0;
            if (path.size() != 0) {
                // 获取当前路径最后一个元素在原集合中的索引
                index2 = getIndex(list, path.get(path.size() - 1));
            }

            if (path.size() == 0 || Math.abs(index1 - index2) == 1) {
                // 添加当前元素到路径
                path.add(list.get(i));
                // 将当前路径作为连续子集添加到结果集合中
                set.add(new ArrayList<>(path));
            } else {
                break;
            }
            // 递归查找下一个元素
            backTracking(list, i + 1);
            // 回溯，移除当前元素
            path.remove(path.size() - 1);
        }
    }

    // 获取元素在原集合中的索引
    private static int getIndex(List<Integer> list, int num) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (num == list.get(i)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
