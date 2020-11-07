package com.globalmedia.homework.controller;

import com.globalmedia.homework.model.entity.Member;
import com.globalmedia.homework.model.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class IndexController {
    private final MemberRepository memberRepository;

    @GetMapping("/")
    public String getMemberForm(Model model) {
        return "main";
    }

    @GetMapping("/members/{identification}/info")
    public String getMemberInfo(Model model, @PathVariable String identification) {

        System.out.println("testetstes");

        model.addAttribute("member", memberRepository.findMemberByIdentification(identification));
        return "memberInfo";
    }

    @PostMapping("/sign-up")
    @ResponseBody
    public ModelAndView signUp(String identification, String password, String name) {
        System.out.println(identification + ", " + password + ", " + name);

        Member member = Member.builder()
                .identification(identification)
                .password(password)
                .name(name)
                .build();

        memberRepository.save(member);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("member", member);


        modelAndView.setViewName("memberInfo");

        return modelAndView;
    }
}
