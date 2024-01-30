import java.util.*

class Daily_Temperatures {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val st = ArrayDeque<Int>()
        val answer = IntArray(temperatures.size) { 0 }

        for ((i, t) in temperatures.withIndex()) {
            var days = 0
            while (!st.isEmpty() && t > temperatures[st.first()]) {
                val tmp = st.removeFirst()
                answer[tmp] = i - tmp
            }
            st.addFirst(i)
        }
        return answer
    }
}