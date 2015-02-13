package com.epam.lab.model.helper;

import java.sql.Timestamp;

import com.epam.lab.dao.annotations.Column;
import com.epam.lab.dao.annotations.Id;
import com.epam.lab.dao.annotations.Table;

@Table(name = "manager_message")
public class ManagerMessage {

	@Id
	@Column(name = "manager_message.id")
	private Long id;

	@Column(name = "manager_message.manager_id")
	private Long managerId;

	@Column(name = "manager_message.type")
	private Integer type;

	@Column(name = "manager_message.message")
	private String message;

	@Column(name = "manager_message.status")
	private Integer status;

	@Column(name = "manager_message.last_update")
	private Timestamp lastUpdate;

	public Long getId() {
		return id;
	}

	public Long getManagerId() {
		return managerId;
	}

	public Integer getType() {
		return type;
	}

	public String getMessage() {
		return message;
	}

	public Integer getStatus() {
		return status;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
