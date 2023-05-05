package lang.leetcode.other;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/** 数组中的第K个最大元素
 *
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 *
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 *
 * 提示：
 * 1 <= k <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 *
 */
public class P0215 {

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }

    // TODO 利用小顶堆解决  还可以利用快排思想
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if(nums[i] > queue.peek()){
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.peek();
    }

    // 排序 时间复杂度不满足要求
    public static int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

}
