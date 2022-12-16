package com.example.mvvmtest.data

fun simpleArraySum(ar: Array<Int>): Int {
        // Write your code here
        var sum :Int=0
        for(i in ar)
        {
              //  println(i)
                sum=sum+i
        }
        return sum
}

fun main() {
        val arCount = readLine()!!.trim().toInt()

        val ar = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

        val result = simpleArraySum(ar)

        println(result)
}
