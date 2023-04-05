package lang.leetcode;

import java.util.HashSet;
import java.util.Set;

/** 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * 提示：
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 */
public class P0014 {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix2(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix2(new String[]{"dog","racecar","car"}));
        System.out.println(longestCommonPrefix2(new String[]{"dog","racecar",""}));
        System.out.println(longestCommonPrefix2(new String[]{"d122og","d122acecar","d"}));
        System.out.println(longestCommonPrefix2(new String[]{"d122o","d122og","d122og1"}));
    }

    // 思路 1. 获取最短串长度
    //      2. 加入一个计数变量cnt，统计前面有几个相同字符，
    //          将每个位置的字符加入Set
    //          Set中 size == 1，说明该位置字符相同，计数变量cnt+1
    //          Set中 size!= 1，说明有不相同的字符，结束计数
    //      3. 截取任意字符串前cnt个字符就是最长公共前缀
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) {
            return strs[0];
        }
        int minLen = strs[0].length();
        int length = strs.length;
        int i  = 1;
        while(i < length){
            minLen = minLen < strs[i].length() ?  minLen : strs[i].length();
            i++;
        }
        int cnt = 0;
        for(int j = 0; j < minLen; j++){
            Set<Character> s = new HashSet();
            for(int n = 0; n < length; n ++){
                s.add(strs[n].charAt(j));
            }
            if(s.size() !=  1){
                break;
            }else{
                cnt++;
            }
        }
        return strs[0].substring(0, cnt);
    }

    // 思路 1. 获取最短串长度minLen，拿(第)一个元素的前minLen个串作为基准串
    //      2. 将基准串与其他串逐个比较，发现有不同时，截取基准串（比如：abcd去掉最后一位，得到新的基准串abc）,重新比较
    //      3. 如果都相同，最后的基准串就是最前公共前缀
    public static String longestCommonPrefix2(String[] strs) {
        if(strs.length == 1) {
            return strs[0];
        }
        int minLen = strs[0].length();
        int length = strs.length;
        int i  = 1;
        while(i < length){
            minLen = minLen < strs[i].length() ?  minLen : strs[i].length();
            i++;
        }
        String minStr = strs[0].substring(0, minLen);
        for(int n = 1; n < length; n++){
            if(!strs[n].startsWith(minStr)){
                if(minStr.length() == 1){
                    minStr = "";
                    break;
                }
                minStr = minStr.substring(0, minStr.length() - 1);
                n = 0;
            }
        }
        return minStr;
    }
}
