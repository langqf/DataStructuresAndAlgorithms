package lang.leetcode.other;

import java.util.ArrayList;
import java.util.List;

/** 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 *
 */
public class P0054 {

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{ {1,2,3}, {4,5,6}, {7,8,9} }));
        System.out.println(spiralOrder(new int[][]{ {1,2,3,4}, {5,6,7,8}, {9,10,11,12 } }));
        System.out.println(spiralOrder(new int[][]{ {1}}));
        System.out.println(spiralOrder(new int[][]{ {7},{9},{6}}));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> list = new ArrayList<>(m*n);
        // 定义 上下左右 边界
        int up = 0;
        int down = m-1;
        int left = 0;
        int right = n-1;
        while(up <= down && left <= right){
            // 向右遍历
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }
            up++;
            if(up <= down){
                // 向下遍历
                for (int i = up; i <= down; i++) {
                    list.add(matrix[i][right]);
                }
                right--;
                if(left <= right){
                    // 向左遍历
                    for (int i = right; i >= left; i--) {
                        list.add(matrix[down][i]);
                    }
                    down--;
                    // 向上遍历
                    for (int i = down; i >= up; i--) {
                        list.add(matrix[i][left]);
                    }
                    left++;
                }
            }
//            System.out.println(list);
//            System.out.println("up = " + up + ", b = " + b + ", c = " + c + ", right=" + right);
        }
        return list;
    }

}
