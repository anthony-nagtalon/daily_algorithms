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

        if(timed) println("${this::class.simpleName}: ${System.currentTimeMillis() - start} ms")
    }
}