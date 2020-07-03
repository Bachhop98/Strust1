package bachtuanhop.entity;

import java.util.Date;

public class CustomerEntity {
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

	public CustomerEntity() {

	}

	public CustomerEntity(int id, String name, String sex, String birthDay, String email, String address, Date deleteYMD,
			Date insertYMD, int insertPSNCD, Date updateYMD, int updatePNDCD) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.birthDay = birthDay;
		this.email = email;
		this.address = address;
		this.deleteYMD = deleteYMD;
		this.insertYMD = insertYMD;
		this.insertPSNCD = insertPSNCD;
		this.updateYMD = updateYMD;
		this.updatePNDCD = updatePNDCD;
	}

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
