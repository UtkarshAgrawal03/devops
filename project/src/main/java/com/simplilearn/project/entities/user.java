package com.simplilearn.project.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class user {
	@Id
	private int uid;
	private String uname;
	private String umail;
	private long contact;
	
	public user(int uid, String uname, String umail, long contact) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.umail = umail;
		this.contact = contact;
	}
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUmail() {
		return umail;
	}
	public void setUmail(String umail) {
		this.umail = umail;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	

}
