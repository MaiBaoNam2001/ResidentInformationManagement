package com.citynow.residentinformationmanagement.listener;

import com.citynow.residentinformationmanagement.service.ParkingRegisterValidation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ParkingRegisterValidationListener {

  private final ParkingRegisterValidation parkingRegisterValidation;

  @RabbitListener(queues = "${spring.rabbitmq.parking-register-validation.queue}")
  public ParkingRegisterValidation.Output validateParkingRegister(
      ParkingRegisterValidation.Input request) {
    log.info("Received Request -> {}", request.toString());
    return parkingRegisterValidation.execute(request);
  }
}
