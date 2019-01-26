package com.hellojava.dao.impl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.hellojava.dao.IUserDao;
import com.hellojava.entity.UserView;
@Repository("userDao")
public class UserDao extends JdbcDaoSupport implements IUserDao {
	@Autowired
	private void initDataSource(DataSource dataSource) {
		setDataSource(dataSource);
	}
	public UserView query(UserView userView) {
		
		return this.getJdbcTemplate().query(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
							String sql="select * from users where userName=? and userPass=password(?)";
							PreparedStatement pre=con.prepareStatement(sql);
							pre.setObject(1, userView.getUserName());
							pre.setObject(2, userView.getUserPass());
							
				return pre;
			}
		}, new ResultSetExtractor<UserView>() {
			public UserView extractData(ResultSet rs) throws SQLException, DataAccessException {
				UserView user=null;
				if(rs.next()) {
					user=new UserView();
					user.setUserName(rs.getString("userName"));
					user.setUserPass(rs.getString("userPass"));
				}
				return user;
			}
		});
	}
	
}
