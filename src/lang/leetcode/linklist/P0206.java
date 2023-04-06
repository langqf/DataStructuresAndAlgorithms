package lang.leetcode.linklist;

/** 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 *
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 *
 * 提示：
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 *
 * 进阶：
 * 链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
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
public class P0206 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5= new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode p1 = reverseList(l1);
        while(p1 != null){
            System.out.print(p1.val + "、");
            p1 = p1.next;
        }
        System.out.println("\n ******************************");

        ListNode l8 = new ListNode(1);
        ListNode l9 = new ListNode(2);
        l8.next = l9;
        ListNode p2 = reverseList(l8);
        while(p2 != null){
            System.out.print(p2.val + "、");
            p2 = p2.next;
        }
        System.out.println("\n ******************************");

        ListNode l11 = null;
        ListNode p3 = reverseList(l11);
        while(p3 != null){
            System.out.print(p3.val + "、");
            p3 = p3.next;
        }
        System.out.println("\n ******************************");
    }
    // 迭代实现
    public static ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null){
            ListNode nextTemp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextTemp;
        }
        return pre;
    }
    // 递归实现
    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }else{
            ListNode pre = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return pre;
        }
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
