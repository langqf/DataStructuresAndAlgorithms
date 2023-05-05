package lang.leetcode.other;

/** 在LR字符串中交换相邻字符
 * 在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。一次移动操作指用一个"LX"替换一个"XL"，或者用一个"XR"替换一个"RX"。
 * 现给定起始字符串start和结束字符串end，请编写代码，当且仅当存在一系列移动操作使得start可以转换成end时， 返回True。
 *
 * 示例 :
 * 输入: start = "RXXLRXRXL", end = "XRLXXRRLX"
 * 输出: True
 * 解释:
 * 我们可以通过以下几步将start转换成end:
 * RXXLRXRXL ->
 * XRXLRXRXL ->
 * XRLXRXRXL ->
 * XRLXXRRXL ->
 * XRLXXRRLX
 *
 * 提示：
 * 1 <= len(start) = len(end) <= 10000。
 * start和end中的字符串仅限于'L', 'R'和'X'。
 *
 */

public class P0777 {

    public static void main(String[] args) {
        System.out.println(canTransform("RXXLRXRXL", "XRLXXRRLX"));
        System.out.println(canTransform("RXXLRXRXL", "XRLXXXRRL"));
        System.out.println(canTransform("RXXLRXRXL", "XRXLXRXRL"));
        System.out.println(canTransform("RXXLRXRXL", "RLXXXRRLX"));
        System.out.println(canTransform("RXXLRXRXL", "RLXXXRRLX"));
        System.out.println(canTransform("RXXLRXRXL", "XXXRLRRLX"));
        System.out.println(canTransform("RXXLRXRXL", "XXXXRLRRL"));
        System.out.println(canTransform("LXXLXRLXXL", "XLLXRXLXLX"));
        System.out.println(canTransform("XXXXXLXXXLXXXX", "XXLXXXXXXXXLXX"));
        System.out.println(canTransform("XXXLXXXXXX", "XXXLXXXXXX"));
        System.out.println(canTransform("LLR", "RRL"));
    }

    // 代码优化一下 使用replaceAll效率很低
    public static boolean canTransform(String start, String end) {
        int i = 0, j = 0;
        int n = start.length();
        while(i < n && j < n){
            while(i < n && start.charAt(i) == 'X'){
                i++;
            }
            while(j < n && end.charAt(j) == 'X'){
                j++;
            }
            if( i < n && j < n){
                char c = start.charAt(i);
                if (c != end.charAt(j)) {
                    return false;
                }
                if ((c == 'L' && i < j) || (c == 'R' && i > j)) {
                    return false;
                }
                i++;
                j++;
            }
        }
        while(i < n){
            if(start.charAt(i) != 'X'){
                return false;
            }
            i++;
        }
        while(j < n){
            if(end.charAt(j) != 'X'){
                return false;
            }
            j++;
        }
        return true;
    }

    // 代码简化一下
    public static boolean canTransform0(String start, String end) {
        if(!start.replaceAll("X", "").equals(end.replaceAll("X", ""))){
            return false;
        }
        int n = start.length();
        for (int i = 0, j = 0; i < n; i++) {
            if(start.charAt(i) == 'X'){
                continue;
            }
            while(end.charAt(j) == 'X'){
                j++;
            }
            char c = start.charAt(i);
            if ((c == 'L' && i < j) || (c == 'R' && i > j)) {
                return false;
            }
            j++;
            /*if (i != j && (start.charAt(i) == 'L') == (i < j)) {
                return false;
            }*/
        }
        return true;
    }

    // 特点1：l,r不能替换顺序
    // 特点2：lx替换xl l向左移动  xr替换rx r向右移动
    public static boolean canTransform1(String start, String end) {
        if(!start.replaceAll("X", "").equals(end.replaceAll("X", ""))){
            return false;
        }
        int i = 0, j = 0;
        int n = start.length();
        while(i < n && j < n){
            while(i < n && start.charAt(i) == 'X'){
                i++;
            }
            while(j < n && end.charAt(j) == 'X'){
                j++;
            }
            if( i < n && j < n){
                /*if(start.charAt(i) != end.charAt(j)) {
                    return false;
                }*/
                char c = start.charAt(i);
                if ((c == 'L' && i < j) || (c == 'R' && i > j)) {
                    return false;
                }
                i++;
                j++;
            }
        }
        return true;
    }

    // 因为L R不能交换 只要保证L R的顺序不变就行
    // 错误：
    // 原因：一个"LX"可以替换一个"XL"，一个"XR"可以替换一个"RX"，
    //      但是一个"XL"不能替换一个"LX"，一个"RX"不能替换一个"XR"
    public static boolean canTransform2(String start, String end) {
        String newStart = start.replaceAll("X", "");
        String newEnd = end.replaceAll("X", "");
        return newStart.equals(newEnd);
    }

}
