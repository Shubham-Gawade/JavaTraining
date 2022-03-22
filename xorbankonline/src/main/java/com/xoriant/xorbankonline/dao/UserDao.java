package com.xoriant.xorbankonline.dao;

import com.xoriant.xorbankonline.model.User;

public interface UserDao {

	User getUser(String userName, String password);
}
