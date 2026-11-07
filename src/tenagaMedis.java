public abstract class tenagaMedis {
    
    public static final String NAMA_RS = "RS St. Mungo";
    public static final int BATAS_PASIEN_HARIAN = 3;
    
    private final String idPegawai;
    
    private String nama;
    private int jumlahPasienHariIni;
    private boolean sedangBertugas;
    
    public tenagaMedis(String nama, String idPegawai) {
        this(nama, idPegawai, 0);
    }
    
    public tenagaMedis(String nama, String idPegawai, int jumlahPasienHariIni) {
        this.nama = nama;
        this.idPegawai = idPegawai;
        this.jumlahPasienHariIni = jumlahPasienHariIni;
        this.sedangBertugas = true;
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getIdPegawai() {
        return idPegawai;
    }

    public int getJumlahPasienHariIni() {
        return jumlahPasienHariIni;
    }

    public void setJumlahPasienHariIni(int jumlahPasienHariIni) {
        if (jumlahPasienHariIni >= 0) {
            this.jumlahPasienHariIni = jumlahPasienHariIni;
        }
    }

    public boolean isSedangBertugas() {
        return sedangBertugas;
    }

    public void setSedangBertugas(boolean sedangBertugas) {
        this.sedangBertugas = sedangBertugas;
    }
    
    public void tampilkanProfil() {
        System.out.println("[" + NAMA_RS + "] " + nama + " (ID: " + idPegawai + ")");
        System.out.println("   Pasien hari ini : " + jumlahPasienHariIni + "/" + BATAS_PASIEN_HARIAN);
        System.out.println("   Status          : " + (sedangBertugas ? "Bertugas" : "Tidak menerima pasien"));
    }
    
    public boolean masihBisaMenerimaPasien() {
        return sedangBertugas && jumlahPasienHariIni < BATAS_PASIEN_HARIAN;
    }
    
    public abstract String tanganiPasien(String namaPasien, int tingkatKeparahan);
}