package kroryi.w3.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kroryi.w3.member.MemberService;
import kroryi.w3.member.dto.MemberDTO;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@WebServlet(name = "Login", urlPatterns = "/login")
@Log4j2
public class LoginController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("로그인 페이지...열기");
        request.getRequestDispatcher("/login/login.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        try {
            MemberDTO memberDTO = MemberService.INSTANCE.login(id, password);
            HttpSession session = request.getSession();
            if(id.equals(memberDTO.getMid())&&password.equals(memberDTO.getMpw())){
                session.setAttribute("loginInfo", memberDTO);
                response.sendRedirect("/todo/list");
            }else {
                throw new ServletException("아이디, 비번 확인하세요.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/login?result=error");
        }
    }
}
