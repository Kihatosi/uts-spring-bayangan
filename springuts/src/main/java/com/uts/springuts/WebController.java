package com.uts.springuts;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    private final String CSS = """
        body { font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif; background-color: #f8fafc; color: #1e293b; margin: 0; padding: 40px 20px; display: flex; justify-content: center; }
        .container { background: #ffffff; width: 100%; max-width: 650px; border-radius: 12px; border: 1px solid #e2e8f0; padding: 36px; box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.05); }
        h1 { font-size: 24px; font-weight: 700; margin: 0 0 6px 0; color: #0f172a; }
        .subtitle { font-size: 13px; font-weight: 600; color: #64748b; letter-spacing: 0.5px; margin-bottom: 24px; text-transform: uppercase; }
        hr { border: none; border-top: 1px solid #e2e8f0; margin: 24px 0; }
        h2 { font-size: 17px; font-weight: 600; margin: 0 0 12px 0; color: #1e293b; }
        ul { padding-left: 20px; margin: 8px 0; }
        li { margin-bottom: 8px; font-size: 14px; line-height: 1.6; color: #334155; }
        p { font-size: 14px; color: #475569; margin: 8px 0 12px 0; }
        a.link-test { color: #1d68c2; text-decoration: none; font-weight: 500; font-size: 14px; }
        a.link-test:hover { text-decoration: underline; }
        .btn { display: inline-block; background-color: #1d68c2; color: #ffffff; padding: 10px 20px; border-radius: 6px; text-decoration: none; font-size: 14px; font-weight: 500; border: none; cursor: pointer; }
        .btn:hover { background-color: #15529a; }
        .form-group { margin-bottom: 16px; }
        label { display: block; font-size: 13px; font-weight: 500; color: #475569; margin-bottom: 6px; }
        input[type="number"] { width: 100%; box-sizing: border-box; padding: 10px 12px; border: 1px solid #cbd5e1; border-radius: 6px; font-size: 14px; outline: none; }
        input:focus { border-color: #1d68c2; }
        .result-box { background-color: #f8fafc; border-left: 4px solid #1d68c2; padding: 16px 20px; border-radius: 4px; margin-top: 24px; font-size: 14px; line-height: 1.6; }
        .back-link { display: inline-block; margin-top: 24px; color: #1d68c2; text-decoration: none; font-size: 14px; }
    """;

    @GetMapping(value = "/", produces = "text/html;charset=UTF-8")
    public String index() {
        return """
            <!DOCTYPE html>
            <html lang="id">
            <head><meta charset="UTF-8"><title>Spring Mastery Hub</title><style>%s</style></head>
            <body>
                <div class="container">
                    <h1>Spring Mastery Hub</h1>
                    <div class="subtitle">UTS BAYANGAN • PEMROGRAMAN BERBASIS FRAMEWORK</div>
                    <hr>
                    <h2>1. Analisis 5W Spring Framework</h2>
                    <ul>
                        <li><strong>What:</strong> Framework berbasis Java untuk pengembangan aplikasi backend & web modern.</li>
                        <li><strong>Why:</strong> Memangkas boilerplate code dan menyediakan arsitektur Dependency Injection (IoC).</li>
                        <li><strong>When:</strong> Digunakan untuk membangun backend REST API dan sistem berskala besar.</li>
                        <li><strong>Who:</strong> Diciptakan oleh Rod Johnson, kini dikelola oleh VMware Tanzu.</li>
                    </ul>
                    <hr>
                    <h2>2. Program John Travolta</h2>
                    <p>Uji endpoint layanan web Spring:</p>
                    <p><a class="link-test" href="/john-travolta">→ /john-travolta (Tampilan Web)</a> | <a class="link-test" href="/api/travolta">→ /api/travolta (JSON)</a></p>
                    <hr>
                    <h2>3. Program Persamaan Kuadrat</h2>
                    <p>Uji perhitungan diskriminan dan akar kuadrat:</p>
                    <p><a class="link-test" href="/kuadrat?a=1&b=-3&c=2">→ /kuadrat?a=1&b=-3&c=2 (Web Form Interaktif)</a></p>
                    <p><a class="link-test" href="/servlet/kuadrat?a=1&b=-3&c=2">→ /servlet/kuadrat (Versi Servlet Klasik)</a></p>
                </div>
            </body>
            </html>
            """.formatted(CSS);
    }

    @GetMapping(value = "/john-travolta", produces = "text/html;charset=UTF-8")
    public String travoltaPage() {
        return """
            <!DOCTYPE html>
            <html lang="id">
            <head><meta charset="UTF-8"><title>Topik: John Travolta</title><style>%s</style></head>
            <body>
                <div class="container">
                    <h1>Topik: John Travolta</h1>
                    <p style="margin: 20px 0; font-size: 15px; color: #334155;">
                        Halo! Ini adalah program Spring Boot untuk topik <strong>John Travolta</strong>. Aktor legendaris penari disko di film <em>Saturday Night Fever!</em>
                    </p>
                    <a href="/" class="btn">← Kembali ke Beranda</a>
                </div>
            </body>
            </html>
            """.formatted(CSS);
    }

    @GetMapping(value = "/kuadrat", produces = "text/html;charset=UTF-8")
    public String kuadratForm(
            @RequestParam(required = false) Double a,
            @RequestParam(required = false) Double b,
            @RequestParam(required = false) Double c) {

        String valA = (a != null) ? String.valueOf(a) : "";
        String valB = (b != null) ? String.valueOf(b) : "";
        String valC = (c != null) ? String.valueOf(c) : "";

        StringBuilder hasil = new StringBuilder();
        if (a != null && b != null && c != null) {
            hasil.append("<div class='result-box'>");
            hasil.append(String.format("Persamaan: <strong>%.1fx² + (%.1fx) + %.1f = 0</strong><br>", a, b, c));
            if (a == 0) {
                hasil.append("<span style='color:red;'>Bukan persamaan kuadrat (a tidak boleh 0)</span>");
            } else {
                double D = (b * b) - (4 * a * c);
                hasil.append(String.format("Diskriminan (D): <strong>%.1f</strong><br><br>", D));
                if (D > 0) {
                    double x1 = (-b + Math.sqrt(D)) / (2 * a);
                    double x2 = (-b - Math.sqrt(D)) / (2 * a);
                    hasil.append("Akar real dan berbeda:<br>");
                    hasil.append(String.format("<strong>x1 = %.1f</strong><br><strong>x2 = %.1f</strong>", x1, x2));
                } else if (D == 0) {
                    double x = -b / (2 * a);
                    hasil.append(String.format("Akar real dan kembar:<br><strong>x1 = x2 = %.1f</strong>", x));
                } else {
                    double real = -b / (2 * a);
                    double imag = Math.sqrt(-D) / (2 * a);
                    hasil.append(String.format("Akar imajiner:<br><strong>x1 = %.2f + %.2fi</strong><br><strong>x2 = %.2f - %.2fi</strong>", real, imag, real, imag));
                }
            }
            hasil.append("</div>");
        }

        return """
            <!DOCTYPE html>
            <html lang="id">
            <head><meta charset="UTF-8"><title>Kalkulator Persamaan Kuadrat</title><style>%s</style></head>
            <body>
                <div class="container">
                    <h1>Kalkulator Persamaan Kuadrat</h1>
                    <p>Masukkan nilai koefisien a, b, dan c di bawah ini:</p>
                    <form method="GET" action="/kuadrat">
                        <div class="form-group"><label>Nilai a:</label><input type="number" step="any" name="a" value="%s" required></div>
                        <div class="form-group"><label>Nilai b:</label><input type="number" step="any" name="b" value="%s" required></div>
                        <div class="form-group"><label>Nilai c:</label><input type="number" step="any" name="c" value="%s" required></div>
                        <button type="submit" class="btn">Hitung Persamaan</button>
                    </form>
                    %s
                    <br><a href="/" class="back-link">← Kembali ke Beranda</a>
                </div>
            </body>
            </html>
            """.formatted(CSS, valA, valB, valC, hasil.toString());
    }
}