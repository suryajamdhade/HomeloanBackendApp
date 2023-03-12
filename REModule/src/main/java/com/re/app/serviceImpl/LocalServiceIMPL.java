package com.re.app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.re.app.model.Localadd;
import com.re.app.repository.LocalRepository;
import com.re.app.service.LocalService;

@Service
public class LocalServiceIMPL implements LocalService {
	@Autowired
	private LocalRepository localRepository;
	
	@Override
	public Localadd setLocalAddr(Localadd localAdd) {
		return localRepository.save(localAdd);
		
	}

}
