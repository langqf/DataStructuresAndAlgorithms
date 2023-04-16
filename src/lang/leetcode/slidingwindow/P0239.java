package lang.leetcode.slidingwindow;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/** 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。
 * 滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 *
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 *
 * 提示：
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 *
 */
public class P0239 {

    public static void main(String[] args) {
        int[] nums1 = maxSlidingWindow(new int[]{-7,-8,7,5,3,1,6,0}, 4);
        System.out.println(Arrays.toString(nums1));
        // [3, 3, 5, 5, 6, 7]
        int[] nums2 = maxSlidingWindow(new int[]{-6,-10,-7,-1,-9,9,-8,-4,10,-5,2,9,0,-7,7,4,-2,-10,8,7}, 7);
        System.out.println(Arrays.toString(nums2));
        // [9,9,10,9,9,9,10,10,10,9,9,9,8,8]
        //[9,9,10,10,10,10,10,10,10,9,9,9,8,8]
    }

    // 双端队列中存数组下标索引 时间复杂度：O(n)  空间复杂度：O(k)
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int ri = 0;
        Deque<Integer> deque = new LinkedList<>();// 使用双端队列来存储滑动窗口中的元素下标。
        for (int i = 0; i < n; i++) {
            // 如果队列不为空且队首元素的下标小于 i-k+1，说明队首元素已经不在当前滑动窗口中，将其弹出队列。
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            // 如果队列不为空且队尾元素对应的数值小于 nums[i]，说明队尾元素不可能成为当前滑动窗口的最大值，将其弹出队列。
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // 将 i 加入队列。
            deque.offerLast(i);
            // 如果 i-k+1>=0，说明当前滑动窗口已经形成，将队首元素对应的数值加入结果数组 res。
            if (i - k + 1 >= 0) {
                res[ri++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }

    // 利用双端队列 ArrayDeque 每次滑动到新位置时，清除比其小的其他元素
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if(k == 1){
            return nums;
        }
        int len = nums.length - k + 1;
        int[] maxNums = new int[len];
        ArrayDeque<Integer> doubleEndedQueue = new ArrayDeque();
        for (int i = 0; i < nums.length; i++) {
            // 清除比其小的其他元素
            while(doubleEndedQueue.size() > 0 && doubleEndedQueue.getLast() < nums[i]){
                doubleEndedQueue.pollLast();
            }
            doubleEndedQueue.offer(nums[i]);
            // 最大值不在窗口中，删除最大值
            if(i >= k && nums[i-k] == doubleEndedQueue.getFirst()){
                doubleEndedQueue.pollFirst();
            }
            if(i >= k - 1){
                maxNums[i-k+1] = doubleEndedQueue.getFirst();
            }
        }
        return maxNums;
    }

    // 利用双端队列 LinkedList  维持一个窗口大小的容量，队头放最大值，出现新的最大值时，清空队列，只保持这个最大值
    public static int[] maxSlidingWindow3(int[] nums, int k) {
        if(k == 1){
            return nums;
        }
        int len = nums.length - k + 1;
        int[] maxNums = new int[len];
        LinkedList<Integer> doubleEndedQueue = new LinkedList();
        doubleEndedQueue.offer(nums[0]);// 队头放最大值
        for (int i = 1; i < nums.length; i++) {
            // 直接删除比其小的其他元素
            while(doubleEndedQueue.size() > 0 && doubleEndedQueue.getLast() < nums[i]){
                doubleEndedQueue.pollLast();
            }
            doubleEndedQueue.offer(nums[i]);
            /*if(nums[i] > first){ // 出现新的最大值时，清空队列
                while(doubleEndedQueue.size() >0){
                    doubleEndedQueue.remove();
                }
                doubleEndedQueue.offer(nums[i]);
            }else{
                // 不大于最大值，有序加入队列  这里如果和最大值重复，就不会加入队列，修改成<=
                for (int j = doubleEndedQueue.size(); j > 0; j--) {
                    if(nums[i] <= doubleEndedQueue.get(j-1)){
                        doubleEndedQueue.add(j, nums[i]);
                        break;
                    }
                }
            }*/
            // 最大值不在窗口中，删除最大值
            if(i >= k && nums[i-k] == doubleEndedQueue.getFirst()){
                doubleEndedQueue.pollFirst();
            }
            if(i >= k - 1){
                maxNums[i-k+1] = doubleEndedQueue.getFirst();
            }
        }
        return maxNums;
    }

    // 动态规划
//    思路：
//    将数组分成大小为 k 的块，每个块中的元素个数为 k。
//    对于每个块，分别计算出从左到右和从右到左的最大值。
//    对于每个滑动窗口，其最大值为其所在块的右侧最大值和下一块的左侧最大值中的较大值。
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            if (i % k == 0) {
                left[i] = nums[i];
            } else {
                left[i] = Math.max(left[i - 1], nums[i]);
            }
            int j = n - i - 1;
            if ((j + 1) % k == 0) {
                right[j] = nums[j];
            } else {
                right[j] = Math.max(right[j + 1], nums[j]);
            }
        }
        System.out.println("left=" + Arrays.toString(left));
        System.out.println("right=" + Arrays.toString(right));
        int[] res = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            res[i] = Math.max(right[i], left[i + k - 1]);
        }
        return res;
    }

    // 暴力求解,利用双指针，每次找里面的最大值，时间复杂度高 时间复杂度：O(nk) 空间复杂度：O(n-k+1)
    public static int[] maxSlidingWindow4(int[] nums, int k) {
        if(k == 1){
            return nums;
        }
        int len = nums.length - k + 1;
        int[] result = new int[len];
        int index = -1;
        for (int i = 0,j = k-1; i < len; i++,j++) {
            if(index >= i){
                if(nums[j] >= nums[index]){
                    result[i] = nums[j];
                    index = j;
                }else{
                    result[i] = nums[index];
                }
            }else{
                int max = Integer.MIN_VALUE;
                for (int l = i; l <= j; l++) {
                    max = Math.max(nums[l], max);
                }
                result[i] = max;
                for (int l = j; l >= i; l--) {
                    if(nums[l] == max){
                        index = l;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
