package lang.leetcode.linklist;

/** 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例 1：
 输入：l1 = [1,2,4], l2 = [1,3,4]
 输出：[1,1,2,3,4,4]
 示例 2：

 输入：l1 = [], l2 = []
 输出：[]
 示例 3：

 输入：l1 = [], l2 = [0]
 输出：[0]

 提示：
 两个链表的节点数目范围是 [0, 50]
 -100 <= Node.val <= 100
 l1 和 l2 均按 非递减顺序 排列
 *
 * /

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
public class P0021 {

    public static void main(String[] args) {
        ListNode nodeList1_3 = new ListNode(4);
        ListNode nodeList1_2 = new ListNode(2, nodeList1_3);
        ListNode l1 = new ListNode(1, nodeList1_2);
        ListNode p1 = l1;

        while(p1 != null){
            System.out.print(p1.val + "、");
            p1 = p1.next;
        }
        ListNode nodeList2_3 = new ListNode(4);
        ListNode nodeList2_2 = new ListNode(3, nodeList2_3);
        ListNode l2 = new ListNode(1, nodeList2_2);
        ListNode p2 = l2;
        System.out.println("\n***********");
        while(p2 != null){
            System.out.print(p2.val + "、");
            p2 = p2.next;
        }
        System.out.println("\n***********");
        ListNode l = mergeTwoLists1(l1, l2);
        while(l != null){
            System.out.print(l.val + "、");
            l = l.next;
        }

    }

    // 迭代实现
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode pre = new ListNode();
        ListNode p = pre;
        while(list1 !=null && list2 != null){
            if(list1.val <= list2.val){
                p.next = list1;
                list1 = list1.next;
            }else{
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        if(list1 == null){
            p.next = list2;
        }
        if(list2 == null){
            p.next = list1;
        }
        return pre.next;
    }

    // 递归实现
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
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
