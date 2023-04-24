package lang.leetcode.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 供暖器
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
 * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
 *
 * 示例 1:
 * 输入: houses = [1,2,3], heaters = [2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 *
 * 示例 2:
 * 输入: houses = [1,2,3,4], heaters = [1,4]
 * 输出: 1
 * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
 *
 * 示例 3：
 * 输入：houses = [1,5], heaters = [2]
 * 输出：3
 *
 * 提示：
 * 1 <= houses.length, heaters.length <= 3 * 10^4
 * 1 <= houses[i], heaters[i] <= 10^9
 *
 */
public class P0475 {

    public static void main(String[] args) {
        System.out.println(findRadius(new int[]{2,3,4,5,6}, new int[]{1,2,3}));
        System.out.println(findRadius(new int[]{2,3,4,5,6}, new int[]{1}));
        System.out.println(findRadius(new int[]{1,2,3,4}, new int[]{1,4}));
        System.out.println(findRadius(new int[]{1,5}, new int[]{2}));
        System.out.println(findRadius(new int[]{1}, new int[]{1,2,3,4}));
    }

    // 二分求解  还有另外一种方式 双指针
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < houses.length; i++) {
            //二分法找小于等于house[i]最近的位置
            // 极端情况  1. 所有的heaters < houses[i]   left = heaters.length -1
            //          2. 所有的heaters > houses[i]   left = 0 -1
            int left = 0;
            int right = heaters.length - 1;
            if(houses[i] <= heaters[left]){
                left = -1;
            }else{
                while(left < right){
                    int mid = left + (right - left + 1)/2;
                    if(heaters[mid] > houses[i]){
                        right = mid -1;
                    }else{
                        left = mid;
                    }
                }
            }
            int leftVal = (left == -1) ? Integer.MAX_VALUE : Math.abs(houses[i] - heaters[left]);
            int rightVal = (left == heaters.length - 1) ? Integer.MAX_VALUE: Math.abs(houses[i] - heaters[left+1]);
            int min = Math.min(leftVal, rightVal);
            max = Math.max(max, min);
        }
        return max;
    }

    // 暴力求解 时间复杂度 m * n
    public static int findRadius1(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < houses.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < heaters.length; j++) {
                // 找出最小距离
                int dis = Math.abs(heaters[j] - houses[i]);
                min = Math.min(min, dis);
            }
            max = Math.max(max, min);
        }
        return max;
    }


}
