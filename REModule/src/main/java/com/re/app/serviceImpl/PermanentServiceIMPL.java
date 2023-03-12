package com.re.app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.re.app.model.Permanent;
import com.re.app.repository.PermanentRepository;
import com.re.app.service.PermanentService;

@Service
public class PermanentServiceIMPL implements PermanentService {
	@Autowired
	public PermanentRepository permanentRepository;

	@Override
	public Permanent setPermanentAddr(Permanent permanent) {
		return permanentRepository.save(permanent);
	}

}
