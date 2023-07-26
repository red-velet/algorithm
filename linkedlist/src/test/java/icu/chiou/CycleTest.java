package icu.chiou;

import icu.chiou.reversal.LinkedList;
import icu.chiou.reversal.ListNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Author: chiou
 * createTime: 2023/7/26
 * Description: 链表环相关
 */
@Slf4j
public class CycleTest {
    /**
     * 测试单链表是否有环
     */
    @Test
    public void testHasCycle() {
        //todo 单链表是否有环
        LinkedList linkedList = new LinkedList();
        ListNode head = linkedList.create(10);
        //遍历原链表
        log.debug("遍历原链表:");
        linkedList.list(head);
        //判断是否有环
        log.info("链表是否有环: {}", linkedList.hasCycle(head) ? "有环" : "没环");
    }

    @Test
    public void testEntryNodeOfLoopStatic() {
        //找到入环节点
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head; // Creating a cycle by pointing the last node to the head

        boolean hasCycle = LinkedList.hasCycleStatic(head);
        System.out.println("Does the linked list have a cycle? " + hasCycle);

        if (hasCycle) {
            ListNode entrance = LinkedList.EntryNodeOfLoopStatic(head);
            System.out.println("Cycle entrance value: " + entrance.val);
        }
    }
}
