package leetcode.arrayList.sort;

public class InsertionSort {
    public static int[] insert_sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            //这样写的话，j就不会只有才在j=0的时候才结束了，减少第二个循环的次数。
            for (int j = i - 1; j >= 0 && nums[j] > nums[j + 1]; j--) {
                swap(nums, j, j + 1);
            }
        }
        return nums;
    }


//    public static int[] insert_sort(int[] nums) {
//        for (int i = 1; i < nums.length; i++) {
//            //j变为0的时候，第二个for循环才结束
//            for (int j = i - 1; j >= 0; j--) {
//                if (nums[j] > nums[j + 1]) {
//                    swap(nums, j, j + 1);
//                }
//            }
//        }
//        return nums;
//    }

//    public static int[] insert_sort(int[] nums) {
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = i - 1; j >= 0; j--) {
//                if (nums[j] > nums[i]) {
//                    //这里i发生变化了，导致第二个循环结束时,i的值可能会出现之前重复过的值，那么j的值也会跟着发生变化，且j的值也是重复过的值
//                    //此时这两个循环都会发生重复
//                    swap(nums, j, i--);
//                }
//            }
//        }
//        return nums;
//    }

    public static void swap(int[] arr, int num1, int num2) {
        arr[num1] = arr[num1] ^ arr[num2];
        arr[num2] = arr[num1] ^ arr[num2];
        arr[num1] = arr[num1] ^ arr[num2];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 10, 6, 8, 7, 55, 99, 44, 63, 78};
        int[] numArr = insert_sort(nums);
        for (int num : numArr) {
            System.out.print(num + " ");
        }
    }
}

