package org.msa.msa5spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestMappingController {
    //유저가 요청한 메소드를 만들거임
    // GET/users로 들어왓을경우
    //리퀘스트 맵핑만 볼거임
    @GetMapping("/users")
    public String index(){
        return "유저 조회";
    }


    //포스트맨으로 맵핑 하고싶을때
    @PostMapping("/users/1")
    public String store(){
        return "유저 생성";
    }
    //현재 맵핑을 안해서 안뜨는거임
}
