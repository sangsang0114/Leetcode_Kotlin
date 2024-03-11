package greedy

class Gas_Station {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        if (gas.sum() < cost.sum()) return -1

        var start = 0
        var fuel = 0

        for (i in gas.indices) {
            /*
            남은 기름으로 출발점이 안 되는 주유소가 있다면,
            이미 지나친 지점도 전부 출발점이 될 수 없으므로
            출발점을 다음 지점으로 밀어낸다.
             */
            if (fuel + gas[i] - cost[i] < 0) {
                start = i + 1
                fuel = 0
            } else {
                fuel += gas[i] - cost[i]
            }
        }
        return start
    }

    fun usingBruteForce(gas: IntArray, cost: IntArray): Int {
        for (start in gas.indices) {
            var fuel = 0
            var canTravel: Boolean = true

            for (i in start..<gas.size + start) {
                val idx = i % gas.size

                if (fuel + gas[idx] - cost[idx] < 0) {
                    canTravel = false
                    break
                } else {
                    fuel += gas[idx] - cost[idx]
                }
            }
            if (canTravel) return start
        }
        return -1
    }
}