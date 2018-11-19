package VO;

public class InfoVO {

	private String compname;
	private String keyname;
	private String blicense;
	private String address;
	private String contact;
	
	public InfoVO(String compname, String keyname, String blicense, String address, String contact) {
		super();
		this.compname = compname;
		this.keyname = keyname;
		this.blicense = blicense;
		this.address = address;
		this.contact = contact;
	}

	public InfoVO() {
		// TODO Auto-generated constructor stub
	}

	public String getCompname() {
		return compname;
	}

	public void setCompname(String compname) {
		this.compname = compname;
	}

	public String getKeyname() {
		return keyname;
	}

	public void setKeyname(String keyname) {
		this.keyname = keyname;
	}

	public String getBlicense() {
		return blicense;
	}

	public void setBlicense(String blicense) {
		this.blicense = blicense;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
	
}
