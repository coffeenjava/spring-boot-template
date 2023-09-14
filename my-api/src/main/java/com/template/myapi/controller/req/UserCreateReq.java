package com.template.myapi.controller.req;

import com.template.myapi.common.validate.MaxByte;
import com.template.myapi.common.validate.Phone;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class UserCreateReq {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @MaxByte(8)
    private String name;

    @NotNull
    @Min(value = 11, message = "10세 이하는 가입이 불가합니다.")
    private Integer age;

    @Phone
    private String phone;
    private String nationalId; // 주민등록번호


}
