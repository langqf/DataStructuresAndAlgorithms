package lang.leetcode.other;

import java.util.Arrays;

/** 最接近的三数之和
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
 *
 * 示例 1：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * 示例 2：
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 *
 * 提示：
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -10^4 <= target <= 10^4
 *
 */
public class P0016 {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{4,0,5,-5,3,3,0,-4,-5}, -2));
    }

    //TODO 考虑优化，跳过重复数字 类似三数之和  排序+双指针
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int best = 100000;// 初始化最好的绝对值
        int t = target;
        for (int i = 0; i < nums.length; i++) {
            int m = i + 1;
            int n = nums.length - 1;
            while(m < n){
                int s = nums[i] + nums[m] + nums[n];
                if(s == target){
                    return s;
                }else if(s < target){
                    m++;
                }else{
                    n--;
                }
                int abs = Math.abs(s - target);
                if(abs < best){
                    best = abs;
                    t = s;
                }
            }
        }
        return t;
    }

}
