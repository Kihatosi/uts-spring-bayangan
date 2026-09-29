package com.uts.springuts;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    private final String CSS = """
        * { box-sizing: border-box; }
        body { font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Arial, sans-serif; background-color: #f8f9fa; color: #212529; margin: 0; padding: 30px 15px; }
        .container { max-width: 720px; margin: 0 auto; background: #ffffff; border: 1px solid #dee2e6; border-radius: 6px; padding: 28px 32px; box-shadow: 0 1px 3px rgba(0,0,0,0.04); }
        h1 { font-size: 20px; font-weight: 600; margin: 0 0 8px 0; color: #1a1a1a; }
        .identity { font-size: 13.5px; color: #495057; line-height: 1.6; margin-bottom: 20px; }
        hr { border: 0; border-top: 1px solid #e9ecef; margin: 20px 0; }
        h2 { font-size: 15px; font-weight: 600; margin: 0 0 10px 0; color: #343a40; text-transform: uppercase; letter-spacing: 0.3px; }
        ul { margin: 8px 0 0 0; padding-left: 20px; }
        li { font-size: 14px; line-height: 1.6; margin-bottom: 6px; color: #333; }
        table { width: 100%; border-collapse: collapse; margin-top: 12px; font-size: 13.5px; }
        th, td { border: 1px solid #dee2e6; padding: 10px 12px; text-align: left; }
        th { background-color: #f1f3f5; font-weight: 600; color: #495057; }
        a { color: #0d6efd; text-decoration: none; }
        a:hover { text-decoration: underline; }
        .form-row { display: flex; gap: 12px; margin-bottom: 14px; }
        .form-group { flex: 1; }
        label { display: block; font-size: 13px; font-weight: 500; margin-bottom: 5px; color: #495057; }
        input[type="number"] { width: 100%; padding: 8px 10px; border: 1px solid #ced4da; border-radius: 4px; font-size: 14px; }
        input[type="number"]:focus { border-color: #86b7fe; outline: none; }
        .btn { background-color: #0d6efd; color: #fff; border: 1px solid #0d6efd; padding: 8px 18px; font-size: 13.5px; border-radius: 4px; cursor: pointer; }
        .btn:hover { background-color: #0b5ed7; }
        .result-box { margin-top: 18px; padding: 14px 16px; background-color: #f8f9fa; border: 1px solid #dee2e6; border-left: 4px solid #0d6efd; font-size: 14px; line-height: 1.6; }
        .back-link { display: inline-block; margin-top: 20px; font-size: 13.5px; }
    """;
    @GetMapping(value = "/", produces = "text/html;charset=UTF-8")
    public String index() {
        return """
            <!DOCTYPE html>
            <html lang="id">
            <head>
                <meta charset="UTF-8">
                <title>UTS Bayangan - Pemrograman Spring Boot</title>
                <style>%s</style>
            </head>
            <body>
                <div class="container">
                    <h1>UTS Bayangan — Pemrograman Berbasis Framework</h1>
                    <div class="identity">
                        <strong>Nama:</strong> Rusmin Nuryadin &nbsp;|&nbsp; 
                        <strong>NIM:</strong> 12409011050120 &nbsp;|&nbsp; 
                        <strong>Mata Kuliah:</strong> RPL Lanjut (Teknik Informatika)
                    </div>

                    <hr>

                    <h2>1. Analisis 5W Spring Framework</h2>
                    <ul>
                        <li><strong>What:</strong> Framework berbasis Java untuk membangun aplikasi enterprise dan backend web service yang modular.</li>
                        <li><strong>Why:</strong> Menyederhanakan konfigurasi (boilerplate code) serta menyediakan fitur <em>Inversion of Control</em> (IoC) dan <em>Dependency Injection</em> (DI).</li>
                        <li><strong>When:</strong> Dibuat oleh Rod Johnson tahun 2003, dan digunakan saat mengembangkan arsitektur REST API skala menengah hingga besar.</li>
                        <li><strong>Who:</strong> Diciptakan oleh Rod Johnson, kini dikembangkan dan dikelola di bawah VMware Tanzu.</li>
                        <li><strong>Where:</strong> Diterapkan pada arsitektur server-side enterprise, backend microservices, dan sistem transaksi terdistribusi.</li>
                    </ul>

                    <hr>

                    <h2>2. Daftar Modul & Pengujian Endpoint</h2>
                    <table>
                        <thead>
                            <tr>
                                <th>Modul / Fitur</th>
                                <th>Tipe</th>
                                <th>Endpoint URL</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Profil John Travolta (Web)</td>
                                <td>Controller (HTML)</td>
                                <td><a href="/john-travolta">/john-travolta</a></td>
                            </tr>
                            <tr>
                                <td>Profil John Travolta (API)</td>
                                <td>REST Controller (JSON)</td>
                                <td><a href="/api/travolta" target="_blank">/api/travolta</a></td>
                            </tr>
                            <tr>
                                <td>Kalkulator Persamaan Kuadrat</td>
                                <td>Controller (Form UI)</td>
                                <td><a href="/kuadrat?a=1&b=-3&c=2">/kuadrat?a=1&b=-3&c=2</a></td>
                            </tr>
                            <tr>
                                <td>Kalkulator Kuadrat (REST API)</td>
                                <td>REST Controller (JSON)</td>
                                <td><a href="/api/kuadrat/hitung?a=1&b=-5&c=6" target="_blank">/api/kuadrat/hitung</a></td>
                            </tr>
                            <tr>
                                <td>Persamaan Kuadrat (Servlet)</td>
                                <td>HttpServlet Murni</td>
                                <td><a href="/servlet/kuadrat?a=1&b=-3&c=2" target="_blank">/servlet/kuadrat</a></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </body>
            </html>
            """.formatted(CSS);
    }

    @GetMapping(value = "/john-travolta", produces = "text/html;charset=UTF-8")
    public String johnTravolta() {
        return """
            <!DOCTYPE html>
            <html lang="id">
            <head>
                <meta charset="UTF-8">
                <title>Profil John Travolta</title>
                <style>%s</style>
            </head>
            <body>
                <div class="container">
                    <h1>Data Profil: John Travolta</h1>
                    <hr>
                    <p style="font-size:14px; line-height:1.6;">
                        <strong>Nama Lengkap:</strong> John Joseph Travolta<br>
                        <strong>Profesi:</strong> Aktor, Penyanyi, Pilot<br>
                        <strong>Peran Ikonik:</strong> Vincent Vega (Pulp Fiction), Tony Manero (Saturday Night Fever)<br>
                        <strong>Film Populer:</strong> Saturday Night Fever (1977), Grease (1978), Pulp Fiction (1994), Face/Off (1997)<br>
                        <strong>Status:</strong> Aktif
                    </p>
                    <a href="/" class="back-link">← Kembali ke Halaman Utama</a>
                </div>
            </body>
            </html>
            """.formatted(CSS);
    }

    @GetMapping(value = "/kuadrat", produces = "text/html;charset=UTF-8")
    public String kuadrat(
            @RequestParam(required = false) Double a,
            @RequestParam(required = false) Double b,
            @RequestParam(required = false) Double c) {

        String valA = (a != null) ? String.valueOf(a) : "";
        String valB = (b != null) ? String.valueOf(b) : "";
        String valC = (c != null) ? String.valueOf(c) : "";

        StringBuilder hasil = new StringBuilder();
        if (a != null && b != null && c != null) {
            hasil.append("<div class='result-box'>");
            hasil.append(String.format("<strong>Bentuk Persamaan:</strong> %.1fx² + (%.1fx) + (%.1f) = 0<br>", a, b, c));
            if (a == 0) {
                hasil.append("<span style='color:#dc3545;'>Nilai a tidak boleh 0 (bukan persamaan kuadrat).</span>");
            } else {
                double D = (b * b) - (4 * a * c);
                double xp = -b / (2 * a);
                double yp = -D / (4 * a);
                hasil.append(String.format("<strong>Determinan (D):</strong> %.2f<br>", D));
                hasil.append(String.format("<strong>Titik Puncak (Xp, Yp):</strong> (%.2f, %.2f) <em>[Fitur v2]</em><br>", xp, yp));
                if (D > 0) {
                    double x1 = (-b + Math.sqrt(D)) / (2 * a);
                    double x2 = (-b - Math.sqrt(D)) / (2 * a);
                    hasil.append(String.format("<strong>Hasil:</strong> Dua akar riil berbeda (x₁ = %.2f, x₂ = %.2f)", x1, x2));
                } else if (D == 0) {
                    double x = -b / (2 * a);
                    hasil.append(String.format("<strong>Hasil:</strong> Dua akar kembar (x₁ = x₂ = %.2f)", x));
                } else {
                    double real = -b / (2 * a);
                    double imag = Math.sqrt(-D) / (2 * a);
                    hasil.append(String.format("<strong>Hasil:</strong> Akar imajiner (x₁ = %.2f + %.2fi, x₂ = %.2f - %.2fi)", real, imag, real, imag));
                }
            }
            hasil.append("</div>");
        }

        return """
            <!DOCTYPE html>
            <html lang="id">
            <head>
                <meta charset="UTF-8">
                <title>Kalkulator Persamaan Kuadrat</title>
                <style>%s</style>
            </head>
            <body>
                <div class="container">
                    <h1>Kalkulator Persamaan Kuadrat (ax² + bx + c = 0)</h1>
                    <hr>
                    <form method="GET" action="/kuadrat">
                        <div class="form-row">
                            <div class="form-group">
                                <label>Nilai a:</label>
                                <input type="number" step="any" name="a" value="%s" required>
                            </div>
                            <div class="form-group">
                                <label>Nilai b:</label>
                                <input type="number" step="any" name="b" value="%s" required>
                            </div>
                            <div class="form-group">
                                <label>Nilai c:</label>
                                <input type="number" step="any" name="c" value="%s" required>
                            </div>
                        </div>
                        <button type="submit" class="btn">Hitung</button>
                    </form>
                    %s
                    <a href="/" class="back-link">← Kembali ke Halaman Utama</a>
                </div>
            </body>
            </html>
            """.formatted(CSS, valA, valB, valC, hasil.toString());
    }
}