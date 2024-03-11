package greedy

import java.util.*

class Task_Scheduler {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val freqs = IntArray(26)
        for (c in tasks)
            freqs[c - 'A']++

        val pq: Queue<Int> = PriorityQueue { a: Int, b: Int -> b - a }
        for (f in freqs)
            if (f > 0)
                pq.add(f)

        var result = 0
        while (true) {
            var intervals = 0
            val list: MutableList<Int> = mutableListOf()

            while (!pq.isEmpty()) {
                val frequency = pq.poll()
                if (intervals < n + 1) {
                    ++intervals
                    ++result

                    if (frequency > 1)
                        list.add(frequency - 1)
                } else {
                    list.add(frequency)
                }
            }
            if (list.isEmpty()) break

            pq.addAll(list)
            result += n + 1 - intervals
        }
        return result
    }
}