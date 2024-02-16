package sort

import ListNode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {

    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var l1 = l1
        var l2 = l2

        if (l1 == null) return l2
        if (l2 == null) return l1

        if (l1.`val` > l2.`val`) {
            l1 = l2.also { l2 = l1 }
        }
        l1.next = mergeTwoLists(l1.next, l2)
        return l1
    }

    fun sortList(head: ListNode?): ListNode? {
        if (head?.next == null) return head

        var half: ListNode? = null
        var slow: ListNode = head

        var fast: ListNode? = head
        while (fast?.next != null) {
            half = slow
            slow = slow.next
            fast = fast.next.next
        }

        half!!.next = null

        val l1 = sortList(head)
        val l2 = sortList(slow)

        return mergeTwoLists(l1, l2)
    }
}