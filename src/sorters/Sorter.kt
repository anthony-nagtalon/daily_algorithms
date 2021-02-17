package sorters

interface Sorter {
    fun sort(array : IntArray, timed : Boolean)
    fun printBoard(array : IntArray) {
        array.forEach {
            print("$it ")
        }
    }
}