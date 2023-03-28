package leetcode.arrayList.sort;

/**
 * —°‘Ò≈≈–Ú
 */
public class SelectSort {
    public static int[] select_sort(int[] arr) {
        if (arr == null && arr.length < 2) {
            return arr;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
        return arr;
    }

    public static void swap(int[] arr, int num1, int num2) {
        int temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 10, 6, 8, 7, 55, 99, 44, 63, 78};
        int[] numArr = select_sort(nums);
        for (int num : numArr) {
            System.out.print(num + " ");
        }
    }
}
