package lang.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/** 数组拆分
 * 给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到 n 的 min(ai, bi) 总和最大。
 * 返回该 最大总和 。
 *
 * 示例 1：
 *
 * 输入：nums = [1,4,3,2]
 * 输出：4
 * 解释：所有可能的分法（忽略元素顺序）为：
 * 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
 * 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
 * 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
 * 所以最大总和为 4
 * 示例 2：
 *
 * 输入：nums = [6,2,6,5,1,2]
 * 输出：9
 * 解释：最优的分法为 (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9
 *
 *
 * 提示：
 *
 * 1 <= n <= 104
 * nums.length == 2 * n
 * -104 <= nums[i] <= 104
 *
 */
//TODO 除了排序方法之外，还有另外一种最快方式 看官方题解
public class P0561 {
    public static void main(String[] args) {
        int[] nums1 = {1,4,3,2};
        System.out.println(arrayPairSum(nums1));

        int[] nums2 = {6,2,6,5,1,2};
        System.out.println(arrayPairSum(nums2));

        int size = 10;
        int[] numsRandom = new int[size];
        for (int i = 0; i < size; i++) {
            numsRandom[i] = (int)(Math.random() * 100);
        }
        System.out.println(Arrays.toString(numsRandom));
        bubbleSort(numsRandom);
        System.out.println(Arrays.toString(numsRandom));
    }
    // 先排序，再取奇数项的和
    public static int arrayPairSum(int[] nums) {
        bubbleSort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            sum += nums[i];
        }
        return sum;
    }

    // 冒泡排序
    public static void bubbleSort(int[] nums){
        int length= nums.length;
        for (int n = 0; n < length; n++) {
            for (int i = 0; i < nums.length - length - 1; i++) {
                if(nums[i] > nums[i+1]){
                    int temp = nums[i + 1];
                    nums[i + 1] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        /* 老师的
        int length = nums.length;
        for (int i = 0; i < nums.length; i++){
            for (int j = 1; j < length - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }*/
    }
}
