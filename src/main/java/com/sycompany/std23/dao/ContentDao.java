package com.sycompany.std23.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.sycompany.std23.dto.ContentDto;



public class ContentDao implements IDao{

	JdbcTemplate template;   // DB의 모든 데이터에 접속하고 잇음, 

	@Autowired //컨테이너에 저장된 패키지를 자동으로 가져옴
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public void deleteDao(final String mid) {
		
		this.template.update(new PreparedStatementCreator() {
		
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			String sql="DELETE From board WHERE mid = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
	
			pstmt.setString(1, mid);
			
			return pstmt;
		}
	});
		
	}

	@Override
	public void writeDao(final String mwriter, final String mcontent) {
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql="INSERTE INTO board(mid, mwriter, mcontent) VALUES(BOARD_SEQ.nextval, ?, ?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, mwriter);
				pstmt.setString(2, mcontent);
				
				return pstmt;
			}
		});
		
		
	}

	@Override
	public ArrayList<ContentDto> listDao() {
		String sql = "SELECT * From board ORDER BY mid DESC";  //게시판 번호 내림차순(최근글이 가장 위로)
		
		ArrayList<ContentDto> dtos = (ArrayList<ContentDto>) template.query(sql, new BeanPropertyRowMapper(ContentDto.class));
		
		return dtos;
	}
	
	
	
}
