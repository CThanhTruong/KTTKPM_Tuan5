package com.example.QuanLyChuyenBay.Repository;

import java.util.List;

import javax.persistence.JoinTable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.QuanLyChuyenBay.entity.MayBay;
import com.example.QuanLyChuyenBay.entity.NhanVien;

@Repository
public interface NhanVienRepo extends JpaRepository<NhanVien, String>{
	
	public List<NhanVien> findByLuongLessThan(Integer luong);
	
	@JoinTable()
	@Query("SELECT SUM(nv.luong) FROM NhanVien nv")
	public Long sumLuongs();
	
	public List<NhanVien> findByTenLike(String ten);
}
