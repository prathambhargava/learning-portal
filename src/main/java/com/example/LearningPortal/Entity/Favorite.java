package com.example.LearningPortal.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "favourite")
public class favorite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long favouriteId;

	@ManyToOne
	@JoinColumn(name = "learner_id")
	private user learner;

	@ManyToOne
	@JoinColumn(name = "course_id")
	private course course;

	@Column(name = "created_on")
	private LocalDateTime createdOn;

	@Column(name = "updated_on")
	private LocalDateTime updatedOn;

}
