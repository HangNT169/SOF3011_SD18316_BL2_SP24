package com.sof3011.hangnt169.B4_CRUDListFixCung.controller;

import com.sof3011.hangnt169.B4_CRUDListFixCung.entity.SinhVien;
import com.sof3011.hangnt169.B4_CRUDListFixCung.service.SinhVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi",  // GET
        "/sinh-vien/search",    // GET
        "/sinh-vien/remove",    // GET
        "/sinh-vien/detail",    // GET
        "/sinh-vien/view-update",  // GET
        "/sinh-vien/update",    // POST
        "/sinh-vien/view-add",   // GET
        "/sinh-vien/add"        // POST
})
public class SinhVienServlet extends HttpServlet {

    private SinhVienService sinhVienService = new SinhVienService();
    private List<SinhVien> lists = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Lay ra duong dan tren url
        String uri = request.getRequestURI();
        // B2: Kiem tra no thuoc url nao trong nhung cai co san
        if (uri.contains("hien-thi")) {
            // thuc hien chuc nang hien thi
            this.hienThiSinhVien(request, response);
        } else if (uri.contains("search")) {
            // search
            this.searchSinhVien(request, response);
        } else if (uri.contains("remove")) {
            this.removeSinhVien(request, response);
        } else if (uri.contains("detail")) {
            this.detailSinhVien(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateSinhVien(request, response);
        } else if (uri.contains("view-add")) {
            this.viewAddSinhVien(request, response);
        } else {
            this.hienThiSinhVien(request, response);
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
            this.updateSinhVien(request, response);
        } else {
            this.addSinhVien(request, response);
        }
    }

    private void viewAddSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/buoi4/add-sinh-vien.jsp").forward(request, response);
    }

    private void viewUpdateSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mssv = request.getParameter("a");
        SinhVien sv = sinhVienService.detail(mssv);
        request.setAttribute("sv1", sv);
        request.getRequestDispatcher("/buoi4/update-sinh-vien.jsp").forward(request, response);
    }

    private void detailSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mssv = request.getParameter("mssv");
        SinhVien sv = sinhVienService.detail(mssv);
        request.setAttribute("sv1", sv);
        request.getRequestDispatcher("/buoi4/detail-sinh-vien.jsp").forward(request, response);
    }

    private void removeSinhVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String mssv = request.getParameter("a");
        sinhVienService.remove(mssv);
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void searchSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = sinhVienService.getAll(); // fake data : 5
        request.setAttribute("a", lists);
        request.getRequestDispatcher("/buoi4/sinhviens.jsp").forward(request, response);
    }

    private void addSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
//        // C1: Lam nhu bt
//        // B1: Lay du lieu tu jsp ve servlet
//        String mssv = request.getParameter("mssv");
//        String ten = request.getParameter("ten");
//        String tuoi = request.getParameter("tuoi");
//        String diaChi = request.getParameter("diaChi");
//        String gioiTinh = request.getParameter("gioiTinh");
//        // B2: Khoi tao doi tuong (contructor => new)
//        SinhVien sv = SinhVien.builder()
//                .gioiTinh(Boolean.valueOf(gioiTinh))
//                .mssv(mssv)
//                .ten(ten)
//                .diaChi(diaChi)
//                .tuoi(Integer.valueOf(tuoi))
//                .build(); // contructor khong ts
//        // B3: goi service
//        sinhVienService.add(sv);
////        lists = sinhVienService.getAll(); // fake data : 5
////        request.setAttribute("a", lists);
////        request.getRequestDispatcher("/buoi4/sinhviens.jsp").forward(request, response);
//        response.sendRedirect("/sinh-vien/hien-thi");
        // C2: BeanUtil
        SinhVien sv = new SinhVien();
        BeanUtils.populate(sv, request.getParameterMap());
        sinhVienService.add(sv);
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void updateSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }
}
