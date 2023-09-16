package hello.hellospring.controller;
//어노테이션

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;
    //등록하고 쓰는게 좋음

    @Autowired  //연결시켜줄떄
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
