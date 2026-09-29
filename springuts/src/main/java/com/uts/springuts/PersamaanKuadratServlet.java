package com.uts.springuts;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "KuadratServlet", urlPatterns = "/servlet/kuadrat")
public class PersamaanKuadratServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String aParam = request.getParameter("a");
        String bParam = request.getParameter("b");
        String cParam = request.getParameter("c");

        out.println("<html><head><title>Persamaan Kuadrat - Versi Servlet</title></head><body style='font-family: sans-serif; padding: 30px;'>");
        out.println("<h2>Kalkulator Persamaan Kuadrat (Implementasi Java Servlet)</h2>");

        if (aParam != null && bParam != null && cParam != null) {
            try {
                double a = Double.parseDouble(aParam);
                double b = Double.parseDouble(bParam);
                double c = Double.parseDouble(cParam);

                out.println("<p>Bentuk Persamaan: <b>" + a + "x² + (" + b + "x) + (" + c + ") = 0</b></p>");

                if (a == 0) {
                    out.println("<p style='color:red;'>Bukan persamaan kuadrat (a tidak boleh 0)</p>");
                } else {
                    double D = (b * b) - (4 * a * c);
                    out.println("<p>Nilai Diskriminan (D): <b>" + D + "</b></p>");

                    if (D > 0) {
                        double x1 = (-b + Math.sqrt(D)) / (2 * a);
                        double x2 = (-b - Math.sqrt(D)) / (2 * a);
                        out.println("<p>Akar riil berbeda: <b>x1 = " + x1 + "</b>, <b>x2 = " + x2 + "</b></p>");
                    } else if (D == 0) {
                        double x = -b / (2 * a);
                        out.println("<p>Akar riil kembar: <b>x1 = x2 = " + x + "</b></p>");
                    } else {
                        double real = -b / (2 * a);
                        double imag = Math.sqrt(-D) / (2 * a);
                        out.println("<p>Akar imajiner: <b>" + String.format("%.2f + %.2fi", real, imag) + "</b> dan <b>" + String.format("%.2f - %.2fi", real, imag) + "</b></p>");
                    }
                }
            } catch (NumberFormatException e) {
                out.println("<p style='color:red;'>Input a, b, dan c harus berupa angka valid.</p>");
            }
        } else {
            out.println("<p>Gunakan parameter di URL, contoh: <code>?a=1&b=-3&c=2</code></p>");
        }

        out.println("<br><a href='/'>← Kembali ke Portal Utama</a>");
        out.println("</body></html>");
    }
}