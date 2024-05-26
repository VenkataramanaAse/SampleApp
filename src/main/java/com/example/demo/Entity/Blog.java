package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
@Data

@Table(name = "blog")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j
@Entity
public class Blog {
	
	
	@Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	 @NotNull
	private String authorName;
	 @NotNull
	private String Description;
	 @NotNull
	private String Publishingdate;
	 @NotNull
	private String Email;
	 @NotNull
	private String PhNo;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getPublishingdate() {
		return Publishingdate;
	}
	public void setPublishingdate(String publishingdate) {
		Publishingdate = publishingdate;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhNo() {
		return PhNo;
	}
	public void setPhNo(String phNo) {
		PhNo = phNo;
	}
	
	
	
}
