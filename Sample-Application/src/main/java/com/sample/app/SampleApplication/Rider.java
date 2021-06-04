package com.sample.app.SampleApplication;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import javax.validation.constraints.NotNull;


@Entity
public class Rider {

   @Id
   @NotNull(message = "Id can not be null!!")
   @Min(value=10000,message="id length must be between 6 to 8 digits")
   @Max(value=10000000,message="id length must be between 6 and 8")
	 private int id1;
   @Column
   @NotNull(message = "Card number cannot be null" )
   @Min(value = 1000 , message = "card number length must be betweenn 5 to 7 digits")
   @Max(value = 1000000 , message = "card number length must be betweenn 5 to 7 digits")
 	 private int card_no;
   @Column
   @NotEmpty(message = "Name can not be empty!!")
   @Size(min=3,max=10,message="name size must be between 2 and 10")
	 private String name;
    @Column 
    @NotEmpty(message = "Phone number  can not be empty!!")
    @Size(min=10,max=10,message="Phone number must be 10 digits")
	 private String phone_no;

	public Rider()
	 {
		 
	 }

	public Rider(int id1,int card_no, String name, String phone_no) {
		super();
		this.id1 = id1;
		this.card_no = card_no;
		this.name = name;
		this.phone_no = phone_no;
		
	}
	 public int getId1() {
	return id1;
}

public void setId1(int id1) {
	this.id1 = id1;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getPhone_no() {
	return phone_no;
}

public void setPhone_no(String phone_no) {
	this.phone_no = phone_no;
}

public int getCard_no() {
	return card_no;
}

public void setCard_no(int card_no) {
	this.card_no = card_no;
}


}
