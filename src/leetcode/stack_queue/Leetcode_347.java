package leetcode.stack_queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 347.前K个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 */
public class Leetcode_347 {
    public int[] topKFrequent(int[] nums, int k) {
        // 创建一个哈希表来记录每个数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) == null) { // 如果哈希表中没有这个数字，将其添加到哈希表中，并设置出现次数为 0
                map.put(num, 0);
            } else { // 如果哈希表中已经有这个数字，将其出现次数加 1
                Integer count = map.get(num);
                map.put(num, ++count);
            }
        }
        // 创建一个小根堆来存储出现次数最高的 k 个数字
        PriorityQueue<int[]> queue = new PriorityQueue<>((arr1, arr2) -> arr1[1] - arr2[1]);
        // 遍历哈希表中的每一对键值对
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            // 如果小根堆中的元素个数小于 k，直接将该键值对添加到小根堆中
            if (queue.size() < k) {
                queue.add(new int[]{entry.getKey(), entry.getValue()});
            } else { // 否则，比较小根堆中的最小值和当前键值对的出现次数，如果后者更大，替换小根堆中的最小值
                if (queue.peek()[1] < entry.getValue()) {
                    queue.poll();
                    queue.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        // 将小根堆中的元素转移到结果数组中
        int[] arr = new int[k];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = queue.poll()[0];
        }
        return arr;
    }
}