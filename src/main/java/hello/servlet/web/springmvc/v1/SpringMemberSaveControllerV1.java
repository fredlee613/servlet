package hello.servlet.web.springmvc.v1;

import hello.servlet.domain.Member.Member;
import hello.servlet.domain.Member.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringMemberSaveControllerV1 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/springmvc/v1/members/save")
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member savedMember = new Member(username, age);
        memberRepository.save(savedMember);

        ModelAndView mav = new ModelAndView("save-result");
        mav.addObject("member", savedMember);

        return mav;
    }
}
