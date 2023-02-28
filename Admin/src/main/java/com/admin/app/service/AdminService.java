package com.admin.app.service;

import java.util.List;
import java.util.Optional;

import com.admin.app.entity.Admin;

public interface AdminService {

	public Optional<Admin> getAdminById(Long id);
	
	public Admin createAdmin(Admin admin);
	
	public Optional<Admin> getAdminByEmail(String email);
	
	public Admin updateAdmin(Long id, Admin admin);
	
	public void deleteAdmin(Long id);
	
	public List<Admin> getAllAdmins();
}
