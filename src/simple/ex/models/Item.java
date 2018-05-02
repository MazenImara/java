package simple.ex.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

@Entity
@Table(name="item")
public class Item implements Serializable{
 
    private static final long serialVersionUID = 453693552059515150L;
    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;
    @Column(name="name")
    private String name;
    @Temporal(TemporalType.DATE)
    @Column (name="createdOn")
    private Date createdOn;
    
    
	public long getId() {
		return id;
	}
    
	public void setId(long id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

}


// CREATE TABLE item (id int NOT NULL AUTO_INCREMENT PRIMARY KEY, name varchar(50) DEFAULT NULL, createdon timestamp);


