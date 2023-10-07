package meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int count = input.nextInt();
        int[] nums = new int[length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = input.nextInt();
        }
        if (length > count) {
            for (int i = 0; i < count; i++) {
                Arrays.sort(nums);
                int[] indexs = getIndex(nums);
                //Ìæ»»
                nums[indexs[0]] = 1;
                nums[indexs[1]] = indexs[2];
            }
        }
        System.out.println(Arrays.stream(nums).sum() % 1000000007);
    }

    private static int[] getIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] indexs = new int[3];
        int max = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = max;
                max = Math.max(nums[i] * nums[j], max);
                if (max > temp) {
                    indexs[0] = i;
                    indexs[1] = j;
                    indexs[2] = max;
                }
            }
        }
        return indexs;
    }
}
