import kroryi.w3.todo.dao.TodoDAO;
import kroryi.w3.todo.vo.TodoVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class TodoDAOTests {

    private TodoDAO todoDAO;
    @BeforeEach
    public void ready() {
        todoDAO = new TodoDAO();
    }

    @Test
    public void testTime() throws SQLException {
        System.out.println(todoDAO.getTime());
    }

    @Test
    public void insert() throws SQLException {
        TodoVO todoVO = TodoVO.builder()
                .title("샘플테이터....")
                .dueDate(LocalDate.of(2024,8,8))
                .build();

        todoDAO.insert(todoVO);
    }

    @Test
    public void testList() throws SQLException {
        List<TodoVO> list =todoDAO.selectAll();
        list.forEach(vo->
            System.out.println(vo));
    }

    @Test
    public void testSelectOne() throws SQLException {
        long tno =1;
        TodoVO todoVO = todoDAO.selectOne(tno);
        System.out.println(todoVO);
    }

    @Test
    public void testDelete() throws SQLException {
        long tno =1;
        todoDAO.deleteOne(tno);
    }

    @Test
    public void testUpdate() throws SQLException {
        TodoVO todoVO= TodoVO.builder()
                .tno(2L)
                .title("수정 진행중...")
                .dueDate(LocalDate.of(2024,8,8))
                .finished(true)
                .build();
        todoDAO.updateOne(todoVO);
    }
}
