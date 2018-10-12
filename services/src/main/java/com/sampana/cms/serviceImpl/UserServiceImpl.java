package com.sampana.cms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampana.cms.constants.IConstants;
import com.sampana.cms.dto.UserDTO;
import com.sampana.cms.model.ResponseDTO;
import com.sampana.cms.model.User;
import com.sampana.cms.repository.UserRepository;
import com.sampana.cms.service.UserService;
import com.sampana.cms.utils.DateUtils;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	
	
	@Override
	public List<User> getUsers(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void createUser(User user) {
		userRepository.save(user);
		
	}
	public List<User> getUser() {
        // TODO Auto-generated method stub
        return (List<User>) userRepository.findAll();
    }

	@Override
	public ResponseDTO saveUser(UserDTO userDTO) {
		ResponseDTO responseDTO = null;
		if (userDTO != null) {
			try {
				User user = getUserObj(userDTO);
				user = userRepository.save(user);
				userDTO = getUserDTOObj(user);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		return responseDTO;
	}
	private UserDTO getUserDTOObj(User user) {
		UserDTO userDTO = null;
		if (null != user) {
			userDTO = new UserDTO();
			userDTO.setUserName(user.getUserName());
			userDTO.setFullName(user.getFullName());
			userDTO.setEmail(user.getEmail());;
			userDTO.setPassword(user.getPassword());
			userDTO.setDeleted(user.getDeleted());
			userDTO.setUserStatusId(user.getUserStatusId());
			

		}
		return userDTO;

	}
private User getUserObj(UserDTO userDTO) {
		
		User  user=null;
		
		if(null !=userDTO) {
			user=new User();
			if(null !=userDTO.getId())
				user.setId(userDTO.getId());
			user.setCreatedAt(DateUtils.getDateObj(userDTO.getCreatedAt(), IConstants.DATE_FORMAT));
			user.setDeleted(userDTO.getDeleted());
			//user.setDeletedAt(DateUtils.getDateObj(userDTO.getDeletedAt(), IConstants.DATE_FORMAT));
			user.setEmail(userDTO.getEmail());
			user.setPassword(userDTO.getPassword());
			user.setFullName(userDTO.getFullName());
			//user.setUpdatedAt(DateUtils.getDateObj(userDTO.getUpdatedAt(), IConstants.DATE_FORMAT));
			user.setUserName(userDTO.getUserName());
			//user.setUserStatusId(userDTO.getUserStatusId());
		}
		return user;
	}



}
