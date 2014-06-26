package com.jelenhu.backend;

import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetBackgroundServlet
 */
@WebServlet("/GetBackgroundServlet")
public class GetBackgroundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBackgroundServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getOutputStream().println("http://formstone.it/files/demo/space.jpg");
		final File folder = new File("//home/jelen/public/photos/sfo");
		List<String> fileList = listFilesForFolder(folder);
		int filenum = fileList.size();
		String randomFileName = fileList.get((new Random()).nextInt(filenum));
		response.getOutputStream().println("/bg/sfo/"+randomFileName);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	public List<String> listFilesForFolder(final File folder) {
		List<String> imglist = new ArrayList<String>();
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry);
	        } else {
	        	imglist.add(fileEntry.getName());
	        }
	    }
	    return imglist;
	}
}
