package com.coll.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.coll.model.BlogComment;
@Repository("blogcommentDAO")
public interface BlogCommentDAO {
	public boolean addBlogComment(BlogComment blogComment);

	public boolean deleteBlogComment(BlogComment blogComment);

	public BlogComment getBlogComment(int commentid);

	public List<BlogComment> listBlogComment(int blogid);
	
	

}
