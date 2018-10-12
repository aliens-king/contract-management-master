package com.sampana.cms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import com.sampana.cms.configuration.Deleted;

@MappedSuperclass
public abstract class Base {

	@Column(name = "created_at")
	private Date createdAt;

   
	@Column(name = "updated_at")
	private Date updatedAt;
	
	@Column(name = "deleted_at")
	private Date deletedAt;
	
	@Column(name = "deleted")
	private String deleted;

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	
	

}
