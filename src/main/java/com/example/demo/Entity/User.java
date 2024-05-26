package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Data
@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j
public class User {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer  user_Id;
    @NotNull
	private String user_Name;
    @NotNull
    @Column
	private String user_Email;
    @NotNull
	private Long user_Phno;
    
    @NotNull
    @Lob
    private byte[] imageData;
    public byte[] getImageData() {
		return imageData;
	}
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@NotNull
	private String user_Adress;
    @NotNull
    private String Password;
    
	public Integer getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(Integer user_Id) {
		this.user_Id = user_Id;
	}
	public String getUser_Name() {
		return user_Name;
	}
	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}
	public String getUser_Email() {
		return user_Email;
	}
	public void setUser_Email(String user_Email) {
		this.user_Email = user_Email;
	}
	public Long getUser_Phno() {
		return user_Phno;
	}
	public void setUser_Phno(Long user_Phno) {
		this.user_Phno = user_Phno;
	}
	public String getUser_Adress() {
		return user_Adress;
	}
	public void setUser_Adress(String user_Adress) {
		this.user_Adress = user_Adress;
	}	
}
