package com.citynow.residentinformationmanagement.service.impl;

import com.citynow.residentinformationmanagement.common.mapper.ModelConverter;
import com.citynow.residentinformationmanagement.entity.Resident;
import com.citynow.residentinformationmanagement.repository.ResidentRepository;
import com.citynow.residentinformationmanagement.service.ResidentFetch;
import com.citynow.residentinformationmanagement.service.template.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:messages.properties")
public class ResidentFetchServiceImpl extends BaseService<ResidentFetch.Input, List<ResidentFetch.Output>> implements ResidentFetch {
    private final ResidentRepository residentRepository;
    private final ModelConverter modelConverter;
    private final Environment env;

    @Override
    protected void preExecute(Input input) {

    }

    @Override
    protected List<Output> doExecute(Input input) {
        if (input.getPage() == 0) {
            return modelConverter.mapAllByMappingType(residentRepository.findAll());
        }
        int page = input.getPage() - 1;
        int pageSize = Integer.parseInt(env.getProperty("resident.page.size"));
        List<Resident> residents = residentRepository.findAll(PageRequest.of(page, pageSize)).getContent();
        return modelConverter.mapAllByMappingType(residents);
    }

    @Override
    protected void postExecute(Input input) {

    }
}
