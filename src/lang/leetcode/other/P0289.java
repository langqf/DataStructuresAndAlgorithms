package lang.leetcode.other;

import java.util.Arrays;

/** 生命游戏
 * 根据 百度百科 ， 生命游戏 ，简称为 生命 ，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态： 1 即为 活细胞 （live），或 0 即为 死细胞 （dead）。
 * 每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 *
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。
 *
 * 示例 1：
 * 输入：board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
 * 输出：[[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
 *
 * 示例 2：
 * 输入：board = [[1,1],[1,0]]
 * 输出：[[1,1],[1,1]]
 *
 * 提示：
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 25
 * board[i][j] 为 0 或 1
 *
 * 进阶：
 * 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
 * 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？
 *
 */
public class P0289 {

    public static void main(String[] args) {
        int[][] board1 = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board1);
        for (int i = 0; i < board1.length; i++) {
            System.out.println(Arrays.toString(board1[i]));
        }
        gameOfLife(board1);
        for (int i = 0; i < board1.length; i++) {
            System.out.println(Arrays.toString(board1[i]));
        }
        System.out.println("*************");
        int[][] board2 = {{1,1},{1,0}};
        gameOfLife(board2);
        for (int i = 0; i < board2.length; i++) {
            System.out.println(Arrays.toString(board2[i]));
        }
        gameOfLife(board2);
        for (int i = 0; i < board2.length; i++) {
            System.out.println(Arrays.toString(board2[i]));
        }
    }

    // 原地更新：通过添加中间态：2表示从生到死的细胞，3表示从死到生的细胞 ， 最后在从中间态转换成终态
    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[] neighbors = {0, 1, -1};
        // 从原始态转换成中间态
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                // 统计每个元素周围八个细胞中活细胞数目 3*3矩阵
                int liveCount = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if(!(neighbors[i] == 0 && neighbors[j] == 0)) {// 排除自身
                            int row = r + neighbors[i];
                            int col = c + neighbors[j];
                            if((row >= 0 && row < m)  && (col >= 0 && col < n) && (board[row][col] == 1 || board[row][col] == 2)){
                                liveCount++;
                            }
                        }
                    }
                }
                if(board[r][c] == 1 && (liveCount < 2 || liveCount > 3)){
                    board[r][c] = 2;
                }
                if(board[r][c] == 0 && liveCount == 3){
                    board[r][c] = 3;
                }
            }
        }
        // 从中间态转换成终态
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j]%2;
            }
        }
    }

    public static void gameOfLife1(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[] neighbors = {0, 1, -1};
        int[][] newBoard = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newBoard[i][j] = board[i][j];
            }
        }
        // 判断每一个元素下一个状态
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                // 统计每个元素周围八个细胞中活细胞数目 3*3矩阵
                int liveCount = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if(!(neighbors[i] == 0 && neighbors[j] == 0)) {// 排除自身
                            int row = r + neighbors[i];
                            int col = c + neighbors[j];
                            if((row >= 0 && row < m)  && (col >= 0 && col < n) && newBoard[row][col] == 1){
                                liveCount++;
                            }
                        }
                    }
                }
                if(newBoard[r][c] == 1 && (liveCount < 2 || liveCount > 3)){
                    board[r][c] = 0;
                }
                if(newBoard[r][c] == 0 && liveCount == 3){
                    board[r][c] = 1;
                }
            }
        }
    }

}
