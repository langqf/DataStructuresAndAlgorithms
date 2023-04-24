package lang.leetcode.search;

/** x 的平方根
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 * 示例 1：
 * 输入：x = 4
 * 输出：2
 *
 * 示例 2：
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 *
 * 提示：
 *
 * 0 <= x <= 2^31 - 1
 *
 */
public class P0069 {

    public static void main(String[] args) {
        System.out.println(mySqrt2(2147395599));// 46339
/*        System.out.println(mySqrt(0));// 46339
        System.out.println(mySqrt(1));// 46339*/
        System.out.println(mySqrt2(2));// 46339
        System.out.println(mySqrt2(3));// 46339
        System.out.println(mySqrt2(4));// 46339
        System.out.println(mySqrt2(5));// 46339
        System.out.println(mySqrt2(6));// 46339
        System.out.println(mySqrt2(7));// 46339
        System.out.println(mySqrt2(8));// 46339
        System.out.println(mySqrt2(9));// 46339
        System.out.println(mySqrt2(10));// 46339
//        System.out.println(Math.sqrt(2147395599));
    }

    // 超出时间限制 速度太慢 因为int溢出了 要强制转换成long
    public static int mySqrt2(int x) {
        int min = 0;
        int max = x;
        while(min <= max){
            int mid = (min + max) / 2;
            long result = (long)mid * mid;
            if(result < x){
                min = mid + 1;
            }else if(result > x){
                max = mid - 1;
            }else{
                return mid;
            }
        }
        return min;// return max;
    }


    public static  int mySqrt1(int x) {
        if(x == 0){
            return x;
        }
        int min = 1;
        int max = x/2;
        while(min < max){
            int mid = (min + max) / 2 + 1; // +1 略微增大搜索空间
            int result = x/mid;
            if(result < mid){
                max = mid - 1;
            }else{
                min = mid;
            }
        }
        return min;
    }

    public int mySqrt(int x) {
        if(x == 0 || x == 1){
            return x;
        }
        int min = 0;
        int max = x;
        int mid = (min + max) / 2;
        while(min <= max){
            int result = x/mid;
            if(result > mid){
                min = mid + 1;
                mid = (min + max) / 2;
            }else if(result < mid){
                max = mid - 1;
                mid = (min + max) / 2;
            }else{
                return mid;
            }
        }
        return min - 1;
    }

}
