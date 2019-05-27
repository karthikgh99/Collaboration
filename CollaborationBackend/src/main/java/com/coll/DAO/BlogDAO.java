package com.coll.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.coll.model.Blog;
@Repository("blogDAO")
public interface BlogDAO {

	public boolean addBlog(Blog blog);
	public boolean deleteBlog(Blog blog);
	public boolean updateBlog(Blog blog);
    public Blog getBlog(int blogid);
    public List<Blog> listBlogs();
    
    public boolean approveBlog(Blog blog);
    public boolean rejectBlog(Blog blog);

    public boolean incrementLikes(Blog blog);
    public boolean incrementDislikes(Blog blog);

}