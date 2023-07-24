package icu.chiou.reversal;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author: chiou
 * createTime: 2023/7/24
 * Description: No Description
 */
public class LinkedList {

    public ListNode create(int len) {
        if (len <= 0) {
            return null;
        }

        // Create the head of the linked list
        ListNode head = new ListNode(1);
        ListNode current = head;

        // Create the rest of the nodes and attach them to the linked list
        for (int i = 2; i <= len; i++) {
            current.next = new ListNode(i);
            current = current.next;
        }

        return head;
    }

    public ListNode createOdd(int len) {
        if (len <= 0) {
            return null;
        }

        // Create the head of the linked list
        ListNode head = new ListNode(2);
        ListNode current = head;

        // Create the rest of the nodes and attach them to the linked list
        for (int i = 2; i <= len; i++) {
            current.next = new ListNode(i * 2);
            current = current.next;
        }

        return head;
    }


    /**
     * 从头结点开始遍历链表输出
     *
     * @param head 头结点
     */
    public void list(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val);
            if (p.next != null) {
                System.out.print("->");
            }
            p = p.next;
        }
        System.out.print("\n");
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @param m    int整型
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //先定位到需要反转区间的起始位置
        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode curr = pre.next;
        for (int i = 0; i < n - m; i++) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        //开始反转
        return dummy.next;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // write code here
        if (head == null) {
            return head;
        }
        ListNode curr = head;
        //移动到需要反转区间末尾
        int count = 1;
        while (count < k) {
            curr = curr.next;
            if (curr == null) {
                return head;
            }
            count++;
        }
        //保存curr的下一个,再端口curr的下一个
        ListNode next = curr.next;
        curr.next = null;
        //反转当前区间
        ReverseList(head);

        if (next != null) {
            head.next = reverseKGroup(next, k);
        }
        return curr;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pHead1 ListNode类
     * @param pHead2 ListNode类
     * @return ListNode类
     */
    public ListNode Merge(ListNode pHead1, ListNode pHead2) {
        // write code here
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                pre.next = p2;
                p2 = p2.next;
            } else {
                pre.next = p1;
                p1 = p1.next;
            }
            pre = pre.next;
        }
        if (p1 != null) {
            pre.next = p1;
        }
        if (p2 != null) {
            pre.next = p2;
        }
        return dummy.next;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param lists ListNode类ArrayList
     * @return ListNode类
     */
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // write code here
        // Step 1: Collect all the node values in an array
        ArrayList<Integer> values = new ArrayList<>();
        for (ListNode list : lists) {
            ListNode current = list;
            while (current != null) {
                values.add(current.val);
                current = current.next;
            }
        }

        // Step 2: Sort the array
        Integer[] sortedValues = values.toArray(new Integer[0]);
        Arrays.sort(sortedValues);

        // Step 3: Reconstruct a new sorted linked list
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        for (int val : sortedValues) {
            current.next = new ListNode(val);
            current = current.next;
        }

        // Step 4: Return the head of the new sorted linked list
        return dummy.next;
    }
}
