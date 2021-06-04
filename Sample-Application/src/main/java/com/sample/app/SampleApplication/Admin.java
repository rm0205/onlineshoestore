package com.sample.app.SampleApplication;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Admin {
	
	@Id
	private int id;
	
	 @Column
	 private String description;
	 
	 @Lob
	 @Column
	 private byte[] image;
	 
	@Column
	private int price;
	
	
	 
	
	 
	 public Admin()
	 {
		 
	 }
	 
	 public Admin(int id, String description, byte[] image,int price ) {
			super();
			this.id = id;
			this.price = price;
			this.image = image;
			this.description = description;
		}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
    public String encodeToString()
{
    return org.springframework.util.Base64Utils.encodeToString(this.getImage());
}
	 

}
