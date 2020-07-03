package bachtuanhop.entity;

import java.util.Date;

public class UserEntity  {
	private int id;
	private String userId;
	private String password;
	private String userName;
	private Date deleteYMD;
	private Date insertYMD;
	private int insertPSNCD;
	private Date updateYMD;
	private int updatePNDCD;
	public UserEntity(int id, String userId, String password, String userName, Date deleteYMD, Date insertYMD,
			int insertPSNCD, Date updateYMD, int updatePNDCD) {
		super();
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.userName = userName;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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