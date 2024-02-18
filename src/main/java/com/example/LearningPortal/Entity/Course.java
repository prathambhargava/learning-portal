package com.example.LearningPortal.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long courseId;

	private String title;
	private String description;

	@ManyToOne
	@JoinColumn(name = "author_id")
	private user author;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private category category;

	@OneToMany(mappedBy = "course")
	private List<enrollment> enrollments;

	@OneToMany(mappedBy = "course")
	private List<favorite> favourites;

	@Column(name = "created_on")
	private LocalDateTime createdOn;

	@Column(name = "updated_on")
	private LocalDateTime updatedOn;

}
