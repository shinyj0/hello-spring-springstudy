package hello.hellospring.controller;
//어노테이션

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;
    //등록하고 쓰는게 좋음

    @Autowired  //연결시켜줄떄
    public MemberController(MemberService memberService) {

        this.memberService = memberService;
        System.out.println("memberService= " + memberService.getClass());
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";

    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }


    @GetMapping(value = "/members")
    public String list(Model model){
        List<Member> members =memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }


}
