package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;

public class qrcode extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

        handler.postDelayed(runnable, 1000);
        final Context context = this;
    }

    private Runnable runnable = new Runnable() {
        public void hitungId() {
            cek cek = new cek(); //objek untuk class cek
            Integer id = cek.getId_presensi(); //mengambil data id presensi yg di cek classs sudah dideklarasikan awal = 1
            String id_presensi = Integer.toString(id);
            cek.setData(id_presensi);
            run();//simpan ke data untuk nantinya dipakai di method bawah
        }

        @Override
        public void run() {
            cek cek = new cek();
            // cek.getData();
            String id = cek.getData();
            Calendar c1 = Calendar.getInstance();
            SimpleDateFormat sdf1 = new SimpleDateFormat("d/M/yy h:m a");
            String strdate1 = sdf1.format(c1.getTime());
//            String x = "1";
//            String data = x + strdate1; //untuk  di generate k qr code nya
//            cek.setDataQr(data);
            String hasil = cek.getDataQr();

            TextView tanggal = (TextView) findViewById(R.id.textView);

            tanggal.setText(strdate1);
            handler.postDelayed(this, 1000);

            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();

            try {
                BitMatrix bitMatrix = multiFormatWriter.encode(strdate1, BarcodeFormat.QR_CODE, 400, 400);
                BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                imageView = (ImageView) findViewById(R.id.imageView);
                imageView.setImageBitmap(bitmap);
            } catch (WriterException e) {
                Toast.makeText(getApplicationContext(), "eror",
                        Toast.LENGTH_SHORT).show();
            }

        }
    };
}
