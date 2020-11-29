package com.globalmedia.homework.controller;

import com.globalmedia.homework.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/test")
    public void test() {
        memberService.insert();
    }
}
