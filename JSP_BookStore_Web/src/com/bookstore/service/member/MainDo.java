package com.bookstore.service.member;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.Impl.SharedDaoImpl;
import com.bookstore.model.BoardVO;
import com.bookstore.model.Category;
import com.bookstore.service.Service;

public class MainDo implements Service{

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<BoardVO> newBookList = null;
		ArrayList<BoardVO> hotBookList = null;
		ArrayList<Category> categorys = null;
		ArrayList<Category> parentCategorys = new ArrayList<Category>();
		ArrayList<Category> childCategorys = new ArrayList<Category>();
		
		
		SharedDaoImpl dao = new SharedDaoImpl();
		
		try {
			newBookList = dao.getNewBooks();
			hotBookList = dao.getHotBooks();
			categorys = dao.getCategorys();
			
			for(Category category : categorys) {
				if(category.getLevel() == 1) {
					parentCategorys.add(category);
				}else
					childCategorys.add(category);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("parentCategorys", parentCategorys);
		request.setAttribute("childCategorys", childCategorys);
		request.setAttribute("hotBooks", hotBookList);
		request.setAttribute("newBooks", newBookList);
	}
	
}
