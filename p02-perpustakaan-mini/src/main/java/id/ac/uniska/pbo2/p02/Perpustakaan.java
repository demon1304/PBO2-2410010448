package id.ac.uniska.pbo2.p02;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Perpustakaan {

    private final List<Koleksi> daftarKoleksi = new ArrayList<>();
    private final Map<String, Anggota> peminjam = new HashMap<>();

    public void tambah(Koleksi k) {
        daftarKoleksi.add(k);
    }

    public Koleksi cari(String kode) {
        for (Koleksi k : daftarKoleksi) {
            if (k.getKode().equalsIgnoreCase(kode)) {
                return k;
            }
        }
        return null;
    }
    
    public List<Koleksi> cariJudul(String kataKunci) {
    String kunci = kataKunci.toLowerCase();

    return daftarKoleksi.stream()
            .filter(k -> k.getJudul().toLowerCase().contains(kunci))
            .toList();
}

    public boolean pinjam(String kode, Anggota anggota) {
        Koleksi k = cari(kode);

        if (k == null) {
            return false;
        }

        boolean berhasil = k.pinjam();

        if (berhasil) {
            peminjam.put(kode, anggota);
        }

        return berhasil;
    }

    public long kembalikan(String kode, int hariTerlambat) {
    Koleksi k = cari(kode);

    if (k == null) {
        return -1;
    }

    k.kembalikan();
    peminjam.remove(kode);

    return k.hitungDenda(hariTerlambat);
}

    public Anggota getPeminjam(String kode) {
        return peminjam.get(kode);
    }

    public long jumlahTersedia() {
        return daftarKoleksi.stream()
                .filter(k -> k.getStatus() == StatusKoleksi.TERSEDIA)
                .count();
    }

    public List<Koleksi> getDaftarKoleksi() {
        return List.copyOf(daftarKoleksi);
    }
}