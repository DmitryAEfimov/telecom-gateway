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
@Table(name = "site")
@Access(AccessType.FIELD)

@Data
public class Site {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Access(AccessType.PROPERTY)
	@Column(name = "id", nullable = false)
	private Long id;

	@JoinColumn(name = "location_id", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private Location location;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@OneToMany(mappedBy = "site", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<LogicalNode> nodes;
}
