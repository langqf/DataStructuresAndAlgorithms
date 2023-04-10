package lang.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 三角形最小路径和
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * 示例 1：
 *
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 示例 2：
 *
 * 输入：triangle = [[-10]]
 * 输出：-10
 *
 *
 * 提示：
 *
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -10^4 <= triangle[i][j] <= 10^4
 *
 *
 * 进阶：
 * 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
 *
 */
public class P0120 {

    public static void main(String[] args) {
        List triangle = new ArrayList();
        List list1 = Arrays.asList(2);
        List list2 = Arrays.asList(3,4);
        List list3 = Arrays.asList(6,5,7);
        List list4 = Arrays.asList(4,1,8,3);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);
        System.out.println(minimumTotal(triangle));

    }
    // 进阶  a[n]数组 a[j]保存triangle[i][j]这个元素最小路径和
    public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 1){
            return triangle.get(0).get(0);
        }
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        for(int i = 1; i < n; i++){
            int size = triangle.get(i).size();
            for(int j = size -1; j >= 0; j--){
                if(j == 0){
                    dp[j] = dp[0]+ triangle.get(i).get(j);
                }else if(j == size - 1){
                    dp[j] = dp[j - 1] + triangle.get(i).get(j);
                }else{
                    dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
                }
            }
            System.out.println();
        }
        int result = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++) {
            result = Math.min(result, dp[k]);
        }
        return result;
    }

    // TODO 进阶？
    // 动态规划
    // dp[i][j] : 表示包含第i行j列元素的最小路径和
    // dp[i][j] = min(dp[i-1][j-1],dp[i-1][j]) + triangle[i][j]
    public static int minimumTotal1(List<List<Integer>> triangle) {
        if(triangle.size() == 1){
            return triangle.get(0).get(0);
        }
        int n = triangle.size();
        int[][] dp = new int[n][];
        for (int i = 0; i < n; i++) {
            dp[i] = new int[triangle.get(i).size()];
        }
        dp[0][0] = triangle.get(0).get(0);
        dp[1][0] = dp[0][0] + triangle.get(1).get(0);
        dp[1][1] = dp[0][0] + triangle.get(1).get(1);
        for(int i = 2; i < n; i++){
            int size = triangle.get(i).size();
            for(int j = 0; j < size; j++){
                if(j == 0){
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                }else if(j == size - 1){
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int k = 0; k < triangle.get(n-1).size(); k++) {
            result = Math.min(result, dp[n-1][k]);
        }
        return result;
    }
}
