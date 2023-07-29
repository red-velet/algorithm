import java.util.Random;

/**
 * Author: chiou
 * createTime: 2023/7/28
 * Description: No Description
 */
public class MyMergeSortArray {
    public static void main(String[] args) {
        int[] nums = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            nums[i] = new Random().nextInt(1000000) + 100;
        }
        long start = System.currentTimeMillis();
        mergeSort(nums);
        long end = System.currentTimeMillis();
        System.out.println("\n耗时: ");
        System.out.println((end - start) + "毫秒");
    }

    public static void mergeSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        mergeSort(nums, 0, nums.length - 1);
    }

    public static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = (left + right) / 2;
        mergeSort(nums, left, middle);
        mergeSort(nums, middle + 1, right);
        merge(nums, left, middle, right);
    }

    public static void merge(int[] nums, int left, int middle, int right) {
        int capacity = right - left + 1;
        int[] temp = new int[capacity];
        int leftStart = left;
        int rightStart = middle + 1;
        for (int i = 0; i < temp.length; i++) {
            if (leftStart > middle) {
                temp[i] = nums[rightStart++];
            } else if (rightStart > right) {
                temp[i] = nums[leftStart++];
            } else if (nums[leftStart] < nums[rightStart]) {
                temp[i] = nums[leftStart++];
            } else {
                temp[i] = nums[rightStart++];
            }
        }
        for (int i = 0; i < temp.length; i++) {
            nums[left + i] = temp[i];
        }
    }

    public static void printArr(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.print("\n");
    }
}
