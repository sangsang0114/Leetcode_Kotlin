package linked_list

class Swap_Nodes_inPairs {
    fun swapPairs(head: ListNode?): ListNode? {
        if (head?.next != null) {
            val p = head.next
            head.next = swapPairs(head.next.next)
            p.next = head
            return p
        }
        return head
    }
}