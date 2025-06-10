package lang.leetcode.other;

/** 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。
 *
 * 示例 1：
 * 输入：x = 121
 * 输出：true
 *
 * 示例 2：
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3：
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 提示：
 * -2^31 <= x <= 2^31 - 1
 *
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 */
public class P0009 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(1221));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }

    // 假设反转后溢出如何处理？ 考虑反转后一半数字
    public static boolean isPalindrome(int x) {
        // 负数、尾数为0且不为0的数 不可能是回文串
        if(x < 0 || (x%10 == 0  && x != 0)){
            return false;
        }
        int ans = 0;
        while(x > ans){
            ans = 10 * ans + x % 10;
            x /= 10;
        }
        return x == ans || x == ans / 10;
    }

    // 反转整个数再进行判断也可以，而且代码更简洁，因为如果反转溢出，那他一定不是回文数，回文数反转以后一定是它本身，所以一定不会溢出
    public static boolean isPalindrome0(int x) {
        if(x < 0 ){
            return false;
        }
        int temp = x;
        int ans = 0;
        while(x != 0 ){
            int y = x % 10;
            ans = 10 * ans + y;
            x /= 10;
        }
        return ans == temp;
    }

    // 整数转字符串
    public static boolean isPalindrome1(int x) {
        String s = x + "";
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length -1;
        while(i < j){
            if(chars[i] != chars[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
