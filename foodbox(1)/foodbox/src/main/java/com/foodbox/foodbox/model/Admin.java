package com.foodbox.foodbox.model;





import java.util.List;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table
public class Admin {

    
    private String username;
    private String password;
    
    @Id
    @GeneratedValue
    private Long Id;
    
    

    public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Admin() {
        super();
    }

    public Admin(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
