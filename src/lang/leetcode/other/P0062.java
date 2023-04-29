package lang.leetcode.other;

/** 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 * 示例 1：
 * 输入：m = 3, n = 7
 * 输出：28
 *
 * 示例 2：
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 *
 * 示例 3：
 * 输入：m = 7, n = 3
 * 输出：28
 * 示例 4：
 *
 * 输入：m = 3, n = 3
 * 输出：6
 *
 * 提示：
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 10^9
 *
 *
 */
public class P0062 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths(7, 3));
        System.out.println(uniquePaths(3, 3));
        System.out.println(uniquePaths(10, 10));
    }

    /** 试试动态规划 f[i,j](0<i<m,0<j<n)表示到达坐标(i,j)位置的路径数
     *  f[i,j] = f[i-1,j] + f[i,j-1]
     *  特别的  第一行 只有一条路径 f[0,j] = 1
     *         第一列 只有一条路径 f[i,0] = 1
     *  f[0,0] = 1;
     *  f[m-1][n-1]就是答案
     */
    public static int uniquePaths1(int m, int n) {
        int[][]  f = new int[m][n];
        f[0][0] = 1;
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            f[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i-1][j] + f[i][j-1];
            }
        }
        return f[m-1][n-1];
    }

    // 状态压缩 当前行到达第j列所需步数
    public static int uniquePaths2(int m, int n) {
        int[] f = new int[n];
        // 初始化第0行到达第j列的所有数据
        f[0] = 1;
        for (int i = 1; i < n; i++) {
            f[i] = 1;
        }
        // 从第一行开始，任何一行到达第0列都是1
        f[0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[j] = f[j-1] + f[j];
            }
        }
        return f[n-1];
    }

    /** 排列组合
     *  因为机器到底右下角，向下几步，向右几步都是固定的，
     *  比如，m=3, n=2，我们只要向下 1 步，向右 2 步就一定能到达终点。
     *  所有可以从3步中找出1步，或者2步
     *  m+n-2 步中找出 m-1或者n-1步
     *
     */

    public static int uniquePaths(int m, int n) {
        int sum = m + n - 2;
        int cnt = Math.min(m-1, n-1);
        int ans = 1;
        for (int i = 0; i < cnt; i++) {
            ans *= sum - i; // 如果是单独计算分子或者分母阶乘，存在int溢出的情况
            ans /= i+1;
        }
        return ans;
    }
}
