package com.takeo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="COURSE_DTLS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="CID")
	@JsonProperty("cid")
	private Integer cid;
	@Column(name="CNAME")
	@JsonProperty("coursename")
	@NotEmpty
	@Size(min =2, message = "Courname nane should be of minimum 2 characters")
	private String cname;
	@Column(name="CDURATION")
	@JsonProperty("cduration")
	@NotEmpty
	@Size(min =2, message = "Courname nane should be of minimum 3 characters")
	private String cduration;
	@Column(name="CFEE")
	@JsonProperty("cfee")
	private Integer cfee;
	
}
	
	