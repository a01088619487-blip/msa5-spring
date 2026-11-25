package org.msa.msa5spring.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.msa.msa5spring.request.RegistrationRequestDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class ValidationController {
    @GetMapping("/validation")
    public String validation(@Valid @RequestBody RegistrationRequestDTO registrationRequestDTO){
        return "유효성 검사";
        // @Valid: DTO에 붙은 검사 규칙(@NotBlank 등)을 실행함.
        //실패하면 메서드 실행 전에 400 응답
    }

    @GetMapping("/validation/{id}")
    public String validationSegment(
            @Min(value = 1, message = "1이상") @PathVariable Long id
            ){
        return id.toString(); //롱타입의 값을 리턴으로해서 값변화
        //레스턴스 객체로 바꾸고 헤드와 바디를 만들어서 최종적으로 반환하는 상태
        //반환 규칙이 없는건강?
    }


}

