import com.example.apihw.model.Post

interface PostsApi {
    suspend fun getPosts(): List<Post>
}