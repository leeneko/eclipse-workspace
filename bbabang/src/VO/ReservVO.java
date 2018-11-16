package VO;

public class ReservVO {
	
	private int reservnum;
	private String reservid;
	private String reservtime;
	
	public ReservVO(int reservnum, String reservid, String reservtime) {
		super();
		this.reservnum = reservnum;
		this.reservid = reservid;
		this.reservtime = reservtime;
	}

	public int getReservnum() {
		return reservnum;
	}

	public void setReservnum(int reservnum) {
		this.reservnum = reservnum;
	}

	public String getReservid() {
		return reservid;
	}

	public void setReservid(String reservid) {
		this.reservid = reservid;
	}

	public String getReservtime() {
		return reservtime;
	}

	public void setReservtime(String reservtime) {
		this.reservtime = reservtime;
	}
	
	
}
