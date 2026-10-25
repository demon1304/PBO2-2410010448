# P05 — Event Handling

## Identitas

- **Nama:** Ricky Abdillah
- **NPM:** 2410010448
- **Kelas:** 5C Reguler Banjarmasin
- **Mata Kuliah:** Pemrograman Berorientasi Objek 2

## 1. Hasil Pengamatan Praktikum 2

Berdasarkan pengujian aplikasi `PengamatEvent`, berikut event yang seharusnya tercatat untuk setiap tindakan.

| No. | Tindakan | Event yang tercatat |
|---|---|---|
| 1 | Mengarahkan kursor ke tombol, kemudian menjauhkan kursor | `mouseEntered` ketika kursor masuk dan `mouseExited` ketika kursor keluar dari tombol |
| 2 | Klik tombol Klik saya | `actionPerformed` dengan jenis `ActionEvent` |
| 3 | Centang kemudian hapus centang Aktifkan fitur | `itemStateChanged` dengan status kotak dicentang dan centang dihapus |
| 4 | Mengganti pilihan dari Pagi menjadi Malam | `itemStateChanged` ketika pilihan baru, yaitu Malam, dipilih (`SELECTED`) |
| 5 | Klik isian, lalu mengetik kata abc | `focusGained` ketika isian mendapat fokus dan `keyTyped` setiap karakter diketik |
| 6 | Klik tombol setelah mengetik di isian | `focusLost` ketika fokus berpindah dari isian ke tombol |

**Kesimpulan Praktikum 2**

Event handling memungkinkan program merespons tindakan pengguna seperti klik tombol, perubahan pilihan, pengetikan, perpindahan fokus, dan pergerakan kursor. Setiap event ditangani oleh listener yang sesuai.

## 2. Jawaban Eksperimen Praktikum 3 — Konversi Suhu

### Eksperimen 1: Menghapus pemeriksaan SELECTED

Jika pemeriksaan `evt.getStateChange() == ItemEvent.SELECTED` dihapus dan `System.out.println("item berubah");` ditambahkan ke dalam event handler `itemStateChanged`, pesan umumnya tercetak **dua kali setiap pilihan diganti**.

Hal ini terjadi karena `JComboBox` menghasilkan perubahan status untuk pilihan lama (`DESELECTED`) dan pilihan baru (`SELECTED`). Pemeriksaan `SELECTED` diperlukan agar aksi hanya dijalankan satu kali untuk pilihan yang baru dipilih.

### Eksperimen 2: Mengganti keyReleased menjadi keyPressed

Hasil konversi menjadi terlambat satu karakter karena event `keyPressed` terjadi sebelum karakter yang ditekan dimasukkan ke dalam `JTextField`. Akibatnya, method `konversi()` membaca teks yang masih berisi nilai sebelumnya.

Event `keyReleased` lebih sesuai untuk memperbarui hasil setelah karakter selesai dimasukkan ke dalam kolom teks.

### Eksperimen 3: Menghapus blok try-catch

Ketika blok `try-catch` dihapus dan huruf diketik pada kolom suhu, `Double.parseDouble()` tidak dapat mengubah teks tersebut menjadi angka. Program menghasilkan `NumberFormatException`.

Karena exception tidak lagi ditangani, stack trace exception ditampilkan di jendela Output. Penanganan exception diperlukan agar input yang tidak valid tidak menyebabkan alur program terhenti secara tidak terkendali.

## 3. Jawaban Eksperimen Praktikum 4 — Kalkulator Sederhana

### Eksperimen 1: Memakai dua cara untuk tombol kali

Jika tombol `kaliButton` memiliki event `actionPerformed` dari GUI Builder dan lambda di konstruktor, kemudian masing-masing mencetak `System.out.println("kali");`, pesan **tercetak dua kali untuk satu kali klik**, dengan asumsi kedua listener terpasang dan tidak ada kondisi lain yang menghalangi eksekusinya.

