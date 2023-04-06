package lang.leetcode.linklist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** 环形链表II
 *
 * 给给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
 * 评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 不允许修改 链表。
 *
 * 示例 1
 * 输入：head = [3,2,0,-4], pos = 1. 图示 -4->2
 *  输出：返回索引为 1 的链表节点
 *  解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *  示例 2：
 *  输入：head = [1,2], pos = 0. 图示 2->1
 *  输出：返回索引为 0 的链表节点
 *  解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *  示例 3：
 *  输入：head = [1], pos = -1
 *  输出：返回 null
 *  解释：链表中没有环。
 *
 *  提示：
 *  链表中节点的数目范围是 [0, 10^4]
 *  -10^5 <= Node.val <= 10^5
 *  pos 为 -1 或者链表中的一个 有效索引 。
 *
 *  进阶：你能用 O(1)（即，常量）内存解决此问题吗？：
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
public class P0142 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
        ListNode listNode1 = detectCycle(l1);
        if(listNode1 != null){
            System.out.println("head = [3,2,0,-4], pos = 1. 图示 -4->2 >>>>>>>>>>>>>>> detectCycle = " + listNode1.val);
        }else{
            System.out.println("head = [3,2,0,-4], pos = 1. 图示 -4->2 >>>>>>>>>>>>>>> detectCycle  is null");
        }
        ListNode l5 = new ListNode(1);
        ListNode l6 = new ListNode(2);
        l5.next = l6;
        l6.next = l5;
        ListNode listNode2 = detectCycle(l5);
        if(listNode2 != null){
            System.out.println("head = [3,2,0,-4], pos = 1. 图示 -4->2 >>>>>>>>>>>>>>> detectCycle = " + listNode2.val);
        }else{
            System.out.println("head = [3,2,0,-4], pos = 1. 图示 -4->2 >>>>>>>>>>>>>>> detectCycle  is null");
        }
        ListNode l7 = new ListNode(1);
        ListNode listNode3 = detectCycle(l7);
        if(listNode3 != null){
            System.out.println("head = [3,2,0,-4], pos = 1. 图示 -4->2 >>>>>>>>>>>>>>> detectCycle = " + listNode3.val);
        }else{
            System.out.println("head = [3,2,0,-4], pos = 1. 图示 -4->2 >>>>>>>>>>>>>>> detectCycle  is null");
        }
    }


    public static ListNode detectCycle(ListNode head) {
        ListNode fast= head;
        ListNode slow = head;
        ListNode cur = null;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next; // fast每次往前2步
            if(slow == fast){ // 有环 slow和fast指向相遇结点
                cur = head;
                while(cur != slow){ // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                    cur = cur.next;
                    slow = slow.next;
                }
                return cur;
            }
        }
        return cur;
    }

    // hash表
    public static ListNode detectCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if(set.contains(head)){
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
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
