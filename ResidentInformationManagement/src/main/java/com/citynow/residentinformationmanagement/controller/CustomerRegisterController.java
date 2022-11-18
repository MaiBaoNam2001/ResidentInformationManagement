package com.citynow.residentinformationmanagement.controller;

import com.citynow.residentinformationmanagement.common.mapper.ModelConverter;
import com.citynow.residentinformationmanagement.dto.request.CustomerRegisterRequest;
import com.citynow.residentinformationmanagement.dto.request.CustomerUpdateRequest;
import com.citynow.residentinformationmanagement.dto.response.CustomerRegisterResponse;
import com.citynow.residentinformationmanagement.dto.response.CustomerUpdateResponse;
import com.citynow.residentinformationmanagement.dto.response.JsonResponse;
import com.citynow.residentinformationmanagement.service.CustomerRegister;
import com.citynow.residentinformationmanagement.service.CustomerRegister.Input;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CustomerRegisterController {

  private final CustomerRegister customerRegister;
  private final ModelConverter modelConverter;

  @PostMapping("/customers/add")
  public List<CustomerRegisterResponse> registerCustomers(
      @RequestBody List<CustomerRegisterRequest> customerRegisterRequests) {
    CustomerRegister.Input input = new Input();
    input.setCustomers(modelConverter.mapAllByIterator(customerRegisterRequests,
        CustomerRegister.Input.Customer.class));
    return modelConverter.mapAllByIterator(customerRegister.execute(input).getCustomers(),
        CustomerRegisterResponse.class);
  }

  @PostMapping("/customers/edit")
  public JsonResponse updateCustomer(
      @RequestBody @Valid CustomerUpdateRequest customerUpdateRequest, BindingResult result) {
    if (result.hasErrors()) {
      return new JsonResponse("FAIL", result.getAllErrors());
    }
    return new JsonResponse("SUCCESS",
        modelConverter.map(customerUpdateRequest, CustomerUpdateResponse.class));
  }
}
