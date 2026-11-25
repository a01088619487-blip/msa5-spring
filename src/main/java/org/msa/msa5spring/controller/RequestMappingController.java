package org.msa.msa5spring.controller;

import org.msa.msa5spring.request.QueryRequestDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api") //<- 이맵핑을 사용하면 아래쪽 주소가 같으면 통합된다?\
// 프리픽스로 인하여 통합 시킬수있다 : 공통된문자열을 한곳에 묶는??
public class RequestMappingController {
    //유저가 요청한 메소드를 만들거임
    // GET/users로 들어왓을경우
    //리퀘스트 맵핑만 볼거임
    @GetMapping
    public String index(){
        return "유저 조회";
    }


    //포스트맨으로 맵핑 하고싶을때
    @PostMapping
    public String store(){
        return "유저 생성";
    }
    //현재 맵핑을 안해서 안뜨는거임

    @PutMapping
    public String update(){
        return "유저 수정";
    }
    @DeleteMapping
    public String destroy(){
        return "유저삭제";
    }

    @GetMapping("/query") //쿼리는 Get 맵핑으로 서용해야한다고함 왜?
    public String query(QueryRequestDTO queryRequestDTO){// 새로 만든 QueryRequestDTO 를 불러오는방식
        return String.format("%d : %s", queryRequestDTO.id(),queryRequestDTO.name());

    }

    // Path Variable(경로 변수): 주소 일부를 값으로 받는 방식
    @GetMapping("/segment/{id}/{name}") // { } 안의 이름이 중요함, 여러 개 사용 가능!
    // 예) /api/segment/2/kim 으로 요청하면 id=2, name=kim 으로 들어옴
    public String segment(@ModelAttribute QueryRequestDTO queryRequestDTO) {
        // { } 이름(id, name)이 DTO 필드 이름과 같아서 @ModelAttribute가 자동으로 채워줌
        return String.format("segment = %d : %s", queryRequestDTO.id(), queryRequestDTO.name());
    }

    // @GetMapping("/segment/1/my")
    // public String test(){
    //     return "Test";
    // }
    // 위의 /segment/{id}/{name} 패턴에도 해당하는 주소지만,
    // 고정 경로가 더 구체적이라서 /api/segment/1/my 요청은 이 메서드가 우선 처리함
    // 그래서 id=1, name=my 조합은 segment() 메서드로 들어가지 못함

    // 파일 받는 방법: Postman form-data에서 Key 타입을 File로 바꿔서 전송
    @PostMapping("/form")
    public String form(@RequestParam("file") MultipartFile file) {
        // getContentType(): 파일 종류, getOriginalFilename(): 원래 파일명
        return String.format("%s : %s", file.getContentType(), file.getOriginalFilename());
    }

    // JSON Body 받기: Postman에서 Body → raw → JSON 선택
    // 데이터를 Body로 보낼 땐 GET 대신 POST 사용 권장
    @PostMapping("/json")
    public String json(@RequestBody QueryRequestDTO queryRequestDTO) {
        return String.format("json= %d : %s", queryRequestDTO.id(), queryRequestDTO.name());
    }

    // Query Parameter 방식
    // - 어노테이션X, DTO 객체 생성

    // Segment Parameter 방식
    // - @PathVariable: 각 키에 맞는 파라미터를 별도로 컨트롤러 파라미터로 생성
    // - @ModelAttribute : DTO객체 생성 을해서 이용

    // Form Data 방식
    // - @ModelAttribute : DTO 객체 또는 컨트롤러 파라미터

    // JSON 방식
    // - @RequestBody : DTO 객체

}
