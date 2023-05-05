package lang.leetcode.other;

/** 整数转罗马数字
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。
 * 但也存在特例，
 * 例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。
 * 这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 *
 * 示例 1:
 * 输入: num = 3
 * 输出: "III"
 *
 * 示例 2:
 * 输入: num = 4
 * 输出: "IV"
 *
 * 示例 3:
 * 输入: num = 9
 * 输出: "IX"
 *
 * 示例 4:
 * 输入: num = 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 *
 * 示例 5:
 * 输入: num = 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * 提示：
 * 1 <= num <= 3999
 *
 */
public class P0012 {

    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
    }

    // 因为最大值是3999 枚举每个数位上的数字
    public static String intToRoman(int num)
    {
        String[][] str = {
            {"","I","II","III","IV","V","VI","VII","VIII","IX"},
            {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
            {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
            {"","M","MM","MMM"}
        };
        StringBuffer sub = new StringBuffer();
        sub.append(str[3][num / 1000]);
        sub.append(str[2][num / 100 % 10]);
        sub.append(str[1][num / 10 % 10]);
        sub.append(str[0][num % 10]);
        return sub.toString();
    }

    // 凑数
    public static String intToRoman1(int num) {
        StringBuffer sub = new StringBuffer();
        int[] arr = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] str = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < arr.length; i++) {
            while(num >= arr[i]){
                num -= arr[i];
                sub.append(str[i]);
            }
        }
        return sub.toString();
    }

    public static String intToRoman2(int num) {
        int a4 = num/1000 % 10;
        int a3 = num/100 % 10;
        int a2 = num/10 % 10;
        int a1 = num/1 % 10;
        StringBuffer sub = new StringBuffer();
        sub.append(a(a4)).append(b(a3)).append(c(a2)).append(d(a1));
        return sub.toString();
    }
    
    public static String d(int num) {
        StringBuffer sub = new StringBuffer();
        if(num > 1 && num < 4){
            for (int i = 0; i < num; i++) {
                sub.append( "I");
            }
        }else if(num == 4){
            sub.append( "IV");
        }else if(num > 4 && num < 9){
            sub.append( "V");
            for (int i = 0; i < num - 5; i++) {
                sub.append( "I");
            }
        }else if(num == 9){
            sub.append( "IX");
        }
        return sub.toString();
    }

    public static String c(int num) {
        StringBuffer sub = new StringBuffer();
        if(num > 1 && num < 4){
            for (int i = 0; i < num; i++) {
                sub.append( "X");
            }
        }else if(num == 4){
            sub.append("XL");
        }else if(num > 4 && num <9){
            sub.append("L");
            for (int i = 0; i < num - 5; i++) {
                sub.append( "X");
            }
        }else if(num == 9){
            sub.append("XC");
        }
        return sub.toString();
    }

    public static String b(int num) {
        StringBuffer sub = new StringBuffer();
        if(num > 1 && num < 4){
            for (int i = 0; i < num; i++) {
                sub.append( "C");
            }
        }else if(num == 4){
            sub.append( "CD");
        }else if(num > 4 && num <9){
            sub.append( "D");
            for (int i = 0; i < num - 5; i++) {
                sub.append( "C");
            }
        }else if(num == 9){
            sub.append( "CM");
        }
        return sub.toString();
    }

    public static String a(int num) {
        StringBuffer sub = new StringBuffer();
        for (int i = 0; i < num; i++) {
            sub.append("M");
        }
        return sub.toString();
    }
}
