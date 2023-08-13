package kedaxunfei;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        boolean flag = false;
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int k = input.nextInt();
        if (k < 0) {
            flag = true;
        }
        String s = "";
        Scanner inputS = new Scanner(System.in);
        if (inputS.hasNextLine()) {
            s = inputS.nextLine();
        }

        int[] result = new int[length];
        result[0] = k;

        for (int i = 1; i < result.length; i++) {
            if (result[i - 1] == -1) {
                flag = true;
                break;
            }
            int score = s.charAt(i) - s.charAt(i - 1);
            if (score <= 0) {
                result[i] = result[i - 1] + Math.abs(score);
            } else {
                result[i] = result[i - 1] - score;
            }
            if (result[i] < 0) {
                result[i] = -1;
            }
        }
        if (flag) {
            System.out.println(-1);
        } else {
            System.out.println(result[result.length - 1]);
        }
    }
}
