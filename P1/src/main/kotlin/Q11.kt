fun main() {
    println("Code By 21012011046")

    val firstMatrix = Matrix(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6)), 2, 3)
    val secondMatrix1 = Matrix(arrayOf(intArrayOf(1, 4), intArrayOf(2, 5), intArrayOf(3, 6)), 3, 2)
    val secondMatrix2 = Matrix(arrayOf(intArrayOf(7, 4), intArrayOf(8, 5), intArrayOf(9, 6)), 3, 2)

    println("*********************** Addition ***********************")
    print("Matrix 1 : ")
    println(secondMatrix2.toString())
    print("Matrix 2 : ")
    println(secondMatrix1.toString())
    val addMatrix = secondMatrix2 + secondMatrix1
    print("Addition : $addMatrix")

    println("*********************** Subtraction ***********************")
    print("Matrix 1 : ")
    println(secondMatrix2.toString())
    print("Matrix 2 : ")
    println(secondMatrix1.toString())
    val subMatrix = secondMatrix2 - secondMatrix1
    print("Subtraction : $subMatrix")

    println("*********************** Multiplication ***********************")
    print("Matrix 1 : ")
    println(firstMatrix.toString())
    print("Matrix 2 : ")
    println(secondMatrix1.toString())
    val mulMatrix = firstMatrix * secondMatrix1
    println("Multiplication : $mulMatrix")
}

class Matrix(private val matrix: Array<IntArray>, private val rows: Int, private val cols: Int) {
    override fun toString(): String {
        var res = "($rows x $cols Matrix): \n"
        for (i in matrix) {
            for (j in i) {
                res += "$j\t"
            }
            res += "\n"
        }
        return res
    }

    operator fun plus(obj: Matrix): Matrix {
        val sum = Array(this.rows) { IntArray(this.cols) }
        for (i in 0 until this.rows) {
            for (j in 0 until this.cols) {
                sum[i][j] = this.matrix[i][j] + obj.matrix[i][j]
            }
        }
        return Matrix(sum, this.rows, this.cols)
    }

    operator fun minus(obj: Matrix): Matrix {
        val sub = Array(this.rows) { IntArray(this.cols) }
        for (i in 0 until this.rows) {
            for (j in 0 until this.cols) {
                sub[i][j] = this.matrix[i][j] - obj.matrix[i][j]
            }
        }
        return Matrix(sub, this.rows, this.cols)
    }

    operator fun times(obj: Matrix): Matrix {
        val mul = Array(this.rows) { IntArray(obj.cols) }
        for (i in 0 until this.rows) {
            for (j in 0 until obj.cols) {
                mul[i][j] = 0
                for (k in 0 until obj.rows) {
                    mul[i][j] += this.matrix[i][k] * obj.matrix[k][j]
                }
            }
        }
        return Matrix(mul, this.rows, obj.cols)
    }
}
