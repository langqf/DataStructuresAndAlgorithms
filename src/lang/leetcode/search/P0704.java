package lang.leetcode.search;

/** 二分查找
 *
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 示例 1:
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 *
 * 示例 2:
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 *
 * 提示：
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 *
 */
public class P0704 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 9));
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 2));
        System.out.println(search(new int[]{12}, 12));
    }

    /**
     * 初始条件：left = 0, right = length-1
     * 终止：left > right
     * 向左查找：right = mid-1
     * 向右查找：left = mid +1
     */
    public static int search(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(target < nums[mid]){
                right = mid - 1;
            }else if(target > nums[mid]){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return index;
    }

    /**
     * 初始条件：left = 0, right = length-1
     * 终止：left > right
     * 向左查找：right = mid-1
     * 向右查找：left = mid +1
     */
    public static int search1(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        int mid = (left +right)/2; // int mid = low + (high - low) / 2;
        while(left <= right){
            if(target < nums[mid]){
                right = mid - 1;
                mid = (left + right)/2;
            }else if(target > nums[mid]){
                left = mid + 1;
                mid = (left + right)/2;
            }else {
                return mid;
            }
        }
        return index;
    }
}
