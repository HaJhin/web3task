package task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import task.model.dto.MemberDto;
import task.service.MemberService;

import java.util.ArrayList;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/write.do")
    public boolean write(@RequestBody MemberDto memberDto) {
        boolean result = memberService.write(memberDto);
        return result;
    } // f ed

    @GetMapping("list.do")
    public ArrayList<MemberDto> list() {
        ArrayList<MemberDto> result = memberService.list();
        return result;
    } // f ed
}
