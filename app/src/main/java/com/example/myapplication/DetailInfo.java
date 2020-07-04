package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailInfo extends AppCompatActivity {
    private TextView tvDetailInfo, tvTitleInfo;
    private static String[] infoDetails = {
            "Cash flow adalah gambaran laju penerimaan dan laju pengeluaran pada periode waktu tertentu selama umur project.\n" +
                    "Net cash flow adalah selisih antara  laju pendapatan dengan laju pengeluaran pada periode waktu tertentu.\n" +
                    "Net cash flow = cash revenue -  cash expended",
            "1.Gross Revenue\n" +
                    "Pendapatan kotor dari proyek migas diperoleh dari hasil penjualan produksi minyak, gas, maupun condensat. Besarnya gross revenue pada awal produksi pada umumnya besar selanjutnya akan mengalami penurunan sesuai dengan karakteristik produksi dari suatu reservoir.\n" +
                    "2.Capital cost\n" +
                    "Capital cost dicirikan dikeluarkan satu kali (one off cost) pada saat dimulainya project dan pada umumnya cukup besar. Kadang-kadang capital cost dikeluarkan beberapa tahun sebelum diperoleh pendapatan.\n" +
                    " Yang termasuk dalam capital cost adalah :\n" +
                    "-biaya pemboran\n" +
                    "-pembelian tanker\n" +
                    "-konstruksi platform\n" +
                    "-pembelian proses facilities\n" +
                    "-pembelian well head dan flow line\n" +
                    "-pembangunan kantor dan camp \n" +
                    "-dan beberapa pembelian bahan lain yang sifatnya merupakan aset\n" +
                    "3.Operating cost\n" +
                    "\tOperating cost dikarakteristikkan  adalah pengeluaran yang terjadi secara periodik yang digunakan untuk mempertahankan produksi lapangan. Yang termasuk dalam operating cost yaitu :\n" +
                    "-membayar gajii karyawan\n" +
                    "-biaya pemeliharaan pearalatan\n" +
                    "-biaya work over\n" +
                    "-biaya overheads kantor\n" +
                    "-dll yang bersifat periodik\n" +
                    "Besarnya biaya operasi dapat dinyatakan dalam bentuk :\n" +
                    "$/ tahun atau $/ bbl\n" +
                    "4.Abandont cost \n" +
                    "Abandont cost adalah biaya yang harus dikeluarkan pada akhir proyek yang digunakan untuk biaya reklamasi/ perbaikkan lingkungan setellah lapangan tersebut ditutup.\n" +
                    "Biaya abandont cost dapat merupakan komponen yang penting didalam  cash flow dapat pula masuk kedalam biaya platform, pada onshore untuk perbaikkan lingkungan. \n" +
                    "5.Taxes (pajak), Royalty \n" +
                    "Selain capital cost dan operating cost perusahaan masih harus membayar kepada pemerintah (Goverment Take) yang da",
            "Net cash flow dan profit\n" +
                    "Net cash flow danprofit kadang-kadang disalahartikan mempunyai pengertian yang sama tetapi sebetulnya secara konseptual keduanya sangat berbeda. Pada net cash flow merupakan perkiraan besarnya uang yang diterima maupun yang dikeluarkan lebih aktual/ riil. Sedangkan pada profit merupakan ukuran yang bersifat artificial yang digunakan pada umumnya untuk melihat sehat tidaknya financial/ keuangan perusahaan. \n",
            "Net cash flow dan pajak\n" +
                    "Untuk perhitungan net cash flow  sesudah pajak maka harus dihitung terlebih dahulu besarnya pajak yang harus dibayar per tahunnya.\n",
            "Depresiasi\n" +
                    "Ada beberapa metode perhitungan depresiasi yang sering digunakan didalam industri migas. Depresiasi digunakan pada perhitungan pajak maupun besarnya pembagian keuntungan (profit sharing). Metode perhitungan tersebut :\n" +
                    "a.Straight Line (metode garis lurus)\n" +
                    "b.Metode Declining Balance\n" +
                    "c.Metode Double Declining Balance\n" +
                    "d.Unit of production\n" +
                    "e.Sum of the year methode",
            "Metode garis lurus\n" +
                    "Contoh 1 :\n" +
                    "Diketahui :\t\n" +
                    "Capital cost = $ 100 MM\n" +
                    "Jumlah tahun depresiasi (umur proyek) = 4 tahun\n" +
                    "Hitunglah depresiasi per tahun (Di) !\n" +
                    "Penyelesaian :\n" +
                    "Rumus yang digunakan :\n" +
                    "Di = K/N\n" +
                    "R = 1/N = ¼ = 0.25\n" +
                    "Di = K.R = 100 x 0.25 = 25\n" +
                    "Ket :\n" +
                    "- Pada metode ini besarnya depresiasi tetap tiap tahunnya.\n" +
                    "- Nilai akhir capital = nilai awal capital – depresiasi\n" +
                    "Pada metode straight line ini dikarakteristikkan :\n" +
                    "1. Besarnya depresiasi per tahun tetap\n" +
                    "2. Nilai akhir dari capital = 0",
            "Metode Declining Balance\n" +
                    "rumus umum yang digunakan untuk Declining Balance yaitu :\n" +
                    "\tDi = K.R(1-R)i-1\n" +
                    "Pada metode ini dikarakteristikkan :\n" +
                    "1.Depresiasi akan mengalami penurunan pada tahun-tahun berikutnya\n" +
                    "2.Nilai capital diakhir tahun project mempunyai nilai tidak sama dengan nol, inilah yang disebut salvage value",
            "Metode Double Declining Balance\n" +
                    "Pada metoda ini merupakan modifikasi dari metode declining balance. Besarnya depresiation rate (R) dikalikan 2 (didouble).\n" +
                    "Rumus yang dipakai yaitu :\n" +
                    "\tDi = K . 2R (1-2R)i-1 \n" +
                    "Dimana :\n" +
                    "K\t= capital\n" +
                    "Di\t= depresiasi\n" +
                    "R\t= depesiation rate",
            "\n" +
                    "Unit of Production Methode\n" +
                    "Pada metode ini unit of production depresiasi dari kapital akan sebanding dengan unit produksi/ satuan produksi yang dihasilkan. Metode ini banyak digunakan pada perusahaan-perusahaan yang bergerak didalam tambang (sumber daya alam).\n" +
                    "Contoh A :\n" +
                    "Suatu lapangan diperkirakan memiliki cadangan sebesar 50 MMBBL. Besarnya produksi yang akan dihasilkan selama 4 tahun produksi adalah sebagai berikut :\n" +
                    "produksi tahun 1 = 20\n" +
                    "produksi tahun 2 = 15\n" +
                    "produksi tahun 3 = 10\n" +
                    "produksi tahun 4 = 5\n" +
                    "Besarnya capital yang dibutuhkan sebesar $ 100 MM. Hit besarnya depresiasi dari capital bila didepresiasi selama 4 tahun.\n" +
                    "Penyelesaian :\n" +
                    "Diketahui :\t\n" +
                    "Cadangan = 50 MMBBL\n" +
                    "Capital = $ 100 MM\n" +
                    "Tahun depresiasi (N) = 4 tahun\n" +
                    "Persamaan yang digunakan :\n" +
                    "Depresiation rate (R) = Produksi pada tahun ke-i / reserve   Di = K . R\n" +
                    "Di = Produksi pada tahun ke-i / reserve x K\n" +
                    "Contoh perhitungan pada tahun ke-1 :\n" +
                    "R = Produksi pada tahun ke-i / reserve  \n" +
                    "R = 20/50 x 100 % = 40%\n" +
                    "Di = K.R = 100 x 0.4 = 40\n" +
                    "Atau\n" +
                    "Di = Produksi pada tahun ke-i / reserve x K\n" +
                    "Di = 20/50 x 100 = 40",
            "Sum-of the year methode\n" +
                    "Pada metoda ini hampir sama dengan metode unit of production dimana besarnya depresiasi pada tahun-tahun awal akan besar, kemudian pada tahun berikutnya mengalami penurunan.\n" +
                    "Rumus yang digunakan :\n" +
                    "Di=K.2(N-(i-1))/N(N+1)\n" +
                    "ket :\n" +
                    "K = capital\n" +
                    "N = jumlah tahun",
            " Net cash flow dan Inflasi\n" +
                    "Pada contoh perhitungan Net cash flow sebelumnya besarnya capital cost dan operating cost didasarkan pada harga-harga barang pada waktu sekarang. Kenyataan di lapangan akan ada kenaikan harga dari barang-barang aset misal : wellhead, harga drillpipe, casing dsb. Sebagi akibat adanya kenaikan harga baja (steel) karena inflasi. Untuk itu, di dalam perhitungan net cash flow faktor inflasi (kenaikan harga barang) perlu diperhitungkan."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_info);

        tvDetailInfo = findViewById(R.id.tv_detailinfo);
        tvTitleInfo = findViewById(R.id.tv_titleinfo);
        int id = getIntent().getIntExtra("id", 0);
        String title = getIntent().getStringExtra("title");
        tvTitleInfo.setText(title);
        tvDetailInfo.setText(infoDetails[id]);
    }
}