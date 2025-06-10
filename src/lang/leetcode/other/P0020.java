package lang.leetcode.other;

import java.util.ArrayList;
import java.util.List;

/** 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 *
 * 提示：
 * 1 <= n <= 8
 *
 */
public class P0020 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));
        System.out.println(generateParenthesis(2));
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(list, "", n, n);
        return list;
    }

    public static void generate(List<String> list, String str, int left, int right) {
        if(left == 0 && right == 0){
            list.add(str);
            return ;
        }
        if(left == right){
            generate(list, str + "(", left - 1, right);
        }else if(left < right){
            if(left > 0){
                generate(list, str + "(", left - 1, right);
            }
            generate(list, str + ")", left, right - 1);
        }
    }

    // 回溯法
    public static List<String> generateParenthesis1(int n) {
        List<String> list = new ArrayList<>();
        backtrack1(list, new StringBuffer(), 0, 0, n);
        return list;
    }

    public static void backtrack1(List<String> list, StringBuffer sub, int left , int right, int n) {
        if(sub.length() == 2 * n){
            list.add(sub.toString());
            return;
        }
        if(left < n){
            sub.append("(");
            backtrack1(list, sub, left + 1, right, n);
            sub.deleteCharAt(sub.length() - 1);
        }
        if(right < left){
            sub.append(")");
            backtrack1(list, sub, left, right + 1, n);
            sub.deleteCharAt(sub.length() - 1);
        }
    }

    // 暴力破解，2n个位置，每个位置都可能为(或)
    public static List<String> generateParenthesis2(int n) {
        List<String> list = new ArrayList<>();
        char[] chars = new char[2 * n];
        dfs(chars, 0, list);
        return list;
    }

    public static void dfs(char[] chars, int pos, List<String> list) {
        if(pos == chars.length){
            if(valid(chars)){
                list.add(new String(chars));
            }
            return;
        }
        chars[pos]= '(';
        dfs(chars, pos+1, list);
        chars[pos]= ')';
        dfs(chars, pos+1, list);

    }

    // 校验括号是否合法 左边括号一定多余或等于右边括号
    public static Boolean valid(char[] chars) {
        int left = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '('){
                left++;
            }else{
                left--;
            }
            if(left < 0){
                return Boolean.FALSE;
            }
        }
        return left == 0;
    }


}
