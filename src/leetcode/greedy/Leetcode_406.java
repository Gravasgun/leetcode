package leetcode.greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 406.根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
 * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue
 * 其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 */
public class Leetcode_406 {
    public int[][] reconstructQueue(int[][] people) {
        // 局部最优：优先按身高 高的people的k 来插入 插入操作后的people满足队列属性
        // 全局最优：最后都做完插入操作，整个队列满足题目队列属性

        // 根据身高降序排列，如果身高相同，则按照 k 值升序排列
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return b[0] - a[0];
            }
        });
        // 创建一个用于存储重构队列的列表
        List<int[]> queue = new LinkedList<>();
        // 遍历排序后的 people 数组
        for (int[] person : people) {
            // 将当前人插入到对应的位置
            // 根据 k 值将当前人插入到列表的指定索引位置
            // 因为在 LinkedList 中插入元素会将后面的元素后移，所以可以直接插入到指定的索引位置
            queue.add(person[1], person);
        }
        // 将列表转换为二维数组并返回
        return queue.toArray(people);
    }
}
