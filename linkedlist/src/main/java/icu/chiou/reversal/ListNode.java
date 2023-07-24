package icu.chiou.reversal;

/**
 * Author: chiou
 * createTime: 2023/7/24
 * Description: 节点类
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "node:" + val;
    }
}
