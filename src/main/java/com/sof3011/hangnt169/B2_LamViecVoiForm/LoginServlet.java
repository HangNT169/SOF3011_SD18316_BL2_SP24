package com.sof3011.hangnt169.B2_LamViecVoiForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = {"/login","/ket-qua"})
// FE (view clien giao diẹn) => jframe/jsp/html => webapp
// BE(server) => logic => service, repositor, ..
// trao doi bang controller thong qua phuong thuc HTTPMethods
// VALUE LUON LUON BAT DAU BANG /
// VALUE chua duong dan cua trinh duyet
// BE & FE trao doi thong qua controller bang phuong thuc HTTP Methods
// Co 4 loai co ban:
// GET :  = READ : Hien thi du lieu (Lay ra) <=> SELECT
// POST: <=> CREATE: Them du lieu <=> INSERT INTO
// PUT : <=> UPDATE: Sua du lieu
// DELETE <=> DELETE: Xoa du lieu
// J4/ J5: Get , Post
// GET: Hien thi lay ra
// Post: Xu ly
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Truyen gia tri tu servlet sang jsp => setAttribute
        String mess ="dfshgsdf";
        request.setAttribute("mess123",mess);
        // Chuyen trang
        // C1: Mnag du lieu muon truyen sang jsp
//        request.getRequestDispatcher("a.jsp").forward(request,response);
        // C2:Chuyen trang => Chi chuyen trang
        response.sendRedirect("/buoi2/a.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Lay du lieu tu jsp ve servlet => getParameter
        String user = request.getParameter("username");
        String password = request.getParameter("pass");
        request.setAttribute("ten", user);
        request.setAttribute("matKhau", password);
        request.getRequestDispatcher("/buoi2/ket-qua.jsp").forward(request, response);
    }
}
