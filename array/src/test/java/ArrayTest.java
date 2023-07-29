import org.junit.Test;

/**
 * Author: chiou
 * createTime: 2023/7/29
 * Description: No Description
 */
public class ArrayTest {
    @Test
    public void binarySearchTest() {
        int[] nums = {1, 2, 5, 8, 10};
        int target = 7;
        Array array = new Array();
        System.out.println("array.search(nums,target) = " + array.search(nums, target));
    }

    @Test
    public void findTest() {
        int[][] nums = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15},
        };
        int target = 1;
        Array array = new Array();
        boolean flag = array.Find(target, nums);
        System.out.println("flag = " + flag);
    }

    @Test
    public void InversePairsTest() {
        int[] nums = {4, 3, 2, 1};
        Array r = new Array();
        int pairs = r.InversePairs(nums);
        System.out.println("pairs = " + pairs);
    }

    @Test
    public void compareTest() {
        Array r = new Array();
        String version1 = "1";
        String version2 = "1";
        int compare = r.compare(version1, version2);
        System.out.println(compare);


    }
}
