package com.base.cafe.model.dto;

import com.base.cafe.model.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MemberDto {
    String memberId;
    String password;
    String nickname;

    /**
     * TODO: modelMapper 로 변경
     * @return
     */
    public Member toEntity() {
        Member member = new Member();
        member.setMemberId(memberId);
        member.setPassword(password);
        member.setNickname(nickname);
        return member;
    }
}
