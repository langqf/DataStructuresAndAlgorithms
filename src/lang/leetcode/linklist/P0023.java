package lang.leetcode.linklist;

/** 合并 K 个升序链表
 *  给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 * 示例 2：
 * 输入：lists = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：lists = [[]]
 * 输出：[]
 *
 * 提示：
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 *
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
public class P0023 {

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];

        ListNode l0_1 = new ListNode(5);
        ListNode l0_2 = new ListNode(4, l0_1);
        ListNode l0_3 = new ListNode(1, l0_2);
        lists[0] = l0_3;

        ListNode l1_1 = new ListNode(4);
        ListNode l1_2 = new ListNode(3, l1_1);
        ListNode l1_3 = new ListNode(1, l1_2);
        lists[1] = l1_3;

        ListNode l2_1 = new ListNode(6);
        ListNode l2_2 = new ListNode(2, l2_1);
        lists[2] = l2_2;

        ListNode listNode = mergeKLists(lists);
        while(listNode != null){
            System.out.print(listNode.val + "、");
            listNode = listNode.next;
        }
    }

    //TODO 采用优先级队列，小顶堆  存储每个链表没有被合并的元素的最前面一个

    // 分治法
    public static ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public static ListNode merge(ListNode[] lists, int l, int r) {
        if(l == r){
            return lists[l];
        }
        if(l > r){
            return null;
        }
        int mid = (l+r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }



    // 顺序合并
    public static ListNode mergeKLists1(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        ListNode result = lists[0];
        for (int i = lists.length - 1; i > 0; i--) {
            result = mergeTwoLists(result, lists[i]);
        }
        return result;
    }

    public static ListNode mergeTwoLists(ListNode p1, ListNode p2) {
        if(p1 == null || p2 == null){
            return p1 == null ? p1 : p2;
        }
        ListNode pre = new ListNode();
        ListNode p = pre;
        while(p1 != null && p2 != null){
            if(p1.val <= p2.val){
                p.next = p1;
                p1 = p1.next;
            }else{
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        p.next = (p1 != null ? p1 : p2);
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
