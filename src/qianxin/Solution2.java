package qianxin;

import java.io.*;
import java.util.*;


public class Solution2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 获取最大收益理财产品组合
     *
     * @param products Point类ArrayList 理财产品数据列表
     * @param months   int整型 总投入月份
     * @return Point类ArrayList
     */
    public ArrayList<Point> maxIncomeProducts(ArrayList<Point> products, int months) {
        // write code here
        //BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("a.xt"));
        ArrayList<Point> list = new ArrayList<>();
        int[] values = new int[products.size()];
        int[] weight = new int[products.size()];
        //初始化
        for (int i = 0; i < products.size(); i++) {
            weight[i] = products.get(i).x;
            values[i] = products.get(i).y;
        }
        int[] result = new int[months + 1];
        //填充dp数组
        for (int i = 0; i < weight.length; i++) {
            for (int j = weight[i]; j < result.length; j++) {
                int temp = result[j];
                result[j] = Math.max(result[j], result[j - weight[i]] + values[i]);
                if (result[j] != temp) {
                    list.add(new Point(weight[i], values[i]));
                }
            }
        }
        return list;
    }
}