package model;

public class ErsReim 
{
	private Integer reimbId ;
	private Double reimbAmount ;
	private String reimbSubmitted; 
	private String reimbResolved;
	private String reimbDes;
	private String reimbReciept;
	private Integer reimbAuthor;
	private Integer reimbResolver;
	private Integer reimbStatus;
	private Integer reimbType;
	
	public ErsReim() {
		super();
	}
	
	
	
	public ErsReim(Integer reimbId, Double reimbAmount, String reimbSubmitted, Integer reimbAuthor,
			Integer reimbResolver, Integer reimbStatus, Integer reimbType) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
	}



	public ErsReim(Integer reimbId, Double reimbAmount, String reimbSubmitted, String reimbDes) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbDes = reimbDes;
	}
	public ErsReim(Long reimbId, Double reimbAmount, String reimbSubmitted, Integer reimbType) {
		super();
		this.reimbId =reimbId.intValue();
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbType = reimbType;
	}
	public ErsReim(Integer reimbId, Double reimbAmount, String reimbSubmitted, Integer reimbType) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbType = reimbType;
	}
	public ErsReim(Integer reimbId, Double reimbAmount, String reimbSubmitted, String reimbResolved, String reimbDes,
			String reimbReciept, Integer reimbAuthor, Integer reimbResolver, Integer reimbStatus, Integer reimbType) {
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
	public Integer getReimbAuthor() {
		return reimbAuthor;
	}
	public void setReimbAuthor(Integer reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}
	public Integer getReimbResolver() {
		return reimbResolver;
	}
	public void setReimbResolver(Integer reimbResolver) {
		this.reimbResolver = reimbResolver;
	}
	public Integer getReimbStatus() {
		return reimbStatus;
	}
	public void setReimbStatus(Integer reimbStatus) {
		this.reimbStatus = reimbStatus;
	}
	public Integer getReimbType() {
		return reimbType;
	}
	public void setReimbType(Integer reimbType) {
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
