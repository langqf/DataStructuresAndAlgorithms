package lang.leetcode.other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/** 扑克牌中的顺子
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，
 * 而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 * 示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 * 示例 2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 * 限制：
 * 数组长度为 5
 * 数组的数取值为 [0, 13] .
 *
 */
public class Offer61 {
    public static void main(String[] args) {
        System.out.println(isStraight(new int[]{1,4,3,2,5}));
        System.out.println(isStraight(new int[]{0,0,1,2,5}));
        System.out.println(isStraight(new int[]{0,0,0,0,0}));
        System.out.println(isStraight(new int[]{1,0,0,0,8}));
        System.out.println(isStraight(new int[]{0,0,2,2,5}));
    }

    // 不排序 set + 最大最小差值
    public static boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        int min = 13;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){ // 遇到0直接跳过
                continue;
            }
            if(set.contains(nums[i])){
                return false;  // 有重复的牌，就不是顺子
            }else{
                set.add(nums[i]);
            }
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        return max - min < 5;
    }

    // 先排序，然后前后两个数的差值判断，连续的五个数，差值为4
    public static boolean isStraight1(int[] nums) {
        Arrays.sort(nums);
        int sub = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == 0){
                continue;
            }
            if(nums[i+1] == nums[i]){
                return false;
            }
            sub += nums[i+1] - nums[i];
        }
        return sub < 5;
    }

    // 先排序，然后通过大小王的数量判断
    public static boolean isStraight2(int[] nums) {
        Arrays.sort(nums);
        int magicNum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == 0){
                magicNum++;
            }else{
                if(nums[i+1] == nums[i]){
                    return false;
                }else{
                    magicNum -= nums[i+1] - nums[i] - 1;
                }
            }
        }
        return magicNum >= 0;
    }
}

