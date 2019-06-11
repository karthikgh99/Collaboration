package com.coll.DAO;

import com.coll.model.ProfilePicture;

public interface ProfilePictureDAO 
{
	public void save(ProfilePicture profilePicture);
	public ProfilePicture getProfilePicture(String username);

}
