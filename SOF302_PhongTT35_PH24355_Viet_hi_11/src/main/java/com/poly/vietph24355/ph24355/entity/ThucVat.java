package com.poly.vietph24355.ph24355.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ThucVat {

    private String ma;

    private String ten;

    private Boolean gioiTinh;

    private Integer chieuCao;

    private String loai;

}
