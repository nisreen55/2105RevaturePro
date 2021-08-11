package model;

public class ReimID 
{
	private String reimbId;

	public ReimID(String reimbId) {
		super();
		this.reimbId = reimbId;
	}

	public ReimID() {
		super();
	}

	public String getReimbId() {
		return reimbId;
	}

	public void setReimbId(String reimbId) {
		this.reimbId = reimbId;
	}

	@Override
	public String toString() {
		return "ReimID [reimbId=" + reimbId + "]";
	}
	
	
}
