package greedy

import java.util.PriorityQueue
import java.util.Queue

class Queue_Reconstruction_by_Height {
    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        val pq: Queue<IntArray> = PriorityQueue { a: IntArray, b: IntArray ->
            if (a[0] != b[0])
                b[0] - a[0]
            else
                a[1] - b[1]
        }

        for (p in people)
            pq.add(p)

        val result: MutableList<IntArray> = mutableListOf()

        while (!pq.isEmpty()) {
            val p = pq.poll()
            result.add(p[1], p)
        }
        return result.toTypedArray()
    }
}