Hal ini terjadi karena satu klik memanggil kedua listener yang terdaftar. Sebaiknya satu tombol hanya menggunakan satu cara penghubung event agar aksi tidak dijalankan dua kali dan kode lebih mudah dipelihara.

### Eksperimen 2: Menambahkan tombol modulus (%)

Perubahan yang diperlukan:

1. **Pada tab Design:** tambahkan tombol baru dengan teks `%`, atur nama variabelnya menjadi `modulusButton`, dan tempatkan tombol pada `operatorPanel`.
2. **Pada tab Source:** tambahkan penanganan operator `%` di method `hitung(char operator)`, misalnya menggunakan `case '%' -> a % b;`.
3. Tambahkan event untuk tombol modulus agar memanggil `hitung('%')`. Gunakan satu cara penghubung event saja.
4. Tambahkan validasi agar pembagian maupun modulus dengan nol ditolak.

Contoh kondisi validasi:

```java
if ((operator == '/' || operator == '%') && b == 0) {
    hasilLabel.setText("Tidak dapat menggunakan nol sebagai pembagi");
    return;
}
```

Contoh penambahan pada `switch`:

```java
case '%' -> a % b;
```

Operator modulus menghasilkan sisa pembagian. Contohnya, `10 % 3` menghasilkan `1`.

### Eksperimen 3: Mengapa kursor kembali ke isian pertama?

Ketika tombol Hapus ditekan, method `hapus()` mengosongkan kedua kolom angka, mengatur label hasil menjadi `Hasil: 0`, lalu menjalankan `angka1Field.requestFocusInWindow()`.

Pemanggilan `requestFocusInWindow()` meminta agar fokus kembali ke kolom angka pertama. Dengan demikian, pengguna dapat langsung mengetik angka baru tanpa harus mengeklik kolom tersebut lagi.

## 4. Peta Event FormAnggotaPerpustakaan

| Komponen | Event | Aksi |
|---|---|---|
| `persetujuanCheckBox` | `itemStateChanged` | Mengaktifkan tombol Daftar jika persetujuan dicentang dan menonaktifkannya jika centang dihapus |
| `batalButton` | `actionPerformed` | Mengosongkan kolom isian, menghapus persetujuan, mengembalikan pilihan program studi dan fokus ke kolom NPM |
| `daftarButton` | `actionPerformed` | Memvalidasi data dan menampilkan ringkasan pendaftaran menggunakan `JOptionPane` |
| `npmField` | `keyReleased` | Menghitung jumlah digit angka yang diketik dan memperbarui label informasi NPM |
| Form utama | `windowClosing` | Menampilkan dialog konfirmasi sebelum form ditutup |

### Penjelasan

Event dibuat melalui menu **Properties → Events** di NetBeans GUI Builder. Properti `defaultCloseOperation` diatur menjadi `DO_NOTHING_ON_CLOSE` supaya form tidak langsung ditutup sebelum pengguna menjawab konfirmasi.

Tombol Daftar dibuat nonaktif pada awal program dan baru aktif ketika persetujuan dicentang.

## 5. Bukti Screenshot

### 5.1 Properties → Events pada tombol Daftar

<img width="1917" height="1078" alt="image" src="https://github.com/user-attachments/assets/3e231708-d5b0-46be-b666-72c7bda1af71" />


### 5.2 Dialog Ringkasan Pendaftaran

<img width="475" height="482" alt="Screenshot 2026-10-26 010955" src="https://github.com/user-attachments/assets/6aa90a26-6745-4c83-bab3-5a2f9cc555d1" />


### 5.3 Dialog Konfirmasi Keluar

<img width="610" height="481" alt="image" src="https://github.com/user-attachments/assets/94cca5fb-c49f-4f98-aa3a-491b6d098299" />


## 6. Deklarasi Penggunaan AI

AI digunakan sebagai alat bantu untuk memahami konsep event handling Java Swing, membantu menyusun dan memperbaiki kode event, menelusuri error kompilasi Maven, serta membantu menyusun dokumentasi README. Implementasi dan pengujian program dilakukan kembali di NetBeans oleh mahasiswa.

