package bachtuanhop.actionForm;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

public class T002ActionForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private String userName;
	private String customerName;
	private String sex;
	private String birthDayFrom;
	private String birthDayTo;
	private String email;
	private String action;
	private int page;
	private List<Customer> listCustomer;

	public T002ActionForm() {
		this.listCustomer = new ArrayList<Customer>();
		this.page = 1;
	}

	public T002ActionForm(String userName, String customerName, String sex, String birthDayFrom, String birthDayTo,
			String action, List<Customer> listCustomer) {
		super();
		this.userName = userName;
		this.customerName = customerName;
		this.sex = sex;
		this.birthDayFrom = birthDayFrom;
		this.birthDayTo = birthDayTo;
		this.action = action;
		this.listCustomer = listCustomer;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getBirthDayFrom() {
		return birthDayFrom;
	}

	public void setBirthDayFrom(String birthDayFrom) {
		this.birthDayFrom = birthDayFrom;
	}

	public String getBirthDayTo() {
		return birthDayTo;
	}

	public void setBirthDayTo(String birthDayTo) {
		this.birthDayTo = birthDayTo;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public List<Customer> getListCustomer() {
		return listCustomer;
	}

	public void setListCustomer(List<Customer> list) {
		this.listCustomer = list;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	

	/*
	 * @Override public ActionErrors validate(ActionMapping mapping,
	 * HttpServletRequest request) { ActionErrors errors = new ActionErrors();
	 * if(this.userId.length()==0){ errors.add("username", new
	 * ActionMessage("LoginActionForm.username.required")); }else
	 * if(this.password.length()==0){ errors.add("password", new
	 * ActionMessage("LoginActionForm.password.required")); } return errors; }
	 */

}
