package leetcode.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * 860.柠檬水找零
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * 注意，一开始你手头没有任何零钱。
 * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 */
public class Leetcode_860 {
    public boolean lemonadeChange(int[] bills) {
        // 检查第一个支付的钞票是否为5美元，以及第二个支付的钞票是否为20美元
        if (bills[0] != 5 || bills[1] == 20) {
            return false;
        }
        // 创建一个 HashMap 用于记录手中各种面额的钞票数量
        Map<Integer, Integer> map = new HashMap<>();
        // 遍历顾客支付的钞票
        for (int i = 0; i < bills.length; i++) {
            // 更新 HashMap 中对应面额的钞票数量
            if (map.get(bills[i]) == null) {
                map.put(bills[i], 1);
            } else {
                Integer num = map.get(bills[i]);
                map.put(bills[i], num + 1);
            }
            // 如果支付的钞票面额为10美元
            if (bills[i] == 10) {
                // 检查是否有5美元的钞票可用来找零
                if (map.get(5) < 1) {
                    return false; // 无法找零，返回false
                } else {
                    // 找零5美元
                    map.put(5, map.get(5) - 1);
                }
            }
            // 如果支付的钞票面额为20美元
            if (bills[i] == 20) {
                // 优先使用一张10美元和一张5美元进行找零
                // 局部最优：遇到账单20，优先消耗美元10，完成本次找零
                // 全局最优：完成全部账单的找零
                if (map.get(10) != null && map.get(5) != null && map.get(10) >= 1 && map.get(5) >= 1) {
                    map.put(10, map.get(10) - 1);
                    map.put(5, map.get(5) - 1);
                } else if (map.get(5) >= 3) {
                    // 如果没有足够的10美元钞票，尝试找零三张5美元钞票
                    map.put(5, map.get(5) - 3);
                } else {
                    return false; // 无法找零，返回false
                }
            }
        }
        return true; // 所有顾客都找零成功，返回true
    }
}