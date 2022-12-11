package sort;

public class BubbleSort {
    public static int[] bubble_sort(int[] arr) {
        if (arr == null && arr.length < 2) {
            return arr;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }

            }
        }
        return arr;
    }

    public static void swap(int[] arr, int num1, int num2) {
        arr[num1] = arr[num1] ^ arr[num2];
        arr[num2] = arr[num1] ^ arr[num2];
        arr[num1] = arr[num1] ^ arr[num2];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 10, 6, 8, 7, 55, 99, 44, 63, 78};
        int[] numArr = bubble_sort(nums);
        for (int num : numArr) {
            System.out.print(num + " ");
        }
    }
}
