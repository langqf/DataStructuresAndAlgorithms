package lang.leetcode.other;

import java.util.ArrayList;
import java.util.List;

/** 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 *
 */
public class P0078 {

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
        System.out.println(subsets(new int[]{0}));
    }

    // 循环枚举 每新增一个元素，就在原有所有子集上加上当前元素
    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> all = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        all.add(list);
        for (int i = 0; i < nums.length; i++) {
            int size = all.size();
            for (int j = 0; j < size; j++) {
                List<Integer> l = new ArrayList<>(all.get(j));
                l.add(nums[i]);
                all.add(l);
            }
        }
        return all;
    }

    // 递归枚举2 每一个元素都可以选与不选，构成一颗完全二叉树
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> all = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        dfs(nums, 0, list, all);
        return all;
    }
    public static void dfs(int[] nums, int cur, ArrayList<Integer> list, List<List<Integer>> all) {
        if(cur == nums.length){
            all.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[cur]);
        dfs(nums, cur + 1, list, all);
        list.remove(list.size() - 1);
        dfs(nums, cur + 1, list, all);
    }

    // 递归枚举1
    public static List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> all = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        all.add(list);
        recursion1(nums, 0, all);
        return all;
    }
    public static void recursion1(int[] nums, int cur, List<List<Integer>> all) {
        if(cur == nums.length){
            return;
        }
        int size = all.size();
        for (int i = 0; i < size; i++) {
            List<Integer> l = new ArrayList<>(all.get(i));
            l.add(nums[cur]);
            all.add(l);
        }
        recursion1(nums, cur + 1, all);
    }

    // n个元素共有子集2^n次方个子集，2^n个是可以用n位二进制数表示
    public static List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> all = new ArrayList<>();
        int len = 1 << nums.length;
        for (int i = 0; i < len; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if(((i >> j) & 1) == 1 ){
                    list.add(nums[j]);
                }
            }
            all.add(list);
        }
        return all;
    }
}
