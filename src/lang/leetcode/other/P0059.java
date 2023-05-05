package lang.leetcode.other;

import java.util.Arrays;

/** 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 *
 * 提示：
 * 1 <= n <= 20
 *
 */
public class P0059 {
    public static void main(String[] args) {
        int[][] arr1 = generateMatrix(5);
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(Arrays.toString(arr1[i]));
        }
    }

    // 按轨迹填数
    public static int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int m = 1;
        for (int x = 0, y = n - 1; x <= y; x++,y--) {
            for (int i = x; i <= y; i++) {
                arr[x][i] = m++;
            }
            for (int i = x + 1; i <= y; i++) {
                arr[i][y] = m++;
            }
            for (int i = y-1; i >= x ; i--) {
                arr[y][i] = m++;
            }
            for (int i = y-1; i > x ; i--) {
                arr[i][x] = m++;
            }
        }
        return arr;
    }

    // 每个外围圈，四个顶点之间相差n-1、n-3、n-5 从(0,0)开始计算每一个元素的值
    public static int[][] generateMatrix1(int n) {
        int[][] arr = new int[n][n];
        arr[0][0] = 1;
        int c = arr.length -1;
        for (int x = 0, y = n -1; x <= y; x++,y--,c-=2) {
            arr[x][x] = x == 0 ? arr[x][x] : arr[x][x-1] + 1;
            int temp = arr[x][x];
            for (int s = x, e = y; s < y; s++,e--) {
                arr[x][s] = temp;
                arr[s][y] = arr[x][s] + c;
                arr[y][e] = arr[s][y] + c;
                arr[e][x] = arr[y][e] + c;
                temp = arr[x][s] + 1;
            }
        }
        return arr;
    }

}
