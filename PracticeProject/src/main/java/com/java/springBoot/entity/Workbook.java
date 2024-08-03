package com.java.springBoot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Workbook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_workbook_id")
	private Long id;

	@Column(name = "workbook_name")
	private String name;

	@Column(name = "workbook_uuid")
	private String workbookUUID;

	@Column(name = "is_deleted")
	private boolean isDeleted = false;

}
