# Kopi dan Nyemil ☕🍩

Aplikasi mobile Android untuk memesan makanan dan minuman dari kedai "Kopi dan Nyemil". Pengguna dapat mendaftar, login, melihat daftar menu, mengatur profil, mengisi alamat pengiriman, dan menerima konfirmasi pesanan.

Aplikasi ini dibuat sebagai **Tugas Pemrograman Mobile** berdasarkan wireframe "Kopi dan Nyemil".

## Identitas

- **Nama:** Yulwi Aulia
- **NIM:** 1247050036
- **Kelas:** D

## Fitur

1. **Splash / Welcome**: tampilan awal dengan logo, nama aplikasi, tagline, dan tombol *Start now*.
2. **Sign Up**: halaman pilihan untuk menuju Register atau Login.
3. **Register**: pendaftaran akun dengan nama lengkap, username, email, nomor HP, dan password, lengkap dengan validasi input (format email, panjang nomor HP, panjang password, dan username unik).
4. **Login**: masuk menggunakan username dan password yang sudah terdaftar, dengan pesan error jika data salah.
5. **Home**: sapaan sesuai nama pengguna dan daftar 5 menu makanan/minuman lengkap dengan foto, deskripsi, dan harga. Dilengkapi bottom navigation (Home, Order, Profile).
6. **Profile**: menampilkan data dari proses Register (nama, username, email, no. HP, alamat) dan dapat diubah lalu disimpan. Tersedia tombol Logout.
7. **Alamat Pengiriman**: form nama lengkap, alamat, dan patokan. Nama dan alamat terisi otomatis dari profil.
8. **Konfirmasi Pesanan**: pesan terima kasih setelah pesanan dikirim, lalu kembali ke Home.

## Daftar Menu (Data Dummy)

| Menu | Deskripsi | Harga |
|---|---|---|
| Kopi Susu Gula Aren | Espresso, susu, gula aren | Rp 22.000 |
| Donat Cokelat | Donat empuk, glaze cokelat | Rp 12.000 |
| Sourdough Loaf | Roti fermentasi alami | Rp 35.000 |
| Cappuccino | Espresso, foam susu lembut | Rp 25.000 |
| Matcha Latte | Matcha Jepang, susu segar | Rp 27.000 |

## Teknologi yang Digunakan

- **Bahasa:** Kotlin
- **IDE:** Android Studio
- **UI:** Jetpack Compose + Material 3
- **Navigasi:** Navigation Compose
- **Arsitektur state:** ViewModel (`AppViewModel`)
- **Data:** statis (dummy data), tanpa database
- **Minimum SDK:** API 24 (Android 7.0)

## Struktur Project

```
lat.pam.kopidannyemil
├── MainActivity.kt
├── data
│   ├── MenuItem.kt          # model menu + data dummy
│   └── AppViewModel.kt      # akun, login, register, profil
├── navigation
│   └── AppNavigation.kt     # daftar route dan alur antar layar
└── ui
    ├── screens              # 8 layar aplikasi
    └── theme                # warna, tipografi, tema
```

## Alur Aplikasi

```
Splash → Sign Up → Login ─────┐
                 └→ Register ─┴→ Home ⇄ Profile
                                  └→ Alamat → Konfirmasi → Home
```

## Cara Menjalankan

1. Pastikan **Android Studio** (versi terbaru) sudah terpasang.
2. Clone repository:
   ```bash
   git clone https://github.com/USERNAME/KopiDanNyemil.git
   ```
3. Buka folder project melalui **File → Open** di Android Studio.
4. Tunggu proses **Gradle Sync** sampai selesai.
5. Pilih emulator atau hubungkan perangkat Android (USB debugging aktif, minimal Android 7.0).
6. Klik tombol **Run ▶**.

## Akun Demo

Untuk langsung mencoba tanpa mendaftar:

| Username | Password |
|---|---|
| `kopi` | `123456` |


## Sumber Aset

- Foto menu: Unsplash
- Logo: Unsplash
