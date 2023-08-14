package kedaxunfei;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        List<Integer> list = new ArrayList<>(length);
        list.add(1);
        for (int i = 1; i < length; i++) {
            list.add( length - list.get(i - 1) + 1);
        }
        StringBuilder sb = new StringBuilder();
        List<Integer> collect = list.stream().distinct().collect(Collectors.toList());
        for (int i = collect.size()-1; i >= 0; i--) {
            if (i == 0) {
                sb.append(collect.get(i));
            } else {
                sb.append(collect.get(i) + " ");
            }
        }
        System.out.println(sb);
    }
}
