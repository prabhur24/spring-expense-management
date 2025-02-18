package com.example.demo_mvn.domain.model;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;

// @Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "expenses")
@Getter
@Setter
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private ExpenseCategory category;

	@CreationTimestamp
	@Column(name = "createdOn", nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private LocalDate createdOn;

	@Column(name = "description", nullable = false, length = 100)
	private String description;

	@Column(nullable = false, precision = 10, scale = 3)
	private BigDecimal amount;


	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Version
	@Column
	private Integer version;


}
