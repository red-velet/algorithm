package icu.chiou;

import icu.chiou.reversal.LinkedList;
import icu.chiou.reversal.ListNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Author: chiou
 * createTime: 2023/7/26
 * Description: 查找链表节点
 */
@Slf4j
public class FindTest {
    @Test
    public void testFindKthToTail() {
        LinkedList linkedList = new LinkedList();
        ListNode head = linkedList.create(6);
        log.debug("遍历原链表:");
        linkedList.list(head);
        int k = 2;
        ListNode target = linkedList.FindKthToTail(head, k);
        log.debug("原链表倒数第{}个为{}:", k, target.val);
    }
}
