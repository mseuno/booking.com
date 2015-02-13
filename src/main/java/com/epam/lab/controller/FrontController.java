package com.epam.lab.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.epam.lab.controller.helper.FactoryController;

public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 2022651427006588913L;

	private static final Logger LOG = Logger.getLogger(FrontController.class);

	{
		PropertyConfigurator.configure(getClass().getResourceAsStream(
				"/config/log4j.properties"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		processGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		processPost(req, resp);

	}

	private void processGet(HttpServletRequest req, HttpServletResponse resp) {

		try {

			Controller controller = FactoryController.getController(req);
			controller.executeGet(getServletContext(), req, resp);

		} catch (Exception e) {

			e.printStackTrace();
			LOG.error(e.getMessage());

		}

	}

	private void processPost(HttpServletRequest req, HttpServletResponse resp) {

		try {

			Controller controller = FactoryController.getController(req);
			controller.executePost(getServletContext(), req, resp);

		} catch (Exception e) {

			e.printStackTrace();
			LOG.error(e.getMessage());

		}

	}

}
