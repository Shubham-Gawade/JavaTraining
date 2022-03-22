package com.xoriant.xorbankonline.service;

import com.xoriant.xorbankonline.model.User;

public interface UserService {

	User getUser(String userName, String password);
}
