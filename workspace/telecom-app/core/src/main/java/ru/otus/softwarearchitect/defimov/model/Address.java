package ru.otus.softwarearchitect.defimov.model;

import lombok.Data;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "address")
@Access(AccessType.FIELD)

@Data
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Access(AccessType.PROPERTY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "fias_id")
	private UUID fiasId;

	@Column(name = "region", nullable = false)
	private String region;

	@Column(name = "district")
	private String district;

	@Column(name = "city")
	private String city;

	@Column(name = "settlement")
	private String settlement;

	@Column(name = "street")
	private String street;

	@Column(name = "house")
	private String house;

	@Column(name = "block")
	private String block;
}
