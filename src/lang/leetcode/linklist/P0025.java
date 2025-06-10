package lang.leetcode.linklist;

/** K 个一组翻转链表
 *  给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 *
 * 示例 2：
 *输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 *
 * 提示：
 * 链表中的节点数目为 n
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 *
 * 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
 *
 */
public class P0025 {

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        ListNode head = reverseKGroup(l1,2);
        while(head != null){
            System.out.print(head.val + "、");
            head = head.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode preHead = new ListNode(0, head);
        ListNode pre = preHead;
        while(head != null){
            int count = 1;
            ListNode tail = head;
            while(tail.next != null && count < k){
                tail = tail.next;
                count++;
            }
            if(count == k){
                ListNode nextKHead = tail.next;// 保存下一组的起始节点
                reverseKGroup(head, tail);
                pre.next = tail;
                pre = head;
                head.next = nextKHead;
                head = nextKHead;
            }else{
//                pre.next = head;
                break;
            }
        }
        return preHead.next;
    }

    // 反转指定位置链表
    public static ListNode reverseKGroup(ListNode head, ListNode tail) {
        if(head == null || head.next == null || head == tail){
            return head;
        }
        // 前一个节点
        ListNode pre = null;
        // 当前节点
        ListNode cur = head;
        while(pre != tail){
            ListNode next = cur.next;// 需要保存后一个节点
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return tail;
    }

    // 反转任意一个链表
    public ListNode reverseKGroup1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        // 前一个节点
        ListNode pre = null;
        // 当前节点
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;// 需要保存后一个节点
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
