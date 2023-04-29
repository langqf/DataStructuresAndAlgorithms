package lang.leetcode.other;

/** 不同路径 II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 示例 1：
 * 输入：obstacleGrid = [[0,0,0},[0,1,0},[0,0,0}}
 * 输出：2
 * 解释：3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 * 示例 2：
 * 输入：obstacleGrid = [[0,1},[0,0}}
 * 输出：1
 *
 * 提示：
 * m == obstacleGrid.length
 * n == obstacleGrid[i}.length
 * 1 <= m, n <= 100
 * obstacleGrid[i}[j} 为 0 或 1
 *
 */
public class P0063 {

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{ {0,0,0},{0,1,0},{0,0,0} }));
        System.out.println(uniquePathsWithObstacles(new int[][]{ {0,1}, {0,0} }));
        System.out.println(uniquePathsWithObstacles(new int[][]{ {1,0} }));
    }

    /** 试试动态规划 f[i,j](0<i<m,0<j<n)表示到达坐标(i,j)位置的路径数
     *  f[i,j] = f[i-1,j] + f[i,j-1]
     *  特别的  第一行 只有一条路径 f[0,j] = 1
     *         第一列 只有一条路径 f[i,0] = 1
     *  f[0,0] = 1;
     *  f[m-1][n-1]就是答案
     *  如果 arr[i][j] == 1  f[i][j] = 0
     */
    public static int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][]  f = new int[m][n];
        for (int i = 0; i < m; i++) {
            if(obstacleGrid[i][0] == 1){
                while(i < m){
                    f[i][0] = 0;
                    i++;
                }
            }else{
                f[i][0] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if(obstacleGrid[0][i] == 1){
                while(i < n){
                    f[0][i] = 0;
                    i++;
                }
            }else{
                f[0][i] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 1){
                    f[i][j] = 0;
                }else{
                    f[i][j] = f[i-1][j] + f[i][j-1];
                }
            }
        }
        return f[m-1][n-1];
    }
    // 滚动数组版
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int f[] = new int[n];
        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(obstacleGrid[i][j] == 1){
                    f[j] = 0;
                    continue;
                }
                if(j - 1 >= 0){
                    f[j] += f[j - 1];
                }
            }
        }
        return f[n-1];
    }

}
