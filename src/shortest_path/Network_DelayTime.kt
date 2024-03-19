package shortest_path

import java.util.*

class Network_DelayTime {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        //네트워크의 각 노드를 출발지 -> 도착지 형태의 그래프로 구성
        val graph: MutableMap<Int, MutableMap<Int, Int>> = mutableMapOf()
        for (time in times) {
            graph.putIfAbsent(time[0], mutableMapOf())

            //출발지에 (도착지, 소요 시간) 추가
            graph[time[0]]!![time[1]] = time[2]
        }

        val pq: Queue<Map.Entry<Int, Int>> = PriorityQueue(compareBy { (node, time) -> time })
        pq.add(AbstractMap.SimpleEntry(k, 0))

        //(도착지, 소요 시간) 최종 결과를 저장
        val dist: MutableMap<Int, Int> = mutableMapOf()
        while (!pq.isEmpty()) {
            val (u, dist_u) = pq.poll()

            if (!dist.containsKey(u)) {
                dist[u] = dist_u

                if (graph.containsKey(u)) {
                    for ((v, length_u_v) in graph[u]!!) {
                        val alt = dist_u + length_u_v
                        pq.add(AbstractMap.SimpleEntry(v, alt))
                    }
                }
            }
        }
        return if (dist.size == n)
            Collections.max(dist.values)
        else -1
    }
}