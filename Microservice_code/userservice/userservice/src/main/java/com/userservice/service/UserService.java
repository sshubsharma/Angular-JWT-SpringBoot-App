package com.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userservice.VO.Department;
import com.userservice.VO.RestTemplateVO;
import com.userservice.entity.User;
import com.userservice.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private RestTemplate resttemplate;
	

	public User saveUser(User user) {
		return userRepo.save(user);
	}

	public RestTemplateVO findUserByuserId(long userId) {
		RestTemplateVO restTemplateVO=new RestTemplateVO();
		User user=userRepo.findUserByuserId(userId);
		Department department=resttemplate.getForObject("http://DEPT-SERVICE/departments/" + userId, Department.class);
		restTemplateVO.setDepartment(department);
		restTemplateVO.setUser(user);
		return restTemplateVO;
	}

}
