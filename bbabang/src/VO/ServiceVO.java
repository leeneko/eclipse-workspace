package VO;

public class ServiceVO {

	private int regnum;
	private String acctime;
	private int rentnum;
	private String location;
	
	public ServiceVO(int regnum, String acctime, int rentnum, String location) {
		super();
		this.regnum = regnum;
		this.acctime = acctime;
		this.rentnum = rentnum;
		this.location = location;
	}

	public int getRegnum() {
		return regnum;
	}

	public void setRegnum(int regnum) {
		this.regnum = regnum;
	}

	public String getAcctime() {
		return acctime;
	}

	public void setAcctime(String acctime) {
		this.acctime = acctime;
	}

	public int getRentnum() {
		return rentnum;
	}

	public void setRentnum(int rentnum) {
		this.rentnum = rentnum;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
}
