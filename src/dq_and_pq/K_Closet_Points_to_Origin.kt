package dq_and_pq

import java.util.*

class K_Closet_Points_to_Origin {

    data class Point(var distance: Long, var point: IntArray)

    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val pq: Queue<Point> = PriorityQueue(compareBy { a -> a.distance })

        for (p in points) {
            val dist = p[0].toLong() * p[0] + p[1].toLong() * p[1]
            pq.add(Point(dist, p))
        }

        val results: Array<IntArray> = Array(k) { IntArray(2) { 0 } }

        for (i in 0 until k) {
            results[i] = pq.poll().point
        }
        return results
    }
}