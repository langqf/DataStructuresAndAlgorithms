package lang.leetcode.other;

import java.util.HashSet;
import java.util.Set;

/** 有效的数独
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 *
 * 注意：
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 * 示例 1：
 * 输入：board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：true
 *
 * 示例 2：
 * 输入：board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：false
 * 解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 *
 * 提示：
 * board.length == 9
 * board[i].length == 9
 * board[i][j] 是一位数字（1-9）或者 '.'
 *
 */
public class P0036 {

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(board));

    }
    // 判断每一个元素是否符合数独规则
    public static boolean isValidSudoku(char[][] board) {
        char[][] row = new char[9][9]; // row[i][j] = 1 表示第i行存在j这个数
        char[][] col = new char[9][9]; // col[i][j] = 1 表示第i列存在j这个数
        char[][] sbox = new char[9][9]; // row[i][j] = 1 表示第i个3*3方阵存在j这个数
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.'){
                    int num = board[i][j] - '1';
                    if(row[i][num] == 1){
                        return false;
                    }else{
                        row[i][num] = 1;
                    }
                    if(col[j][num] == 1){
                        return false;
                    }else{
                        col[j][num] =1;
                    }
                    int boxIndex  = (i/3) * 3 + j/3;
                    if(sbox[boxIndex][num] == 1){
                        return false;
                    }else{
                        sbox[boxIndex][num] = 1;
                    }
                }
            }
        }
        return true;
    }


    // 暴力破解
    public static boolean isValidSudoku1(char[][] board) {
        int n = board.length;
        for (int i = 0; i < n ; i++) {
            Set<Character> setRow = new HashSet<>();//每一行
            Set<Character> setCol = new HashSet<>();//每一列
            for (int j = 0; j < n; j++) {
                if(board[i][j] != '.'){
                    if(setRow.contains(board[i][j])){
                        return false;
                    }else{
                        setRow.add(board[i][j]);
                    }
                }
                if(board[j][i] != '.'){
                    if(setCol.contains(board[j][i])){
                        return false;
                    }else{
                        setCol.add(board[j][i]);
                    }
                }
            }
        }
        int r = 0, c = 0;
        while(r < n){
            while(c < n){
                Set<Character> setRow = new HashSet<>();// 3 X 3 行
                for (int i = r ; i < r+3; i++) {
                    for (int j = c; j < c+3; j++) {
                        if(board[i][j] != '.'){
                            if(setRow.contains(board[i][j])){
                                return false;
                            }else{
                                setRow.add(board[i][j]);
                            }
                        }
                    }
                }
                c += 3;
            }
            r += 3;
            c = 0;
        }
        return true;
    }

}

