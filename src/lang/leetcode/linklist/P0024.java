package lang.leetcode.linklist;

/** 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 *
 * 提示：
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 *
 */
public class P0024 {
    public static void main(String[] args) {
        ListNode l0_0 = new ListNode(4);
        ListNode l0_1 = new ListNode(3, l0_0);
        ListNode l0_2 = new ListNode(2, l0_1);
        ListNode listNode = new ListNode(1, l0_2);
        listNode = swapPairs(listNode);
        while(listNode != null){
            System.out.print(listNode.val + "、");
            listNode = listNode.next;
        }
    }
    // 递归
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next  = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    // 非递归
    public static ListNode swapPairs1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = new ListNode();
        ListNode p = pre;
        p.next = head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while(p1 != null && p2 != null){
            p.next = p2;
            p1.next = p2.next;
            p2.next = p1;
            p = p1;
            p1 = p1.next;
            p2 = (p1 == null ? null : p1.next);
        }
        return pre.next;
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
