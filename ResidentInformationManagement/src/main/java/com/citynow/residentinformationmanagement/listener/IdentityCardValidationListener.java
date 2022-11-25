package com.citynow.residentinformationmanagement.listener;

import com.citynow.residentinformationmanagement.service.IdentityCardValidation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class IdentityCardValidationListener {

  private static final String IDENTITY_CARD_VALIDATION_QUEUE = "identity-card-validation.queue";
  private final IdentityCardValidation identityCardValidation;

  @RabbitListener(queues = IDENTITY_CARD_VALIDATION_QUEUE)
  public IdentityCardValidation.Output validateIdentityCard(IdentityCardValidation.Input request) {
    log.info("Received Request -> {}", request.toString());
    return identityCardValidation.execute(request);
  }
}
