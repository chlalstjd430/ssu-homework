package com.globalmedia.homework.service;

import com.globalmedia.homework.model.entity.Member;
import com.globalmedia.homework.model.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberUpdateService memberUpdateService;

    public void insert() {
        memberUpdateService.update();


    }


}
