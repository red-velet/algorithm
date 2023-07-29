package icu.chiou;

import icu.chiou.reversal.LinkedList;
import icu.chiou.reversal.ListNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Author: chiou
 * createTime: 2023/7/24
 * Description: 反转链表相关测试类
 */
@Slf4j
public class ReversalTest {
    /**
     * 测试反转单链表
     */
    @Test
    public void testReverseList() {
        //todo 反转单链表
        LinkedList linkedList = new LinkedList();
        ListNode head = linkedList.create(10);
        //遍历原链表
        log.debug("遍历原链表:");
        linkedList.list(head);
        //反转
        ListNode listNode = linkedList.ReverseList(head);
        //遍历反转后的链表
        log.debug("遍历反转后的链表:");
        linkedList.list(listNode);
    }

    /**
     * 测试反转指定区间单链表
     */
    @Test
    public void testReverseBetween() {
        //todo 反转指定区间单链表
        LinkedList linkedList = new LinkedList();
        ListNode head = linkedList.create(10);
        //遍历原链表
        log.debug("遍历原链表:");
        linkedList.list(head);
        //反转
        ListNode listNode = linkedList.reverseBetween(head, 1, 3);
        //遍历反转后的链表
        log.debug("遍历反转后的链表:");
        linkedList.list(listNode);
    }

    /**
     * 测试链表中的节点每k个一组翻转
     */
    @Test
    public void testReverseKGroup() {
        //todo 反转链表中的节点每k个一组翻转
        LinkedList linkedList = new LinkedList();
        ListNode head = linkedList.create(10);
        //遍历原链表
        log.debug("遍历原链表:");
        linkedList.list(head);
        //反转
        //ListNode listNode = linkedList.reverseKGroup(head, 3);
        ListNode listNode = linkedList.reverseKGroup(null, 3);

        //遍历反转后的链表
        log.debug("遍历反转后的链表:");
        linkedList.list(listNode);
    }

    /**
     * 测试合并两个排序的链表
     */
    @Test
    public void testMerge() {
        //todo 合并两个排序的链表
        LinkedList linkedList = new LinkedList();
        ListNode head = linkedList.create(10);

        ListNode odd = linkedList.createOdd(10);
        //遍历原链表
        log.debug("遍历原链表:");
        linkedList.list(head);
        linkedList.list(odd);
        //合并
        ListNode listNode = linkedList.Merge(head, odd);

        //遍历合并后的新链表
        log.debug("遍历合并后的新链表:");
        linkedList.list(listNode);
    }

    /**
     * 测试合并k个已排序的链表
     */
    @Test
    public void testMergeKLists() {
        //todo 合并k个已排序的链表
        LinkedList linkedList = new LinkedList();
        ListNode head = linkedList.create(10);

        ListNode odd = linkedList.createOdd(10);
        //遍历原链表
        log.debug("遍历原链表:");
        linkedList.list(head);
        linkedList.list(odd);
        //合并
        ArrayList<ListNode> listNodes = new ArrayList<>();
        listNodes.add(head);
        listNodes.add(odd);
        ListNode listNode = linkedList.mergeKLists(null);

        //遍历合并后的新链表
        log.debug("遍历合并后的新链表:");
        linkedList.list(listNode);
    }

    /**
     * 测试链表相加(二)
     */
    @Test
    public void testAddInList() {
        LinkedList linkedList = new LinkedList();
        ListNode head1 = linkedList.create(3);
        //遍历原链表1
        log.debug("遍历原链表1:");
        linkedList.list(head1);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(0);

        //遍历原链表2
        log.debug("遍历原链表2:");
        linkedList.list(head2);

        //合并
        ListNode addInList = linkedList.addInList(head1, head2);
        //遍历合并后的新链表
        log.debug("遍历相加后的新链表:");
        linkedList.list(addInList);

    }

}
