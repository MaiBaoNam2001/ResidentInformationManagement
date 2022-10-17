package com.citynow.residentinformationmanagement.controller;

import com.citynow.residentinformationmanagement.common.mapper.ModelConverter;
import com.citynow.residentinformationmanagement.service.ResidentFetch;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/manager")
@PropertySource("classpath:messages.properties")
public class ResidentFetchController {
    private final ResidentFetch residentFetch;
    private final ModelConverter modelConverter;
    private final Environment env;

    @GetMapping("/residents")
    public String fetchResidents(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
        ResidentFetch.Input input = new ResidentFetch.Input();
        input.setPage(0);
        int residentCount = residentFetch.execute(input).size();
        int pageSize = Integer.parseInt(env.getProperty("resident.page.size"));
        model.addAttribute("totalPage", Math.ceil((residentCount * 1.0) / pageSize));
        input.setPage(page);
        model.addAttribute("residents", modelConverter.mapAllByMappingType(residentFetch.execute(input)));
        model.addAttribute("page", page);
        return "fetch_residents";
    }
}
