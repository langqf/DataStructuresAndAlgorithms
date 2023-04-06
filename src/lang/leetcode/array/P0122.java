package lang.leetcode.array;
/** 买卖股票的最佳时机
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 * 示例 1：
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
 *      总利润为 4 + 3 = 7 。
 *
 * 示例 2：
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 *      总利润为 4 。
 *
 * 示例 3：
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。
 *
 * 提示：
 * 1 <= prices.length <= 3 * 10(4)
 * 0 <= prices[i] <= 10(4)
 */
public class P0122 {

    public static void main(String[] args) {
        int[] example1 = {7,1,5,3,6,4};
        int[] example2 = {1,2,3,4,5};
        int[] example3 = {7,6,4,3,1};
        int[] example4 = {7,6,1,2,1,3,5,3,2,1,5,4,6,3};
        System.out.println(maxProfit(example1));
        System.out.println(maxProfit(example2));
        System.out.println(maxProfit(example3));
        System.out.println(maxProfit(example4));
        System.out.println("***************************");
        System.out.println(maxProfit2(example1));
        System.out.println(maxProfit2(example2));
        System.out.println(maxProfit2(example3));
        System.out.println(maxProfit2(example4));
    }

    // 合理计算买入卖出日期，再计算差价 比如1-3-8  sum+(8-1)
    public static int maxProfit(int[] prices){
        if(prices.length == 1){
            return 0;
        }
        int sum = 0;
        int i = 0, j = 0;
        int length = prices.length;
        while(i < length && j < length){
            if(j == length-1 || prices[j] > prices[j+1]){ // 要卖出了 或者 一直在涨价
                if(j > i){
                    int profit = prices[j] - prices[i];
//                    System.out.println("第"+ (i+1) + "天买入价：" + prices[i]+ " ，第"+ (j+1) + "天卖出价：" + prices[j] + ". 利润：" + profit);
                    sum += profit;
                }
                i = j + 1;
            }
            j++;
        }
        return sum;
    }

    // 只要涨价，就加上差价  比如1-3-8  sum+(3-1) + (8-3)
    public static int maxProfit2(int[] prices){
        if(prices.length == 1){
            return 0;
        }
        int sum = 0;
        int j = 0;
        while(j < prices.length -1){
            if(prices[j] <= prices[j+1]){
                sum += (prices[j+1] - prices[j]);
            }
            j++;
        }
        return sum;
    }


}
