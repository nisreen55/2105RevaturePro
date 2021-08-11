package model;

public class ReimStatus 
{
	private Integer reStatusId;
	private String reStatusName;
	
	public ReimStatus() 
	{
	}

	public ReimStatus(Integer reStatusId, String reStatusName) {
		super();
		this.reStatusId = reStatusId;
		this.reStatusName = reStatusName;
	}

	public ReimStatus(String reStatusName) {
		super();
		this.reStatusName = reStatusName;
	}

	public Integer getReStatusId() {
		return reStatusId;
	}

	public void setReStatusId(Integer reStatusId) {
		this.reStatusId = reStatusId;
	}

	public String getReStatusName() {
		return reStatusName;
	}

	public void setReStatusName(String reStatusName) {
		this.reStatusName = reStatusName;
	}

	@Override
	public String toString() {
		return "ReimStatus [reStatusId=" + reStatusId + ", reStatusName=" + reStatusName + "]";
	}
	
	
}
