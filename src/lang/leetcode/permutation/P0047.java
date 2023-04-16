package lang.leetcode.permutation;

import java.util.*;

/** 全排列 II
 *  给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 *
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 *
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 提示：
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 *
 */
public class P0047 {

    public static void main(String[] args) {
        int[] nums = {1,1,2,2};
        List<List<Integer>> allList = permuteUnique(nums);
        System.out.println(allList.size());
        System.out.println(allList);
    }

    // 使用回溯算法 它通过不断地尝试所有可能的解来求解问题 时间复杂度也是O(n*n!)
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);// 先排序
        boolean[] used = new boolean[nums.length];
        dfs(nums, list, new ArrayList<>(), used);
        return list;
    }

    public static void dfs(int[] nums, List<List<Integer>> result, List<Integer> tempList, boolean[] used){
        if(tempList.size() == nums.length){// 在递归函数中，我们首先判断如果size=n，则说明我们已经填写完了整个排列，将当前排列加入答案数组中
            result.add(new ArrayList<>(tempList));
        }else{
            for (int i = 0; i < nums.length; i++){
                if(used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])){ // 如果当前数字和上一个数字相同且上一个数字没有被使用过，那么就跳过这个数字
                    continue;
                }
                tempList.add(nums[i]);
                used[i] = true;
                dfs(nums, result, tempList, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1); // 在递归返回后，我们需要将加入的数字从排列中删除，以便尝试下一个数字
            }
        }
    }

}
