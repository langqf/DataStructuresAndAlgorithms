package lang.leetcode.linklist;

/** 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 示例 1：
 输入：head = [1,2,3,4,5], n = 2
 输出：[1,2,3,5]

 示例 2：
 输入：head = [1], n = 1
 输出：[]
 示例 3：

 输入：head = [1,2], n = 1
 输出：[1]

 提示：
 链表中结点的数目为 sz
 1 <= sz <= 30
 0 <= Node.val <= 100
 1 <= n <= sz

 进阶：你能尝试使用一趟扫描实现吗？

 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
   int val;
   ListNode next;
   ListNode() {}
   ListNode(int val) { this.val = val; }
   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class P0019 {

    public static void main(String[] args) {
        ListNode nodeList5 = new ListNode(5);
        ListNode nodeList4 = new ListNode(4, nodeList5);
        ListNode nodeList3 = new ListNode(3, nodeList4);
        ListNode nodeList2 = new ListNode(2, nodeList3);
        ListNode nodeList1 = new ListNode(1, nodeList2);
        ListNode p1 = nodeList1;
        while(p1 != null){
            System.out.print(p1.val + "、");
            p1 = p1.next;
        }
        System.out.println("\n ******************************");
        nodeList1 = removeNthFromEnd(nodeList1, 1);
        ListNode p2 = nodeList1;
        do{
            System.out.print(p2.val + "、");
            p2 = p2.next;
        } while(p2 != null);

    }
    // 进阶 尝试使用一趟扫描实现 双指针间隔n个元素，fast到达最后时，slow刚刚指向倒数第n个
    public static ListNode removeNthFromEnd(ListNode head, int n){
        ListNode result = new ListNode();
        result.next = head;
        ListNode fast = result;
        ListNode slow = result;
        for(int i = 0; i < n; i++){
            fast = fast.next; // 快指针先走n步
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return result.next;
    }

    public static ListNode removeNthFromEnd1(ListNode head, int n){
        // 求链表长度
        int size = 0;
        ListNode p = head;
        while(p != null){
            size++;
            p = p.next;
        }
        // 从前往后，n位置
        int pre_n = size - n;
        if(pre_n == 0){
            // 第0个数
            head = head.next;
        }else{
            // 找到前一个数
            ListNode l = head;
            int j = 0;
            while(j < pre_n - 1){
                j++;
                l = l.next;
            }
            l.next = l.next.next;
        }

        return head;
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
