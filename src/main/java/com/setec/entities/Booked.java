package com.setec.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "tbl_booked")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booked {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String phoneNumber;
	private String email;
	private String date;
	private String time;
	private Integer person;
	
	  // add total
    private double total;

    // getters and setters
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
	
}
