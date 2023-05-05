package lang.leetcode.other;

import java.util.Arrays;

/** 旋转图像
 *
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 *
 * 示例 2：
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 * 提示：
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 *
 */
public class P0048 {
    public static void main(String[] args) {
        int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix1);
        for (int i = 0; i < matrix1.length; i++) {
            System.out.println(Arrays.toString(matrix1[i]));
        }
        int[][] matrix2 = {{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
        rotate(matrix2);
        for (int i = 0; i < matrix2.length; i++) {
            System.out.println(Arrays.toString(matrix2[i]));
        }
    }
    // 用翻转代替旋转
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        // 先上下翻转
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = temp;
            }
        }
        // 再沿对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    // 从外到内，一层一层地处理每一个正方形，交换其中的元素
    public static void rotate0(int[][] matrix) {
        int n = matrix.length;
        for (int x = 0, y = n -1; x < y ; x++, y--) { // x表示x行x列，y表示y行y列
            for (int s = x, e = y; s < y; s++, e--) {  // s表示s行s列，e表示e行e列
                int temp = matrix[x][s];
                matrix[x][s] = matrix[e][x];
                matrix[e][x] = matrix[y][e];
                matrix[y][e] = matrix[s][y];
                matrix[s][y] = temp;
            }
        }
    }



    // 从外到内，一层一层地处理每一个正方形，交换其中的元素
    public static void rotate1(int[][] matrix) {
        int n = matrix.length;
        for (int x = 0, y = n -1; x < y ; x++, y--) { // x表示x行x列，y表示y行y列
            for (int s = x, e = y; s < y; s++, e--) {  // s表示s行s列，e表示e行e列
                int temp = matrix[x][s];
                matrix[x][s] = matrix[e][x];
                matrix[e][x] = matrix[y][e];
                matrix[y][e] = matrix[s][y];
                matrix[s][y] = temp;
            }
        }
    }

    // matrixNew[col][n−row−1] = matrix[row][col] 这个式子经过四次变换后，变回了原来的值，说明四个就是一个循环
    // n为偶数次，需要变换 n^2/4次  n为奇数时，需要变换(n^2-1)/4次
    public void rotate3(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    // 仔细观察  第i行 第j列元素变成了 倒数第i列第j行的元素 使用一个辅助数组 使用了额外的O(n^2)空间
    public static void rotate2(int[][] matrix) {
        int n = matrix.length;
        int[][] supArr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                supArr[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][n-1-i] = supArr[i][j];
            }
        }
    }
}
