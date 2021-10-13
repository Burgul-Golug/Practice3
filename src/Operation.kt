enum class Operation {
    SORT_ASC {
         override fun <T : Comparable<T>> invoke(list: List<T>): List<T> = list.sorted()
            },

    SORT_DESC{
        override fun <T : Comparable<T>> invoke(list: List<T>): List<T> = list.sortedDescending()
             },

    SHUFFLE{
        override fun <T : Comparable<T>> invoke(list: List<T>): List<T> = list.shuffled()
    };
    abstract operator fun <T:Comparable<T>> invoke(list: List<T>): List<T>
}