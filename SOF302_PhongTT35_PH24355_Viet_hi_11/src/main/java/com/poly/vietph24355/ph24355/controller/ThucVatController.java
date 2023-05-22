package com.poly.vietph24355.ph24355.controller;

import com.poly.vietph24355.ph24355.entity.ThucVat;
import com.poly.vietph24355.ph24355.service.Impl.ThucVatServiceImpl;
import com.poly.vietph24355.ph24355.service.ThucVatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThucVatController {

    private List<ThucVat> thucVats = new ArrayList<>();

    private ThucVatService thucVatService = new ThucVatServiceImpl();

    @GetMapping("thuc-vat/hien-thi")
    public String hienThi(Model model){
        thucVats = thucVatService.getAll();
        model.addAttribute("list", thucVats);
        return "thucvats";
    }


    @GetMapping("thuc-vat/remove{ma}")
    public String deleteTV(@PathVariable("ma")String ma, Model model){
        thucVatService.removeThucVat(ma);
        thucVats = thucVatService.getAll();
        model.addAttribute("list", thucVats);
        return "thucvats";
    }

    @PostMapping("thuc-vat/search")
    public String searchTV(@RequestParam("ma")String ma, Model model){
        model.addAttribute("list",  thucVatService.findThucVatByMa(ma));
        return "thucvats";
    }

    @PostMapping("/thuc-vat/add")
    public String addTV(@RequestParam("ma")String ma, @RequestParam("ten")String ten,
                        @RequestParam("gioiTinh")String gioiTinh, @RequestParam("loai")String loai,
                        @RequestParam("chieuCao")String chieuCao, Model model){
        ThucVat tv = ThucVat.builder()
                .ma(ma)
                .ten(ten)
                .gioiTinh(Boolean.valueOf(gioiTinh))
                .chieuCao(Integer.valueOf(chieuCao))
                .loai(loai)
        .build();
        thucVatService.addThucVat(tv);
        thucVats = thucVatService.getAll();
        model.addAttribute("list", thucVats);
        return "thucvats";
    }

}
