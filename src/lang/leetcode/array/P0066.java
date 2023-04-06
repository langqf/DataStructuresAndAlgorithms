package lang.leetcode.array;

/** 加1
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 *
 * 示例 2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 *
 * 输入：digits = [0]
 * 输出：[1]
 *
 * 提示：
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 */
public class P0066 {

    public static void main(String[] args) {
        int[] digits1 = {1,2,3};
        int[] result1 = plusOne(digits1);
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i] + " ");
        }
        System.out.println("\n ***************");
        int[] digits2 = {0};
        int[] result2 = plusOne(digits2);
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i] + " ");
        }
        System.out.println("\n ***************");
        int[] digits3 = {1,9,9,9};
        int[] result3 = plusOne(digits3);
        for (int i = 0; i < result3.length; i++) {
            System.out.print(result3[i] + " ");
        }

    }

    public static int[] plusOne(int[] digits) {
        for(int i = digits.length - 1 ; i >= 0; i--){
            if(digits[i] != 9){
                digits[i] += 1;
                return digits;
            }else{
                digits[i] = 0;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static int[] plusOne1(int[] digits) {
        for(int i = digits.length - 1 ; i >= 0; i--){
            if(digits[i] != 9){
                digits[i] += 1;
                while(++i < digits.length){
                    digits[i] = 0;
                }
                return digits;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
