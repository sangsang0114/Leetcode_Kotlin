class Reverse_String {
    fun reverseString(s: CharArray): Unit {
        var l = 0
        var r = s.size - 1
        while (l < r) {
            var temp = s[l]
            s[l] = s[r]
            s[r] = temp
            ++l
            --r
        }
    }

    fun otherSolution(s: CharArray): Unit {
        var l = 0
        var r = s.size - 1
        while (l < r) {
            s[l] = s[r].also { s[r] = s[l] }
            --r
            ++l
        }
    }
}