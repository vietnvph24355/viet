package com.poly.vietph24355.ph24355.service.Impl;

import com.poly.vietph24355.ph24355.entity.ThucVat;
import com.poly.vietph24355.ph24355.service.ThucVatService;

import java.util.ArrayList;
import java.util.List;

public class ThucVatServiceImpl implements ThucVatService {

    private List<ThucVat> thucVatList = new ArrayList<>();

    private ThucVat tv = new ThucVat();

    public ThucVatServiceImpl(){
        thucVatList.add(new ThucVat("TV01", "Cay xanh", true, 150, "CV01"));

        thucVatList.add(new ThucVat("TV02", "Cay do", false, 300, "CV02"));

        thucVatList.add(new ThucVat("TV03", "Cay tim", false, 150, "CV03"));

        thucVatList.add(new ThucVat("TV04", "Cay vang", true, 450, "CV04"));

        thucVatList.add(new ThucVat("TV05", "Cay luc", true, 500, "CV01"));
    }

    @Override
    public List<ThucVat> getAll() {
        return thucVatList;
    }

    @Override
    public List<ThucVat> findThucVatByTen(String ten) {
        return thucVatList.stream()
                .filter((o) -> o.getTen()
                        .equalsIgnoreCase(ten))
                .toList();
    }

    @Override
    public List<ThucVat> findThucVatByMa(String ma) {
        return thucVatList.stream()
                .filter((o) -> o.getMa()
                        .equalsIgnoreCase(ma))
                .toList();
    }

    @Override
    public ThucVat detailTV(String ma) {
        for (ThucVat tc : thucVatList){
            if(tc.getMa().equalsIgnoreCase(ma)){
                return tc;
            }
        }
        return null;
    }

    @Override
    public void addThucVat(ThucVat thucVat) {
        thucVatList.add(thucVat);
    }

    @Override
    public void removeThucVat(String ma) {
      ThucVat tv = detailTV(ma);
       thucVatList.remove(tv);
    }

    @Override
    public void updateTV(String ma) {
        var taget = this.thucVatList.stream().filter((o) -> o.getMa().equalsIgnoreCase(ma)).findFirst();
        taget.ifPresent((o) -> {
            o.setMa(tv.getMa());
            o.setTen(tv.getTen());
            o.setGioiTinh(tv.getGioiTinh());
            o.setChieuCao(tv.getChieuCao());
            o.setLoai(tv.getLoai());
        });
    }
}
