package leetcode.tree;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {

    /* Write Code Here */
    public int calculateMaxTotalYie(int[][] cropField) {
        // 寻找和最大的行
        List<Integer> rowList = new ArrayList<>();
        for (int i = 0; i < cropField.length; i++) {
            int maxSum = 0;
            for (int j = 0; j < cropField[0].length; j++) {
                maxSum += cropField[i][j];
            }
            rowList.add(maxSum);
        }

        // 寻找和最大的行的下标
        int rowMax = Collections.max(rowList);
        int rowMaxIndex = 0;
        for (int i = 0; i < rowList.size(); i++) {
            if (rowMax == rowList.get(i)) {
                rowMaxIndex = i;
            }
        }

        // 寻找和最大的列
        List<Integer> colList = new ArrayList<>();
        for (int i = 0; i < cropField[0].length; i++) {
            int maxSum = 0;
            for (int j = 0; j < cropField.length; j++) {
                maxSum += cropField[j][i];
            }
            colList.add(maxSum);
        }

        //寻找和最大的列的下标
        int colMax = Collections.max(colList);
        int colMaxIndex = 0;
        for (int i = 0; i < colList.size(); i++) {
            if (colMax == colList.get(i)) {
                colMaxIndex = i;
            }
        }

        // 确定重复的那个数字 cropField[rowMaxIndex][colMaxIndex]
        // 行翻倍 行不变，列在变
        for (int i = 0; i < cropField[0].length; i++) {
            if (i == colMaxIndex) {
                continue;
            }
            cropField[rowMaxIndex][i] *= 2;
        }

        // 列翻倍 列不变，行在变
        for (int i = 0; i < cropField.length; i++) {
            if (i == rowMaxIndex) {
                continue;
            }
            cropField[i][colMaxIndex] *= 2;
        }
        // 求和
        int sum = 0;
        for (int i = 0; i < cropField.length; i++) {
            for (int j = 0; j < cropField[0].length; j++) {
                sum += cropField[i][j];
            }
        }
        sum += cropField[rowMaxIndex][colMaxIndex];
        return sum;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int cropField_rows = 0;
        int cropField_cols = 0;
        cropField_rows = in.nextInt();
        cropField_cols = in.nextInt();

        int[][] cropField = new int[cropField_rows][cropField_cols];
        for (int cropField_i = 0; cropField_i < cropField_rows; cropField_i++) {
            for (int cropField_j = 0; cropField_j < cropField_cols; cropField_j++) {
                cropField[cropField_i][cropField_j] = in.nextInt();
            }
        }

        if (in.hasNextLine()) {
            in.nextLine();
        }


        res = new Solution().calculateMaxTotalYie(cropField);
        System.out.println(res);

        //样例输入
        //4 4
        //2 3 1 4
        //1 2 0 3
        //4 2 1 7
        //3 1 4 2
    }
}