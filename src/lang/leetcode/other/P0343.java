package lang.leetcode.other;

/** 整数拆分
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * 返回 你可以获得的最大乘积 。
 *
 * 示例 1:
 * 输入: n = 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 *
 * 示例 2:
 * 输入: n = 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 *
 * 提示:
 * 2 <= n <= 58
 *
 */
public class P0343 {
    public static void main(String[] args) {
        System.out.println(integerBreak(2));
        System.out.println(integerBreak(3));
        System.out.println(integerBreak(4));
        System.out.println(integerBreak(5));
        System.out.println(integerBreak(6));
        System.out.println(integerBreak(7));
        System.out.println(integerBreak(8));
        System.out.println(integerBreak(9));
        System.out.println(integerBreak(10));
    }


    // 动态规划 dp[i]代表 i 拆分之后得到的乘积的最大的元素
    // 状态转移方程式：dp[i]=max(dp[i],(i-j)*max(dp[j],j))
    public static int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], (i - j) * Math.max(dp[j], j));
            }
        }
        return dp[n];
    }

    // 暴力求解
    public static int integerBreak1(int n) {
        int max = 0;
        for (int i = 1,j = n-1;  i <= j; i++,j--) {
            int m1 = i * j;
            int m2 = i <= 4 ? i * integerBreak2(j) : integerBreak2(i) * integerBreak2(j);
            max = Math.max(max, Math.max(m1, m2));
        }
        return max;
    }

    // 思路错误
    public static int integerBreak2(int n) {
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        if(n == 4){
            return 4;
        }
        int left;
        int right;
        if(n%2 == 0){
            left = n/2;
            right = n/2;
        }else{
            left = n/2;
            right = n/2 + 1;
        }
        int m1 = left * right;
        int m2 = integerBreak(left) * integerBreak(right);
        return m1 > m2 ? m1 : m2;
    }
}
