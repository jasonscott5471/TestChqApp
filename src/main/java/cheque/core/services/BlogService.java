package cheque.core.services;


import cheque.core.models.entities.Blog;
import cheque.core.services.util.BlogEntryList;
import cheque.core.models.entities.BlogEntry;
import cheque.core.services.util.BlogList;

/**
 * Created by finwebmailer on 6/19/2016.
 */
public interface BlogService {
    /**
     * @param blogId the id of the blog to add this BlogEntry to
     * @param data the BlogEntry containing the data to be used for creating the new entity
     * @return the created BlogEntry with a generated ID
     * @throws cheque.core.services.exceptions.BlogNotFoundException if the blog to add to cannot be found
     */
    public BlogEntry createBlogEntry(Long blogId, BlogEntry data);

    public BlogList findAllBlogs();

    public BlogEntryList findAllBlogEntries(Long blogId); // findBlog all associated blog entries

    public Blog findBlog(Long id);
}