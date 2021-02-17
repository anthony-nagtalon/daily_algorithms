package sorters

class SelectionSorter : Sorter {
    override fun sort(array : IntArray, timed : Boolean) {
        var start = System.currentTimeMillis()

        for(i in array.indices) {
            var minIndex = i
            for(j in i until array.size) {
                if(array[minIndex] > array[j]) minIndex = j
            }

            val temp = array[minIndex]
            array[minIndex] = array[i]
            array[i] = temp
        }

        if(timed) println("Sort completed: ${System.currentTimeMillis() - start} ms")
    }
}

fun main() {
    val array = intArrayOf(2,4,5,1,62,23,635,23,4,1,8,0)
    SelectionSorter().sort(array, true)
    SelectionSorter().printBoard(array)
}