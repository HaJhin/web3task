package task.model.dao;

import org.springframework.stereotype.Component;
import task.model.dto.MemberDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Component
public class MemberDao {
    private Connection conn;
    private String DBURL = "jdbc:mysql://localhost:3306/taskDB";
    private String DBUSER = "root";
    private String DBPWD = "6703";

    public MemberDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DBURL,DBUSER,DBPWD);
            System.out.println("[Connection Success");
        } catch (Exception e) {
            System.out.println(e);
        } // try-catch ed
    } // init ed

    public boolean write(MemberDto memberDto) {
        try {
            String sql = "insert into visitor(vphone,vcount)values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, memberDto.getVphone());
            ps.setInt(2, memberDto.getVcount());
            int count = ps.executeUpdate();
            if (count == 1) {return true;}
        } catch (Exception e) {
            System.out.println(e);
        } // try catch ed
        return false;
    } // f ed

    public ArrayList<MemberDto> list() {
        ArrayList<MemberDto> list = new ArrayList<>();
        try {
            String sql = "select * from visitor";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                MemberDto memberDto = MemberDto.builder()
                        .vno(rs.getInt("vno"))
                        .vphone(rs.getString("vphone"))
                        .vcount(rs.getInt("vcount"))
                        .build();

                list.add(memberDto);
            } // w ed
        } catch (Exception e) {
            System.out.println(e);
        } // try catch ed
        return list;
    } // f ed

}
