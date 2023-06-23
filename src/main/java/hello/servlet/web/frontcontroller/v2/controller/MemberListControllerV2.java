package hello.servlet.web.frontcontroller.v2.controller;

import hello.servlet.domain.Member.Member;
import hello.servlet.domain.Member.MemberRepository;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberListControllerV2 implements ControllerV2 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("members", memberRepository.findAll());

        return new MyView("/WEB-INF/views/members.jsp");
    }
}
