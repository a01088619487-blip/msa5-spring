package org.msa.msa5spring.error;


import org.msa.msa5spring.response.GlobalResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // Exception과 그 자식 예외를 전부 처리함 (상속 관계 중요)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<GlobalResponseDTO<Void>> handle(Exception e) {
        // Void = 데이터 없이 상태/메시지만 내려줄 때 쓰는 타입
        // 메서드 이름은 아무거나 가능하지만 handle이 관습
        return ResponseEntity
                .status(500)
                .body(
                        new GlobalResponseDTO<>(
                                "E99", "시스템 에러", null
                        ) // code, message,result
                );
    }


}


