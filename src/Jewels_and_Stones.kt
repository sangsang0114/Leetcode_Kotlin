fun numJewelsInStones(jewels: String, stones: String): Int {
    var count = 0
    val freqs: MutableSet<Char> = HashSet()

    for (j in jewels.toCharArray())
        freqs.add(j)

    for (s in stones.toCharArray())
        if (freqs.contains(s))
            ++count
    return count
}
