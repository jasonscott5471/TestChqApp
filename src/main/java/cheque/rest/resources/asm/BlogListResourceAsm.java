package cheque.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import cheque.core.services.util.BlogList;
import cheque.rest.mvc.BlogController;
import cheque.rest.resources.BlogListResource;

/**
 * Created by finwebmailer on 6/20/2016.
 */
public class BlogListResourceAsm extends ResourceAssemblerSupport<BlogList, BlogListResource> {

    public BlogListResourceAsm()
    {
        super(BlogController.class, BlogListResource.class);
    }

    @Override
    public BlogListResource toResource(BlogList blogList) {
        BlogListResource res = new BlogListResource();
        res.setBlogs(new BlogResourceAsm().toResources(blogList.getBlogs()));
        return res;
    }
}