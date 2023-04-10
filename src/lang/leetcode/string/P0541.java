package lang.leetcode.string;

/** 反转字符串
 *
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 *
 * 示例 1：
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 *
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 *
 * 提示：
 * 1 <= s.length <= 10^4
 * s 仅由小写英文组成
 * 1 <= k <= 10^4
 *
 */
public class P0541 {

    public static void main(String[] args) {
        String str = "abcd";
        str = reverseStr(str, 3);
        System.out.println(str);
    }

    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        for(int i = 0; i < length - 1; i += 2 * k){
            int start = i;
            int end = Math.min(i + k -1 , length - 1);
            /*if(i + k -1  > length -1){
                end = length -1;
            }else{
                end = i + k -1;
            }*/
            // 反转 交换i 和i+k中间的元素
            while(start < end){
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }

        }
        return String.valueOf(chars);
    }

}
