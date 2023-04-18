package lang.leetcode.bitwise.operation;

/** 2 的幂
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 如果存在一个整数 x 使得 n == 2^x ，则认为 n 是 2 的幂次方。
 *
 * 示例 1：
 * 输入：n = 1
 * 输出：true
 * 解释：2^0 = 1
 *
 * 示例 2：
 * 输入：n = 16
 * 输出：true
 * 解释：2^4 = 16
 *
 * 示例 3：
 * 输入：n = 3
 * 输出：false
 *
 * 示例 4：
 * 输入：n = 4
 * 输出：true
 *
 * 示例 5：
 * 输入：n = 5
 * 输出：false
 *
 * 提示：
 *
 * -2^31 <= n <= 2^31 - 1
 *
 *
 * 进阶：你能够不使用循环/递归解决此问题吗？
 */
public class P0231 {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(4));
    }

    // 进阶
    // 对于任意一个2的n次幂的数，将 n 和 n-1 进行 & 运算 结果都等于0
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }

    // 转二进制 判断最高位是否为1  时间太长
    public static boolean isPowerOfTwo1(int n) {
        String binaryStr = "";
        while(n > 0){
            binaryStr = n%2 + binaryStr;
            n/=2;
        }
        if(!binaryStr.startsWith("1")){
            return false;
        }else{
            for (int i = 1; i < binaryStr.length(); i++) {
                if(binaryStr.charAt(i) != '0'){
                    return false;
                }
            }
            return true;
        }
    }

    // 移位
    public static boolean isPowerOfTwo2(int n) {
        int m = 1;
        while(m <= n && m > 0){
            if(m < n){
                m <<= 1;
            }else if(m == n){
                return true;
            } else{
                return false;
            }
        }
        return false;
    }

}

