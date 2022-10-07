package com.example.QuanLyChuyenBay.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tblNhanVien")
@Getter
@Setter
@NoArgsConstructor
public class NhanVien {
	
	@Id
	private String manv;
	private String ten;
	private Integer luong;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "tbl_chung_nhan",
    	joinColumns = {
    			@JoinColumn(name = "manv", referencedColumnName = "manv")
		},
    	inverseJoinColumns = {
    			@JoinColumn(name = "mamb", referencedColumnName = "mamb")
    	}
	)
	@JsonBackReference
	private Set<MayBay> mayBays;
	
	

}
