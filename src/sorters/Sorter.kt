package sorters

interface Sorter {
    fun sort(array : IntArray, timed : Boolean)
    fun printBoard(array : IntArray) {
        array.forEach {
            print("$it ")
        }
    }
}

fun main() {
    var array = intArrayOf(2,4,5,1,62,23,635,23,4,1,8,0)
    BubbleSorter().sort(array, true)

    array = intArrayOf(2,4,5,1,62,23,635,23,4,1,8,0)
    SelectionSorter().sort(array, true)

    array = intArrayOf(2,4,5,1,62,23,635,23,4,1,8,0)
    InsertionSorter().sort(array, true)

    SelectionSorter().printBoard(array)
}