package camacoder;

import java.util.Scanner;

public class Coder_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int num1 = input.nextInt();
            int num2 = input.nextInt();
            System.out.println(num1 + num2);
        }
    }
}
