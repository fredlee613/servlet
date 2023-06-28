package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.Member.Member;
import hello.servlet.domain.Member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @GetMapping("/new-form")
    public String newForm() {
        return "new-form";
    }

    @PostMapping("/save")
    public String save(@RequestParam("username") String username, @RequestParam("age") int age, Model model) {
        Member savedMember = memberRepository.save(new Member(username, age));
        model.addAttribute("member", savedMember);
        return "save-result";
    }

    @GetMapping
    public String members(Model model) {
        model.addAttribute("members", memberRepository.findAll());
        return "members";
    }

}
