package com.jelenhu.backend;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetThemeDescription
 */
public class GetThemeDescriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetThemeDescriptionServlet() {
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
		String fileName = path+theme+"/content.properties";
		InputStream fileStream = new FileInputStream(fileName);
		InputStreamReader sReader = new InputStreamReader(fileStream, "UTF-8");
		Properties themeConfig = new Properties();
		themeConfig.load(sReader);
	
		response.setHeader("content-type","text/html;charset=UTF-8");
		PrintWriter responseWriter = response.getWriter();
		responseWriter.println(themeConfig.getProperty("ThemeName") + "$$" + themeConfig.getProperty("ThemeDescription"));
	}

}
