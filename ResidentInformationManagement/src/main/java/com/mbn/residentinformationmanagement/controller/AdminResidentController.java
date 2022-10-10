package com.mbn.residentinformationmanagement.controller;

import com.mbn.residentinformationmanagement.entity.Resident;
import com.mbn.residentinformationmanagement.service.ResidentAddService;
import com.mbn.residentinformationmanagement.service.ResidentFindByIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/manager")
public class AdminResidentController {
    private final ResidentAddService residentAddService;
    private final ResidentFindByIdService residentFindByIdService;

    @GetMapping("/residents")
    public String fetchResidents() {
        return "fetch_resident";
    }

    @GetMapping("/residents/add")
    public String addResident(Resident resident) {
        return "add_resident";
    }

    @PostMapping("/residents/add")
    public String addResidentHandler(@Valid Resident resident, BindingResult result) {
        if (result.hasErrors()) {
            return "add_resident";
        }
        residentAddService.execute(resident);
        return "redirect:/manager/residents";
    }

    @GetMapping("/residents/update/{id}")
    public String updateResident(@PathVariable(value = "id") String id, Model model) {
        Resident resident = residentFindByIdService.execute(id).get();
        model.addAttribute("resident", resident);
        return "update_resident";
    }

    @PostMapping("/residents/update/{id}")
    public String updateResidentHandler(@Valid Resident resident, BindingResult result) {
        if (result.hasErrors()) {
            return "update_resident";
        }
        residentAddService.execute(resident);
        return "redirect:/manager/residents";
    }
}
