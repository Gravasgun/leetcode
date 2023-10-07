package qianxin;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param planks int整型一维数组 
     * @return bool布尔型
     */
    public boolean CheckSquare (int[] planks) {
        // write code here
        int sum= Arrays.stream(planks).sum();
        if (sum%4==0){
            return true;
        }
        return false;
    }
}