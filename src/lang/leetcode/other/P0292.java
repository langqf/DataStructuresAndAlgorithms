package lang.leetcode.other;

/** Nim 游戏
 * 你和你的朋友，两个人一起玩 Nim 游戏：
 * 桌子上有一堆石头。
 * 你们轮流进行自己的回合， 你作为先手 。
 * 每一回合，轮到的人拿掉 1 - 3 块石头。
 * 拿掉最后一块石头的人就是获胜者。
 * 假设你们每一步都是最优解。请编写一个函数，来判断你是否可以在给定石头数量为 n 的情况下赢得游戏。如果可以赢，返回 true；否则，返回 false 。
 *
 * 示例 1：
 * 输入：n = 4
 * 输出：false
 * 解释：以下是可能的结果:
 * 1. 移除1颗石头。你的朋友移走了3块石头，包括最后一块。你的朋友赢了。
 * 2. 移除2个石子。你的朋友移走2块石头，包括最后一块。你的朋友赢了。
 * 3. 你移走3颗石子。你的朋友移走了最后一块石头。你的朋友赢了。
 * 在所有结果中，你的朋友是赢家。
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：true
 *
 * 示例 3：
 * 输入：n = 2
 * 输出：true
 *
 * 提示：
 * 1 <= n <= 2^31 - 1
 *
 */

public class P0292 {

    public static void main(String[] args) {
        System.out.println("1 canWin:" + canWinNim(1));
        System.out.println("2 canWin:" + canWinNim(2));
        System.out.println("3 canWin:" + canWinNim(3));
        System.out.println("4 canWin:" + canWinNim(4));
        System.out.println("7 canWin:" + canWinNim(7));
        System.out.println("7 canWin:" + canWinNim(8));
    }
    // 不是4的倍数的，都能赢，先手每次拿掉1-3块后，保证剩余的石头剩余数量是4的倍数就行
    // 比如 5先移走一块，剩4块；6先移走2块，剩4块；7先移走3块，剩4块；
    // 剩下的，对手拿走1块，你拿走3块，对手拿走2块，你拿走2块，对手拿走3块，你拿走1块
    public static boolean canWinNim(int n) {
        return n%4 != 0;
    }

}
