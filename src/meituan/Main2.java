package meituan;

import java.util.*;

/**
 * ��Ŀ������
 * С��������һ���ʴ����ٶ�ÿһ���׵Ĳʴ��϶���һ��ɫ�ʡ�
 * <p>
 * ��Ϊ�������Ҫ��С��ϣ���Ӳʴ��Ͻ�ȡһ�Σ�ʹ�òʴ��е���ɫ����������K�֡�
 * <p>
 * ��Ȼ�������Ľ�ȡ�������ܷǳ��ࡣ����С�������������ؽ�ȡһ�Ρ�
 * <p>
 * ��������ǰ���С����ȡ��������һ�Σ�ʹ����βʴ��ϲ�ͬ��ɫ������������K�֡�
 */

/**
 * ������������һ����������N,K���Կո�ֿ����ֱ��ʾ�ʴ���N���׳������ȡ��һ�������Ĳʴ����ܳ���K����ɫ��
 * <p>
 * ������һ��N��������ÿ��������ʾһ��ɫ�ʣ���ͬ��������ʾ��ͬ��ɫ�ʡ�
 * <p>
 * 1��N,K��5000���ʴ��ϵ���ɫ���ֽ���[1, 2000]֮�䡣
 * <p>
 * ���������һ�У�һ����������ʾѡȡ�Ĳʴ�����󳤶ȡ�
 */
public class Main2 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int count = input.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(input.nextInt());
        }
        int result = 0;
        for (int left = 0; left < list.size() - 1; left++) {
            set.clear();
            set.add(list.get(left));
            for (int temp = left + 1; temp < list.size(); temp++) {
                set.add(list.get(temp));
                if (set.size() == count + 1) {
                    result = Math.max(result, temp - left);
                    break;
                }
            }
        }
        System.out.println(result);
    }
}