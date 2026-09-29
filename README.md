# UTS Bayangan — Pemrograman Berbasis Framework (Spring Boot)

Repositori ini disusun untuk memenuhi tugas **QUIZ - UTS Mandiri / UTS Bayangan** pada mata kuliah **Rekayasa Perangkat Lunak Lanjut (RPL Lanjut)**.

### Identitas Mahasiswa
* **Nama**: Rusmin Nuryadin
* **NIM**: 12409011050120
* **Program Studi**: Teknik Informatika
* **Perguruan Tinggi**: UIN Syarif Hidayatullah Jakarta
* **Dosen Pengampu**: Rizal Broer Bahaweres

---

## 1. Analisis 5W Spring Framework

* **WHAT (Apa itu Spring?)**  
  Spring Framework adalah framework aplikasi open-source berbasis Java enterprise yang menyediakan infrastruktur menyeluruh untuk membangun aplikasi backend dan web yang modular, scalable, serta mudah diuji. Fitur utamanya berpusat pada *Inversion of Control* (IoC) dan *Dependency Injection* (DI).

* **WHY (Mengapa Menggunakan Spring?)**  
  Spring memangkas penulisan kode berulang (*boilerplate code*), mengotomatiskan manajemen siklus hidup objek (Java Beans), mempermudah integrasi database melalui Spring Data, serta memiliki ekosistem enterprise yang matang untuk keamanan (Spring Security) dan arsitektur cloud.

* **WHEN (Kapan Dibuat dan Kapan Digunakan?)**  
  Dibuat pertama kali oleh Rod Johnson pada tahun 2003 sebagai respons terhadap kompleksitas arsitektur J2EE terdahulu. Digunakan saat membangun aplikasi modern berskala menengah hingga enterprise, terutama backend RESTful API, web service terdistribusi, dan microservices.

* **WHO (Siapa Pengembang dan Penggunanya?)**  
  Diarsiteki oleh Rod Johnson dan saat ini dikembangkan serta dikelola oleh VMware Tanzu. Digunakan secara luas oleh para software engineer, perusahaan teknologi global, dan instansi finansial/perbankan di seluruh dunia.

* **WHERE (Di Mana Penerapannya?)**  
  Diterapkan pada layer *server-side* backend untuk menangani logika bisnis, REST API untuk aplikasi mobile/web frontend, sistem perbankan dengan konkurensi tinggi, sistem inventori e-commerce, hingga containerized cloud microservices.

---

## 2. Struktur Modul & Daftar Pengujian Endpoint

Aplikasi ini mengimplementasikan komparasi teknologi backend Java:

| Modul / Topik | Tipe Arsitektur | Endpoint URL | Keterangan |
| :--- | :--- | :--- | :--- |
| **Portal Web Utama** | Web Controller (HTML) | `/` | Beranda ringkasan tugas & analisis 5W |
| **John Travolta (Web)** | Controller (HTML) | `/john-travolta` | Tampilan antarmuka profil aktor |
| **John Travolta (API)** | REST Controller (JSON) | `/api/travolta` | Respon data format JSON |
| **Persamaan Kuadrat (UI)** | Controller (Form UI) | `/kuadrat?a=1&b=-3&c=2` | Form hitung interaktif determinan & akar |
| **Persamaan Kuadrat (API)** | REST Controller (JSON) | `/api/kuadrat/hitung?a=1&b=-5&c=6` | Perhitungan kuadrat via REST API JSON |
| **Persamaan Kuadrat (Servlet)** | HttpServlet Klasik | `/servlet/kuadrat?a=1&b=-3&c=2` | Komparasi menggunakan Java Servlet murni |

---

## 3. Manajemen Multi-Versi Git (Nilai ++)

Sesuai instruksi pengerjaan untuk menyediakan beberapa versi:
1. **Branch `main` (Versi 1.0)**: Arsitektur dasar Spring Boot REST Controller dan antarmuka web.
2. **Branch `v2-enhancement` (Versi 2.0)**: Peningkatan fitur komparasi dengan menyertakan implementasi Java Servlet klasik (`HttpServlet`) berdampingan dengan Spring DispatcherServlet.

---

## 4. Cara Menjalankan Proyek Secara Lokal

1. Clone repositori:
   ```bash
   git clone [https://github.com/Kihatosi/uts-spring-bayangan.git](https://github.com/Kihatosi/uts-spring-bayangan.git)
