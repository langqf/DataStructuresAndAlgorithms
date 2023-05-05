package lang.leetcode.other;

import java.util.Arrays;

/** 颜色分类(荷兰国旗问题)
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 *
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 *
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 *
 * 进阶：
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 */
public class P0075 {

    public static void main(String[] args) {
        int[] nums1 = {2,0,2,1,1,0};
        sortColors(nums1);
        System.out.println(Arrays.toString(nums1));
        int[] nums2 = {2,0,1};
        sortColors(nums2);
        System.out.println(Arrays.toString(nums2));
        int[] nums3 = {2,0,1,0,1,2,1,2,0,0,1,2,1,2};
        sortColors(nums3);
        System.out.println(Arrays.toString(nums3));
    }

    // 三指针 从两头遍历 0,1,2
    public static void sortColors(int[] nums) {
        int p0 = 0, p1 = 0, p2 = nums.length - 1;
        while (p1 <= p2) {
            if(nums[p1] == 0){
                swap(nums, p0, p1);
                p0++;
                p1++;
            }else if(nums[p1] == 2){
                swap(nums, p2, p1);
                p2--;
            }else{
                p1++;
            }
        }
    }
    // 双指针二 从左往右，遍历一遍
    public static void sortColors2(int[] nums) {
        int p0 = 0, p2 = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            while(i < p2 && nums[i] == 2){
                swap(nums, p2, i);
                p2--;
                i++;
            }
            if(nums[i] == 0){
                swap(nums, p0, i);
                p0++;
            }
        }
    }
    // 双指针一 从左往右，遍历一遍
    public static void sortColors1(int[] nums) {
        int p0 = 0, p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1){
                swap(nums, p1, i);
                p1++;
            }else if(nums[i] == 0){
                swap(nums, p0, i);
                if(p0 < p1){ // 如果p0指向的是1，则把1交换出去后，要交换回来
                    swap(nums, p1, i);
                }
                p0++;
                p1++;
            }
        }
    }

    private static void swap(int[] nums, int i , int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    // 分别统计0,1,2的个数
    public static void sortColors3(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                count0++;
            }else if(nums[i] == 1){
                count1++;
            }else {
                count2++;
            }
        }
        int i = 0;
        while(i < count0){
            nums[i] = 0;
            i++;
        }
        int j = 0;
        while(j < count1){
            nums[i+j] = 1;
            j++;
        }
        int ij = i + j;
        int k = 0;
        while(k < count2){
            nums[ij+k] = 2;
            k++;
        }
    }

    // 单指针 遍历两遍
    public static void sortColors0(int[] nums) {
        int p = 0;
        // 所有0排前面
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                swap(nums, p, i);
                p++;
            }
        }
        // 所有1排前面
        for (int i = p; i < nums.length; i++) {
            if(nums[i] == 1){
                swap(nums, p, i);
                p++;
            }
        }
    }
}
