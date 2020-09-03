package bachtuanhop.logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bachtuanhop.actionForm.Customer;
import bachtuanhop.actionForm.T002ActionForm;
import bachtuanhop.constant.Constant;
import bachtuanhop.dao.T002DAO;
import bachtuanhop.entity.T002Entity;

public class T002Logic {
	T002DAO t002Dao = new T002DAO();

	public T002ActionForm viewAll(int page) {

		int offset = (page - 1) * Constant.LIMIT;
		List<T002Entity> dtos = t002Dao.viewPage(offset, Constant.LIMIT);
		T002ActionForm actionForm = new T002ActionForm();
		actionForm.setListCustomer(new LinkedList<Customer>());

		for (T002Entity customerEntity : dtos) {
			customerEntity.setId(customerEntity.getId());
			customerEntity.setName(customerEntity.getName());
			customerEntity.setSex(customerEntity.getSex());
			customerEntity.setBirthDay(customerEntity.getBirthDay());
			customerEntity.setAddress(customerEntity.getAddress());
//			Customer customers = new Customer(String.valueOf(customerDTO.getId()), customerDTO.getName(),
//					customerDTO.getSex(), customerDTO.getBirthDay(), customerDTO.getAddress());
//			actionForm.getListCustomer().add(customerEntity);
		}

		return actionForm;

	}

	public String convert(String sex) {
		if (sex.equals(Constant.MALE)) {
			return Constant.ZERO;
		} else if (sex.equals(Constant.FEMALE)) {
			return Constant.ONE;
		}
		return null;

	}

	public void insert(T002Entity customer) {
		t002Dao.insert(customer);
	}

	public void update(T002Entity customer) {
		t002Dao.update(customer);
	}

	public void delete(int[] ids) {
		for (int id : ids) {
			t002Dao.delete(id);
		}
	}

	public Date stringToDate(String st) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat(Constant.FORMATDAY);
		try {

			date = sdf.parse(st);

		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return date;
	}

	@SuppressWarnings("unused")
	public T002ActionForm find(String userName, String sex, String birthDayFrom, String birthDayTo, int page) {

		int offset = (page - 1) * Constant.LIMIT;
		List<T002Entity> dtos = t002Dao.viewPage(offset, Constant.LIMIT);
		T002ActionForm actionForm = new T002ActionForm();
		actionForm.setListCustomer(new LinkedList<Customer>());

		Date dayFrom = null, dayTo = null;
		if (!"".equals(birthDayFrom)) {

			dayFrom = stringToDate(birthDayFrom);
		} else
			dayFrom = stringToDate(Constant.DATEMIN);

		if (!"".equals(birthDayTo)) {
			dayTo = stringToDate(birthDayTo);
		} else
			dayTo = stringToDate(getCurrentTimeStamp());
		for (T002Entity customerDTO : dtos) {
//			Customer customers = new Customer(String.valueOf(customerDTO.getId()), customerDTO.getName(),
//					customerDTO.getSex(), customerDTO.getBirthDay(), customerDTO.getAddress());
//			actionForm.getListCustomer().add(customers);
		}

		return actionForm;

	}

	/**
	 * @return tra ve ngay hien tai :yyyy/MM/dd
	 * 
	 */
	public static String getCurrentTimeStamp() {

		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy/MM/dd");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;
	}

	public int totalPage() {
		int totalItem = t002Dao.totalItem();
		int totalPage = (int) (Math.ceil((double) totalItem / Constant.LIMIT));
		return totalPage;

	}

	public boolean checkFormatDay(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat(Constant.FORMATDAY);
		Date testDate = null;
		try {
			testDate = sdf.parse(date);
		} catch (ParseException e) {
			return false;
		}
		if (!sdf.format(testDate).equals(date)) {
			return false;
		}
		return true;
	}

	public boolean compareDates(String dayFrom, String dayTo) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(Constant.FORMATDAY);
			Date birthDayFrom = sdf.parse(dayFrom);
			Date birthDayTo = sdf.parse(dayTo);
			if (birthDayFrom.before(birthDayTo)) {
				return true;
			}
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public int[] convertStringArrayToIntArray(String[] ids) {
		int[] arrId = new int[ids.length];
		int i = 0;
		for (String id : ids) {
			arrId[i++] = Integer.parseInt(id);
		}
		return arrId;

	}

	public boolean validateEmail(String email) {
		Pattern pattern = Pattern.compile(Constant.EMAILPATTERN);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			return true;
		}
		return false;

	}

}
