package bachtuanhop.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import bachtuanhop.constant.Constant;
import bachtuanhop.logic.T002Logic;

public class T003Action extends Action {
	T002Logic t002Logic = new T002Logic();
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//int id = Integer.valueOf(request.getParameter("id"));
		return  mapping.findForward(Constant.SUCCESS);
	}
}
