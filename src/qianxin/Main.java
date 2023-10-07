package qianxin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int num=input.nextInt();
        solution(num);
    }

    private static void solution(int num) {
        for (int i = 0; i <= num; i++) {
            if (success(i)){
                System.out.println(i);
            }
        }
    }

    private static boolean success(int num) {
        int originalNum=num;
        int n=String.valueOf(num).length();
        int sum=0;
        while (sum>0){
            int digit=num%10;
            sum+=Math.pow(digit,n);
            num/=10;
        }
        return sum==originalNum;
    }
}
