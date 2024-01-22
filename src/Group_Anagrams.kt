class Group_Anagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val anagrams = mutableMapOf<String, MutableList<String>>()
        for (s in strs) {
            val key = s.toCharArray().sorted().joinToString("")
            anagrams.getOrPut(key) { mutableListOf() }
            anagrams[key]!!.add(s)
        }
        return ArrayList<List<String>>(anagrams.values)
    }

    fun mySolutiob(strs: Array<String>): List<List<String>> {
        val anagrams = mutableMapOf<String, MutableList<String>>()
        for (s in strs) {
            val temp = s.toCharArray()
            temp.sort()
            val key = temp.joinToString("")
            anagrams.getOrPut(key) { mutableListOf() }
            anagrams[key]!!.add(s)
        }

        val answer = mutableListOf<List<String>>()
        for ((key, value) in anagrams.entries) {
            answer.add(value)
        }
        return answer
    }
}