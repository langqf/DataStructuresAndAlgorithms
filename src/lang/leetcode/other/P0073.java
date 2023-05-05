package lang.leetcode.other;

import java.util.Arrays;

/** 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 示例 1：
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 *
 * 示例 2：
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 * 提示：
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -2^31 <= matrix[i][j] <= 2^31 - 1
 *
 * 进阶：
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 *
 */
public class P0073 {
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        int[][] matrix1 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix1);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix1[i]));
        }
    }
    // 使用常量空间
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean rowFlag0 = false;
        boolean colFlag0 = false;
        for (int i = 0; i < n; i++) {
            if(matrix[0][i] == 0){
                rowFlag0 = true;
            }
        }
        for (int i = 0; i < m; i++) {
            if(matrix[i][0] == 0){
                colFlag0 = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(rowFlag0){
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if(colFlag0){
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
    // 使用额外的O(m+n)空间
    public static void setZeroes1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0){
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if(rows[i] == 1 || cols[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
        /*for (int i = 0; i < m; i++) {
            if(rows[i] == 1){
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if(cols[i] == 1){
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }*/
    }
    // 使用额外的O(mn)空间
    public static void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] copyMatrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                copyMatrix[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(copyMatrix[i][j] == 0){
                    // 行置0
                    for (int c = 0; c < n; c++) {
                        matrix[i][c] = 0;
                    }
                    // 列置0
                    for (int r = 0; r < m; r++) {
                        matrix[r][j] = 0;
                    }
                }
            }
        }
    }
}
