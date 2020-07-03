package bachtuanhop.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import bachtuanhop.actionForm.T002ActionForm;
import bachtuanhop.constant.Constant;
import bachtuanhop.logic.T002Logic;

public class T002Action extends Action {
	T002Logic t002Logic = new T002Logic();

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		T002ActionForm t002Form = (T002ActionForm) form;
		request.getAttribute("page");
		int page = t002Form.getPage();
		request.setAttribute("page", page);
		if ("first".equals(t002Form.getAction())) {
			t002Form.setPage(1);
			page = t002Form.getPage();
			t002Form.setListCustomer(t002Logic.viewAll(page).getListCustomer());
			return mapping.findForward(Constant.SUCCESS);
		} else if ("pre".equals(t002Form.getAction())) {
			page = t002Form.getPage();
			t002Form.setPage(page - 1);
			page = t002Form.getPage();
			t002Form.setListCustomer(t002Logic.viewAll(page).getListCustomer());
			return mapping.findForward(Constant.SUCCESS);
		} else if ("next".equals(t002Form.getAction())) {
			page = t002Form.getPage();
			t002Form.setPage(page + 1);
			page = t002Form.getPage();
			t002Form.setListCustomer(t002Logic.viewAll(page).getListCustomer());
			return mapping.findForward(Constant.SUCCESS);

		} else if ("last".equals(t002Form.getAction())) {
			t002Form.setPage(t002Logic.totalPage());
			page = t002Form.getPage();
			t002Form.setListCustomer(t002Logic.viewAll(page).getListCustomer());
			return mapping.findForward(Constant.SUCCESS);

		} else if ("search".equals(t002Form.getAction())) {

			return mapping.findForward(Constant.SEARCH);

		} else if ("delete".equals(t002Form.getAction())) {

			return mapping.findForward(Constant.DELETE);

		} else {
			t002Form.setListCustomer(t002Logic.viewAll(page).getListCustomer());
			return mapping.findForward(Constant.SUCCESS);
		}

	}

	/*
	 * public ActionForward searchUser(ActionMapping mapping, ActionForm form,
	 * HttpServletRequest request, HttpServletResponse response) throws Exception {
	 * return mapping.findForward(Constant.SEARCH);
	 * 
	 * }
	 * 
	 * public ActionForward deleteUser(ActionMapping mapping, ActionForm form,
	 * HttpServletRequest request, HttpServletResponse response) throws Exception {
	 * return mapping.findForward(Constant.DELETE);
	 * 
	 * }
	 */
}
