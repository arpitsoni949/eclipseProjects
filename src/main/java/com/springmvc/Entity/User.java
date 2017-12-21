package com.springmvc.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries(
		{
			@NamedQuery(name="findAll",query="from User u where u.id=:id")
		})
@Entity
@Table(name="User")
public class User {
	@Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private String address;
    
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String name, String address)
    {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    
    @Override
    public String toString()
    {
        return "User [address=" + address + ", id=" + id + ", name=" + name+ "]";
    }
    public Integer getId()
    {
        return id;
    }
    public void setId(Integer id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
}
