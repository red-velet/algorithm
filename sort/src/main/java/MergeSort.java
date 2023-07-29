/**
 * Author: chiou
 * createTime: 2023/7/28
 * Description: No Description
 */
public class MergeSort {
    // 归并排序主函数
    public static void mergeSort(int[] arr) {
        // 检查输入数组是否为空或只有一个元素，如果是，则无需排序
        if (arr == null || arr.length <= 1) {
            return;
        }

        // 调用归并排序函数，传入待排序数组、数组起始位置和结束位置
        mergeSort(arr, 0, arr.length - 1);
    }

    // 归并排序递归函数
    private static void mergeSort(int[] arr, int start, int end) {
        // 当子数组只有一个元素时，不需要继续划分
        if (start >= end) {
            return;
        }

        // 找到中间位置
        int mid = (start + end) / 2;

        // 递归地对左侧子数组进行排序
        mergeSort(arr, start, mid);

        // 递归地对右侧子数组进行排序
        mergeSort(arr, mid + 1, end);

        // 合并左右子数组
        merge(arr, start, mid, end);
    }

    // 合并函数
    private static void merge(int[] arr, int start, int mid, int end) {
        // 创建临时数组，用于合并时暂存排序结果
        int[] temp = new int[end - start + 1];

        // 定义左侧子数组的起始位置和右侧子数组的起始位置
        int leftStart = start;
        int rightStart = mid + 1;

        // 循环遍历左右子数组，比较元素并放入临时数组中
        for (int i = 0; i < temp.length; i++) {
            // 检查左侧子数组是否已经遍历完
            if (leftStart > mid) {
                temp[i] = arr[rightStart++];
            }
            // 检查右侧子数组是否已经遍历完
            else if (rightStart > end) {
                temp[i] = arr[leftStart++];
            }
            // 比较左右子数组的元素，将较小的元素放入临时数组中
            else if (arr[leftStart] < arr[rightStart]) {
                temp[i] = arr[leftStart++];
            } else {
                temp[i] = arr[rightStart++];
            }
        }

        // 将临时数组中的排序结果复制回原数组对应的位置
        for (int i = 0; i < temp.length; i++) {
            arr[start + i] = temp[i];
        }
    }

    // 测试用例
    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("原始数组: ");
        printArray(arr);

        mergeSort(arr);

        System.out.println("\n排序后的数组: ");
        printArray(arr);
    }

    // 辅助函数，用于打印数组
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
