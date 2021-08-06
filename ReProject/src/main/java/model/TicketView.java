package model;

public class TicketView
{
	private Integer reimbId ;
	private Double reimbAmount ;
	private String reimbSubmitted; 
	private String reimbResolved;
	private String reimbDes;
	private String reimbReciept;
	private String reimbAuthor;
	private String reimbResolver;
	private String reimbStatus;
	private String reimbType;
	
	public TicketView() {
		super();
	}
	
	
	public TicketView(Integer reimbId) {
		super();
		this.reimbId = reimbId;
	}


	public TicketView(Integer reimbId, Double reimbAmount, String reimbSubmitted, String reimbType, String reimbAuthor) 
	{
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbType = reimbType;
		this.reimbAuthor = reimbAuthor;
	}
	
	public TicketView(Integer reimbId, Double reimbAmount, String reimbSubmitted, String reimbType, String reimbAuthor, String reimbStatus) 
	{
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbType = reimbType;
		this.reimbAuthor = reimbAuthor;
		this.reimbStatus = reimbStatus;

	}
	public TicketView(Integer reimbId, Double reimbAmount, String reimbSubmitted, String reimbResolved, String reimbDes,
			String reimbReciept, String reimbAuthor, String reimbResolver, String reimbStatus, String reimbType) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDes = reimbDes;
		this.reimbReciept = reimbReciept;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
	}
	
	public Integer getReimbId() {
		return reimbId;
	}
	public void setReimbId(Integer reimbId) {
		this.reimbId = reimbId;
	}
	public Double getReimbAmount() {
		return reimbAmount;
	}
	public void setReimbAmount(Double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}
	public String getReimbSubmitted() {
		return reimbSubmitted;
	}
	public void setReimbSubmitted(String reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}
	public String getReimbResolved() {
		return reimbResolved;
	}
	public void setReimbResolved(String reimbResolved) {
		this.reimbResolved = reimbResolved;
	}
	public String getReimbDes() {
		return reimbDes;
	}
	public void setReimbDes(String reimbDes) {
		this.reimbDes = reimbDes;
	}
	public String getReimbReciept() {
		return reimbReciept;
	}
	public void setReimbReciept(String reimbReciept) {
		this.reimbReciept = reimbReciept;
	}
	public String getReimbAuthor() {
		return reimbAuthor;
	}
	public void setReimbAuthor(String reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}
	public String getReimbResolver() {
		return reimbResolver;
	}
	public void setReimbResolver(String reimbResolver) {
		this.reimbResolver = reimbResolver;
	}
	public String getReimbStatus() {
		return reimbStatus;
	}
	public void setReimbStatus(String reimbStatus) {
		this.reimbStatus = reimbStatus;
	}
	public String getReimbType() {
		return reimbType;
	}
	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}
	@Override
	public String toString() {
		return "ErsReim \n[reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbSubmitted=" + reimbSubmitted
				+ ", reimbResolved=" + reimbResolved + ", reimbDes=" + reimbDes + ", reimbReciept=" + reimbReciept
				+ ", reimbAuthor=" + reimbAuthor + ", reimbResolver=" + reimbResolver + ", reimbStatus=" + reimbStatus
				+ ", reimbType=" + reimbType + "]";
	}
	
	/*public ErsReim(Integer reimbId, Double reimbAmount, String reimbSubmitted, String reimbResolved) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
	}*/

	
}

