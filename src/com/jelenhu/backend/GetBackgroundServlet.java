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
public class GetBackgroundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBackgroundServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utility util = new Utility();
		HashMap<String, String> config = util.getConfig("config.properties");
		String path = config.get("BgImageHomePath");
		String theme = config.get("BackgroundTheme");
		String vdir = config.get("VirtualFolder");
		
		final File folder = new File(path + theme);
		List<String> imgFileList = getImgFileList(folder);
		int filenum = imgFileList.size();
		String randomFileName = imgFileList.get((new Random()).nextInt(filenum));
		response.getOutputStream().println(vdir + theme + "/"+randomFileName);
	}
	
	public List<String> getImgFileList(final File folder) {
		List<String> imglist = new ArrayList<String>();
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            getImgFileList(fileEntry);
	        } 
	        else {
	        	imglist.add(fileEntry.getName());
	        }
	    }
	    
	    imglist.remove("content.properties");
	    return imglist;
	}

}
