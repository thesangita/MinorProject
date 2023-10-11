package com.tp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Destinations {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int destId;
	
	//hawamahal
	@Column(length = 50, nullable = false, unique = true)
	private String destName;
	
	//mountaun,desert
	@Column(length = 50, nullable = false)
	private String destType;
		
	//jaipur
	@Column(length = 100, nullable = false, unique = true)
	private String imageLocation;
	
	//beautifull hieracihal site in the desrt
	@Column(length = 150, nullable = true)
	private String imageDescription;
	
	//stars are calculated
	private float popularityScore;

	@Column(length = 60, nullable = false)
	private String stateAndUTName;
	
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image;

}