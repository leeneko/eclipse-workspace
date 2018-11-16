package VO;

public class RentVO {
	private int rentnum;
	private String rcarnum;
	private String rentdate;
	private String returndate;
	private int deposit;
	private int startkm;
	private int endkm;
	private int startamount;
	private int endamount;
	private String returned;
	private int fee;
	
	public RentVO(int rentnum, String rcarnum, String rentdate, String returndate, int deposit, int startkm, int endkm,
			int startamount, int endamount, String returned, int fee) {
		super();
		this.rentnum = rentnum;
		this.rcarnum = rcarnum;
		this.rentdate = rentdate;
		this.returndate = returndate;
		this.deposit = deposit;
		this.startkm = startkm;
		this.endkm = endkm;
		this.startamount = startamount;
		this.endamount = endamount;
		this.returned = returned;
		this.fee = fee;
	}
	
	public RentVO(int rentnum, String rcarnum, String rentdate, int deposit, int startkm, int startamount) {
		super();
		this.rentnum = rentnum;
		this.rcarnum = rcarnum;
		this.rentdate = rentdate;
		this.deposit = deposit;
		this.startkm = startkm;
		this.startamount = startamount;
	}
	
	public int getRentnum() {
		return rentnum;
	}

	public void setRentnum(int rentnum) {
		this.rentnum = rentnum;
	}

	public String getRcarnum() {
		return rcarnum;
	}

	public void setRcarnum(String rcarnum) {
		this.rcarnum = rcarnum;
	}

	public String getRentdate() {
		return rentdate;
	}

	public void setRentdate(String rentdate) {
		this.rentdate = rentdate;
	}

	public String getReturndate() {
		return returndate;
	}

	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getStartkm() {
		return startkm;
	}

	public void setStartkm(int startkm) {
		this.startkm = startkm;
	}

	public int getEndkm() {
		return endkm;
	}

	public void setEndkm(int endkm) {
		this.endkm = endkm;
	}

	public int getStartamount() {
		return startamount;
	}

	public void setStartamount(int startamount) {
		this.startamount = startamount;
	}

	public int getEndamount() {
		return endamount;
	}

	public void setEndamount(int endamount) {
		this.endamount = endamount;
	}

	public String getReturned() {
		return returned;
	}

	public void setReturned(String returned) {
		this.returned = returned;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}
	
}
