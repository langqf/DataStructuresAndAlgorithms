package lang.leetcode.string;

/** 找出字符串中第一个匹配项的下标
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 *
 *示例 1：
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 *
 * 示例 2：
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 *
 * 提示：
 *
 * 1 <= haystack.length, needle.length <= 10^4
 * haystack 和 needle 仅由小写英文字符组成
 *
 */
public class P0028 {
    public static void main(String[] args) {
        System.out.println(strStr("s1dbutsad", "sad"));
    }

    //TODO  KMP 算法
    public static int strStr(String haystack, String needle) {

        return -1;
    }

    // 暴力法
    public static int strStr1(String haystack, String needle) {
        if(needle.length() > haystack.length()){
            return  -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            int k = i;
            for (int j = 0; j < needle.length() && k < haystack.length(); j++,k++) {
                if(haystack.charAt(k) != needle.charAt(j)){
                    break;
                }
            }
            if(k == (i + needle.length())){
                return i;
            }
        }
        return -1;
    }
}
