package com.example.QuanLyChuyenBay.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.QuanLyChuyenBay.entity.MayBay;

@Repository
public interface MayBayRepo extends JpaRepository<MayBay, String>{
	
	public List<MayBay> findByTamBayGreaterThan(Integer tamBay);
	public List<MayBay> findByLoaiLike(String loai);
	public List<MayBay> findByLoaiLikeOrLoaiLike(String loai1, String loai2);
//	public MayBay findByMamb(String mamb);
	public Integer countByLoaiLike(String loai);
}
