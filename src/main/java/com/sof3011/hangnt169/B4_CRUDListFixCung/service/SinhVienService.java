package com.sof3011.hangnt169.B4_CRUDListFixCung.service;

import com.sof3011.hangnt169.B4_CRUDListFixCung.entity.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienService {

    private List<SinhVien> listSinhVien = new ArrayList<>();

    public SinhVienService() {
        // add doi tuong vao list
        listSinhVien.add(new SinhVien("HE130468", "sdfhgfhfg", 18, "Ha Noi", true));
        listSinhVien.add(new SinhVien("HE130467", "sdfgfdg", 20, "Ha Noi", true));
        listSinhVien.add(new SinhVien("HE130461", "abcd", 21, "Ha N3oi", false));
        listSinhVien.add(new SinhVien("HE130462", "gafsdg", 22, "Ha Noi2", false));
        listSinhVien.add(new SinhVien("HE14316", "agsdfgsfd", 24, "Ha Noi1", true));
    }

    public List<SinhVien> getAll() {
        return listSinhVien;
    }

    public void add(SinhVien sv) {
        listSinhVien.add(sv);
    }

    public void remove(String mssv) {
//        for (SinhVien sv : listSinhVien) {
//            if (sv.getMssv().equals(mssv)) {
//                listSinhVien.remove(sv);
//            }
//        }
        for (int i = 0; i < listSinhVien.size(); i++) {
            if (listSinhVien.get(i).getMssv().equals(mssv)) {
                listSinhVien.remove(i);
            }
        }
    }
}
