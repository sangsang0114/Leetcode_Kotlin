class MyQueue() {
    private val input = ArrayDeque<Int>()
    private val output = ArrayDeque<Int>()
    fun push(x: Int) {
        input.addLast(x)
    }

    fun pop(): Int {
        this.peek()
        return output.removeFirst()
    }

    fun peek(): Int {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.addLast(input.removeFirst())
            }
        }
        return output.first()
    }

    fun empty(): Boolean {
        return input.isEmpty() && output.isEmpty()
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */