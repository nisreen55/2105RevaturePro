package model;



public class UName 
{
	public String name;

	public UName(String name) {
		super();
		this.name = name;
	}

	public UName() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UName [name=" + name + "]";
	}
	
	

}