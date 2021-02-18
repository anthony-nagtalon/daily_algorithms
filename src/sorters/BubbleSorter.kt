package sorters

class BubbleSorter : Sorter {
    override fun sort(array: IntArray, timed: Boolean) {
        val start = System.currentTimeMillis()
        var swap : Boolean

        for (i in array.indices) {
            swap = false

            for(j in 0 until array.size - i - 1) {
                if(array[j] > array [j + 1]) {
                    swap(array, j, j + 1)
                    swap = true
                }
            }

            if(!swap) break
        }

        if(timed) println("${this::class.simpleName}: ${System.currentTimeMillis() - start} ms")
    }
}