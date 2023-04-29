package lang.leetcode.other;

import java.security.SecureRandom;
import java.util.Random;

/** 三门问题
 * 参赛者的面前有三扇关闭着的门，其中一扇的后面是天使，选中后天使会达成你的一个愿望，而另外两扇门后面则是恶魔，选中就会死亡。
 * 当你选定了一扇门，但未去开启它的时候，上帝会开启剩下两扇门中的一扇，露出其中一只恶魔。（上帝是全能的，必会打开恶魔门）随后上帝会问你要不要更换选择，选另一扇仍然关着的门。
 *
 * 正确的答案是，如果你选择了换，碰见天使的概率会高达2/3，而不不换的话，碰见天使的概率只有1/3。 怎么来的？
 *
 */
public class ThreeDoor {

    public static Random random = new SecureRandom();

    public static void main(String[] args) {
        // 三条不同的门
        int[] doors = new int[]{0,1,2};
        // 统计不改变选择，选中天使门的次数
        int unChangeCount = 0;
        // 统计改变选择，选中天使门的次数
        int changeCount = 1;
        int total = 100000;
        for (int i = 0; i < total; i++) {
            // 天使门
            int angelDoor = random.nextInt(3);
            // 选择的门
            int selectDoor = random.nextInt(3);
            /*for (int j = 0; j < doors.length; j++) {
                // 上帝开启的这条恶魔门（不是天使门，并且不是选中的门）  我们将这条门移除
                if(doors[j] != angelDoor && doors[j] != selectDoor){
                    // System.out.println();
                }
            }*/
            if(selectDoor == angelDoor){
                unChangeCount++;
            }else{
                changeCount++;
            }
        }

        System.out.println("不换门遇见天使次数:" + unChangeCount +  "比例：" +  (unChangeCount * 1.0 / total));
        System.out.println("换门遇见天使次数:" + changeCount +  "比例：" +  (changeCount * 1.0 / total));
    }
}
