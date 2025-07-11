package com.internship2025.changemanagementsystem.Interfaces;

import lombok.Builder;
import lombok.Data;


public interface Constant {
    Integer SUCCESS_CODE = 0;
    Integer FAILED_CODE = 202;
    Integer NO_DATA_FOUND_CODE = 404;
    Integer EXCEPTION_CODE = -99;

    String SUCCESS_MESSAGE = "Operation has been Successful";
    String FAILED_MESSAGE = "Operation has been Failed";
    String NO_DATA_FOUND_MESSAGE = "No Data Found";
    String EXCEPTION_MESSAGE = " Operation Failed. Unexpected Error Occurred.";
}
