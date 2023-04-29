package lang.leetcode.other;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/** 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 * 提示：
 * n == height.length
 * 1 <= n <= 2 * 10^4
 * 0 <= height[i] <= 10^5
 *
 */
public class P0042 {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trap(new int[]{4,2,0,3,2,5}));
        System.out.println(trap(new int[]{2,0,2}));
    }

    // 双指针
    public static int trap1(int[] height) {
        int left = 0;
        int right = height.length -1;
        int num = 0;
        while(left < right){
            // 左边 <= 右边，从左往右找到右边第一个 > left的
            if(height[left] <= height[right]){
                int temp = left + 1;
                while(temp <= right && height[temp] <= height[left]){
                    num += height[left] - height[temp];
                    temp++;
                }
                left = temp;
            }else{// 右边 > 左边，从右往左找到左边第一个 > right的
                int temp = right - 1;
                while(temp >= left && height[temp] <= height[right]){
                    num += height[right] - height[temp];
                    temp--;
                }
                right = temp;
            }
        }
        return num;
    }
    // 官方双指针思路
    public static int trap(int[] height) {
        int left = 0;
        int right = height.length -1;
        int num = 0;
        int leftMax = 0;
        int rightMax = 0;
        while(left < right){
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            if(height[left] < height[right]){
                num += leftMax - height[left];
                left++;
            }else{
                num += rightMax - height[right];
                right--;
            }
        }
        return num;
    }

    /**
     * 暴力
     * 思路：位置i能接雨水 = Math.min(左边最大高度,右边最大高度) - h[i]
     *      对于每一个元素，每次都要向左或者向右找最大高度 时间复杂度O(n^2)
     */
    public static int trap2(int[] height) {
        int n = height.length;
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            int left = i;
            int leftMax = 0;
            while(left >= 0){
                leftMax = Math.max(leftMax, height[left]);
                left--;
            }
            int right = i;
            int rightMax = 0;
            while(right < n){
                rightMax = Math.max(rightMax, height[right]);
                right++;
            }
            num[i] = Math.min(leftMax, rightMax) - height[i];
        }
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }
        return sum;
    }

    /**
     * 动态规划（暴力思路进阶）：
     * 如果知道i左边最大高度，那么i+1左边的最大高度就是Math.max(leftMax[i], h[i+1); 时间复杂度是O(n)
     * 同理，可以求每个元素右边最大高度
     * 位置i能接雨水 = Math.min(左边最大高度,右边最大高度) - h[i]
     */
    public static int trap3(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        int[] rightMax = new int[n];
        rightMax[n-1] = height[n-1];
        for (int i = n-2; i >= 0 ; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }
        return sum;
    }



    /**
     * 单调栈 计算每一个能接雨水的位置 比如 3,1,5  3位left 1为top 5为h[i]
     *      1.栈至少得有两个元素
     *      2.h[left] >= h[top]
     *      3. 宽度：w = i-left-1 比如 3,1,5  w = 2-0-1 = 1
     *         高度：h = Math.min(h[left], h[i]) -h[top]  比如 3,1,5  w = 2-0-1 h= min(5,3) - 1 = 2
     *         num = w * h = 2
     *      在两个高度为h1,h2位置中间，一层一层计算能接雨水的数量
     */
    public static int trap4(int[] height) {
        int n = height.length;
        Deque<Integer> stack = new LinkedList<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            // 满足条件计算雨水数量
            while(!stack.isEmpty() && height[i] > height[stack.peek()] ){
                int top = stack.pop();
                // 如果栈中只有一个元素了，就结束计算
                if(stack.isEmpty()){
                    break;
                }
                int left = stack.peek();
                int w = i - left -1;
                int h = Math.min(height[left], height[i]) - height[top];
                sum += w*h;
            }
            stack.push(i);
        }
        return sum;
    }

}
