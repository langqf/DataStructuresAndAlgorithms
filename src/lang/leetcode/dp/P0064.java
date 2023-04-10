package lang.leetcode.dp;

import java.util.Arrays;

/** 最小路径和
 *
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例 1：
 * 1--3--1
 *       .
 * 1  5  1
 *       .
 * 4  2  1
 *
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 *
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 *
 */
public class P0064 {

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
        System.out.println(minPathSum(new int[][]{{1,2,3},{41,5,6}}));
    }

    // 动态规划 dp[i][j] : 表示包含第i行j列元素的最小路径和
    // dp[0][0] = grid[0][0]位置所在的元素值
    // dp[i][j] = min(dp[i-1][j],dp[i][j-1]) + grid[i][j]另外第一行和第一列元素特殊
    // 我们的目标是从左上角走到右下角，整个网格的最小路径和其实就是包含右下角元素的最小路径和，右下角元素位置i=[m-1],j=[grid[m-1].length -1]
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int[][] dp = new int[m][];
        for (int i = 0; i < m; i++) {
            dp[i] = new int[grid[i].length];
        }
        for(int i = 0; i < m; i++){
            for (int j = 0; j < grid[i].length; j++) {
                if(i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                }else if(i == 0 && j != 0){
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                }else if(i != 0 && j == 0){
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                }else{
                    dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i][j];
                }
            }
        }
        return dp[m-1][grid[m-1].length -1];
    }

}
