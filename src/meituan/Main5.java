package meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Main5 {
    //    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int length = input.nextInt();
//        int average = input.nextInt();
//        int[] nums = new int[length];
//        for (int i = 0; i < length; i++) {
//            nums[i] = input.nextInt();
//        }
//        int result = -1;
//        for (int i = 0; i < nums.length - 1; i++) {
//            int sum = nums[i];
//            for (int j = i + 1; j < nums.length; j++) {
//                sum += nums[j];
//                if (sum / (j - i + 1) == average && sum % (j - i + 1) == 0) {
//                    result = Math.max(result, j - i + 1);
//                }
//            }
//        }
//        System.out.println(result);
//    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int average = input.nextInt();
        int[] nums = new int[length];
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = input.nextInt();
        }
        Arrays.fill(result, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum / (i + 1) == average && sum % (i + 1) == 0) {
                result[i] = i + 1;
            }
        }
        int max = Arrays.stream(result).max().getAsInt();
        System.out.println(max);
    }
}
