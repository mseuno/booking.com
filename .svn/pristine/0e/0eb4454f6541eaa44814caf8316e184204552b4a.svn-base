package com.epam.lab.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public abstract class DispatcherController implements Controller {

	private static final Logger LOG = Logger
			.getLogger(DispatcherController.class);

	{
		PropertyConfigurator.configure(getClass().getResourceAsStream(
				"/config/log4j.properties"));
	}

	public void forward(String URL, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher(URL).forward(request, response);
	}

	public void redirect(String URL, HttpServletResponse response,
			ServletContext context) throws IOException {
		response.sendRedirect(URL);
	}

	protected Long toLong(Object obj) {

		long res = -1;
		try {
			if (obj != null) {
				res = Long.parseLong(obj.toString().trim());
			}
		} catch (NumberFormatException e) {
			LOG.error(e.getMessage());
			// e.printStackTrace();
		}
		return res;
	}

	protected Integer toInt(Object obj) {

		int res = -1;
		try {
			if (obj != null) {
				res = Integer.parseInt(obj.toString().trim());
			}
		} catch (NumberFormatException e) {
			LOG.error(e.getMessage());
			// e.printStackTrace();
		}
		return res;
	}
}
