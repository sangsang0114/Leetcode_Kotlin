package linked_list

import ListNode
import java.util.*

fun isPalindrome(head: ListNode?): Boolean {
    val deque: Deque<Int> = LinkedList()

    var node = head
    while (node != null) {
        deque.add(node.`val`)
        node = node.next
    }

    while (!deque.isEmpty() && deque.size > 1) {
        if (deque.pollFirst() != deque.pollLast())
            return false
    }
    return true
}

fun isPalindromeUsingRunner(head: ListNode?): Boolean {
    var fast: ListNode? = head
    var slow: ListNode? = head

    while (fast != null && fast.next != null) {
        fast = fast.next!!.next
        slow = slow!!.next
    }

    if (fast != null)
        slow = slow!!.next

    var rev: ListNode? = null
    while (slow != null) {
        var next: ListNode? = slow.next
        slow.next = rev
        rev = slow
        slow = next
    }

    var h = head
    while (rev != null) {
        if (rev.`val` != h!!.`val`)
            return false

        rev = rev.next
        h = h!!.next
    }
    return true
}