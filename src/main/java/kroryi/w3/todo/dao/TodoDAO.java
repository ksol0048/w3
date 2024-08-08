package kroryi.w3.todo.dao;

import kroryi.w3.todo.vo.TodoVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoDAO {

    public void insert(TodoVO vo) throws SQLException {
        String sql = "INSERT INTO tbl_todo (title, dueDate,finished) VALUES (?, ?, ?)";
        Connection conn = ConnectionUtil.INSTANCE.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, vo.getTitle());
        ps.setDate(2, Date.valueOf(vo.getDueDate()));
        ps.setBoolean(3, vo.isFinished());
        ps.executeUpdate();

    }

    public List<TodoVO> selectAll() throws SQLException {
        String sql = "SELECT * FROM tbl_todo";
        Connection connection = ConnectionUtil.INSTANCE.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();

        List<TodoVO> list = new ArrayList<TodoVO>();
        while (resultSet.next()) {
            TodoVO vo = TodoVO.builder()
                    .tno(resultSet.getLong("tno"))
                    .title(resultSet.getString("title"))
                    .dueDate(resultSet.getDate("dueDate").toLocalDate())
                    .finished(resultSet.getBoolean("finished"))
                    .build();

            list.add(vo);
        }
        return list;
    }

    public TodoVO selectOne(long tno) throws SQLException {
        String sql = "SELECT * FROM tbl_todo WHERE tno = ?";

        Connection connection = ConnectionUtil.INSTANCE.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setLong(1, tno);
        ResultSet resultSet = ps.executeQuery();
        resultSet.next();
        TodoVO vo =TodoVO.builder()
                .tno(resultSet.getLong("tno"))
                .title(resultSet.getString("title"))
                .dueDate(resultSet.getDate("dueDate").toLocalDate())
                .finished(resultSet.getBoolean("finished"))
                .build();
        return vo;
    }

    public void deleteOne(long tno) throws SQLException {
        String sql = "DELETE FROM tbl_todo WHERE tno = ?";
        Connection connection = ConnectionUtil.INSTANCE.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setLong(1, tno);
        ps.executeUpdate();

    }

    public void updateOne(TodoVO vo) throws SQLException {
        String sql = "UPDATE tbl_todo SET title = ?, dueDate = ?, finished=? WHERE tno = ?";

        Connection connection = ConnectionUtil.INSTANCE.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, vo.getTitle());
        ps.setDate(2, Date.valueOf(vo.getDueDate()));
        ps.setBoolean(3, vo.isFinished());
        ps.setLong(4, vo.getTno());
        ps.executeUpdate();
    }

    public String getTime() throws SQLException {
        String now = null;
        try (Connection connection = ConnectionUtil.INSTANCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("select now()");
             ResultSet rs = ps.executeQuery();
        ) {
            rs.next();
            now = rs.getString(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }
}
