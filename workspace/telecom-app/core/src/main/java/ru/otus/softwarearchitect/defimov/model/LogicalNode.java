package ru.otus.softwarearchitect.defimov.model;

import lombok.Data;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "logical_node")
@Access(AccessType.FIELD)

@Data
public class LogicalNode {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Access(AccessType.PROPERTY)
	@Column(name = "id", nullable = false)
	private Long id;

	@JoinColumn(name = "site_id", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private Site site;

	@Column(name = "name")
	private String name;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private OperatedStatus status;

	@Column(name = "model")
	private String model;
}
