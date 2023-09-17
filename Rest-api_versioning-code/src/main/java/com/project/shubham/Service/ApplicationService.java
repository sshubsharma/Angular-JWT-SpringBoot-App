package com.project.shubham.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.project.shubham.model.ApplicationDTO;

@Component
public class ApplicationService {
	
	private static int count=3;
	
	private static List<ApplicationDTO> user=new ArrayList<ApplicationDTO>();
	
	static {
		user.add(new ApplicationDTO(1,"shubham","sharma",1,"india"));
		user.add(new ApplicationDTO(2,"monti","sharma",2,"india"));
		user.add(new ApplicationDTO(3,"mogli","sharma",3,"india"));
		user.add(new ApplicationDTO(4,"sunda","sharma",4,"india"));
		user.add(new ApplicationDTO(5,"foji","sharma",5,"india"));
	}

	//return all users
	public List<ApplicationDTO> finaAll(){
		return user;
	}
	
	//save the user
	public ApplicationDTO save(ApplicationDTO applicationDTO) {
		if(applicationDTO.getId()==0) {
			applicationDTO.setId(++count);
		}
		user.add(applicationDTO);
		return applicationDTO;
	}
	
	//find the user
	
	public ApplicationDTO findOne(int id) {
		for(ApplicationDTO applicationDTO:user) {
			if(applicationDTO.getId()==id) {
				return applicationDTO;
			}
		}
		return null;
	}
	
	//delete 
	public ApplicationDTO deleteByid(int id) {
		Iterator<ApplicationDTO> itr=user.iterator();
		while(itr.hasNext()) {
			ApplicationDTO applicationDTO=itr.next();
			if(applicationDTO.getId()==id) {
				itr.remove();
				return applicationDTO;
			}
		}
		
			
		return null;
	}
}
