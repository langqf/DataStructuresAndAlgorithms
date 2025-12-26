package lang.leetcode.array;

/**
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 示例 1:
 *
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 *
 * 提示:
 *
 * 1 <= nums.length <= 10⁴
 * -10⁴ <= nums[i] <= 10⁴
 * nums 为 无重复元素 的 升序 排列数组
 * -10⁴ <= target <= 10⁴
 */
public class P0035 {

    public static void main(String[] args) {
        int nums1[] = {1,3,5,6,7,8,9,11,22};
        int target1 = 10;
        System.out.println(returnIdx(nums1, target1));

        int nums2[] = {1,3,5,6};
        int target2 = 5;
        System.out.println(returnIdx(nums2, target2));
    }

    public static int returnIdx(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        int mid = (start + end) / 2;
        while(start <= end){
            if(start == end){
                return nums[mid] >= target ? mid : mid + 1;
            }else{
                if(nums[mid] > target){
                    end = mid;
                }else if(nums[mid]  < target){
                    start = mid + 1;
                }else{
                    return mid;
                }
            }
            mid = (start + end) / 2;
        }
        return mid;
    }
    // 官方解法 更简洁，逻辑更清晰
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }


}
