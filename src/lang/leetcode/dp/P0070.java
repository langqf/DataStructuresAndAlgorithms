package lang.leetcode.dp;

/** 爬楼梯
 *  假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *  每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 *
 * 示例 2：
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 *
 * 提示：
 * 1 <= n <= 45
 *
 */
public class P0070 {

    public static void main(String[] args) {
        System.out.println(climbStairs2(5));
    }

    // 动态规划
    public static int climbStairs1(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    // 斐波那契数列
    public static int climbStairs2(int n) {
        if(n == 1){
            return 1;
        }else if(n ==2 ){
            return 2;
        }
        int a1 = 1;
        int a2 = 2;
        for(int i = 3; i <= n; i++){
            int sum = a1 + a2;
            a1 = a2;
            a2 = sum;
        }
        return a2;
    }


    // 递归
    public static int climbStairs(int n) {
        if(n == 1){
            return 1;
        }else if(n ==2 ){
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
