package com.example.QuanLyChuyenBay.Controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.QuanLyChuyenBay.Repository.MayBayRepo;
import com.example.QuanLyChuyenBay.entity.MayBay;
import com.example.QuanLyChuyenBay.entity.NhanVien;

@RestController
@RequestMapping("/maybay")
public class MayBayController {
	
	@Autowired
	MayBayRepo mayBayRepo;
	
	@GetMapping()
	public List<MayBay> getMayBayByTamBay(@Param("mintambay") Integer mintambay) {
		System.out.println(mintambay);
		List<MayBay> mayBays = mayBayRepo.findByTamBayGreaterThan(mintambay);
		return mayBays;
	}
	
	@GetMapping(value = "/count", params= {"loai"})
	public Integer getCountByLoai(@Param("loai") String loai) {
		String loaiLike = loai+"%";
		return mayBayRepo.countByLoaiLike(loaiLike);
	}
	
	@GetMapping(value = "/nhanvien", params= {"loai", "loaisub"})
	public Set<String> getNhanVienByLoaiOrLoai(@Param("loai") String loai, @Param("loaisub") String loaisub) {
		String loaiLike = loai+"%";
		Set<String> manvs = new HashSet<String>();
		List<MayBay> mayBays = mayBayRepo.findByLoaiLikeOrLoaiLike(loaiLike, loaisub+"%");
		for (MayBay mayBay : mayBays) {
			for (NhanVien nhanVien : mayBay.getNhanViens()) {
				manvs.add(nhanVien.getManv());
			}
			
		}
		return manvs;
	}
	
	@GetMapping(value = "/manhanvien", params= {"loai"})
	public Set<String> getMaNhanVienByLoai(@Param("loai") String loai) {
		String loaiLike = loai+"%";
		Set<String> manvs = new HashSet<String>();
		List<MayBay> mayBays = mayBayRepo.findByLoaiLike(loaiLike);
		for (MayBay mayBay : mayBays) {
			for (NhanVien nhanVien : mayBay.getNhanViens()) {
				manvs.add(nhanVien.getManv());
			}
			
		}
		return manvs;
	}
	
	@GetMapping(value = "/tennhanvien", params= {"loai"})
	public Set<String> getTenNhanVienByLoai(@Param("loai") String loai) {
		String loaiLike = loai+"%";
		Set<String> manvs = new HashSet<String>();
		List<MayBay> mayBays = mayBayRepo.findByLoaiLike(loaiLike);
		for (MayBay mayBay : mayBays) {
			for (NhanVien nhanVien : mayBay.getNhanViens()) {
				manvs.add(nhanVien.getTen());
			}
			
		}
		return manvs;
	}
	
	@GetMapping(value = "/nhanvien", params= {"mamb"})
	public Set<NhanVien> getNhanVienByMamb(@Param("mamb") String mamb) {
		return mayBayRepo.getReferenceById(mamb).getNhanViens();
		
	}
}
