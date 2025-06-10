package lang.leetcode.string;

/** 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 *
 */
public class P0005 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
        /*System.out.println(longestPalindrome("b"));
        System.out.println(longestPalindrome("bb"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("abcdfabba"));*/
    }

    // 中心扩展算法 从中心向两边扩展  枚举每一个边界(单个元素或者连续的两个元素)作为中心
    public static String longestPalindrome(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int maxLen = 1;
        int begin = 0;
        for (int i = 0; i < len; i++) {
            int s1 = expandPalindrome(chars, i, i);
            int s2 = expandPalindrome(chars, i, i + 1);
            if(s1 > maxLen || s2 > maxLen){
                maxLen = Math.max(s1, s2);
                begin = i - (maxLen-1)/2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static int expandPalindrome(char[] chars, int left, int right) {
        while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    /** 动态规划 dp[i][j] 表示s中i到j是否是回文串
     *  子串长度大于2时，dp[i][j]=true需要满足 dp[i+1][j-1]=true && s[i] = s[j]
     *  边界条件：
     *  子串长度 = 1 一定是回文串
     *  子串长度 = 2 s[i] = s[i+1]时，是回文串
     *  所有dp[i][j]=true的位置 j-i+1的最大值是最长回文串
     */
    public static String longestPalindrome2(String s) {
        int len = s.length();
        Boolean[][] dp = new Boolean[len][len];
        // 初始化长度为1的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = Boolean.TRUE;
        }
        // 子串长度大于2时，dp[i][j]=true需要满足 dp[i+1][j-1]=true && s[i] = s[j] 所以必须先求 dp[i+1][j-1]是否回文串
        // 按照子串长度从小到大处理
        int maxLen = 1;
        int begin = 0;
        int L = 2;
        char[] chars = s.toCharArray();
        while(L <= len){
            for (int i = 0; i < len - L + 1; i++) {
                int j = L + i - 1;
                if(chars[i] != chars[j]){
                    dp[i][j] = Boolean.FALSE;
                }else{
                    if(L == 2){ // j - i < 3 包含长度1,2,3
                        dp[i][j] = Boolean.TRUE;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j] && (j - i + 1) > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
            L++;
        }
        return s.substring(begin, begin + maxLen);
    }

    // 暴力法
    public static String longestPalindrome3(String s) {
        int len = s.length();
        if(len < 2){
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if( (j - i + 1) > maxLen && validPalindrome(c, i, j)){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static boolean validPalindrome(char[] c, int i, int j) {
        while(i < j){
            if(c[i++] != c[j--]){
                return false;
            }
        }
        return true;
    }

}
