public class Main {

    public static void main(String[] args) {
        System.out.println("=== SISTEM " + tenagaMedis.NAMA_RS + " ===\n");

        dokter dokter = new dokter("Severus Snape", "DR-001", "Ramuan dan Racun");
        perawat perawat = new perawat("Poppy Pomfrey", "PR-001", "Pagi", 1);

        System.out.println("--- [Req 1,5,6] Profil (void, override, super.method) ---");
        dokter.tampilkanProfil();
        perawat.tampilkanProfil();

        System.out.println("\n--- Immutability ---");
        System.out.println("Konstanta global NAMA_RS            : " + tenagaMedis.NAMA_RS);
        System.out.println("Konstanta global BATAS_PASIEN_HARIAN: " + tenagaMedis.BATAS_PASIEN_HARIAN);
        System.out.println("Atribut final idPegawai dokter      : " + dokter.getIdPegawai()
                + " (tidak punya setter)");

        System.out.println("\n--- Enkapsulasi (getter/setter) ---");
        dokter.setSpesialisasi("Penawar Racun");
        System.out.println("Spesialisasi setelah setter: " + dokter.getSpesialisasi());

        System.out.println("\n--- Method fungsi ---");
        System.out.println("Dokter bisa terima pasien? " + dokter.masihBisaMenerimaPasien());

        System.out.println("\n--- Abstract method + logika if/else ---");
        System.out.println(dokter.tanganiPasien("Harry", 2));
        System.out.println(dokter.tanganiPasien("Ron", 5));
        System.out.println(dokter.tanganiPasien("Draco", 9));
        System.out.println(dokter.tanganiPasien("Neville", 6));
        System.out.println(perawat.tanganiPasien("Hagrid", 8));
        System.out.println(perawat.tanganiPasien("Luna", 4));
        System.out.println(perawat.tanganiPasien("Ginny", 1));

        System.out.println("\n--- Inheritance (referensi bertipe superclass) ---");
        tenagaMedis tm1 = new dokter("Remus Lupin", "DR-003", "Penyakit Sihir Gelap");
        tenagaMedis tm2 = new perawat("Hannah Abbott", "PR-003", "Siang");
        System.out.println(tm1.tanganiPasien("Cedric diggory", 9));
        System.out.println(tm2.tanganiPasien("silmi diggory", 9));

        System.out.println("\n--- Polimorfisme interface ---");
        pemeriksaan p1 = new dokter("Hermione Granger", "DR-002", "Mantra Penyembuh");
        pemeriksaan p2 = new perawat("Molly Weasley", "PR-002", "Malam");
        System.out.println(p1.periksa("Fred"));
        System.out.println(p2.periksa("George"));

        System.out.println("\n--- Multiple interface (Dokter: Pemeriksaan + Darurat) ---");
        darurat d = new dokter("Minerva McGonagall", "DR-004", "Transfigurasi");
        d.aktifkanProtokolDarurat("Seamus");
        System.out.println(dokter.periksa("Seamus"));
        dokter.aktifkanProtokolDarurat("Seamus");
    }
}