package com.sof3011.hangnt169.B2_LamViecVoiForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "KetQuaServlet", value = "/ket-qua1")
public class KetQuaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.sendRedirect("test.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // B1: Lay du lieu tu jsp ve servlet => getParameter
//        String user = request.getParameter("username");
//        String password = request.getParameter("pass");
//        request.setAttribute("ten", user);
//        request.setAttribute("matKhau", password);
//        request.getRequestDispatcher("/buoi2/ket-qua.jsp").forward(request, response);
    }
}
