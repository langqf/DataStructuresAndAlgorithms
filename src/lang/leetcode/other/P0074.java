package lang.leetcode.other;

/** 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 *示例 1：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 *
 * 示例 2：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 *
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -10^4 <= matrix[i][j], target <= 10^4
 *
 */
public class P0074 {
    public static void main(String[] args) {
//        System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
//        System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13));
//        System.out.println(searchMatrix(new int[][]{{1},{1}}, 2));
        System.out.println(searchMatrix(new int[][]{{1},{3},{5}}, 3));
    }

    // 两次二分 先用二分找所在行，再在该行二分找 target
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int left = 0 , right = m -1;
        while(left < right){
            int mid = left + (right-left + 1)/2;
            if(matrix[mid][0] > target){
                right = mid -1;
            }else{
                left = mid;
            }
        }
        int i = left;
        int n = matrix[i].length;
        left = 0; right = n - 1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(matrix[i][mid] > target){
                right--;
            }else if(matrix[i][mid] < target){
                left++;
            }else{
                return true;
            }
        }
        return false;
    }
}
