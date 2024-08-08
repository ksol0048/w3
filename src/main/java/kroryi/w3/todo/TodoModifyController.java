package kroryi.w3.todo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kroryi.w3.todo.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Log4j2
@WebServlet(name = "TodoModifyController", urlPatterns = "/todo/modify")
public class TodoModifyController extends HttpServlet {

private TodoService todoService=TodoService.INSTANCE;
private final DateTimeFormatter Date_formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long tno = Long.parseLong(request.getParameter("tno"));
            TodoDTO todoDTO = todoService.get(tno);
            request.setAttribute("dto", todoDTO);
            request.getRequestDispatcher("/todo/modify.jsp").forward(request, response);
        }catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("수정하기전 데이터 가죠오기 실패");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String finishedStr = request.getParameter("finished");

        log.info("finished:{}", finishedStr);
        TodoDTO todoDTO = TodoDTO.builder()
                .tno(Long.parseLong(request.getParameter("tno")))
                .title(request.getParameter("title"))
                .dueDate(LocalDate.parse(request.getParameter("dueDate")))
                .finished(finishedStr != null && finishedStr.equals("on"))
                .build();

        log.info("/todo/modify POST....");
        log.info(todoDTO);
        try {
            todoService.modify(todoDTO);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("수정하기전 데이터 가죠오기 실패");
        }
        response.sendRedirect("/todo/list");
    }
}
