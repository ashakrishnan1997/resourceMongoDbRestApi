package com.resource.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection  = "ResourceMaster")
public class Resource {
	
	@Id
	private Integer resourceTypeId;
	private String resourceTypeName;
	
	public Integer getResourceTypeId() {
		return resourceTypeId;
	}
	public void setResourceTypeId(Integer resourceTypeId) {
		this.resourceTypeId = resourceTypeId;
	}
	public String getResourceTypeName() {
		return resourceTypeName;
	}
	public void setResourceTypeName(String resourceTypeName) {
		this.resourceTypeName = resourceTypeName;
	}
	
	
	

}