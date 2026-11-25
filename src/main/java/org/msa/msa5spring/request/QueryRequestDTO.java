package org.msa.msa5spring.request;

public record QueryRequestDTO(
        //1번째 ID : PK의 데이터타입에 따라서 다름 현재는 long객체 사용
        Long id,
        // 2번째 name
        String name
        //인텔리지와 포스트맨의 파라미터와 key가 이름이 같아야함!!

) {
}
