package com.worldchurch.webproject.model.repository;

import com.worldchurch.webproject.model.entity.UserInfo;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

@Repository
public class JdbcUserRepository implements UserRepository {
    private final DataSource dataSource;
    private UserInfo userInfo;

    public JdbcUserRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public UserInfo save(UserInfo userInfo) {
        String sql = "insert into UserInfo(userId, password, name, email, phoneNo, birthDt) values (?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DataSourceUtils.getConnection(dataSource);
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, userInfo.getUserId());
            pstmt.setString(2, userInfo.getPassword());
            pstmt.setString(3, userInfo.getName());
            pstmt.setString(4, userInfo.getEmail());
            pstmt.setString(5, userInfo.getPhoneNo());
            pstmt.setString(6, userInfo.getBirthDt());

            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();

            if (rs.next()) {
                //id 정보 추가?
                userInfo.setId(rs.getLong(1));
            } else {
                //Exception이 발생하면 어떻게 처리해야 하는지?
                throw new SQLException("저장 실패");
            }
        } catch (Exception e) {

        } finally {
            close(conn, pstmt, rs);
        }

        return userInfo;
    }

    @Override
    public UserInfo findByUserId(String userId) {
        //userInfo 초기화?

        String sql = "select userId, password, name, email, phoneNo, birthDt from UserInfo where userId = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DataSourceUtils.getConnection(dataSource);
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, userId);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                userInfo.setUserId(rs.getString("userId"));
                userInfo.setPassword(rs.getString("password"));
                userInfo.setName(rs.getString("name"));
                userInfo.setEmail(rs.getString("email"));
                userInfo.setPhoneNo(rs.getString("phoneNo"));
                userInfo.setBirthDt(rs.getString("birthDt"));

            } else {
                throw new SQLException("조회 실패");
            }
        } catch (Exception e) {

        } finally {
            close(conn, pstmt, rs);
        }

        return userInfo;
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
