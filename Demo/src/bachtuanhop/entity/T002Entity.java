package bachtuanhop.entity;

import java.util.Date;

public class T002Entity {
	private int id;
	private String name;
	private String sex;
	private String birthDay;
	private String email;
	private String address;
	private Date deleteYMD;
	private Date insertYMD;
	private int insertPSNCD;
	private Date updateYMD;
	private int updatePNDCD;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDeleteYMD() {
		return deleteYMD;
	}

	public void setDeleteYMD(Date deleteYMD) {
		this.deleteYMD = deleteYMD;
	}

	public Date getInsertYMD() {
		return insertYMD;
	}

	public void setInsertYMD(Date insertYMD) {
		this.insertYMD = insertYMD;
	}

	public int getInsertPSNCD() {
		return insertPSNCD;
	}

	public void setInsertPSNCD(int insertPSNCD) {
		this.insertPSNCD = insertPSNCD;
	}

	public Date getUpdateYMD() {
		return updateYMD;
	}

	public void setUpdateYMD(Date updateYMD) {
		this.updateYMD = updateYMD;
	}

	public int getUpdatePNDCD() {
		return updatePNDCD;
	}

	public void setUpdatePNDCD(int updatePNDCD) {
		this.updatePNDCD = updatePNDCD;
	}

}
