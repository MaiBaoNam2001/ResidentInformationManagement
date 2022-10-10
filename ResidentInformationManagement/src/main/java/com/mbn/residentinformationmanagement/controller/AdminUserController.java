package com.mbn.residentinformationmanagement.controller;

import com.mbn.residentinformationmanagement.entity.Resident;
import com.mbn.residentinformationmanagement.entity.User;
import com.mbn.residentinformationmanagement.repository.ResidentRepository;
import com.mbn.residentinformationmanagement.repository.RoleRepository;
import com.mbn.residentinformationmanagement.service.ResidentAddService;
import com.mbn.residentinformationmanagement.service.ResidentFindByIdService;
import com.mbn.residentinformationmanagement.service.UserAddService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminUserController {
    private final UserAddService userAddService;
    private final ResidentFindByIdService residentFindByIdService;
    private final ResidentAddService residentAddService;

    private final PasswordEncoder passwordEncoder;

    @GetMapping("/users")
    public String fetchUsers() {
        return "fetch_user";
    }

    @GetMapping("/users/add")
    public String addUser(User user) {
        return "add_user";
    }

//    @GetMapping("/users/add")
//    public String addUser() {
//        User user = new User();
//        user.setUsername("vietanh.hoang");
//        user.setPassword(passwordEncoder.encode("Viethoang123#"));
//        user.setCreatedDate(new Date());
//        user.setResident(residentFindByIdService());
//        return "add_user";
//    }

    @PostMapping("/users/add")
    public String addUserHandler(@Valid User user, @RequestParam(value = "resident") String residentId, @RequestParam(value = "role") String roleId, BindingResult result) {
        if (result.hasErrors()) {
            return "add_user";
        }
        userAddService.execute(user);
        Resident resident = residentFindByIdService.execute(residentId).get();
        resident.setUser(user);
        residentAddService.execute(resident);
        return "redirect:/admin/users";
    }
}
