package com.jaysurya.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "STUDENT_TBL")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private int age;
	private String dept;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "STUDENT_COURSE_TABLE", joinColumns = {
	@JoinColumn(name = "student_id", referencedColumnName = "id") },inverseJoinColumns = {
	@JoinColumn(name = "course_id", referencedColumnName = "id") }

	)
	private Set<Course> courses;
}
