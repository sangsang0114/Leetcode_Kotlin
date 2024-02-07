import java.util.*

class MyQueue() {
    val input: Deque<Int> = ArrayDeque()
    val output = ArrayDeque<Int>()
    fun push(x: Int) {
        input.push(x)
    }

    fun pop(): Int {
        this.peek()
        return output.pop()
    }

    fun peek(): Int {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop())
            }
        }
        return output.peek()
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