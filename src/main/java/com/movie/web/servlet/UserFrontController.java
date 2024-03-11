package com.movie.web.servlet;

import java.io.IOException;

import com.movie.web.action.ActionForward;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("*.ms")
public class UserFrontController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);
	}
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		ActionForward forward = null;
		
		switch (requestURI) {
		case "/SubmitOk.ms" : 
			forward = new SubmitOkAction().execute(req ,resp);
			break;
		case "/movie/mypage.ms" : 
			forward = new MoveMypage().execute(req ,resp);
			break;
		case "/movie/checkId.ms" : 
			forward = new CheckIdAction().execute(req ,resp);
		case "/movie/joinOk.ms" :
			forward = new JoinOkAction().execute(req ,resp);
			break;
		case "/movie/logout.ms" : 
			forward = new LogOutAction().execute(req ,resp);
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {		// Redirect 방식
				resp.sendRedirect(forward.getPath());
			}else {							// forward 방식
				req.getRequestDispatcher(forward.getPath()).forward(req, resp);
			}
		}
	}
	}
