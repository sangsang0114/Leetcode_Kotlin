package bit_operation

class Hamming_Distance {
    fun hammingDistance(x: Int, y: Int): Int {
        val xor = x xor y
        return Integer.bitCount(xor)
    }
}