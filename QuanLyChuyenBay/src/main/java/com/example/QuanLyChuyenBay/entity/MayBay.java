package com.example.QuanLyChuyenBay.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tblMayBay")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MayBay {
	
	@Id
	private String mamb;
	private String loai;
	private Integer tamBay;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "mayBays")
	@JsonBackReference
	private Set<NhanVien> nhanViens;
}
