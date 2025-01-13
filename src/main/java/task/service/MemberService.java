package task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.model.dao.MemberDao;
import task.model.dto.MemberDto;

import java.util.ArrayList;

@Service
public class MemberService {
    @Autowired
    private MemberDao memberDao;

    public boolean write(MemberDto memberDto) {
        boolean result = memberDao.write(memberDto);
        return result;
    } // f ed

    public ArrayList<MemberDto> list() {
        ArrayList<MemberDto> result = memberDao.list();
        return result;
    }
}
