package com.citynow.residentinformationmanagement.controller;

import com.citynow.residentinformationmanagement.common.mapper.ModelConverter;
import com.citynow.residentinformationmanagement.dto.request.ResidentUpdateRequest;
import com.citynow.residentinformationmanagement.service.ResidentFindById;
import com.citynow.residentinformationmanagement.service.ResidentUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/manager")
public class ResidentUpdateController {
    private final ResidentUpdate residentUpdate;
    private final ResidentFindById residentFindById;
    private final ModelConverter modelConverter;

    @GetMapping("/residents/update/{id}")
    public String updateResident(@PathVariable(value = "id") String id, Model model) {
        ResidentFindById.Input input = new ResidentFindById.Input();
        input.setId(id);
        ResidentFindById.Output output = residentFindById.execute(input);
        model.addAttribute("residentUpdateRequest", modelConverter.map(output, ResidentUpdateRequest.class));
        return "update_resident";
    }

    @PostMapping("/residents/update/{id}")
    public String updateResidentHandler(@Valid ResidentUpdateRequest residentUpdateRequest, BindingResult result) {
        if (result.hasErrors()) {
            return "update_resident";
        }
        ResidentUpdate.Input input = modelConverter.map(residentUpdateRequest, ResidentUpdate.Input.class);
        residentUpdate.execute(input);
        return "redirect:/manager/residents";
    }
}
