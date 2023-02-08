import android.util.Log
import com.example.apihw.model.Post
import com.example.apihw.model.Welcome
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*

/**
 * Created by Taha Ben Ashur (https://github.com/tahaak67) on 04,Feb,2023
 */
class PostsApiImpl(
    private val client: HttpClient
): PostsApi {

    override suspend fun getPosts(): List<Post> {
        return try {
            var welcome :Welcome = client.get {
                url(Routes.POSTS)
            }.body()
            welcome.exchanges
        } catch (e: RedirectResponseException) {
            Log.e("PostsApi", "3XX Error: ${e.message}")
            emptyList()
        } catch (e: ClientRequestException) {
            Log.e("PostsApi", "4XX Error: ${e.message}")
            emptyList()
        } catch (e: ServerResponseException) {
            Log.e("PostsApi", "5XX Error: ${e.message}")
            emptyList()
        } catch (e: Exception) {
            Log.e("PostsApi", "Error: ${e.message}")
            emptyList()
        }
    }
}