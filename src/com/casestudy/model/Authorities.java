package com.casestudy.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity @IdClass(value = AuthoritiesId.class)
@Table(name = "authorities")
//@Table(name = "authorities", uniqueConstraints = @UniqueConstraint(columnNames = {"authority", "username"}))
public class Authorities {
	@Id
	@Column(name = "authority")
	private String authority;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "username")
	private Credential user;

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Credential getCredential() {
		return user;
	}

	public void setCredential(Credential credential) {
		this.user = credential;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
}

class AuthoritiesId implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "authority")
	private String authority;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "username")
	private Credential user;

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Credential getUser() {
		return user;
	}

	public void setUser(Credential credential) {
		this.user = credential;
	}
}