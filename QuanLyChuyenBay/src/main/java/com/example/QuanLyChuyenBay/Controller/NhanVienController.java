package com.example.QuanLyChuyenBay.Controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.QuanLyChuyenBay.Repository.MayBayRepo;
import com.example.QuanLyChuyenBay.Repository.NhanVienRepo;
import com.example.QuanLyChuyenBay.entity.MayBay;
import com.example.QuanLyChuyenBay.entity.NhanVien;

@RestController
@RequestMapping("/nhanvien")
public class NhanVienController {
	
	@Autowired
	NhanVienRepo nhanVienRepo;
	
	@GetMapping()
	public List<NhanVien> getMayBayByTamBay(@Param("maxluong") Integer maxluong) {
		List<NhanVien> nhanViens = nhanVienRepo.findByLuongLessThan(maxluong);
		return nhanViens;
	}
	
	@GetMapping(value = "/sum/luong")
	public Long getSumByLuong() {
		return nhanVienRepo.sumLuongs();
	}
	
	@GetMapping(value = "/maybay", params = {"ten"}) 
	private Set<MayBay> getMayBayByTen(@Param("ten") String ten) {
		List<NhanVien> nhanViens = nhanVienRepo.findByTenLike(ten + "%");
		
		Set<MayBay> mayBaySet = new HashSet<MayBay>();
 		for (NhanVien nhanVien : nhanViens) {
			for (MayBay mayBay : nhanVien.getMayBays()) {
				mayBaySet.add(mayBay);
			}
		}
 		return mayBaySet;
	}
}
