/**
 * Author: chiou
 * createTime: 2023/7/29
 * Description: No Description
 */
public class Array {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 请实现无重复数字的升序数组的二分查找
     * <p>
     * 给定一个 元素升序的、无重复数字的整型数组 nums 和一个目标值 target ，
     * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标（下标从 0 开始），否则返回 -1
     *
     * @param nums   int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search(int[] nums, int target) {
        //todo 存在返回下标 不存在返回-1
        //1.边界判断
        if (nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        //2.查找
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // 找到目标值，返回索引
            } else if (nums[mid] < target) {
                left = mid + 1; // 目标值可能在右半部分，更新左指针
            } else {
                right = mid - 1; // 目标值可能在左半部分，更新右指针
            }
        }

        return -1; // 没有找到目标值，返回 -1
    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 在一个二维数组array中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * [
     * [1,2,8,9],
     * [2,4,9,12],
     * [4,7,10,13],
     * [6,8,11,15]
     * ]
     * 给定 target = 7，返回 true。
     * <p>
     * 给定 target = 3，返回 false。
     *
     * @param target int整型
     * @param array  int整型二维数组
     * @return bool布尔型
     */
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }

        int rows = array.length;
        int cols = array[0].length;

        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            int value = array[row][col];
            if (value == target) {
                return true;
            } else if (value < target) {
                // 当前值小于目标值，说明目标值可能在当前值的下方，因为下方的值更大
                row++;
            } else {
                // 当前值大于目标值，说明目标值可能在当前值的左边，因为左边的值更小
                col--;
            }
        }

        // 没有找到目标值
        return false;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 给定一个长度为n的数组nums，请你找到峰值并返回其索引。数组可能包含多个峰值，
     * 在这种情况下，返回任何一个所在位置即可。
     * 1.峰值元素是指其值严格大于左右相邻值的元素。严格大于即不能有等于
     * 2.假设 nums[-1] = nums[n] = −∞−∞
     * 3.对于所有有效的 i 都有 nums[i] != nums[i + 1]
     * 4.你可以使用O(logN)的时间复杂度实现此问题吗？
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int findPeakElement(int[] nums) {
        // write code here
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] >= nums[m + 1]) {
                // 如果当前元素大于等于其右边相邻元素，说明峰值在左半部分或者当前位置就是峰值
                r = m;
            } else {
                // 如果当前元素小于其右边相邻元素，说明峰值在右半部分
                l = m + 1;
            }
        }
        // 当循环结束时，left 和 right 指向同一个位置，即峰值元素的索引
        return l;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
     * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P mod 1000000007
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int InversePairs(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        return mergeSort(nums, 0, nums.length - 1) % 1000000007;
    }

    /**
     * 归并排序，统计逆序对的数量
     *
     * @param nums  数组
     * @param left  左边界
     * @param right 右边界
     * @return 逆序对的数量
     */
    public int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = (left + right) / 2;
        // 分别对左右两个部分进行归并排序
        int leftNum = mergeSort(nums, left, mid);
        int rightNum = mergeSort(nums, mid + 1, right);
        // 合并左右两个有序数组并统计逆序对数量
        int leftAndRight = merge(nums, left, mid, right);
        // 返回当前合并阶段发现的逆序对数量
        return rightNum + leftNum + leftAndRight;
    }

    /**
     * 合并两个有序数组，并统计逆序对的数量
     *
     * @param nums  数组
     * @param left  左边界
     * @param mid   中间索引
     * @param right 右边界
     * @return 当前合并阶段发现的逆序对数量
     */
    public int merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int leftStart = left;
        int rightStart = mid + 1;
        int index = 0;
        int count = 0; // 统计逆序对的数量

        while (leftStart <= mid && rightStart <= right) {
            if (nums[leftStart] <= nums[rightStart]) {
                temp[index++] = nums[leftStart++];
            } else {
                temp[index++] = nums[rightStart++];
                // 统计逆序对的数量，因为右边数组有一个元素小于左边数组的当前元素，说明构成了逆序对
                count += mid - leftStart + 1;
                // 对逆序对数量进行取模，避免溢出
                count %= 1000000007;
            }
        }

        // 将左边数组剩余的元素复制到临时数组
        while (leftStart <= mid) {
            temp[index++] = nums[leftStart++];
        }

        // 将右边数组剩余的元素复制到临时数组
        while (rightStart <= right) {
            temp[index++] = nums[rightStart++];
        }

        // 将临时数组中的元素拷贝回原数组
        for (int i = 0; i < temp.length; i++) {
            nums[left + i] = temp[i];
        }

        // 返回当前合并阶段发现的逆序对数量
        return count;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 有一个长度为 n 的非降序数组，比如[1,2,3,4,5]，将它进行旋转，
     * 即把一个数组最开始的若干个元素搬到数组的末尾，变成一个旋转数组，
     * 比如变成了[3,4,5,1,2]，或者[4,5,1,2,3]这样的。
     * 请问，给定这样一个旋转数组，求数组中的最小值。
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int minNumberInRotateArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // 如果中间元素大于右边界的元素，说明最小值在右半部分
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            // 如果中间元素小于右边界的元素，说明最小值在左半部分或就是中间元素本身
            else if (nums[mid] < nums[right]) {
                right = mid;
            }
            // 如果中间元素等于右边界的元素，不能确定最小值在左半部分还是右半部分，但是可以将右边界向左移动
            // 因为右边界的元素一定不会是最小值，可以排除掉
            else {
                right--;
            }
        }

        // 当循环结束时，left 和 right 指向同一个位置，即旋转数组中的最小值
        return nums[left];
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 比较版本号
     * 牛客项目发布项目版本时会有版本号，比如1.02.11，2.14.4等等
     * 现在给你2个版本号version1和version2，请你比较他们的大小
     * 版本号是由修订号组成，修订号与修订号之间由一个"."连接。
     * 1个修订号可能有多位数字组成，
     * 修订号可能包含前导0，且是合法的。例如，1.02.11，0.1，0.2都是合法的版本号
     * 每个版本号至少包含1个修订号。
     * 修订号从左到右编号，下标从0开始，最左边的修订号下标为0，下一个修订号下标为1，以此类推。
     * <p>
     * 比较规则：
     * 一. 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较忽略任何前导零后的整数值。比如"0.1"和"0.01"的版本号是相等的
     * 二. 如果版本号没有指定某个下标处的修订号，则该修订号视为0。例如，"1.1"的版本号小于"1.1.1"。因为"1.1"的版本号相当于"1.1.0"，第3位修订号的下标为0，小于1
     * 三.  version1 > version2 返回1，如果 version1 < version2 返回-1，不然返回0.
     *
     * @param version1 string字符串
     * @param version2 string字符串
     * @return int整型
     */
    public int compare(String version1, String version2) {
        // 分割版本号字符串为修订号数组
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int length = Math.max(v1.length, v2.length);
        for (int i = 0; i < length; i++) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;

            // 比较当前修订号
            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
            // 当前修订号相等，继续比较下一个修订号
        }

        // 两个版本号完全相等
        return 0;
    }
}
