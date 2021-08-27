package com.wangrui.myblog.bean;

public class Type {

	private int typeID;
	private String typeName;
	
	public int getTypeID() {
		return typeID;
	}
	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Type(int typeID, String typeName) {
		super();
		this.typeID = typeID;
		this.typeName = typeName;
	}
	@Override
	public String toString() {
		return typeName ;
	}
	
	
}
