package my.service;

import my.dto.UserDTO;

public interface UserService {
	public UserDTO login(UserDTO userDTO);
	public void regist(UserDTO userDTO);
	public boolean isExist(UserDTO userDTO);
}
