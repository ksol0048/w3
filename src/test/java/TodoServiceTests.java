import kroryi.w3.todo.TodoService;
import kroryi.w3.todo.dto.TodoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;

public class TodoServiceTests {
    private TodoService todoService;

    @BeforeEach
    public void ready() {
        todoService=TodoService.INSTANCE;
    }

    @Test
    public void testRegister() throws SQLException {
        TodoDTO todoDTO= TodoDTO.builder()
                .title("JDBC Test Title")
                .dueDate(LocalDate.now())
                .build();

        todoService.register(todoDTO);
    }
}
