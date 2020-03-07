package ru.otus.softwarearchitect.defimov.model;

import lombok.Data;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "location")
@Access(AccessType.FIELD)

@Data
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Access(AccessType.PROPERTY)
	@Column(name = "id", nullable = false)
	private Long id;

	@JoinColumn(name = "address_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Address address;

	@Column(name = "longitude", nullable = false)
	private Double longitude;

	@Column(name = "latitude", nullable = false)
	private Double latitude;

	@OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Site> sites;
}
