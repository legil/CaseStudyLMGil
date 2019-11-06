package com.casestudy.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="boardCollection")
public class BoardCollection {
	
	@Id
	@Column(name = "bc_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bc_id;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private AppUser user;
	
	@OneToMany(mappedBy = "boardCollection")
	private List<Board> boardCollection;
	
	//private List<Board> boards;
	
	

}
