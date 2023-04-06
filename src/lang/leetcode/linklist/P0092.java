package lang.leetcode.linklist;

/** 反转链表 II
 *  给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 *
 * 示例 2：
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *
 * 提示：
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 *
 * 进阶： 你可以使用一趟扫描完成反转吗？
 *
 * 解题思路
 *
 * 本题需要反转链表中从第m个节点到第n个节点的部分，可以采用迭代的方式进行反转。
 * 首先需要找到第m个节点的前一个节点pre，以及第n个节点的后一个节点next，然后将从第m个节点到第n个节点的链表进行反转，最后将pre和next节点与反转后的链表连接起来即可。
 * 具体步骤如下：
 * 定义一个虚拟头节点dummy，将其next指向head节点，用于处理m=1的情况。
 * 找到第m个节点的前一个节点pre，以及第n个节点的后一个节点next。
 * 将从第m个节点到第n个节点的链表进行反转，反转后的链表的头节点为newHead，尾节点为newTail。
 * 将pre节点的next指向newHead，将newTail节点的next指向next节点。
 * 返回dummy节点的next节点，即为反转后的链表。
 *
 * 进阶：通过m-n计算反转次数
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
public class P0092 {

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
        ListNode p1 = reverseBetween(l1,2,4);
        while(p1 != null){
            System.out.print(p1.val + "、");
            p1 = p1.next;
        }
        System.out.println("\n ******************************");

        ListNode l8 = new ListNode(5);
        ListNode p2 = reverseBetween(l8,1,1);
        while(p2 != null){
            System.out.print(p2.val + "、");
            p2 = p2.next;
        }
        System.out.println("\n ******************************");

        ListNode l9 = new ListNode(3);
        ListNode l10 = new ListNode(5);
        l9.next = l10;
        ListNode p3 = reverseBetween(l9,1,2);
        while(p3 != null){
            System.out.print(p3.val + "、");
            p3 = p3.next;
        }
        System.out.println("\n ******************************");
    }

    // 使用一趟扫描完成反转
    // 思路：计算反转次数 n = right-left 从left位置反转n+1次数
    public static ListNode reverseBetween1(ListNode head, int left, int right) {
        int n = right - left;
        if(n == 0){
            return head;
        }
        ListNode cur = head;
        ListNode front = null; // 第left个节点前面一个节点
        for (int i = 0; i < left - 1; i++) {
            front = cur;
            cur = cur.next;
        }
        ListNode leftNode = cur; // 第left个节点
        ListNode pre = null;
        int count = 0;
        while(count < n + 1){
            ListNode nextTemp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextTemp;
            count++;
        }
        // 反转完成后，pre指向第right个节点，cur指向第right个节点的后一个节点
        // 需要将第leftNode.next指向该位置cur
        // 第left个节点前面一个节点不是空,需要将其next指向pre，否则pre就是最终头结点
        leftNode.next = cur;
        if(front != null){
            front.next = pre;
            return head;
        }else{
            return  pre; // 第left个节点前面一个节点是空，pre是最终的头结点
        }
    }

    // 思路：找到left,right位置的节点，反转
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode front = null; // 第left个节点前面一个节点
        ListNode cur = head;
        for (int i = 1; i < left; i++) {
            front = cur;
            cur = cur.next;
        }
        // cur是第left个节点
        //ListNode leftNode = cur; // 第left个节点
        ListNode rightNode = head; // 第right个节点
        for (int i = 0; i < right - 1; i++) {
            rightNode = rightNode.next;
        }
        ListNode afterNode = rightNode.next; // 第right个节点后一个节点
        ListNode pre = afterNode;
        while(pre != rightNode){
            ListNode nextTemp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextTemp;
        }
        // 循环结束  cur == afterNode  pre = rightNode
        // 需要将第leftNode.next指向该 rightNode.next
        // 第left个节点前面一个节点不是空,需要将其next指向pre，否则pre就是最终头结点
//        leftNode.next = afterNode;
        if(front != null){
            front.next = rightNode;
            return head;
        }else{
            return rightNode;
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
