package com.example.QuanLyChuyenBay.Controller;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.QuanLyChuyenBay.Repository.ChuyenBayRepo;
import com.example.QuanLyChuyenBay.Repository.MayBayRepo;
import com.example.QuanLyChuyenBay.entity.ChuyenBay;
import com.example.QuanLyChuyenBay.entity.MayBay;

@RestController
@RequestMapping("/chuyenbay")
public class ChuyenBayController {
	
	@Autowired
	ChuyenBayRepo chuyenBayRepo;
	
	@GetMapping(params= {"gaden"})
	public List<ChuyenBay> getChuyenBayByGaDen(@Param("gaden") String gaden) {
		List<ChuyenBay> chuyenBays = chuyenBayRepo.findByGaDen(gaden);
		return chuyenBays;
	}
	
	@GetMapping(params = {"startDoDai", "endDoDai"})
	public List<ChuyenBay> getBetwenDoDai(
			@Param("startDoDai") Integer startDoDai,
			@Param("endDoDai") Integer endDoDai) {
		List<ChuyenBay> chuyenBays = chuyenBayRepo.findByDoDaiBetween(startDoDai, endDoDai);
		return chuyenBays;
	}
	
	@GetMapping(params = {"gaDi", "gaDen"})
	public List<ChuyenBay> getByGadiAndGaDen(
			@Param("gaDi") String gaDi,
			@Param("gaDen") String gaDen) {
		List<ChuyenBay> chuyenBays = chuyenBayRepo.findByGaDiAndGaDen(gaDi, gaDen);
		return chuyenBays;
	}
	
	@GetMapping(value = "/count", params= {"gaDi"})
	public Integer getCountByGaDi(@Param("gaDi") String gaDi) {
		Integer chuyenBay = chuyenBayRepo.countByGaDi(gaDi);
		return chuyenBay;
	}
	
	@GetMapping("/")
	public String asd() {
		return "asdds";
	}
}
