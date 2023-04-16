package lang.leetcode.slidingwindow;

import java.util.*;

/** 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 提示：
 * 0 <= s.length <= 5 * 10^4
 * s 由英文字母、数字、符号和空格组成
 *
 */
public class P0003 {

    public static void main(String[] args) {
        String str = "bbbbb";
        // 1234567895 abba abcabcbb bbbbb pwwkew abca abcd
        int index = lengthOfLongestSubstring3(str);
        System.out.println(index);
    }

    // 优化的窗口，利用两个指针
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || "".equals(s)){
            return 0;
        }
        int start = 0;
        int end = 0;
        int len = 0;
        Map map = new HashMap<>();
        for (int i = 0; i <  s.length(); i++) {
            if(map.containsKey(s.charAt(i)) && (int)map.get(s.charAt(i)) >= start){
                len = Math.max(len, end - start); // 出现重复字符时，才计算长度
                start = (Integer)map.get(s.charAt(i)) + 1;
            }
            map.put(s.charAt(i), i);
            end++;
        }
        len = Math.max(len, end - start);
        return len;
    }

    // chatgtp1 思想：Set是一个窗口，如果出现重复元素，清空窗口中那个重复元素及其之前的所有元素，再往前走
    public static int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        Set set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    // chatgtp2 思想：双指针
    public static int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);//每一步都计算长度
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    /* 别人的答案
    对于这道题，我们可以使用数组来实现。具体原理如下：
    定义一个长度为128的整型数组，用来存储每个字符出现的位置。
    定义两个指针i和j，分别表示子串的起始位置和结束位置。
    遍历字符串，如果当前字符在数组中的值为0，说明该字符没有出现过，将其位置存入数组中。
    如果当前字符在数组中的值不为0，说明该字符已经出现过，需要更新子串的起始位置i，使其指向该字符上一次出现的位置的下一个位置。
    每次遍历都需要更新子串的结束位置j，计算当前子串的长度，并将其与之前的最大长度进行比较，取较大值。
    最后返回最大长度即可。
    使用数组实现的时间复杂度为O(n)，空间复杂度为O(1)。
    */
    public int lengthOfLongestSubstring2(String s) {
        int max = 0;
        int[] last = new int[128];
        Arrays.fill(last, -1);
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);// last[index] 记录字符上次出现位置
            max = Math.max(max, i - start + 1);
            last[index] = i;
        }
        return max;
    }

}
