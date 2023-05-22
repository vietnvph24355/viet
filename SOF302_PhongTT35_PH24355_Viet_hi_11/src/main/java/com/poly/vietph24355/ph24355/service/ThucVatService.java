package com.poly.vietph24355.ph24355.service;

import com.poly.vietph24355.ph24355.entity.ThucVat;

import java.util.List;

public interface ThucVatService {

    List<ThucVat> getAll();

    List<ThucVat> findThucVatByTen(String ten);

    List<ThucVat> findThucVatByMa(String ma);

    ThucVat detailTV(String ma);

    void addThucVat(ThucVat thucVat);

    void removeThucVat(String ma);

    void updateTV(String ma);

}
