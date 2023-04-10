package lang.leetcode.dp;

/** 最长递增子序列
 *
 *  给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 *
 * 示例 2：
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 解释 [0,1,2,3]
 *
 * 示例 3：
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 2500
 * -10^4 <= nums[i] <= 10^4
 *
 * 进阶：
 * 你能将算法的时间复杂度降低到 O(nlog(n)) 吗?
 *
 */
public class P0300 {

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
        System.out.println(lengthOfLIS(new int[]{4,10,4,3,8,9}));
        System.out.println(lengthOfLIS(new int[]{18,55,66,2,3,54}));
        System.out.println(lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }

    // TODO 进阶?
    // 动态规划 dp[i]等于前面所有<a[i]的dp值+1中最大的一个
    // dp[i] ：表示以nums[i]结尾的最长上升子序列的长度
    // dp[i] = max(dp[j]+1，dp[k]+1，dp[p]+1，.....)
    // 只要
    // nums[i] > nums[j]
    // ...
    // nums[i] > nums[k]
    // ...
    // nums[i] > nums[p]
    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return 1;
        }
        int[] dp = new int[len];
        dp[0] = 1;
        int max = dp[0];
        for(int i = 1; i < len; i++){
            int maxDp = 1;
            for(int j = i - 1; j >= 0; j--){
                if(nums[i] > nums[j]) {
                    maxDp = Math.max(maxDp, dp[j] + 1);
                }
            }
            dp[i] = maxDp;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
