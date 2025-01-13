fun main() {
    println("Code By 21012011046")

    println("Array created by using arrayOf() method")
    var a1 = arrayOf(23, 43, 5, 63, 8)
    println(a1.contentToString())

    println("Array created by using Array<> method")
    var a2 = Array(5) { 0 }
    println(a2.contentDeepToString())

    println("Array created by using Array<> and Lambda function")
    var a3 = Array(7) { i -> i }
    println(a3.contentToString())

    println("Array created using IntArray()")
    var a4 = IntArray(5) { 7 }
    println(a4.joinToString(", "))

    println("Array created using IntArrayOf()")
    var a5 = intArrayOf(12, 54, 64, 67, 2)
    println(a5.joinToString(", "))

    println("Array created by using arrayOf() and intArrayOf()")
    var a6 = arrayOf(intArrayOf(45, 3), intArrayOf(4, 1), intArrayOf(9, 2))
    println(a6.contentDeepToString())

    print("Enter number of Elements : ")
    val size: Int = readLine()!!.toInt()
    val user = IntArray(size) { 0 }
    for (i in 0 until size) {
        print("a[$i]:")
        user[i] = readLine()!!.toInt()
    }
    print("Entered Array = ")
    println(user.contentToString())

    println("========================== With In-Built Function ==========================")
    println("Array Sorted by in-built Function = ")
    user.sort()
    println(user.contentToString())

    val a7 = intArrayOf(45, 96, 689, 593, -45, -76, -453, -56)
    println("========================== Without In-Built Function ==========================")
    println("Array Sorted without in-built Function = ")

    var temp: Int
    for (i in a7.indices) {
        for (j in a7.indices) {
            if (a7[j] > a7[i]) {
                temp = a7[j]
                a7[j] = a7[i]
                a7[i] = temp
            }
        }
    }
    println(a7.contentToString())
}
