package com.citynow.residentinformationmanagement.controller;

import com.citynow.residentinformationmanagement.service.ResidentDelete;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/manager")
public class ResidentDeleteController {
    private final ResidentDelete residentDelete;

    @PostMapping("/residents/delete/{id}")
    public String deleteResidentHandler(@PathVariable(value = "id") String id) {
        ResidentDelete.Input input = new ResidentDelete.Input();
        input.setId(id);
        residentDelete.execute(input);
        return "redirect:/manager/residents";
    }
}
