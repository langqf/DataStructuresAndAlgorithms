package lang.leetcode.linklist;

/** 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 *  输出：[7,0,8]
 *  解释：342 + 465 = 807.
 *
 *  示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * 提示：
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class P0002 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        ListNode l5 = new ListNode(1);
        ListNode p1 = addTwoNumbers(l1, l5);
        while(p1 != null){
            System.out.print(p1.val + "、");
            p1 = p1.next;
        }
        System.out.println("\n ******************************");

        ListNode l8 = new ListNode(1);
        ListNode l9 = new ListNode(9);
        ListNode p2 = addTwoNumbers(l8, l9);
        while(p2 != null){
            System.out.print(p2.val + "、");
            p2 = p2.next;
        }
        System.out.println("\n ******************************");
        ListNode l11 = new ListNode(9);
        ListNode l21 = new ListNode(9);
        ListNode l31 = new ListNode(9);
        ListNode l41 = new ListNode(9);
        ListNode l51 = new ListNode(9);
        ListNode l61 = new ListNode(9);
        ListNode l71 = new ListNode(9);
        l11.next = l21;
        l21.next = l31;
        l31.next = l41;
        l41.next = l51;
        l51.next = l61;
        l61.next = l71;
        ListNode l12= new ListNode(9);
        ListNode l22 = new ListNode(9);
        ListNode l32 = new ListNode(9);
        ListNode l42 = new ListNode(9);
        l12.next = l22;
        l22.next = l32;
        l32.next = l42;
        ListNode p3 = addTwoNumbers(l11, l12);
        while(p3 != null){
            System.out.print(p3.val + "、");
            p3 = p3.next;
        }
        System.out.println("\n ******************************");
    }

    // 参考别人思路 优化，如果链表长短不一，将短链表剩下的位置看作0
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode sum = head;
        int plusOne = 0;
        while(l1 != null || l2 != null){
            int val1 = (l1 == null ? 0 : l1.val);
            int val2 = (l2 == null ? 0 : l2.val);
            int val = val1 + val2 + plusOne;
            plusOne = val/10;
            sum.next = new ListNode(val%10);
            sum = sum.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if(plusOne == 1){
            sum.next = new ListNode(1);
        }
        return head.next;
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode sum = head;
        boolean plusOne = false;
        while(l1 != null && l2 != null){
            int val = l1.val + l2.val;
            if(plusOne){
                val++;
            }
            plusOne = val/10 == 1 ? true : false;
            sum.next = new ListNode(val%10);
            sum = sum.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 != null){
            plusList(l1, sum, plusOne);
        }else if(l2 != null){
            plusList(l2, sum, plusOne);
        }else if(plusOne){
            sum.next = new ListNode(1);
        }
        return head.next;
    }

    public static ListNode plusList(ListNode l, ListNode sum, boolean plusOne) {
        while(l != null){
            int val = l.val;
            if (plusOne) {
                val++;
            }
            plusOne = val/10 == 1 ? true : false;
            sum.next = new ListNode(val%10);
            sum = sum.next;
            l = l.next;
        }
        if(plusOne){
            sum.next = new ListNode(1);
        }
        return sum;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
