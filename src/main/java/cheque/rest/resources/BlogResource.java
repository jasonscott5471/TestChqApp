package cheque.rest.resources;
import org.springframework.hateoas.ResourceSupport;
import cheque.core.models.entities.Blog;

/**
 * Created by finwebmailer on 6/20/2016.
 */
public class BlogResource extends ResourceSupport {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Blog toBlog() {
        Blog blog = new Blog();
        blog.setTitle(title);
        return blog;
    }
}