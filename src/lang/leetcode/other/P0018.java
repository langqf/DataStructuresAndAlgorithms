package lang.leetcode.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 四数之和
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]]
 * （若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 * 示例 1：
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 * 示例 2：
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 *
 * 提示：
 * 1 <= nums.length <= 200
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 *
 */
public class P0018 {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        int[] nums5 = {1000000000,1000000000,1000000000,1000000000};
        System.out.println(fourSum(nums5, -294967296));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length < 4){
            return list;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i< len - 3; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue; // 去重，这样更好理解
            }
            for(int j = i + 1; j < len -2; j++){
                if(j > i + 1 && nums[j] == nums[j-1]){
                    continue; // 去重，这样更好理解
                }
                int k = j + 1;
                int l = len - 1;
                while(k < l) {
                    long sum = (long)nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while(k<l && nums[k] == nums[k-1])
                            k++;
                        while(k<l && nums[l] == nums[l+1])
                            l--;
                    }else if(sum < target) {
                        k++;
                    }else{
                        l--;
                    }
                }
            }
        }
        return list;
    }
}
