package cheque.rest.resources;

import org.springframework.hateoas.ResourceSupport;
import cheque.core.models.entities.BlogEntry;

/**
 * Created by finwebmailer on 6/20/2016.
 */
public class BlogEntryResource extends ResourceSupport {
    private String title;



    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BlogEntry toBlogEntry() {
        BlogEntry entry = new BlogEntry();
        entry.setTitle(title);
        entry.setContent(content);
        return entry;
    }
}
