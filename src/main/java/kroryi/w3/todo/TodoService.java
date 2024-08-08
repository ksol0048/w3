package kroryi.w3.todo;

import kroryi.w3.todo.dao.TodoDAO;
import kroryi.w3.todo.dto.TodoDTO;
import kroryi.w3.todo.util.MapperUtil;
import kroryi.w3.todo.vo.TodoVO;
import org.modelmapper.ModelMapper;
import lombok.extern.log4j.Log4j2;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2
public enum TodoService {
    INSTANCE;

    private TodoDAO dao;
    private ModelMapper modelmapper;

    TodoService() {
        dao = new TodoDAO();
        modelmapper = MapperUtil.INSTANCE.get();
    }

    public void register(TodoDTO todoDTO) throws SQLException {
//        System.out.println("register: " + todoDTO);

        TodoVO todoVO = modelmapper.map(todoDTO, TodoVO.class);
        log.info("등록합니다. todo: {}", todoVO);
        dao.insert(todoVO);

        //만약 필드 명이 다르면
        /*UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

        @Mapping(source = "firstName", target = "givenName")
        @Mapping(source = "lastName", target = "familyName")
        UserVO dtoToVo(UserDTO userDTO);

        @Mapping(source = "givenName", target = "firstName")
        @Mapping(source = "familyName", target = "lastName")
        UserDTO voToDto(UserVO userVO);*/
    }

    public List<TodoDTO> listAll() throws SQLException {
        List<TodoVO> voList = dao.selectAll();
        List<TodoDTO> dtoList = voList.stream().map(vo -> modelmapper.map(vo, TodoDTO.class)).collect(Collectors.toList());
        return dtoList;
    }

    public List<TodoDTO> getList() {
        List<TodoDTO> todoDTOS = IntStream.range(0, 10).mapToObj(i -> {
            TodoDTO dto = new TodoDTO();
            dto.setTno((long) i);
            dto.setTitle("Todo.." + i);
            dto.setDueDate(LocalDate.now());
            return dto;
        }).collect(Collectors.toList());
        return todoDTOS;
    }

    public TodoDTO get(Long tno) throws SQLException {
        log.info("tno:{}", tno);
        TodoVO todoVo = dao.selectOne(tno);
        return modelmapper.map(todoVo, TodoDTO.class);
    }

    public void modify(TodoDTO todoDTO) throws SQLException {
        log.info("todoDTO:{}", todoDTO);
        TodoVO todoVO = modelmapper.map(todoDTO, TodoVO.class);
        dao.updateOne(todoVO);
    }

    public void remove(Long tno) throws SQLException {
        log.info("삭제할 번호: {}",tno);
        dao.deleteOne(tno);
    }
}
