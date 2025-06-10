package lang.leetcode.other;

/** 整数反转
 *给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 *
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 *
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 *
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 *
 * 提示：
 * -2^31 <= x <= 2^31 - 1
 *
 */
public class P0007 {

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
//        System.out.println(Integer.MIN_VALUE);// -2147483648
//        System.out.println(Integer.MIN_VALUE/10);// -214748364
        System.out.println(reverse(-2147483412));
        System.out.println(reverse(-2143847412));

    }

    public static int reverse(int x) {
        int rev = 0;
        while(x != 0){
            int digit = x % 10;
            x /= 10;
            int temp = rev * 10 + digit;
            if(temp/10 != rev){// 溢出之后/10不等于rev,说明溢出
                return 0;
            }
            rev = temp;
        }
        return rev;
    }

    public static int reverse1(int x) {
        int rev = 0;
        while(x != 0){
            if(rev < Integer.MIN_VALUE/10 || rev > Integer.MAX_VALUE/10){
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }

}
