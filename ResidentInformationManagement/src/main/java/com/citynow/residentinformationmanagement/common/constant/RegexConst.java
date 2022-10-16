package com.citynow.residentinformationmanagement.common.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RegexConst {

    public static final String UUID =
            "^[0-9a-fA-F]{8}\\b-[0-9a-fA-F]{4}\\b-[0-9a-fA-F]{4}\\b-[0-9a-fA-F]{4}\\b-[0-9a-fA-F]{12}$";
    public static final String PHONE_NUMBER = "^((\\+)84|0)[1-9](\\d{2}){4}$";
    public static final String EMAIL_SIMPLE = "^(.+)@(\\S+)$";
    public static final String USERNAME = "^.{8,20}$";
    public static final String PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";
}