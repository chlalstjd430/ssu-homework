package com.globalmedia.homework.service;

import com.globalmedia.homework.model.entity.Member;
import com.globalmedia.homework.model.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class MemberUpdateService {
    private final MemberRepository memberRepository;

    @Transactional
    public void update() {
        Member member = memberRepository.findMemberByIdentification("test");
        member.setName("updateName3");

        memberRepository.save(member);
        throw new IllegalArgumentException("test exception!");

    }

}
