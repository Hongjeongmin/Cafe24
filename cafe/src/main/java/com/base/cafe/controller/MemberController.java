package com.base.cafe.controller;

import com.base.cafe.model.dto.MemberDto;
import com.base.cafe.model.result.BaseResult;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    /**
     * login 관련 API 입니다.
     * @param loginRequest
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<BaseResult> login(@RequestBody LoginRequest loginRequest) {
//        MemberDto memberDto = loginRequest.toMemberDto();

        String secretKey;
        try {
            //TODO: 시크릿 키 생성
            secretKey = "cookie";
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok().body(BaseResult.isFail("로그인에 실패하였습니다."));
        }

        //TODO: cookie 저장.

        return ResponseEntity.ok().body(BaseResult.isSuccess("로그인에 성공하였습니다.").add("shawl_key", secretKey));
    }

    @Getter
    @Setter
    private class LoginRequest {
        @NotNull
        String memberId;
        @NotNull
        String password;

        MemberDto toMemberDto() {
            return MemberDto.builder()
                    .memberId(memberId)
                    .password(password)
                    .build();
        }
    }
}
