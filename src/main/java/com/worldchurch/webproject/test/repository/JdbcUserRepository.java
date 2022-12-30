package com.worldchurch.webproject.test.repository;

import com.worldchurch.webproject.test.dto.User;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Optional;

@Repository
public class JdbcUserRepository implements UserRepository{
    private final DataSource dataSource;
    private User user;

    public JdbcUserRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(User user) {
        String sql = "insert into User(userId, pwd, name) values (?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DataSourceUtils.getConnection(dataSource);
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getPwd());
            pstmt.setString(3, user.getName());

            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();

            if (rs.next()) {

            } else {
                throw new SQLException("저장 실패");
            }
        } catch (Exception e) {

        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public Optional<User> getUserByUserId(String userId) {
        String sql = "select userId, pwd, name from user where userId = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DataSourceUtils.getConnection(dataSource);
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, userId);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                user.setUserId(rs.getString("userId"));
                user.setPwd(rs.getString("pwd"));
                user.setName(rs.getString("name"));
            } else {
                throw new SQLException("저장 실패");
            }
        } catch (Exception e) {

        } finally {
            close(conn, pstmt, rs);
        }

        return Optional.of(user);
    }

    private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (conn != null) {
                close(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void close(Connection conn) throws SQLException {
        DataSourceUtils.releaseConnection(conn, dataSource);
    }
}
