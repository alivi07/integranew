package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.InputType;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tahun extends AppCompatActivity {
    private EditText etTahun;
    private TextView tvTahun, coa;
    private Button btnNext2;
    DecimalFormat precision = new DecimalFormat("0.00");

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tahun);
        final LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        //Membuat array EditText
        final List<EditText> allEts = new ArrayList<EditText>();
        List<TextView> allTvs = new ArrayList<TextView>();

        final List<Integer> listTahun = new ArrayList<Integer>();

        final int jmlTahun = getIntent().getIntExtra("jumlahTahun", 0);
        for (int i = 0; i < jmlTahun; i++) {
            tvTahun = new TextView(this);
            etTahun = new EditText(this);
            etTahun.setInputType(InputType.TYPE_CLASS_NUMBER);
            allTvs.add(tvTahun);
            allEts.add(etTahun);
            tvTahun.setText("Tahun ke-" + (i + 1));
            ll.addView(tvTahun);
            ll.addView(etTahun);
        }
        btnNext2 = new Button(this);
        btnNext2.setText("NEXT");
        btnNext2.setTextColor(Color.parseColor("#ffffff"));
        btnNext2.setBackground(ContextCompat.getDrawable(this, R.drawable.tombol));
        btnNext2.setId(80);
        ll.addView(btnNext2);
        TextView tv = new TextView(this);
        ll.addView(tv);
        //Menampilkan ke layout android
        this.setContentView(ll);
        String metode = getIntent().getStringExtra("metode");
        coa = new TextView(this);
        ll.addView(coa);
        coa.setText(metode);
        btnNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //list produksi*harga = income
                List<Integer> income = new ArrayList<Integer>();
                //list Di
                List<String> di = new ArrayList<String>();
                //list Taxable income = income-opex-Di
                List<String> taxableIncome = new ArrayList<String>();
                //list tax = tax/100*taxable income
                List<String> tax = new ArrayList<String>();
                //list NCF =income-opex-tax
                List<String> ncf = new ArrayList<String>();
                int capital = getIntent().getIntExtra("capital", 0);
                int nonCapital = getIntent().getIntExtra("nonCapital", 0);
                int harga = getIntent().getIntExtra("harga", 0);
                int opex = getIntent().getIntExtra("opex", 0);
                int pajak = getIntent().getIntExtra("pajak", 0);
                String metode = getIntent().getStringExtra("metode");

                int investasi = -1 * (capital + nonCapital);
                double dblTotalNCF = 0;
                //total produksi
                double totProduksi = 0;
                for (int i = 0; i < jmlTahun; i++) {
                    totProduksi += Double.parseDouble(allEts.get(i).getText().toString());
                }
                for (int i = 0; i < jmlTahun; i++) {
                    int produksi = Integer.parseInt(allEts.get(i).getText().toString());
                    int intIncome = produksi * harga;
                    double R = 0, intDi = 0, dblTaxableIncome = 0, dblTax = 0;
                    if (metode.equals("Straight Line")) {
                        //di = K.1/N
                        double jml = jmlTahun;
                        R = 1 / jml;
                        intDi = capital * R;
                        di.add(String.format("%.2f", intDi));
                    } else if (metode.equals("Declining Balance")) {
                        //Di=K.R(1-R)ˆi-1
                        double jml = jmlTahun;
                        R = 1 / jml;
                        intDi = capital * R * Math.pow((1 - R), (i + 1) - 1);
                        di.add(String.format("%.2f", intDi));
                    } else if (metode.equals("Double Declining Balance")) {
                        //Di = Di=K.2R(1-2R)^i-1
                        double jml = jmlTahun;
                        R = 1 / jml;
                        intDi = capital * 2 * R * Math.pow((1 - 2 * R), (i + 1) - 1);
                        di.add(String.valueOf(intDi));
                    } else if (metode.equals("Unit of Production")) {
                        //Depresiation rate (R) = Produksi pada tahun ke-i / reserve   Di = K . R
                        //Di = Produksi pada tahun ke-i / reserve x K
                        intDi = produksi / totProduksi * capital;
                        di.add(String.valueOf(intDi));
                    } else if (metode.equals("Sum-of the Year")) {
                        //Di=K.2(N-(i-1))/N(N+1)
                        double jml = jmlTahun;
                        double dblCapital = capital;
                        intDi = (dblCapital * 2 * (jml - ((i + 1) - 1))) / (jml * (jml + 1));
                        di.add(String.valueOf(intDi));
                    }
                    dblTaxableIncome = intIncome - opex - intDi;
                    double dblPajak = pajak;
                    dblTax = (dblPajak / 100) * dblTaxableIncome;
                    double dblNcf = intIncome - opex - dblTax;
                    dblTotalNCF = dblTotalNCF + dblNcf;
                    listTahun.add(produksi);
                    income.add(intIncome);
                    taxableIncome.add(String.format("%.2f", dblTaxableIncome));
                    tax.add(String.format("%.2f", dblTax));
                    ncf.add(String.format("%.2f", dblNcf));
                }
                dblTotalNCF = dblTotalNCF + investasi;
                Intent intent = new Intent(Tahun.this, PerhitunganNcf.class);
                intent.putExtra("jumlahTahun", getIntent().getIntExtra("jumlahTahun", 0));
                intent.putExtra("capital", capital);
                intent.putExtra("nonCapital", nonCapital);
                intent.putIntegerArrayListExtra("produksi", (ArrayList<Integer>) listTahun);
                intent.putExtra("harga", harga);
                intent.putExtra("opex", opex);
                intent.putIntegerArrayListExtra("income", (ArrayList<Integer>) income);
                intent.putStringArrayListExtra("di", (ArrayList<String>) di);
                intent.putStringArrayListExtra("taxableIncome", (ArrayList<String>) taxableIncome);
                intent.putStringArrayListExtra("tax", (ArrayList<String>) tax);
                intent.putStringArrayListExtra("ncf", (ArrayList<String>) ncf);
                intent.putExtra("totalNCF", dblTotalNCF);
                intent.putExtra("investasi", investasi);
                intent.putExtra("metode", metode);
                intent.putExtra("pajak", pajak);

                startActivity(intent);
            }
        });
        //Menampilkan isi EditText ke TextView  tv.setText(allEds.get(1).getText().toString());
    }


}