package bachtuanhop.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import bachtuanhop.actionForm.T001ActionForm;
import bachtuanhop.constant.Constant;
import bachtuanhop.logic.T001Logic;

public class T001Action extends Action {
	T001Logic t001Logic = new T001Logic();

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		T001ActionForm t001Form = (T001ActionForm) form;
		String userId = t001Form.getUserId();
		String password = t001Form.getPassword();
		boolean check = t001Logic.checkUserIdPassword(userId, password);
		String userName = "";
		if (check == false) {
			ActionErrors er = new ActionErrors();
			er.add("",new ActionMessage(Constant.ERROR_USERID_PASS_INCORRECT,Constant.USERID,Constant.PASSWORD));
			saveErrors(request, er);
			return mapping.getInputForward();
		} else
		session.setAttribute(Constant.USERID, userId);
		session.setAttribute(Constant.PASSWORD, password);
		userName = t001Logic.getUserName(userId, password);
		request.setAttribute(Constant.USERNAME, userName);
		
		return mapping.findForward(Constant.SUCCESS);

	}
}
