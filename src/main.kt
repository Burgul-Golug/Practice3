import kotlin.random.Random

fun main()
{
    var randInt = generateIntegers (5)
    println("$randInt \n Sort ascending: " + randInt.operate(Operation.SORT_ASC)
    + "\n Sort Descending" + randInt.operate(Operation.SORT_DESC)
    + "\n Shuffle" + randInt.operate(Operation.SHUFFLE));

    var randStr = generateStrings(3,10)
    println("$randStr \n Sort ascending: " + randStr.operate(Operation.SORT_ASC)
            + "\n Sort Descending" + randStr.operate(Operation.SORT_DESC)
            + "\n Shuffle" + randStr.operate(Operation.SHUFFLE));
}

fun <T : Comparable<T>> List<T>.operate(operation: Operation): Result<List<T>> {

    if (this.isEmpty()) {
        return Result.Error("Ошибка! Список пуст")
    }
    else {
        when (operation) {
            Operation.SORT_ASC -> return Result.Success(Operation.SORT_ASC(this))
            Operation.SORT_DESC -> return Result.Success(Operation.SORT_DESC(this))
            Operation.SHUFFLE -> return Result.Success(Operation.SHUFFLE(this))
        }
    }
}

fun generateStrings(stringsLength: Int, length : Int) : List<String>
{
    val letters: List<Char> = ('A'..'Z') + ('a'..'z')
    val randStr = mutableListOf<String>()
    for (i in 1..length)
        randStr.add(List(stringsLength) {letters.random()}.joinToString(""))
    return randStr
}

fun generateIntegers(length : Int) : List<Int>
{
    return List(length) { Random.nextInt(-1000,1000)}
}
