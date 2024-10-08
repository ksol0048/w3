package kroryi.w3.todo.vo;

import lombok.*;

import java.time.LocalDate;

@Builder
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TodoVO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
