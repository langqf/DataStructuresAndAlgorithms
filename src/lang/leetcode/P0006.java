package lang.leetcode;

import java.util.Arrays;

/** N 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 *
 * 示例 1：
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * 示例 3：
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 */
public class P0006 {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3)); // PAHNAPLSIIGYIR
        System.out.println(convert("PAYPALISHIRING", 4)); // PINALSIGYAHRPI
        System.out.println(convert("A", 1));// A
    }

    // 别人的代码，利用一个标志位令数组下标反向，聪明的boy
    public static String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        StringBuffer[] arr = new StringBuffer[numRows];
        for (int l = 0; l < numRows; l++) {
            arr[l] = new StringBuffer();
        }
        char[] chars = s.toCharArray();
        int i = 0;
        int flag = -1;
        for (char c: chars){
            arr[i].append(c);
            if(i == 0 || i == numRows - 1){
               flag = -flag;
            }
            i += flag;
        }
        StringBuffer result = new StringBuffer();
        for (int m = 0; m < arr.length; m++) {
            result.append(arr[m]);
        }
        return result.toString();
    }

    // 优化 参考别人代码  利用取余判断
    public static String convert0(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        StringBuffer[] arr = new StringBuffer[numRows];
        for (int l = 0; l < numRows; l++) {
            arr[l] = new StringBuffer();
        }
        int len = s.length();
        char[] chars = s.toCharArray();
        int period = 2 * (numRows - 1);
        for(int i = 0; i < len; i++){
            int mod = i % period;
            if(mod < numRows){
                // 第一组
                arr[mod].append(chars[i]);
            }else{
                // 第二组
                arr[period - mod].append(chars[i]);
            }
        }
        StringBuffer result = new StringBuffer();
        for (int m = 0; m < arr.length; m++) {
            result.append(arr[m]);
        }
        return result.toString();
    }

    /**
     *  0   4   8
     *  1 3 5 7 9
     *  2   6
     *  建立一个字符串数组，按规律添加元素，举例：rowNums=3 数组 arr[0]、 arr[1]、 arr[2]
     *  每 2*（rowNums-1)个数据是一组
     *  第一组：
     *  0,1添加到arr[0]、 arr[1]
     *  2,3添加到arr[2]、 arr[1]
     *  第二组：
     *  4,5添加到arr[0]、 arr[1]
     *  6,7添加到arr[2]、 arr[1]
     *  ......
     *  ......
     *  ......
     *  分组写得太死了
     */
    public static String convert1(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        StringBuffer[] arr = new StringBuffer[numRows];
        for (int l = 0; l < numRows; l++) {
            arr[l] = new StringBuffer();
        }
        int i = 0;
        int len = s.length();
        while(i < len){
            // 第一组
            for(int j = 0; j < numRows -1 && i < len; j++,i++){
                arr[j].append(s.charAt(i));
            }
            // 第二组
            for(int k = numRows -1; k > 0  && i < len; k--,i++){
                arr[k%numRows].append(s.charAt(i));
            }
        }
        String result = "";
        for (int m = 0; m < numRows; m++) {
            result += arr[m].toString();
        }
        return result;
    }

    /** 总结每一行元素位置规律，暴力匹配每一行数据，时间复杂度太高
     *  numRows = 3
     *  4 = 2 * (numRows - 1)
     *  0   4   8  对4求余=0或4-0
     *  1 3 5 7 9  对4求余=1或4-1
     *  2   6      对4求余=2或4-2
     */
    public static String convert2(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        StringBuffer str = new StringBuffer();
        int len = s.length();
        int n = 2 * (numRows - 1);
        for(int r = 0; r < numRows; r++){
            for (int i = 0; i < len; i++) {
                if(r == 0 || r == numRows - 1){
                    if(i%n == r){
                        str.append(s.charAt(i));
                    }
                }else if(i%n == r || i%n == (n-r)) {
                    str.append(s.charAt(i));
                }
            }
        }
        return str.toString();
    }
}
