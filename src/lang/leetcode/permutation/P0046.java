package lang.leetcode.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 全排列
 *  给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 *
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 * 提示：
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 *
 */
public class P0046 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> allList = permute1(nums);
        System.out.println(allList);
    }

    // 使用回溯算法 它通过不断地尝试所有可能的解来求解问题 时间复杂度也是O(n*n!)
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(nums, list, new ArrayList<>());
        return list;
    }

    public static void dfs(int[] nums, List<List<Integer>> result, List<Integer> tempList){
        if(tempList.size() == nums.length){// 在递归函数中，我们首先判断如果 first == n，则说明我们已经填写完了整个排列，将当前排列加入答案数组中
            result.add(new ArrayList<>(tempList));
        }else{
            for (int i = 0; i < nums.length; i++){
                if(!tempList.contains(nums[i])){
                    tempList.add(nums[i]);
                    dfs(nums, result, tempList);
                    tempList.remove(tempList.size() - 1); // 在递归返回后，我们需要将加入的数字从排列中删除，以便尝试下一个数字
                }
            }
        }
    }

    // 从第一个位置开始，依次将每个数字放到第一个位置，然后递归处理剩余的数字，直到所有数字都被放置完毕。在递归处理剩余数字时，需要将当前位置后面的数字进行交换，以便遍历所有可能的排列
    public static List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, res);
        return res;
    }

    private static void backtrack(int[] nums, int start, List<List<Integer>> res) {
        System.out.println("start is " + start + ". nums is "+ Arrays.toString(nums));
        if (start == nums.length) {
            System.out.println("1++++++++++++++++++++++++++++");
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            res.add(list);
        } else {
            for (int i = start; i < nums.length; i++) {
                swap(nums, start, i);
                backtrack(nums, start + 1, res);
                swap(nums, start, i);
            }
            System.out.println("2--------------------------");
        }
    }

    private static void swap(int[] nums, int i, int j) {
        System.out.println("swap start=" + i + ", i = " + j);
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
