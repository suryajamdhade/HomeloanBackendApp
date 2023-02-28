package com.admin.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.app.entity.Admin;
import com.admin.app.repository.AdminRepository;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}

	public Optional<Admin> getAdminById(Long id) {
		return adminRepository.findById(id);
	}

	public Optional<Admin> getAdminByEmail(String email) {
		return adminRepository.findByEmail(email);
	}

	public Admin createAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	public Admin updateAdmin(Long id, Admin admin) {
		Optional<Admin> adminOptional = adminRepository.findById(id);

		if (adminOptional.isPresent()) {
			Admin existingAdmin = adminOptional.get();

			existingAdmin.setFirstName(admin.getFirstName());
			existingAdmin.setLastName(admin.getLastName());
			existingAdmin.setEmail(admin.getEmail());
			existingAdmin.setPassword(admin.getPassword());

			return adminRepository.save(existingAdmin);
		} else {
			return null;
		}
	}

	public void deleteAdmin(Long id) {
		adminRepository.deleteById(id);
	}
}
