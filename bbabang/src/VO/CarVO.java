package VO;

public class CarVO {
	
	String carnum;
	String cartype;
	String carname;
	String carstat;
	int rentalfee;
	int runfee;
	int oilfee;
	
	public CarVO(String carnum, String cartype, String carname, String carstat, int rentalfee, int runfee, int oilfee) {
		super();
		this.carnum = carnum;
		this.cartype = cartype;
		this.carname = carname;
		this.carstat = carstat;
		this.rentalfee = rentalfee;
		this.runfee = runfee;
		this.oilfee = oilfee;
	}

	public String getCarnum() {
		return carnum;
	}

	public void setCarnum(String carnum) {
		this.carnum = carnum;
	}

	public String getCartype() {
		return cartype;
	}

	public void setCartype(String cartype) {
		this.cartype = cartype;
	}

	public String getCarname() {
		return carname;
	}

	public void setCarname(String carname) {
		this.carname = carname;
	}

	public String getCarstat() {
		return carstat;
	}

	public void setCarstat(String carstat) {
		this.carstat = carstat;
	}

	public int getRentalfee() {
		return rentalfee;
	}

	public void setRentalfee(int rentalfee) {
		this.rentalfee = rentalfee;
	}

	public int getRunfee() {
		return runfee;
	}

	public void setRunfee(int runfee) {
		this.runfee = runfee;
	}

	public int getOilfee() {
		return oilfee;
	}

	public void setOilfee(int oilfee) {
		this.oilfee = oilfee;
	}
	
	
	
}
