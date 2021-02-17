package sorters

class BubbleSorter : Sorter {
    override fun sort(array: IntArray, timed: Boolean) {
        val start = System.currentTimeMillis()
        var swap = false

        for (i in array.indices) {
            swap = false

            for(j in 0 until array.size - i - 1) {
                if(array[j] > array [j + 1]) {
                    val temp = array[j]
                    array[j] = array[j+1]
                    array[j+1] = temp
                    swap = true
                }
            }

            if(!swap) break;
        }

        if(timed) println("${this::class.simpleName}: ${System.currentTimeMillis() - start} ms")
    }
}