package org.msa.msa5spring.controller;


import org.msa.msa5spring.request.QueryRequestDTO;
import org.msa.msa5spring.response.GlobalResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ResponseController {
    @GetMapping("/res") // /res는 ResponseController의 약자
    public ResponseEntity<GlobalResponseDTO<String>> index() {
        //return ResponseEntity.status(200).body("3");//
        // return ResponseEntity.status(200).body("123");
        // body는 String만 담아 서 ""로만가능함
        //혹시나 body에서 int로 하고싶으면 <String> 아니라 <Integer>로 사용
        // public ResponseEntity<Integer> index(){
        // return ResponseEntity.status(200).body(3); 로교체해줘여한다.
        GlobalResponseDTO<String> globalResponseDTO = new GlobalResponseDTO<>("00","정상처리","레스폰스 테스트");
        return ResponseEntity.status(200).body(globalResponseDTO);

    }

    @GetMapping("/res/test")
    public ResponseEntity<GlobalResponseDTO<QueryRequestDTO>> test(
            QueryRequestDTO queryRequestDTO
    ){
        return ResponseEntity
                .status(200)
                .body(
                        new GlobalResponseDTO<>(
                                "00",
                                "정상 처리", //code message
                                new QueryRequestDTO(3L,"홍길동") //id,name
                        )//new GlobalResponseDTO<QueryRequestDTO>이 생략되어잇는상태
                );
    }
}
