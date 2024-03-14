package linked_list

class Add_Two_Numbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var l1var = l1
        var l2var = l2

        var node = ListNode(0)
        val root = node

        /*
        sum: 자릿수의 합
        carry: 자리 올림 수
        remainder: 나머지
         */
        var sum: Int
        var carry = 0
        var remainder: Int

        while (l1var != null || l2var != null || carry != 0) {
            sum = 0
            if (l1var != null) {
                sum += l1var.`val`
                l1var = l1var.next
            }

            if (l2var != null) {
                sum += l2var.`val`
                l2var = l2var.next
            }

            remainder = (sum + carry) % 10
            carry = (sum + carry) / 10
            node.next = ListNode(remainder)
            node = node.next
        }
        return root.next
    }
}