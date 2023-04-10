package lang.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/** 字符串中的第一个唯一字符
 *
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 *
 *示例 1：
 * 输入: s = "leetcode"
 * 输出: 0
 *
 * 示例 2：
 * 输入: s = "loveleetcode"
 * 输出: 2
 *
 * 示例 3：
 * 输入: s = "aabb"
 * 输出: -1
 *
 * 提示:
 * 1 <= s.length <= 10^5
 * s 只包含小写字母
 *
 */
public class P0387 {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println(firstUniqChar("aabb"));
    }


    public static int firstUniqChar(String s) {
        // 因为题目中只包含小写英文，利用0-26个字符数组，存储每个字符出现次数
        // count[0] == count['a'-'a']  count[25] = count['z'-'a']
        int[] count = new int[26];
        int length = s.length();
        for(int i = 0; i < length; i++){
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < length; i++) {
            if(count[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }

    // hash
    public static int firstUniqChar0(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int length = s.length();
        for(int i = 0; i < length; i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1); // map记录每个字符出现次数
        }
        for(int i = 0; i < length; i++){
            char c = s.charAt(i);
            if (1 == map.get(c)) { // 找到第一个出现次数等于1的
                return i;
            }
        }
        return -1;
    }

    // hash  有bug
    public static int firstUniqChar2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int length = s.length();
        for(int i = 0; i < length; i++){
            char c = s.charAt(i);
            map.put(c, i); // map记录每个字符最后出现位置
        }
        for(int i = 0; i < length; i++){
            char c = s.charAt(i);
            if (i == map.get(c)) { // 第一次出现的位置和最后一次相同
                return i;
            }
        }
        return -1;
    }
    // 暴力破解
    public static int firstUniqChar1(String s) {
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(s.indexOf(chars[i]) == s.lastIndexOf(chars[i])){
                return i;
            }
        }
        return -1;
    }

}
