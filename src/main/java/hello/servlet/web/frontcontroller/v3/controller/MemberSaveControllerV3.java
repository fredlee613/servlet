package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.domain.Member.Member;
import hello.servlet.domain.Member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));
        Member savedMember = memberRepository.save(new Member(username, age));

        ModelView mv = new ModelView("save-result");
        mv.getModel().put("member", savedMember);

        return mv;
    }
}
