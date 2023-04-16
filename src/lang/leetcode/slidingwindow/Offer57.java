package lang.leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 剑指 Offer 57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * 示例 1：
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 *
 * 示例 2：
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 * 限制：
 *
 * 1 <= target <= 10^5
 */
public class Offer57 {

    public static void main(String[] args) {
        System.out.println(Math.sqrt(0));
        int[][] nums = findContinuousSequence2(12);
        if(nums != null){
            for (int i = 0; i < nums.length; i++) {
                System.out.println(Arrays.toString(nums[i]));
            }
        }
    }

    /**
     *  作者：力扣官方题解
     *     链接：https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solutions/128296/mian-shi-ti-57-ii-he-wei-sde-lian-xu-zheng-shu-x-2/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *     利用二元一次方程求根公式
     */
    public static int[][] findContinuousSequence2(int target) {
        List<int[]> vec = new ArrayList<int[]>();
        int sum = 0, limit = (target - 1) / 2; // (target - 1) / 2 等效于 target / 2 下取整
        for (int x = 1; x <= limit; ++x) {
            long delta = 1 - 4 * (x - (long) x * x - 2 * target);
            if (delta < 0) {
                continue;
            }
            int delta_sqrt = (int) Math.sqrt(delta + 0.5);
            if ((long) delta_sqrt * delta_sqrt == delta && (delta_sqrt - 1) % 2 == 0) {
                int y = (-1 + delta_sqrt) / 2; // 另一个解(-1-delta_sqrt)/2必然小于0，不用考虑
                if (x < y) {
                    int[] res = new int[y - x + 1];
                    for (int i = x; i <= y; ++i) {
                        res[i - x] = i;
                    }
                    vec.add(res);
                }
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }

    // 求sum可以利用 等差数列求和公式 sum = (i+j)(j-i+1)/2
    // 滑动窗口，双指针
    public static int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int i = 1;
        int j = 1;
        int sum = 0;
        while(i <= target/2){
            if(sum < target){
                sum += j;
                j++;
            }else if(sum > target){
                sum -= i;
                i++;
            }else{
                int[] arr = new int[j - i];
                for (int m = i; m < j; m++) {
                    arr[m -i] = m;
                }
                list.add(arr);
                sum -= i;
                i++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    // 暴力破解
    public static int[][] findContinuousSequence1(int target) {
        List<List<Integer>> list = new ArrayList<>();
        int[][] nums = null;
        int i = 1;
        int j = 1;
        int sum = 0;
        while(j < target){
            while(sum < target){
                sum += j;
                j++;
            }
            if(sum == target) {
                List<Integer> l = new ArrayList<>();
                for (int m = i; m < j; m++) {
                    l.add(m);
                }
                list.add(l);
            }
            sum = 0;
            i++;
            j = i;
        }
        if(list.size() > 0){
            nums = new int[list.size()][];
            for (int k = 0; k < list.size(); k++) {
                nums[k] = new int[list.get(k).size()];
                for (int l = 0; l < list.get(k).size(); l++) {
                    nums[k][l] = list.get(k).get(l);
                }
            }
        }else{
            nums = new int[0][];
        }
        return nums;
    }
}
