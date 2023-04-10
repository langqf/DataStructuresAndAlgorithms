package lang.leetcode.dp;

/** 打家劫舍
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 示例 2：
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 *
 */
public class P0198 {

    public static void main(String[] args) {
        System.out.println(rob1(new int[]{1,2,3,1}));
        System.out.println(rob1(new int[]{2,7,9,3,1}));
        System.out.println(rob1(new int[]{1,3,11,5,14,2,1}));
        System.out.println(rob1(new int[]{1,2,3,41,5,6}));
    }

    // 动态规划  dp[i]表示偷窃i号房屋能得到最高金额
    // dp[i] = nums[i] + Math.max(d[i-2],d[i-3]);
    public static int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }else if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }else if(nums.length == 3){
            return Math.max(nums[0] + nums[2], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0] + nums[2];
        int max = Integer.MIN_VALUE;
        for (int i = 3; i < nums.length; i++) {
            dp[i] = nums[i] + Math.max(dp[i-2],dp[i-3]);
        }
        return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
    }



    // dp[i] : 偷盗 至 第 i个房子时，所获取的最大利益  不一定要偷窃第i个房子
    // dp[i] = max(dp[i-2]+nums[i], dp[i-1])
    public static int rob1(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }else if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
