package lang.leetcode.other;

/** 除数博弈
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 * 最初，黑板上有一个数字 n 。在每个玩家的回合，玩家需要执行以下操作：
 *
 * 选出任一 x，满足 0 < x < n 且 n % x == 0 。
 * 用 n - x 替换黑板上的数字 n 。
 * 如果玩家无法执行这些操作，就会输掉游戏。
 * 只有在爱丽丝在游戏中取得胜利时才返回 true 。假设两个玩家都以最佳状态参与游戏。
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：true
 * 解释：爱丽丝选择 1，鲍勃无法进行操作。
 *
 * 示例 2：
 * 输入：n = 3
 * 输出：false
 * 解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
 *
 * 提示：
 * 1 <= n <= 1000
 *
 */
public class P1025 {

    public static void main(String[] args) {

        System.out.println("1 is " + divisorGame(1));// fail
        System.out.println("2 is " + divisorGame(2));// 1 win
        System.out.println("3 is " + divisorGame(3));// 1 1 fail
        System.out.println("4 is " + divisorGame(4));// 1 1 1 win
        System.out.println("5 is " + divisorGame(5));// 1 1 1 1 fail
        System.out.println("6 is " + divisorGame(6));// 1 1 1 1  win
        System.out.println("7 is " + divisorGame(7));
        System.out.println("8 is " + divisorGame(8));
    }

    /**
     *  如果N是奇数，因为奇数的所有因数都是奇数，因此 N 进行一次 N-x 的操作结果一定是偶数，所以如果 a 拿到了一个奇数，那么轮到 b 的时候，b拿到的肯定是偶数，
     *  这个时候 b 只要进行 -1， 还给 a 一个奇数，那么这样子b就会一直拿到偶数，到最后b一定会拿到最小偶数2，a就输了
     * 所以如果游戏开始时Alice拿到N为奇数，那么她必输，也就是false。如果拿到N为偶数，她只用 -1，让bob 拿到奇数，最后bob必输，结果就是true。
     *
     */
    public static boolean divisorGame(int n) {
        return n % 2 == 0;
    }

}
