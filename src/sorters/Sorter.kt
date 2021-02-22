package sorters

import kotlin.random.Random

interface Sorter {
    fun sort(array : IntArray, timed : Boolean)

    fun swap(array: IntArray, i: Int, j: Int) {
        val temp = array[i]
        array[i] = array[j]
        array[j] = temp
    }

    fun printBoard(array : IntArray) {
        array.forEach {
            print("$it ")
        }
        println()
    }
}

fun main() {
    val array = IntArray(20) { Random.nextInt(0, 200)}

    //BubbleSorter().sort(array, true)
    //SelectionSorter().sort(array, true)
    //InsertionSorter().sort(array, true)
    //MergeSorter().sort(array, true)
    //QuickSorter().sort(array, true)
    //HeapSorter().sort(array, true)
    //CountingSorter().sort(array, true)
    RadixSorter().sort(array, true)

    SelectionSorter().printBoard(array)
}