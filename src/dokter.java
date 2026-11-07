public class dokter extends tenagaMedis implements pemeriksaan, darurat {

    private String spesialisasi;
    private int jumlahPasienDirujuk;

    public dokter(String nama, String idPegawai, String spesialisasi) {
        super(nama, idPegawai);
        this.spesialisasi = spesialisasi;
        this.jumlahPasienDirujuk = 0;
    }

    public dokter(String nama, String idPegawai, String spesialisasi, int jumlahPasienAwal) {
        super(nama, idPegawai, jumlahPasienAwal);
        this.spesialisasi = spesialisasi;
        this.jumlahPasienDirujuk = 0;
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }

    public void setSpesialisasi(String spesialisasi) {
        this.spesialisasi = spesialisasi;
    }

    public int getJumlahPasienDirujuk() {
        return jumlahPasienDirujuk;
    }

    public void setJumlahPasienDirujuk(int jumlahPasienDirujuk) {
        if (jumlahPasienDirujuk >= 0) {
            this.jumlahPasienDirujuk = jumlahPasienDirujuk;
        }
    }

    @Override
    public void tampilkanProfil() {
        super.tampilkanProfil();
        System.out.println("   Peran           : Dokter " + spesialisasi);
        System.out.println("   Pasien dirujuk  : " + jumlahPasienDirujuk);
    }

    @Override
    public String tanganiPasien(String namaPasien, int tingkatKeparahan) {
        if (!masihBisaMenerimaPasien()) {
            return "Dokter " + getNama() + " tidak dapat menerima " + namaPasien
                    + " (kuota penuh atau tidak bertugas).";
        }
        setJumlahPasienHariIni(getJumlahPasienHariIni() + 1);
        if (tingkatKeparahan >= 8) {
            jumlahPasienDirujuk++;
            return "Dokter " + getNama() + " merujuk " + namaPasien + " ke Ruang Intensif (keparahan "
                    + tingkatKeparahan + ").";
        } else if (tingkatKeparahan >= 4) {
            return "Dokter " + getNama() + " memberi resep dan jadwal kontrol untuk "
                    + namaPasien + " (keparahan " + tingkatKeparahan + ").";
        } else {
            return "Dokter " + getNama() + " menyarankan istirahat untuk " + namaPasien
                    + " (keparahan " + tingkatKeparahan + ").";
        }
    }

    @Override
    public String periksa(String namaPasien) {
        return "Dokter " + getNama() + " (" + spesialisasi + ") memeriksa " + namaPasien
                + " secara menyeluruh.";
    }

    @Override
    public void aktifkanProtokolDarurat(String namaPasien) {
        System.out.println("!! DARURAT SIHIR untuk " + namaPasien + " dipimpin Dokter " + getNama());
    }
}