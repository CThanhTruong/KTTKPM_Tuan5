package com.example.QuanLyChuyenBay.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder.In;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tblChuyenBay")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChuyenBay {
	
	@Id
	private String maCB;
    private String gaDi;
    private String gaDen;
    private Integer doDai;
    private Time giodi;
    private Time gioden;
    private Integer chiPhi;
    
    
    


}