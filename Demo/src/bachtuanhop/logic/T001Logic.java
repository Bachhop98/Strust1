package bachtuanhop.logic;

import bachtuanhop.actionForm.T001ActionForm;
import bachtuanhop.dao.T001DAO;

public class T001Logic {
	T001DAO t001DAO = new T001DAO();
	T001ActionForm t001Form = new T001ActionForm();

	public boolean checkUserIdPassword(String userId, String password) {
		try {
			if (t001DAO.count(userId, password) == 1) {
				return true;
			}

		} catch (Exception e) {

		}
		return false;
	}

	public String getUserName(String userId, String password) {
		return t001DAO.getUserName(userId, password);

	}

}
