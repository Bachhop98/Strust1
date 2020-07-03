package bachtuanhop.actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class T001ActionForm extends ActionForm {

	private static final long serialVersionUID = 1L;
	private String userId;
	private String password;
	
	public T001ActionForm() {
	}

	public T001ActionForm(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (("".equals(userId)) && ("".equals(password))) {
			errors.add("", new ActionMessage("errors.invalid.userid.password","userId","password"));
		}
		if ("".equals(userId)) {
			errors.add("", new ActionMessage("errors.invalid","userId"));
		}
		if ("".equals(password)) {
			errors.add("", new ActionMessage("errors.invalid","password"));
		}
		return errors;
	}
	/*
	 * @Override public void reset(ActionMapping mapping, HttpServletRequest
	 * request) { super.reset(mapping, request); userId = ""; password = ""; }
	 */
}
