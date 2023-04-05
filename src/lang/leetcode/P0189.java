package lang.leetcode;

import java.util.Arrays;

/** 轮转数组
 *给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 *
 * 示例 2:
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 *
 * 提示：
 * 1 <= nums.length <= 10(5)
 * -2(31) <= nums[i] <= 2(31) - 1
 * 0 <= k <= 10(5)
 *
 * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 *
 */
public class P0189 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,6,7};
        int k1 = 3;
        rotate(nums1, k1);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " "); // 输出数组元素
        }
        System.out.println("\n***********");
        int[] nums2 = {-1,-100,3,99};
        int k2 = 2;
        rotate(nums2, k2);
        for (int i = 0; i < nums2.length; i++) {
            System.out.print(nums2[i] + " "); // 输出数组元素
        }
        System.out.println("\n***********");
        int[] nums3 = {-1};
        int k3 = 2;
        rotate(nums3, k3);
        for (int i = 0; i < nums3.length; i++) {
            System.out.print(nums3[i] + " "); // 输出数组元素
        }
    }
    // 利用数组反转
    public static void rotate(int[] nums, int k) {
        k = k%nums.length;
        reverseNums(nums, 0, nums.length-1);// 全部反转
        reverseNums(nums, 0, k-1);// 反转前k位
        reverseNums(nums, k, nums.length - 1);// 从第k位开始，反转后面lenth-k位
    }

    /**
     *
     * @param nums 要反转的数组
     * @param i
     * @param j
     */
    public static void reverseNums(int[] nums, int i, int j) {
        // i,j分别表示要反转的两个数的位置
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    // 每次移动一位，移动k次  时间复杂度O(k*n)太高，n表示数组长度
    // leetcode不通过，超出时间限制
    public static void rotate2(int[] nums, int k) {
        int len = nums.length;
        if(len == 1){
            return;
        }
        int s = k%len;
        if(s == 0){
            return;
        }
        int cnt = 0;
        while(cnt < k){
            int last = nums[len-1];
            for (int i = len-1; i > 0; i--) {
                nums[i] = nums[i-1];
            }
            nums[0] = last;
            cnt++;
        }
    }

    // 将最后s位先存起来，再移位，再还原最后s位
    public static void rotate1(int[] nums, int k) {
        int len = nums.length;
        if(len == 1){
            return;
        }
        int s = k%len;
        if(s == 0){
            return;
        }
        // 将最后s位先存起来
        int[] tempInt = new int[s];
        for(int i = 0; i < s ; i++){
            tempInt[i] = nums[len-1-i];
        }
        // 从len-s位开始移动，每次移动s位
        for (int i = len-s-1; i >= 0; i--) {
            nums[i+s] = nums[i];
        }
        // 处理tempInt的s位数据赋给nums
        for (int i = 0; i < s; i++) {
            nums[s-1-i] = tempInt[i];
        }
    }

    // 利用另外一个空数组，找到下标后，存入其中，最后再复制回来
    public static void rotate0(int[] nums, int k) {
        int len = nums.length;
        if(len == 1){
            return;
        }
        int s = k%len;
        if(s == 0){
            return;
        }
        int[] tempNums = new int[len];
        for (int i = 0; i < len; i++) {
            int j = (i + s)%len;
            tempNums[j] = nums[i];
        }
        for (int i = 0; i < len; i++) {
            nums[i] = tempNums[i];
        }
    }

}
