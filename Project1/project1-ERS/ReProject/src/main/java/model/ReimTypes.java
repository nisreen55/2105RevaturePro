package model;

public class ReimTypes 
{
	private Integer reTypeId;
	private String reTypeName;
	
	public ReimTypes() 
	{
	}

	public ReimTypes(Integer reTypeId, String reTypeName) {
		super();
		this.reTypeId = reTypeId;
		this.reTypeName = reTypeName;
	}

	

	public ReimTypes(String reTypeName) {
		super();
		this.reTypeName = reTypeName;
	}

	public Integer getReTypeId() {
		return reTypeId;
	}

	public void setReTypeId(Integer reTypeId) {
		this.reTypeId = reTypeId;
	}

	public String getReTypeName() {
		return reTypeName;
	}

	public void setReTypeName(String reTypeName) {
		this.reTypeName = reTypeName;
	}

	@Override
	public String toString() {
		return "ReimTypes [reTypeId=" + reTypeId + ", reTypeName=" + reTypeName + "]";
	}
	
	
}
