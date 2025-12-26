package lang.leetcode.array;

import java.util.Arrays;

/**
 *
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 * 示例 3：
 *
 * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 * 输出：[1]
 * 解释：需要合并的数组是 [] 和 [1] 。
 * 合并结果是 [1] 。
 * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 *
 *
 * 提示：
 *
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -10⁹ <= nums1[i], nums2[j] <= 10⁹
 *
 *
 * 进阶：你可以设计实现一个时间复杂度为 O(m + n) 的算法解决此问题吗？
 *
 */
public class P0088 {

    public static void main(String[] args) {
        int nums1[] = {1,2,3,0,0,0},nums2[] = {2,5,6};
        int m1 = 3,n1 = 3;
        merge(nums1, m1, nums2, n1);
        System.out.println(Arrays.toString(nums1));

        int nums1_2[] = {1},nums2_2[] = {};
        int m2 = 1,n2 = 0;
        merge(nums1_2, m2, nums2_2, n2);
        System.out.println(Arrays.toString(nums1_2));

        int nums1_3[] = {0},nums2_3[] = {1};
        int m3 = 0,n3 = 1;
        merge(nums1_3, m3, nums2_3, n3);
        System.out.println(Arrays.toString(nums1_3));

        int nums1_4[] = {2,0},nums2_4[] = {1};
        int m4 = 1,n4 = 1;
        merge(nums1_4, m4, nums2_4, n4);
        System.out.println(Arrays.toString(nums1_4));
    }

    // 时间复杂度O(n²)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0){
            return;
        }
        if(m == 0){
            for (int k = 0; k < nums1.length; k++) {
                nums1[k] = nums2[k];
            }
            return;
        }
        int len = m + n;
        int count = 0 ;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < len; j++) {
                if(nums2[i] < nums1[j]){
                    // nums2中元素较小，需要在位置j插入nums2[i]，nums1中j位置后的元素都要后移
                    // 如果nums2中元素较大，继续向前比较nums1中元素，直到比nums1中元素小才后移
                    for(int k = len-1 ; k > j ; k--){
                        nums1[k] = nums1[k-1];
                    }
                    nums1[j] = nums2[i];
                    count++;
                    break;
                }
            }
        }
        // 将剩余的nums2的数据复制到nums1中
        if(count < n){
            int rest = n -count;
            for (int i = 0; i < rest; i++) {
                nums1[len-rest+i] = nums2[count+i];
            }
        }
    }

    // 通过两两比较大小的方式有序插入临时数组中，时间复杂度O(m+n)
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0){
            return;
        }
        if(m == 0){
            for (int k = 0; k < nums1.length; k++) {
                nums1[k] = nums2[k];
            }
            return;
        }
        int numsTemp[] = new int[m+n];
        int i = 0,j = 0;
        while(i < m && j < n ){
            if(nums1[i] <= nums2[j]){
                numsTemp[i + j] = nums1[i];
                i++;
            }else{
                numsTemp[i + j] = nums2[j];
                j++;
            }
        }
        if(i < m ){
            for (int k = i; k < m; k++) {
                numsTemp[n+k] = nums1[k];
            }
        }
        if (j < n ){
            for (int k = j; k < n; k++) {
                numsTemp[m+k] = nums2[k];
            }
        }
        for (int k = 0; k < nums1.length; k++) {
            nums1[k] = numsTemp[k];
        }
    }


}
