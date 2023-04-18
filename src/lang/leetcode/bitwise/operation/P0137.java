package lang.leetcode.bitwise.operation;

/** 只出现一次的数字 II
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法且不使用额外空间来解决此问题。
 *
 * 示例 1：
 * 输入：nums = [2,2,3,2]
 * 输出：3
 *
 * 示例 2：
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99

 * 提示：
 * 1 <= nums.length <= 3 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 *
 */
public class P0137 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,3,2}));
        System.out.println(singleNumber(new int[]{0,1,0,1,0,1,99}));
        System.out.println(singleNumber(new int[]{1}));
    }

    /** TODO  位运算难理解
     *  https://www.geekxh.com/1.8.%E4%BD%8D%E8%BF%90%E7%AE%97%E7%B3%BB%E5%88%97/805.html#_04%E3%80%81%E4%BD%8D%E8%BF%90%E7%AE%97
     *  https://leetcode.cn/problems/single-number-ii/solutions/746993/zhi-chu-xian-yi-ci-de-shu-zi-ii-by-leetc-23t6/
     *  https://leetcode.cn/problems/single-number-ii/solutions/8944/single-number-ii-mo-ni-san-jin-zhi-fa-by-jin407891/
     *  思路：
     *  1. hashMap 不满足空间复杂度要求
     *  2. 数学公式  3×(a b c)−(a a a b b b c) = 2c
     *  3. 统计每一位出现的次数，然后每位对3取模
     *  4. 位运算 使用三进制数(状态机或者数字电路设计)
     */
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num: nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
