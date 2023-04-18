package lang.leetcode.bitwise.operation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/** 丢失的数字
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * 示例 1：
 *
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：2
 * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 示例 3：
 * 输入：nums = [9,6,4,2,3,5,7,0,1]
 * 输出：8
 * 解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 示例 4：
 * 输入：nums = [0]
 * 输出：1
 * 解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 10^4
 * 0 <= nums[i] <= n
 * nums 中的所有数字都 独一无二
 *
 * 进阶：你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
 *
 */
public class P0268 {

    public static void main(String[] args) {
        System.out.println(missingNumber1(new int[]{9,6,4,2,3,5,7,0,1}));
        System.out.println(missingNumber2(new int[]{9,6,4,2,3,5,7,0,1}));
        System.out.println(missingNumber3(new int[]{9,6,4,2,3,5,7,0,1}));
        System.out.println(missingNumber4(new int[]{9,6,4,2,3,5,7,0,1}));
    }

    // 位运算  对任意整数 xxx 都满足 x⊕x=0 x⊕0=x
    // 时间复杂度O(n)
    // 空间复杂度O(1)
    public static int missingNumber4(int[] nums) {
        int n = nums.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            result ^= nums[i];
        }
        for (int i = 0; i <= n; i++) {
            result ^= i;
        }
        return result;
    }

    // 数学公式 sum = n(n+1)/2
    // 时间复杂度O(n)
    // 空间复杂度O(1)
    public static int missingNumber3(int[] nums) {
        int n = nums.length;
        int total = n*(n+1)/2;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        return total - sum;
    }

    // hash
    // 时间复杂度O(n)
    // 空间复杂度O(n)  需要额外的Set
    public static int missingNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i <= n; i++) {
            if(!set.contains(i)){
                return i;
            }
        }
        return n;
    }

    // 排序
    // 时间复杂度O(nlgn) 取决于排序算法
    // 空间复杂度主要取决于排序的递归调用栈空间 O(logn)
    public static int missingNumber1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return n;
    }


}
