package binary_search

class Search_a_2D_Matrix_II {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var row = 0
        var col = matrix[0].size - 1

        while (row < matrix.size && col >= 0) {
            when {
                matrix[row][col] == target -> return true
                matrix[row][col] > target -> --col
                else -> ++row
            }
        }
        return false
    }
}