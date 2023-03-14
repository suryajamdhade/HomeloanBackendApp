package com.re.app.controller;

import java.io.IOException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.re.app.dto.PropertyDTO;
import com.re.app.model.PropertLegal;
import com.re.app.model.PropertyInfo;
import com.re.app.service.PropertyService;

@RestController
@RequestMapping("/property-api")
public class PropertyController {

	@Autowired
	private PropertyService propertyservice;
	
	@Autowired
	private  ModelMapper modelMapper;
	
	@PostMapping(consumes = { "multipart/form-data" })
    public ResponseEntity<PropertyDTO> SaveProperty(@RequestPart PropertyDTO propertyDTO,
                                                       @RequestPart( required = false) MultipartFile nocFile,
                                                       @RequestPart( required = false) MultipartFile titleDeedFile,
                                                       @RequestPart( required = false) MultipartFile ownershipPapersFile,
                                                       @RequestPart(required = false) MultipartFile commencementCertificateFile) throws IOException {

        PropertyInfo propertyinfo = modelMapper.map(propertyDTO, PropertyInfo.class);

        PropertLegal propertyLegal = new PropertLegal();
        propertyLegal.setLegalDisputestatus(propertyDTO.getPropertyLegal().getLegalDisputestatus());

        if (nocFile != null) {
            propertyLegal.setNoc(nocFile.getBytes());
        }

        if (titleDeedFile != null) {
            propertyLegal.setTitleDeed(titleDeedFile.getBytes());
        }

        if (ownershipPapersFile != null) {
            propertyLegal.setOwnershipPapers(ownershipPapersFile.getBytes());
        }

        if (commencementCertificateFile != null) {
            propertyLegal.setCommencementCertificate(commencementCertificateFile.getBytes());
        }

        propertyinfo.setPropertyLegal(propertyLegal);
        
        PropertyDTO savedProperty = modelMapper.map( propertyservice.savePropDetails(propertyinfo),PropertyDTO.class);
        return new ResponseEntity<>(savedProperty, HttpStatus.CREATED);
    }

	@PutMapping(value="/update-property",consumes = { "multipart/form-data" })
    public ResponseEntity<PropertyDTO> UpdateProperty(@RequestPart PropertyDTO propertyDTO,
                                                       @RequestPart( required = false) MultipartFile nocFile,
                                                       @RequestPart( required = false) MultipartFile titleDeedFile,
                                                       @RequestPart( required = false) MultipartFile ownershipPapersFile,
                                                       @RequestPart(required = false) MultipartFile commencementCertificateFile) throws IOException {

        PropertyInfo propertyinfo = modelMapper.map(propertyDTO, PropertyInfo.class);

        PropertLegal propertyLegal = new PropertLegal();
        propertyLegal.setLegalDisputestatus(propertyDTO.getPropertyLegal().getLegalDisputestatus());

        if (nocFile != null) {
            propertyLegal.setNoc(nocFile.getBytes());
        }

        if (titleDeedFile != null) {
            propertyLegal.setTitleDeed(titleDeedFile.getBytes());
        }

        if (ownershipPapersFile != null) {
            propertyLegal.setOwnershipPapers(ownershipPapersFile.getBytes());
        }

        if (commencementCertificateFile != null) {
            propertyLegal.setCommencementCertificate(commencementCertificateFile.getBytes());
        }

        propertyinfo.setPropertyLegal(propertyLegal);
        
        PropertyDTO updateProperty = modelMapper.map( propertyservice.savePropDetails(propertyinfo),PropertyDTO.class);
        return new ResponseEntity<>(updateProperty, HttpStatus.CREATED);
    }


}

