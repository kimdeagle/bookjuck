package com.test.bookjuck.admin.statistics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bookjuck.dao.StatisticsBarDAO;
import com.test.bookjuck.dao.StatisticsPiDAO;
import com.test.bookjuck.dto.StatisticsBarDTO;
import com.test.bookjuck.dto.StatisticsPiDTO;

@WebServlet("/admin/statistics/statistics.do")
public class statistics extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

		
		  String yearStart = request.getParameter("yearStart");
	      String monthStart = request.getParameter("monthStart");
	      String dayStart = request.getParameter("dayStart");
	      
	      
	      String yearEnd = request.getParameter("yearEnd");
	      String monthEnd = request.getParameter("monthEnd");
	      String dayEnd = request.getParameter("dayEnd");
		
	      HashMap<String,String> map = new HashMap<String,String>();
	      
	      map.put("yearStart", yearStart);
	      map.put("monthStart", monthStart);
	      map.put("dayStart", dayStart);
	      map.put("yearEnd", yearEnd);
	      map.put("monthEnd", monthEnd);
	      map.put("dayEnd", dayEnd);
	      
	      ArrayList<StatisticsBarDTO> list1 = new ArrayList<StatisticsBarDTO>();  
	      ArrayList<StatisticsBarDTO> list2 = new ArrayList<StatisticsBarDTO>();  
	      ArrayList<StatisticsBarDTO> list3 = new ArrayList<StatisticsBarDTO>();  
	      ArrayList<StatisticsPiDTO> list4 = new ArrayList<StatisticsPiDTO>();
	      ArrayList<StatisticsPiDTO> list5 = new ArrayList<StatisticsPiDTO>();
	  
	      
	      
	      if (!(yearStart == null || yearStart.equals("")) 
	              && !(monthStart == null || monthStart.equals(""))
	              && !(dayStart == null || dayStart.equals(""))
	              && !(yearEnd == null || yearEnd.equals(""))
	              && !(monthEnd == null || monthEnd.equals(""))
	              && !(dayEnd == null || dayEnd.equals("")))  
	        {
	           
	    	  StatisticsBarDAO dao = new StatisticsBarDAO();
	          list1 = dao.getBookStat(map);//막대그래프
	          list2 = dao.getEBookStat(map);
	          list3 = dao.getBaroBookStat(map);
	          
	          StatisticsPiDAO dao2 = new StatisticsPiDAO();
	          list4 = dao2.getAgeCnt(map);//원형그래프
	          list5 = dao2.getGenderCnt(map);
	          
	                 
	          request.setAttribute("yearStart", yearStart);
	          request.setAttribute("monthStart", monthStart);
	          request.setAttribute("dayStart", dayStart);
	          request.setAttribute("yearEnd", yearEnd);
	          request.setAttribute("monthEnd", monthEnd);
	          request.setAttribute("dayEnd", dayEnd);
	         
	          request.setAttribute("list1", list1);
	          request.setAttribute("list2", list2);
			  request.setAttribute("list3", list3);
			  request.setAttribute("list4", list4);
			  request.setAttribute("list5", list5);
	          
	              
	        } else {
	        	
	        	StatisticsBarDAO dao = new StatisticsBarDAO();
		        list1 = dao.defBookStat();
		        list2 = dao.defEBookStat();
		        list3 = dao.defBaroBookStat();
		        
		        StatisticsPiDAO dao2 = new StatisticsPiDAO();
		        list4 = dao2.defaultGetAgeCnt();
		        list5 = dao2.defaultGetGenderCnt();
		        
		        
	        	
	        	
		        request.setAttribute("list1", list1);
		        request.setAttribute("list2", list2);
				request.setAttribute("list3", list3);
				request.setAttribute("list4", list4);
				request.setAttribute("list5", list5);
	        	
	        }
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/admin/statistics/statistics.jsp");
		dispatcher.forward(request, resp);

	}

}

