package sliding_window

import java.util.*
import kotlin.math.max

class Sliding_Window_Maximum {
    fun maxSlidingWindow_TLE(nums: IntArray, k: Int): IntArray {
        val answer: MutableList<Int> = mutableListOf()
        val window: MutableList<Int> = mutableListOf()

        if (nums.size == 1) return intArrayOf(nums[0])
        if (nums.size == 2) return intArrayOf(max(nums[0], nums[1]))

        var right = k
        for (i in 0 until k)
            window.add(nums[i])
        answer.add(window.maxOrNull() ?: 0)

        while (right < nums.size) {
            window.removeAt(0)
            window.add(nums[right])
            ++right
            answer.add(window.maxOrNull() ?: 0)
        }
        return answer.toIntArray()
    }

    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val dq = ArrayDeque<Int>()
        val answer = mutableListOf<Int>()
        val stack: Deque<Int> = ArrayDeque<Int>()

        for (i in nums.indices) {
            if (!dq.isEmpty() && dq.first() < i - k + 1) //인덱스가 윈도우 바깥에 있을 경우 제거
                dq.removeFirst()

            while (!dq.isEmpty() && nums[dq.last()] < nums[i]) // 현재 값보다 작으면 모두 삭제
                dq.removeLast()

            dq.add(i)

            if (i >= k - 1)
                answer.add(nums[dq.first()])
        }

        return answer.toIntArray()
    }
}