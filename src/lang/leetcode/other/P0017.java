package lang.leetcode.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 类似九宫格输入法
 *         2（abc） 3(def)
 * 4(ghi)  5（jkl） 6(mno)
 * 7(pqrs) 8（tuv） 9(wxyz)
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 *
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 * 提示：
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 *
 */
public class P0017 {

    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
        System.out.println(letterCombinations("2"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits.length() == 0 ){
            return list;
        }
        Map<Character, String> map = new HashMap(){{
        put('2',"abc");
        put('3',"def");
        put('4',"ghi");
        put('5',"jkl");
        put('6',"mno");
        put('7',"pqrs");
        put('8',"tuv");
        put('9',"wxyz");
        }};
        StringBuffer s = new StringBuffer();
        backtrack(list, map, digits, 0, s);
        return list;
    }

    public static void backtrack(List<String> list, Map<Character, String> map, String digits, int i, StringBuffer s){
        if(i == digits.length()){
            list.add(s.toString());
            return;
        }
        String alp = map.get(digits.charAt(i));
        for (int k = 0; k < alp.length(); k++) {
            s.append(alp.charAt(k));
            backtrack(list, map, digits, i+1, s);
            s.deleteCharAt(i);
        }
    }

}
