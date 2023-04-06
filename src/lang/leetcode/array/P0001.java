package lang.leetcode.array;

import java.util.*;

/** 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 * 提示：
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 *
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 */
public class P0001 {
    public static void main(String[] args) {
        int[] v1 = twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int i = 0; i < v1.length; i++) {
            System.out.print(v1[i] + " ");
        }
        System.out.println("*****************");
        int[] v2 = twoSum(new int[]{3,2,4}, 6);
        for (int i = 0; i < v2.length; i++) {
            System.out.print(v2[i] + " ");
        }
        System.out.println("*****************");
        int[] v3 = twoSum(new int[]{3,3}, 6);
        for (int i = 0; i < v3.length; i++) {
            System.out.print(v3[i] + " ");
        }

    }
    // map保存差值
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);// 保存差值
        }
        return null;
    }

    // map保存数组元素值
    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer result = target - nums[i];
            if(map.containsKey(result)){
                return new int[]{map.get(result), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    // 暴力比较
    public static int[] twoSum2(int[] nums, int target) {
        int index[] = new int[2];
        int i,j;
        for (i = 0; i < nums.length; i++) {
            for (j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    index[0] = i;
                    index[1] = j;
                    return index;
                }
            }
        }
        return index;
    }

}
