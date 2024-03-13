package string

private class Reorder_Log_Files {
    fun reorderLogFiles(logs: Array<String>): Array<String> {
        val letters = mutableListOf<String>()
        val nums = mutableListOf<String>()

        for (log in logs) {
            if (Character.isDigit(log.split(" ")[1][0])) {
                nums.add(log)
            } else {
                letters.add(log)
            }
        }

        letters.sortWith(Comparator { s1: String, s2: String ->
            val s01 = s1.split(" ", limit = 2)
            val s02 = s2.split(" ", limit = 2)

            val compared = s01[1].compareTo(s02[1])

            if (compared == 0) {
                s01[0].compareTo(s02[0])
            } else {
                compared
            }
        })

        letters.addAll(nums)
        return letters.toTypedArray()
    }
}