package cheque.core.repositories;


import cheque.core.models.entities.Blog;

import java.util.List;

/**
 * Created by finwebmailer on 7/19/2016.
 */
public interface BlogRepo {
    public Blog createBlog(Blog data);
    public List<Blog> findAllBlogs();
    public Blog findBlog(Long id);
    public Blog findBlogByTitle(String title);
    public List<Blog> findBlogsByAccount(Long accountId);
}
