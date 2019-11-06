package com.casestudy.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "link")
public class Link {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long board_id;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "rating")
	private int rating;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_added")
	private java.util.Date dateAdded;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modified")
	private Date dateModified;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_board")
    private Board board;
	
}
