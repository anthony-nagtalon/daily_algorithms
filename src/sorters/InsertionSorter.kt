package sorters

class InsertionSorter : Sorter {
    override fun sort(array: IntArray, timed: Boolean) {
        var start = System.currentTimeMillis()

        for(i in 1 until array.size) {
            val key = array[i]
            var j = i - 1

            while(j >= 0 && array[j] > key) {
                array[j+1] = array[j]
                j--
            }
            array[j + 1] = key
        }

        if(timed) println("${this::class.simpleName}: ${System.currentTimeMillis() - start} ms")
    }
}