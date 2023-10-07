package camacoder;

import java.util.Scanner;

public class Coder_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int lineNum = input.nextInt();
            int line = 0;
            while (line++ < lineNum) {
                int num1 = input.nextInt();
                int num2 = input.nextInt();
                System.out.println(num1 + num2);
            }
        }
    }
}
