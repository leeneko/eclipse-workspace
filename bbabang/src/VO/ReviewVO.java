package VO;

public class ReviewVO {

	private int postnum;
	private String author;
	private String posted;
	private String title;
	private String content;
	
	public ReviewVO(int postnum, String author, String posted, String title, String content) {
		super();
		this.postnum = postnum;
		this.author = author;
		this.posted = posted;
		this.title = title;
		this.content = content;
	}
	public ReviewVO() {
		// TODO Auto-generated constructor stub
	}
	public int getPostnum() {
		return postnum;
	}
	public void setPostnum(int postnum) {
		this.postnum = postnum;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPosted() {
		return posted;
	}
	public void setPosted(String posted) {
		this.posted = posted;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
