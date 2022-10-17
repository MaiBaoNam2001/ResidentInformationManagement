package com.citynow.residentinformationmanagement.controller;

import com.citynow.residentinformationmanagement.common.mapper.ModelConverter;
import com.citynow.residentinformationmanagement.dto.request.ResidentAddRequest;
import com.citynow.residentinformationmanagement.service.ResidentAdd;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/manager")
public class ResidentAddController {
    private final ResidentAdd residentAdd;
    private final ModelConverter modelConverter;

    @GetMapping("/residents/add")
    public String addResident(ResidentAddRequest residentAddRequest) {
        return "add_resident";
    }

    @PostMapping("/residents/add")
    public String addResidentHandler(@Valid ResidentAddRequest residentAddRequest, BindingResult result) {
        if (result.hasErrors()) {
            return "add_resident";
        }
        ResidentAdd.Input input = modelConverter.map(residentAddRequest, ResidentAdd.Input.class);
        residentAdd.execute(input);
        return "redirect:/manager/residents";
    }
}
