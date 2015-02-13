package com.epam.lab.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.epam.lab.dao.impl.ManagerDao;
import com.epam.lab.dao.impl.ManagerMessageDao;
import com.epam.lab.dao.mapping.Mapping;
import com.epam.lab.exceptions.DuplicateUniqueKeyException;
import com.epam.lab.model.Manager;
import com.epam.lab.model.helper.ManagerMessage;

public class ManagerService {

	private static final Logger LOG = Logger.getLogger(Mapping.class);

	{
		PropertyConfigurator.configure(getClass().getResourceAsStream(
				"/config/log4j.properties"));
	}
	private ManagerMessageDao managerMessageDao = new ManagerMessageDao();
	private ManagerDao daoManager = new ManagerDao();

	public Manager selectManagerByEmailAndPassword(String email, String password) {
		return daoManager.readByEmailAndPassword(email, password);
	}

	public String registerNewManager(Manager manager) {
		String result = null;
		try {
			manager.setId(daoManager.registerNewManager(manager));
		} catch (DuplicateUniqueKeyException e) {
			result = "Manager with such email exist!";
			LOG.warn(result);
		}
		return result;
	}

	public List<Manager> getNewApplications(String language) {
		return daoManager.getNewApplications(language);
	}

	public void update(Manager manager) {
		daoManager.update(manager);
	}

	public void sendRequest(ManagerMessage message) {
		new ManagerMessageDao().create(message);
	}

	public List<ManagerMessage> getImportantSendMessage(int send, int important) {
		return managerMessageDao.getImportantSendMessage(send, important);
	}

	public List<ManagerMessage> getMessageByStatus(int status) {
		return managerMessageDao.getMessageByStatus(status);
	}

}
