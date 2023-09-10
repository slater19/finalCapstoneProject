package com.foodbox.foodbox.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.foodbox.foodbox.model.Admin;
import com.foodbox.foodbox.repository.AdminRepository;

import java.util.Map;

import javax.servlet.http.HttpSession;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RestController
public class AdminController {

   @Autowired
    private AdminRepository adminRepository;

    @SuppressWarnings("rawtypes")
    @PostMapping("/admin/{username}")
    public boolean verifyAdminLogin(@RequestBody Map loginData, @PathVariable(name = "username") String username, HttpSession session) {
        String lusername=(String)loginData.get("username");
        String lpassword=(String)loginData.get("password");
        Admin admin = adminRepository.findByusername(username);

        if(admin!=null && admin.getUsername().equals(lusername) && admin.getPassword().equals(lpassword)) {
            session.setAttribute("adminUsername", lusername);
            return true;
        }else {
            return false;
        }
    }

}