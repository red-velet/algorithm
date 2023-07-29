package icu.chiou.reversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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

    /**
     * 判断链表是否有环
     *
     * @param head 头结点
     * @return true-有环 false-没有环
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasCycleStatic(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取链表的环的入口节点
     *
     * @param pHead 链表头结点
     * @return null-没环 非null-有环返回入口节点
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                //有环
                slow = pHead;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }


    public static ListNode EntryNodeOfLoopStatic(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                //有环
                slow = pHead;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    /**
     * 链表中倒数最后k个结点
     *
     * @param pHead ListNode类
     * @param k     int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail(ListNode pHead, int k) {
        // write code here
        //参数校验
        if (pHead == null) {
            return null;
        }
        int len = getLinkedListLen(pHead);
        if (len < k) {
            return null;
        }
        ListNode pre = pHead;
        ListNode curr = pHead;
        for (int i = 0; i < k; i++) {
            pre = pre.next;
        }
        while (pre != null) {
            curr = curr.next;
            pre = pre.next;
        }
        return curr;
    }

    /**
     * 获取单链表长度
     *
     * @param head 头结点
     * @return 长度
     */
    public int getLinkedListLen(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        return len;
    }

    /**
     * 删除链表倒数第n个节点
     *
     * @param head ListNode类
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write code here
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = dummy.next;
        ListNode removeNodeFront = curr;
        for (int i = 0; i < n; i++) {
            removeNodeFront = removeNodeFront.next;
        }
        while (removeNodeFront != null) {
            removeNodeFront = removeNodeFront.next;
            curr = curr.next;
            pre = pre.next;
        }
        //删除节点
        pre.next = curr.next;
        return dummy.next;
    }

    /**
     * 两个链表的第一个公共节点
     *
     * @param pHead1 链表1的头结点
     * @param pHead2 链表2的头结点
     * @return null-没有公共节点不相交 非空-相交节点
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = (p1 == null) ? pHead2 : p1.next;
            p2 = (p2 == null) ? pHead1 : p2.next;
        }
        return p1;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        //1.使用栈。添加数组
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode p1 = head1;
        ListNode p2 = head2;
        while (p1 != null || p2 != null) {
            if (p1 != null) {
                stack1.push(p1.val);
                p1 = p1.next;
            }
            if (p2 != null) {
                stack2.push(p2.val);
                p2 = p2.next;
            }
        }
        ListNode dummy = new ListNode(-1);
        int v1, v2, sum = 0, carry = 0;
        while (!stack1.empty() || !stack2.empty() || carry != 0) {
            v1 = stack1.isEmpty() ? 0 : stack1.pop();
            v2 = stack2.isEmpty() ? 0 : stack2.pop();
            sum = v1 + v2 + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            node.next = dummy.next;
            dummy.next = node;
        }
        //3.返回结果
        return dummy.next;
    }

    public ListNode sortInList(ListNode head) {
        // write code here
        ListNode p = head;
        List<Integer> list = new ArrayList<>();
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        return null;
    }

    public boolean isPail(ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return true;
        }
        //使用栈和数组存储逆序和正序
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            list.add(p.val);
            stack.push(p.val);
            p = p.next;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(stack.pop())) {
                break;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode oddEvenList(ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head; // 奇数位节点的起始点
        ListNode even = head.next; // 偶数位节点的起始点
        ListNode evenHead = even; // 保存偶数位节点的头部

        // 将奇数位节点和偶数位节点分开
        while (even != null && even.next != null) {
            odd.next = even.next; // 连接奇数节点
            odd = odd.next; // 更新奇数节点
            even.next = odd.next; // 连接偶数节点
            even = even.next; // 更新偶数节点
        }

        // 将偶数位节点连接到奇数位节点的尾部
        odd.next = evenHead;

        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null) {
            ListNode q = p.next;
            while (q.next != null && q.val == q.next.val) {
                q = q.next;
            }
            if (q == p.next) {
                p = p.next;
            } else {
                p.next = q.next;
            }
        }
        return dummy.next;
    }
}
