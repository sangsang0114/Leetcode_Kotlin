package hash

import java.util.concurrent.ThreadLocalRandom

class Pigeonhole_Principle {
    fun main() {
        var sameBirthdays = 0

        repeat(100000) {
            val birthdays = IntArray(23)

            //23명이 모이는 경우
            for (j in 0..22) {
                val birthday = ThreadLocalRandom.current().nextInt(1, 365 + 1)

                if (birthdays.contains(birthday)) {
//                if (IntStream.of(*birthdays).anyMatch { it==birthday }) {
                    ++sameBirthdays
                    break
                }
                birthdays[j] = birthday
            }
        }
        println("10만 번의 실험 중 생일이 동일한 실험의 확률")
        println(sameBirthdays.toDouble() / 100000 * 100)
        println("%")
    }
}