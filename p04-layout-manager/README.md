Nama  : Ricky Abdillah 
NPM  : 2410010448
Kelas   : 5C REG BJM 

pertanyaan eksperimen 2
1. Pada flowPanel, ubah Alignment menjadi Center lalu kecilkan jendela. Apa yang berubah? Baris mana di initComponents() yang ikut berubah?
Jawaban: Tombol-tombol menjadi rata tengah. Ketika jendela diperkecil, tombol yang tidak muat akan berpindah ke baris berikutnya. Pada initComponents(), pengaturan alignment berubah menjadi java.awt.FlowLayout.CENTER.

3. Pada gridPanel, ubah Rows menjadi 0 dan Columns menjadi 2. Berapa baris yang terbentuk dan mengapa?
Jawaban: Terbentuk 5 baris dan 2 kolom. Karena terdapat 9 tombol dan setiap baris menampung 2 tombol, maka diperlukan 5 baris; baris terakhir hanya berisi 1 tombol.


5. Pada boxPanel, atur maximumSize keempat tombol menjadi lebar 32767 dan tinggi sama dengan tinggi tombol. Bagaimana lebar tombol berubah? Apa fungsi Vertical Strut?
Jawaban: Tombol dapat melebar mengikuti ruang horizontal yang tersedia karena batas maksimum lebarnya diperbesar. Vertical Strut berfungsi memberikan jarak vertikal di antara tombol.

pertanyaan eksperimen 4
1. Ubah Weight X pada namaField menjadi 0.0, lalu lebarkan jendela. Apa yang terjadi?
Jawaban: Kolom Nama tidak lagi memperoleh tambahan ruang horizontal dari GridBagLayout, sehingga lebarnya cenderung tetap dan tidak mengikuti pelebaran jendela.

2. Ubah Direction formPanel di dalam isiPanel dari North menjadi Center, lalu tinggikan jendela. Apa perbedaannya?
Jawaban: Ketika formPanel berada di North, form tetap menempel di bagian atas. Ketika dipindahkan ke Center, form ditempatkan di area tengah sehingga posisinya dapat terlihat lebih ke tengah saat jendela ditinggikan.

3. Hapus setMinimumSize(getSize()) di constructor, lalu kecilkan jendela sekecil mungkin. Bagian mana yang rusak lebih dulu?
Jawaban: Komponen form mulai terlihat berhimpitan atau terpotong karena ukuran jendela dapat diperkecil melewati ukuran minimum yang sebelumnya ditetapkan.

tahap 1

<img width="3024" height="4032" alt="foto" src="https://github.com/user-attachments/assets/65ef65e4-be70-4486-ac9c-c054a4694600" />


tahap 2

<img width="810" height="330" alt="Screenshot 2026-10-18 225334" src="https://github.com/user-attachments/assets/729a53db-57f5-43bd-b061-196674872126" />

tahap 4

dinilai oleh rian
<img width="697" height="485" alt="Screenshot 2026-10-18 225933" src="https://github.com/user-attachments/assets/eb843ac7-9642-4aec-a8da-95277d163c76" />

pertanyaan refleksi
1. Mengapa Null Layout dan Absolute Layout sebaiknya dihindari?
Null Layout dan Absolute Layout sebaiknya dihindari karena menggunakan posisi dan ukuran komponen yang tetap berdasarkan piksel. Akibatnya, tampilan bisa berantakan saat ukuran jendela berubah atau skala layar berbeda. Absolute Layout juga dapat membutuhkan library tambahan NetBeans sehingga aplikasi lebih sulit dijalankan di komputer lain.

2. Jelaskan perbedaan perilaku FlowLayout dan GridLayout saat jendela dilebarkan.
FlowLayout menyusun komponen secara berurutan dengan ukuran asli komponen. Jika ruang tidak cukup, komponen akan berpindah ke baris berikutnya. Saat jendela dilebarkan, komponen dapat tersusun dalam lebih sedikit baris.
GridLayout menyusun komponen dalam bentuk tabel dengan ukuran sel yang sama. Saat jendela dilebarkan, ukuran sel dan komponen ikut menyesuaikan sehingga semua komponen tetap berukuran sama.

3. Apa fungsi Weight X dan Fill pada constraint GridBagLayout?
Weight X berfungsi mengatur pembagian ruang horizontal tambahan di antara kolom atau komponen. Nilai 0.0 berarti tidak mendapatkan bagian ruang tambahan, sedangkan 1.0 memungkinkan isian mendapatkan ruang tambahan.
Fill berfungsi mengatur apakah komponen memenuhi ruang selnya. Contohnya, HORIZONTAL membuat komponen isian melebar secara horizontal mengikuti ukuran sel.

4. Mengapa formPanel dibungkus isiPanel dan diletakkan di North?
formPanel dibungkus di dalam isiPanel agar susunan form lebih terorganisasi dan dapat menggunakan layout yang berbeda. Dengan meletakkannya di posisi North, form tetap berada di bagian atas ketika ruang jendela bertambah tinggi, sehingga tidak ikut berpindah ke tengah.
5. Sebutkan dua prinsip desain yang Anda terapkan pada Form Anggota Perpustakaan dan tunjukkan buktinya.
1. Keselarasan (Alignment): Label NPM, nama lengkap, program studi, dan kontak disusun sejajar dengan kolom isian masing-masing sehingga form mudah dibaca.
2. Konsistensi (Consistency): Jarak antar-komponen dibuat seragam, penggunaan label dibuat konsisten, dan tombol Batal serta Daftar diletakkan bersama di bagian bawah form.
