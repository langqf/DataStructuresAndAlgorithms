package lang.leetcode.search;

import java.util.Arrays;

/** 爱吃香蕉的珂珂
 *  珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 *
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 *
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 *
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 *
 * 示例 1：
 * 输入：piles = [3,6,7,11], h = 8
 * 输出：4
 *
 * 示例 2：
 * 输入：piles = [30,11,23,4,20], h = 5
 * 输出：30
 *
 * 示例 3：
 * 输入：piles = [30,11,23,4,20], h = 6
 * 输出：23
 *
 * 提示：
 *
 * 1 <= piles.length <= 10^4
 * piles.length <= h <= 10^9
 * 1 <= piles[i] <= 10^9
 *
 */
public class P0875 {

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{3,6,7,11}, 8));
        System.out.println(minEatingSpeed(new int[]{30,11,23,4,20}, 5));
        System.out.println(minEatingSpeed(new int[]{30,11,23,4,20}, 6));
    }

    // 吃香蕉最慢速度 1小时/根  最快速度 max(piles[])/根  在最快和最慢之间查找满足条件的最小的速度
    public static int minEatingSpeed(int[] piles, int h) {
        int lowestSpeed = 1;
        int fastestSpeed = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            fastestSpeed = Math.max(fastestSpeed, piles[i]);
        }
        int k = fastestSpeed;
        int midSpeed = (lowestSpeed + fastestSpeed)/2;
        while(lowestSpeed < fastestSpeed){
            if(canEat(piles, midSpeed, h)){
                k = midSpeed;
                fastestSpeed = midSpeed;
            }else{
                lowestSpeed = midSpeed + 1;
            }
            midSpeed = (lowestSpeed + fastestSpeed)/2;
        }
        return k;
    }

    // 当前速度吃完香蕉用时 > 目标时间  说明速度太慢，要提高速度
    public static boolean canEat(int[] piles, int speed, int h){
        int total = 0;
        for (int i = 0; i < piles.length; i++) {
             total += (piles[i] + speed - 1) / speed;
//            total += Math.ceil(piles[i] * 1.0 / speed);
        }
        return total > h ? false: true;
    }

}
