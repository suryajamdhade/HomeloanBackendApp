package com.re.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.re.app.model.Localadd;
import com.re.app.model.Permanent;
import com.re.app.service.LocalService;
import com.re.app.service.PermanentService;

@RestController
@RequestMapping("/CustomerAddress-api")
public class CustomerAddressController {

	@Autowired
	private PermanentService permanentService;
	@Autowired
	private LocalService localService;

	@PostMapping("/set-Permanent")
	public ResponseEntity<Permanent> setPermanentAddress(@RequestBody Permanent permanent) {
		Permanent setPermanentAddr = permanentService.setPermanentAddr(permanent);
		return new ResponseEntity<>(setPermanentAddr, HttpStatus.CREATED);

	}

	@PutMapping("/update-Permanent/{perAddId}")
	public ResponseEntity<Permanent> updatePermanentAddress(@RequestBody Permanent permanent,
			@PathVariable int perAddId) {
		Permanent updatePermanentAddr = permanentService.setPermanentAddr(permanent);
		return new ResponseEntity<>(updatePermanentAddr, HttpStatus.CREATED);

	}

	@PostMapping("/set-LocalAdd")
	public ResponseEntity<Localadd> setLocalAddress(@RequestBody Localadd localAdd) {
		Localadd setLocalAddr = localService.setLocalAddr(localAdd);
		return new ResponseEntity<>(setLocalAddr, HttpStatus.CREATED);

	}

	@PutMapping("/update-LocalAdd/{la_Id}")
	public ResponseEntity<Localadd> updateLocalAddress(@RequestBody Localadd localAdd, @PathVariable int la_Id) {
		Localadd updateLocalAddr = localService.setLocalAddr(localAdd);
		return new ResponseEntity<>(updateLocalAddr, HttpStatus.CREATED);

	}

}
