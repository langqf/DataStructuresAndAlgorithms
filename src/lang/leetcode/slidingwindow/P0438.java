package lang.leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * 示例 1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *
 *  示例 2:
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 * 提示:
 *
 * 1 <= s.length, p.length <= 3 * 10^4
 *
 * s 和 p 仅包含小写字母
 *
 */
public class P0438 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("1,2,3");
        System.out.println(findAnagrams("cbaebabacd","abc"));
        System.out.println(findAnagrams("abab","ab"));
    }

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        int[] sArr = new int[26];
        int[] pArr = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pArr[p.charAt(i) - 'a'] = 1;
            sArr[p.charAt(i) - 'a'] = 1;
        }
        int left = 0;
        int right = p.length();
        while( right < s.length()){
            boolean flag = true;
            for (int i = left; i < right; i++) {
                if(sArr[i] != pArr[i]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                result.add(left);
            }
            sArr[s.charAt(left) - 'a']--;
            left++;

            sArr[s.charAt(right) - 'a']++;
        }
        return null;
    }

    // len表示不匹配字符个数，len=0时，完全匹配 right++不配次字符可能-1，left++不匹配字符可能+1
    public static List findAnagrams1(String s, String p) {
        List res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return res;
        }
        int[] count = new int[26];
        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }
        int left = 0, right = 0, len = p.length();
        while (right < s.length()) {
            if (count[s.charAt(right) - 'a'] > 0) {
                len--;
            }
            count[s.charAt(right) - 'a']--;
            right++;
            if (len == 0) {
                res.add(left);
            }
            if (right - left == p.length()) {
                if (count[s.charAt(left) - 'a'] >= 0) {
                    len++;
                }
                count[s.charAt(left) - 'a']++;
                left++;
            }
        }
        return res;
    }

    // 将它转变为遍历s的时候一种“消耗品”——当“消耗品”不足，唯一可以做的就是移动左窗口释放一些出来
    // 如果遇到没有的字符，high原地等待；low++遍历到这个字符后（即low比high多1后），下一次high也会消耗掉这个没有的字符
    public static List<Integer> findAnagrams2(String s, String p) {
        int[] cnt = new int[128];
        for (char c : p.toCharArray()) cnt[c]++;
        int lo = 0, hi = 0;
        List<Integer> res = new ArrayList<>();
        while (hi < s.length()) {
            if (cnt[s.charAt(hi)] > 0) {
                cnt[s.charAt(hi++)]--;
                if (hi - lo == p.length()) res.add(lo);
            } else {
                cnt[s.charAt(lo++)]++;
            }
        }
        return res;
    }
}
