public class perawat extends tenagaMedis implements pemeriksaan {

    private String shift;
    private int jumlahEskalasi;

    public perawat(String nama, String idPegawai, String shift) {
        super(nama, idPegawai);
        this.shift = shift;
        this.jumlahEskalasi = 0;
    }

    public perawat(String nama, String idPegawai, String shift, int jumlahPasienAwal) {
        super(nama, idPegawai, jumlahPasienAwal);
        this.shift = shift;
        this.jumlahEskalasi = 0;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public int getJumlahEskalasi() {
        return jumlahEskalasi;
    }

    public void setJumlahEskalasi(int jumlahEskalasi) {
        if (jumlahEskalasi >= 0) {
            this.jumlahEskalasi = jumlahEskalasi;
        }
    }

    @Override
    public void tampilkanProfil() {
        super.tampilkanProfil();
        System.out.println("   Peran           : Perawat shift " + shift);
        System.out.println("   Eskalasi ke dokter: " + jumlahEskalasi);
    }

    @Override
    public String tanganiPasien(String namaPasien, int tingkatKeparahan) {
        if (!masihBisaMenerimaPasien()) {
            return "Perawat " + getNama() + " tidak dapat menerima " + namaPasien
                    + " (kuota penuh atau tidak bertugas).";
        }
        setJumlahPasienHariIni(getJumlahPasienHariIni() + 1);
        if (tingkatKeparahan >= 7) {
            jumlahEskalasi++;
            return "Perawat " + getNama() + " segera mengeskalasi " + namaPasien
                    + " ke dokter jaga (keparahan " + tingkatKeparahan + ").";
        } else if (tingkatKeparahan >= 3) {
            return "Perawat " + getNama() + " memasang infus dan memantau " + namaPasien
                    + " (keparahan " + tingkatKeparahan + ").";
        } else {
            return "Perawat " + getNama() + " memberi perawatan luka ringan pada " + namaPasien
                    + " (keparahan " + tingkatKeparahan + ").";
        }
    }

    @Override
    public String periksa(String namaPasien) {
        return "Perawat " + getNama() + " mengukur tanda vital " + namaPasien + ".";
    }
}