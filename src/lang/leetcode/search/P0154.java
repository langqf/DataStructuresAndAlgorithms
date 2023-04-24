package lang.leetcode.search;

/** 寻找旋转排序数组中的最小值 II
 *
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
 * 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * 你必须尽可能减少整个过程的操作步骤。
 *
 * 示例 1：
 * 输入：nums = [1,3,5]
 * 输出：1
 *
 * 示例 2：
 * 输入：nums = [2,2,2,0,1]
 * 输出：0
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 *
 *
 * 进阶：这道题与 寻找旋转排序数组中的最小值 类似，但 nums 可能包含重复元素。允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
 *
 */
public class P0154 {

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,1,2}));
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMin(new int[]{11,13,15,17}));
        System.out.println(findMin(new int[]{4}));
        System.out.println(findMin(new int[]{3,1,2}));
        System.out.println(findMin(new int[]{4,5,6,7,0,1,4}));
        System.out.println(findMin(new int[]{2,2,2,0,1}));
        System.out.println(findMin(new int[]{3,1}));
        System.out.println(findMin(new int[]{3,3,1}));
        System.out.println(findMin(new int[]{3,3,1,3,3,3}));
        System.out.println(findMin(new int[]{3,1,3,3}));
        System.out.println(findMin(new int[]{3,1,3,}));
        System.out.println(findMin(new int[]{1,3}));
        System.out.println(findMin(new int[]{10,1,10,10,10}));
    }

    // 思路，以右边元素做参考，找到从右往左的最小值
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return nums[left];
    }

    // 思路，以左边元素做参考，找到从左到右的最大值 可能跳过中间最小元素  在存在重复元素时，该方法不能使用
    public static int findMin1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(nums[mid] > nums[left]){
                left = mid;
            }else if(nums[mid] < nums[left]){
                right = mid - 1;
            }else if(nums[mid] == nums[left]) {// 这里和P0153不同，有相等的情况，缩小边界
               left++;
            }
        }
        return nums[(left + 1)%nums.length];
    }
}
