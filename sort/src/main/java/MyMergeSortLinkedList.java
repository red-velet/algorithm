/**
 * Author: chiou
 * createTime: 2023/7/28
 * Description: No Description
 */
public class MyMergeSortLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 归并排序主函数
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = findMiddle(head);
        // 将链表断开，拆分链表为两部分，左侧链表为head，右侧链表为mid.next
        ListNode right = middle.next;
        middle.next = null;


        ListNode leftStart = sortList(head);
        ListNode rightStart = sortList(right);
        return merge(leftStart, rightStart);
    }

    // 寻找链表的中间节点，使用快慢指针法
    private static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // 合并两个有序链表
    private static ListNode merge(ListNode leftStart, ListNode rightStart) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (leftStart != null && rightStart != null) {
            if (leftStart.val > rightStart.val) {
                p.next = rightStart;
                rightStart = rightStart.next;
            } else {
                p.next = leftStart;
                leftStart = leftStart.next;
            }
            p = p.next;
        }
        if (leftStart != null) {
            p.next = leftStart;
        }
        if (rightStart != null) {
            p.next = rightStart;
        }
        return dummy.next;
    }

    // 测试用例
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("原始链表: ");
        printList(head);

        ListNode sortedList = sortList(head);

        System.out.println("\n排序后的链表: ");
        printList(sortedList);
    }

    // 辅助函数，用于打印链表
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
