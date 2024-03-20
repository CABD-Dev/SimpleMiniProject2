package com.example.demo.parameter;

public abstract class RC {
    public static final String SUCCESS_CODE = "200";
    public static final String SUCCESS_MSG = "Success";
    public static final String BAD_REQUEST_CODE = "400";
    public static final String BAD_REQUEST_MSG = "Bad Request";
    public static final String NOT_FOUND_CODE = "404";
    public static final String NOT_FOUND_MSG = "Not found";
    public static final String TOO_MANY_REQUEST = "429";
    public static final String TOO_MANY_REQUEST_MSG = "To Many Request";
    public static final String BANK_NOT_SUPPORTED_CODE = "404";
    public static final String BANK_NOT_SUPPORTED_MSG = "Bank not supported by switch";
    public static final String INVALID_MERCHANT_CODE = "404";
    public static final String INVALID_MERCHANT_MSG = "Invalid Merchant";
    public static final String INVALID_QR_CODE = "403";
    public static final String INVALID_QR_MSG = "Invalid QR";
    public static final String INVALID_SIGNATURE = "403";
    public static final String INVALID_SIGNATURE_MSG = "Invalid Signature";
    public static final String INVALID_TOKEN = "403";
    public static final String INVALID_TOKEN_MSG = "Invalid Token";
    public static final String INVALID_CREDENTIAL = "403";
    public static final String INVALID_CREDENTIAL_MSG = "Invalid Credential";
    public static final String INVALID_AMOUNT_CODE = "403";
    public static final String INVALID_AMOUNT_MSG = "Invalid amount";
    public static final String PAID_QR_CODE = "403";
    public static final String PAID_QR_MSG = "The QR has been paid";
    public static final String EXPIRED_QR_CODE = "403";
    public static final String EXPIRED_QR_MSG = "Expired QR";
    public static final String ALREADY_EXIST_CODE = "409";
    public static final String ALREADY_EXIST_MSG = "Requested data already exist";
    public static final String GENERAL_ERROR_CODE = "500";
    public static final String GENERAL_ERROR_MSG = "General error";
    public static final String TRANSACTION_NOT_FOUND = "404";
    public static final String TRANSACTION_NOT_FOUND_MSG = "Transaction not found";
    public static final String UNABLE_AUTHORIZE_CODE = "401";
    public static final String UNABLE_AUTHORIZE_MSG = "Unauthorized";
    public static final String USER_NOT_FOUND_MSG = "User Not Found";
    public static final String EXPIRED_TOKEN_MSG = "Expired Token";
    public static final String ERROR = "Error";
    public static final String KONG_ADMIN_ERROR = "Kong API Error";
    public static final String PASSWORD_NOT_MATCH       = "Password doesn't match";
    public static final String CHANGE_PASS_SUCCESS = "Password changed succesfully";
    private RC() {}
}
