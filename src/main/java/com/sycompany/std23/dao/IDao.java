package com.sycompany.std23.dao;

import java.util.ArrayList;

import com.sycompany.std23.dto.ContentDto;

public interface IDao {

	public void deleteDao(String mid);	 // 글 삭제 (글을 삭제하고 알려주는 것)
	
	public void writeDao(String mwriter, String mcontent);  // 글 작성 (글을 넣어주는 것)
	
	public ArrayList<ContentDto> listDao();   // 글 리스트 (가져와서 보여주는 것)
	
}
