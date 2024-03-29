package com.citynow.residentinformationmanagement.common.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.UUID;

public class UUIDUtils {

  public static String getUUID() {
    return StringUtils.left(String.valueOf(UUID.randomUUID()), 8);
  }
}
