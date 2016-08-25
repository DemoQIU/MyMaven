package my.service.impl;

import java.util.List;

import javax.annotation.Resource;

import my.dto.UserDTO;
import my.model.User;
import my.repository.UserRepository;
import my.service.UserService;

public class UserServiceImpl implements UserService {
	@Resource
	UserRepository userRepository ;

	@Override
	public UserDTO login(UserDTO userDTO) {
		
		String username = userDTO.getUsername();
		String password = userDTO.getPassword();
		List<User> user = userRepository.findByUsernameAndPassword(username,password);
		if(!user.isEmpty()){
			return userDTO;
		}else{
			throw new RuntimeException();
		}
	}

	@Override
	public void regist(UserDTO userDTO) {
		User user = new User();
		String username = userDTO.getUsername();
		String password = userDTO.getPassword();
		user.setUsername(username);
		user.setPassword(password);
		userRepository.save(user);
	}

	@Override
	public boolean isExist(UserDTO userDTO) {
		List<User> user = userRepository.findByUsernameAndPassword(userDTO.getUsername(),userDTO.getPassword());
		if(user.size()==1){
			return true;
		}else{
		return false;
		}
	}
}
