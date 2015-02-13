package com.epam.lab.tags;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class PrintTag extends TagSupport {

	private static final long serialVersionUID = 4828588070487726349L;

	private String forPrint = null;
	private String key = null;
	private ResourceBundle bundle = null;

	@Override
	public int doStartTag() throws JspException {

		try {

			bundle = (ResourceBundle) pageContext.getSession().getAttribute(
					"ResourceBundle");
			forPrint = bundle.getString(key);

		} catch (Exception e) {

		}

		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {

		try {
			pageContext.getOut().print(forPrint);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SKIP_BODY;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
