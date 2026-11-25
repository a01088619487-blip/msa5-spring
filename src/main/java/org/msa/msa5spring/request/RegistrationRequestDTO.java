package org.msa.msa5spring.request;

import jakarta.validation.constraints.*;

public record RegistrationRequestDTO(
        @NotBlank(message = "이메일 필수") //email엔 필수 (@NotEmpty는 null의 유무체크)
        @Pattern(regexp ="^[a-z]{4,8}$",message = "이메일 패턴 틀림")
        //소문자 a-z까지 범위와 4글자에서 8글자 허용
        // 정규표현식, blank보다 우선시 된다
        String email,

        @NotBlank(message = "비밀번호 필수")
        @Size(min = 2, max = 10, message = "비밀번호는 2~10자")
        String password,

        String name,

        @Min(value = 0, message = "나이는 최소 0 이상")
        @Max(value = 999, message = "니이는 최대 999살 입니다.")
        // Not은 현재 필수가 아니기 때문에 필요없다
        Integer age // integer null의 오류를 맞기위함??
) { }
