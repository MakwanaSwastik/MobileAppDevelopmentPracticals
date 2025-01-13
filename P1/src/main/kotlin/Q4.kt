fun main() {
    println("21012011046")
    print("Enter a number: ")
    var num = readLine()!!.toInt()

    if (num % 2 == 0) {
        println("Even!")
    } else {
        println("Odd!")
    }
}
