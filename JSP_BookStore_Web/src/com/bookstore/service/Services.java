package com.bookstore.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.service.admin.BookAddDo;
import com.bookstore.service.admin.BookAddForm;
import com.bookstore.service.admin.BookDeleteDo;
import com.bookstore.service.admin.BookInfo;
import com.bookstore.service.admin.BookList;
import com.bookstore.service.admin.BookModifyDo;
import com.bookstore.service.member.CartAddDo;
import com.bookstore.service.member.CartDelDo;
import com.bookstore.service.member.CartList;
import com.bookstore.service.member.CartNowBuyDo;
import com.bookstore.service.member.CartsDelDo;
import com.bookstore.service.member.CheckIdDo;
import com.bookstore.service.member.EmailCheck;
import com.bookstore.service.member.LoginDo;
import com.bookstore.service.member.LogoutDo;
import com.bookstore.service.member.MainDo;
import com.bookstore.service.member.OrderList;
import com.bookstore.service.member.SignUpDo;

public class Services {
	private static Services instance = new Services();
	public static Services getInstance() {return instance;}
	
	private Services() {}
	
	// Member 서비스
	public void runMemberService(HttpServletRequest request, HttpServletResponse response, int code) throws ServletException, IOException {
		Service service = null;
		
		switch(code) {
		case Code.MAIN_DO:
			service = new MainDo(); break;
		case Code.LOGIN:
			service = new LoginDo(); break;
		case Code.LOGOUT:
			service = new LogoutDo(); break;
		case Code.CHECK_ID:
			service = new CheckIdDo(); break;
		case Code.SIGNUP:
			service = new SignUpDo(); break;
		case Code.EMAILCHECK:
			service = new EmailCheck(); break;
		case Code.BOOOK_LIST:
			service = new com.bookstore.service.member.BookList(); break;
		case Code.BOOOK_INFO:
			service = new com.bookstore.service.member.BookInfo(); break;
		case Code.CART_ADD_DO:
			service = new CartAddDo(); break;
		case Code.CART_LIST:
			service = new CartList(); break;
		case Code.CART_DEL_DO:
			service = new CartDelDo(); break;
		case Code.CARTS_DEL_DO:
			service = new CartsDelDo(); break;
		case Code.CART_BUY:
			service = new CartNowBuyDo(); break;
		case Code.MEMBER_ORDER:
			service = new OrderList(); break;
		}
		service.run(request, response);
	}
	
	public void runAdminService(HttpServletRequest request, HttpServletResponse response, int code) throws ServletException, IOException {
		Service service = null;
		
		switch(code) {
		case Code.ADMIN_LOGIN:
			service = new com.bookstore.service.admin.LoginDo(); break;
		case Code.BOOOK_LIST:
			service = new BookList(); break;
		case Code.BOOOK_INFO:
			service = new BookInfo(); break;
		case Code.ADMIN_BOOK_ADD_FROM:
			service = new BookAddForm(); break;
		case Code.ADMIN_BOOK_ADD_DO:
			service = new BookAddDo(); break;
		case Code.ADMIN_BOOK_MODIFY_DO:
			service = new BookModifyDo(); break;
		case Code.ADMIN_BOOK_DELETE_DO:
			service = new BookDeleteDo(); break;
		}
		
		service.run(request, response);
	}
}