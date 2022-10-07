package com.example.QuanLyChuyenBay.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.QuanLyChuyenBay.entity.ChuyenBay;

@Repository
public interface ChuyenBayRepo extends JpaRepository<ChuyenBay, String> {
	
	public List<ChuyenBay> findByGaDen(String gaDen);
	public List<ChuyenBay> findByDoDaiBetween(Integer start, Integer end);
	public List<ChuyenBay> findByGaDiAndGaDen(String gaDi, String gaDen);
	public Integer countByGaDi(String gaDi);
}
