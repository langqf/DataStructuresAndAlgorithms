package lang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。
 * 请你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 *
 * 注意，输出的顺序和三元组的顺序并不重要。
 *
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 *
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 *
 * 提示：
 * 3 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 *
 * 进阶：
 *  四数之和
 */
public class P0015 {
    public static void main(String[] args) {
        int[] nums1 = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums1));
        System.out.println(fourSum(nums1));
        int[] nums2 = {0,1,1,1};
        System.out.println(threeSum(nums2));
        System.out.println(fourSum(nums2));
        int[] nums3 = {0,0,0,0};
        System.out.println(threeSum(nums3));
        System.out.println(fourSum(nums3));
        int[] nums4 = {-2,0,0,2,2};
        System.out.println(threeSum(nums4));
        System.out.println(fourSum(nums4));
        int[] nums5 = {-1,0,1,2,-1,-4,0,-1,1,2,-2,-1,2,-1,1,2,-2,-3};
        for (int i = 0; i < nums5.length; i++) {
            System.out.print(nums5[i] + " ");// -1 0 1 2 -1 -4 0 -1 1 2 -2 -1 2 -1 1 2 -2 -3
        }
        System.out.println();
        System.out.println(threeSum(nums5)); // [[-4, 2, 2], [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, -1, 2], [-1, 0, 1]]
        System.out.println(fourSum(nums5));
        // [[-4, 0, 2, 2], [-4, 1, 1, 2], [-3, -1, 2, 2], [-3, 0, 1, 2], [-3, 1, 1, 1], [-2, -2, 2, 2], [-2, -1, 1, 2], [-2, 0, 0, 2], [-2, 0, 1, 1], [-1, -1, 0, 2], [-1, -1, 1, 1], [-1, 0, 0, 1]]
    }

    // 四数之和  固定两个数
    public static List<List<Integer>> fourSum(int[] nums) {
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
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum == 0) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while(k<l && nums[k] == nums[k-1])
                            k++;
                        while(k<l && nums[l] == nums[l+1])
                            l--;
                    }else if(nums[i] + nums[j] + nums[k] + nums[l]< 0) {
                        k++;
                    }else{
                        l--;
                    }
                }
            }
        }
        return list;
    }

    // 别人的代码
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length<3){
            return list;
        }
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue; // 去重，这样更好理解
            }
            int j = i + 1;
            int k = nums.length - 1;
            while(j<k) {
                if(nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[j]);
                    res.add(nums[k]);
                    list.add(res);
                    j++;
                    k--;
                    while(j<k && nums[j] == nums[j-1])
                        j++;
                    while(j<k && nums[k] == nums[k+1])
                        k--;
                }else if(nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                }else{
                    k--;
                }
            }
        }
        return list;
    }

    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length<3) return list;
        Arrays.sort(nums);
        int i,j,k,sum;
        for(i = 0; i < nums.length - 2; i++){
            if(i == 0 || nums[i] != nums[i-1]) {
                j = i + 1;
                k = nums.length - 1;
                while (j < k) {
                    sum = nums[i] + nums[j] + nums[k];
                    if (sum > 0) {
                        k--;
                    } else if (sum < 0) {
                        j++;
                    } else {
                        List<Integer> l = new ArrayList<>(3);
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        list.add(l);
                        j++;
                        k--;
                        // 匹配成功之后才判断是否需要去重 减少判断次数
                        while(j < k && nums[j] == nums[j-1]){
                            j++;
                        }
                        while(j < k && nums[k] == nums[k+1]){
                            k--;
                        }
                    }
                }
            }
        }
        return list;
    }

    // 很慢，去重位置不正确，应该放到匹配成功（三数和为0）之后判断
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int i,j,k,sum;
        for(i = 0; i < nums.length; i++){
            if(i == 0 || nums[i] != nums[i-1]) {
                j = i + 1;
                k = nums.length - 1;
                while (j < k) {
                    // 去重位置不正确，应该放到匹配成功（三数和为0）之后判断
                    if(j > i+1 && nums[j] == nums[j-1]) {
                        j++;
                    }else if(k < nums.length -1 && nums[k] == nums[k+1]) {
                        k--;
                    }else {
                        sum = nums[i] + nums[j] + nums[k];
                        if (sum > 0) {
                            k--;
                        } else if (sum < 0) {
                            j++;
                        } else {
                            List<Integer> l = new ArrayList<>(3);
                            l.add(nums[i]);
                            l.add(nums[j]);
                            l.add(nums[k]);
                            list.add(l);
                            j++;
                            k--;
                        }
                    }
                }
            }
        }
        return list;
    }
    // -4 -3 -2 -2 -1 -1 -1 -1 -1 0 0 1 1 1 2 2 2 2
    // [[-4, 2, 2], [-3, 1, 2], [-2, 0, 2],             [-1, -1, 2], [-1, 0, 1]]
    // [[-4, 2, 2], [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, -1, 2], [-1, 0, 1]]
}
