sealed class Result<T>
{
    class Success<T>(val data: T) : Result<T>()
    class Error<T>(val errorString: String) : Result<T>()
}
