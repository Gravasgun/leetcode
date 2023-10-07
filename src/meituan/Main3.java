package meituan;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int y = input.nextInt();
        int z = input.nextInt();
        int sum = 0;
        int index = 0;
        while (sum < z) {
            if (index++ % 3 == 0) {
                sum += x + y;
            } else {
                sum += x;
            }
        }
        System.out.println(index);
    }
}
