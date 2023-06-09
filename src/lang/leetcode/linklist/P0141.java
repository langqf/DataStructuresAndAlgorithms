                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 package lang.leetcode.linklist;

import java.util.HashSet;
import java.util.Set;

/** 环形链表
 *
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
 * 评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 *
 * 示例 1
 * 输入：head = [3,2,0,-4], pos = 1. 图示 -4->2
 *  输出：true
 *  解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *  示例 2：
 *  输入：head = [1,2], pos = 0. 图示 2->1
 *  输出：true
 *  解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *  示例 3：
 *  输入：head = [1], pos = -1
 *  输出：false
 *  解释：链表中没有环。
 *
 *  提示：
 *  链表中节点的数目范围是 [0, 10^4]
 *  -10^5 <= Node.val <= 10^5
 *  pos 为 -1 或者链表中的一个 有效索引 。
 *
 *  进阶：你能用 O(1)（即，常量）内存解决此问题吗？
 *
 * /

 /**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class P0141 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
        System.out.println("head = [3,2,0,-4], pos = 1. 图示 -4->2 >>>>>>>>>>>>>>> hasCycle = " + hasCycle(l1));
        ListNode l5 = new ListNode(1);
        ListNode l6 = new ListNode(2);
        l5.next = l6;
        l6.next = l5;
        System.out.println("head = [1,2], pos = 0. 图示 2->1 >>>>>>>>>>>>>>>>>>>>> hasCycle = " + hasCycle(l5));
        ListNode l7 = new ListNode(1);
        System.out.println("head = [1], pos = -1 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> hasCycle = " + hasCycle(l7));
    }

    // 快慢指针
    public static boolean hasCycle(ListNode head) {
        ListNode fast= head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next; // fast每次往前2步
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    // hash表
    public static boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if(set.contains(head)){
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            next = null;
        }

    }

}
