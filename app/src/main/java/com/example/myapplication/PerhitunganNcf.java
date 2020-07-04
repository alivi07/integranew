package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PerhitunganNcf extends AppCompatActivity {
    TextView tvProduksi, tvTahun;
    View view;
    TableRow tableRow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perhitungan_ncf);
        final List<Integer> listTahun = new ArrayList<Integer>();
        final int jmlTahun = getIntent().getIntExtra("jumlahTahun", 0);

        TableLayout prices = (TableLayout) findViewById(R.id.tablelayout);
        prices.setStretchAllColumns(true);
        prices.bringToFront();
        for (int i = -1; i < jmlTahun + 1; i++) {
            TableRow tableRow = new TableRow(this);
            tableRow.setPadding(5, 5, 5, 5);
            if (i % 2 == 0) {
                tableRow.setBackgroundColor(Color.parseColor("#ECEFF1"));
            } else {
                tableRow.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }

            TextView tvTahun = new TextView(this);
            TextView tvProduksi = new TextView(this);
            TextView tvIncome = new TextView(this);
            TextView tvCapital = new TextView(this);
            TextView tvNonCapital = new TextView(this);
            TextView tvOpex = new TextView(this);
            TextView tvDi = new TextView(this);
            TextView tvTaxableIncome = new TextView(this);
            TextView tvTax = new TextView(this);
            TextView tvNCF = new TextView(this);

            tvTahun.setPadding(0, 3, 0, 3);
            tvProduksi.setPadding(0, 3, 0, 3);
            tvIncome.setPadding(0, 3, 0, 3);
            tvCapital.setPadding(0, 3, 0, 3);
            tvNonCapital.setPadding(0, 3, 0, 3);
            tvOpex.setPadding(0, 3, 0, 3);
            tvDi.setPadding(0, 3, 0, 3);
            tvTaxableIncome.setPadding(0, 3, 0, 3);
            tvTax.setPadding(0, 3, 0, 3);
            tvNCF.setPadding(0, 3, 0, 3);

            if (i == -1) {
                tvTahun.setText(String.valueOf(i + 1));
                tvProduksi.setText("");
                tvIncome.setText("");
                tvCapital.setText(String.valueOf(getIntent().getIntExtra("capital", 0)));
                tvNonCapital.setText(String.valueOf(getIntent().getIntExtra("nonCapital", 0)));
                tvOpex.setText("");
                tvDi.setText("");
                tvTaxableIncome.setText("");
                tvTax.setText("");
                tvNCF.setText(String.valueOf(getIntent().getIntExtra("investasi", 0)));
            } else if (i != -1 && i <= jmlTahun - 1) {
                tvTahun.setText(String.valueOf(i + 1));
                tvProduksi.setText(String.valueOf(getIntent().getIntegerArrayListExtra("produksi").get(i)));
                tvIncome.setText(String.valueOf(getIntent().getStringArrayListExtra("income").get(i)));
                tvCapital.setText("");
                tvNonCapital.setText("");
                tvOpex.setText(String.valueOf(getIntent().getIntExtra("opex", 0)));
                tvDi.setText(getIntent().getStringArrayListExtra("di").get(i));
                tvTaxableIncome.setText(getIntent().getStringArrayListExtra("taxableIncome").get(i));
                tvTax.setText(getIntent().getStringArrayListExtra("tax").get(i));
                tvNCF.setText(getIntent().getStringArrayListExtra("ncf").get(i));
            } else {
                tvTahun.setText("");
                tvProduksi.setText("");
                tvIncome.setText("");
                tvCapital.setText("");
                tvNonCapital.setText("");
                tvOpex.setText("");
                tvDi.setText("");
                tvTaxableIncome.setText("");
                tvTax.setText("Total : ");
                tvTax.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);
                tvNCF.setText(String.format("%.2f", getIntent().getDoubleExtra("totalNCF", 0)));
            }
            tableRow.addView(tvTahun);
            tableRow.addView(tvProduksi);
            tableRow.addView(tvIncome);
            tableRow.addView(tvCapital);
            tableRow.addView(tvNonCapital);
            tableRow.addView(tvOpex);
            tableRow.addView(tvDi);
            tableRow.addView(tvTaxableIncome);
            tableRow.addView(tvTax);
            tableRow.addView(tvNCF);
            prices.addView(tableRow);
        }

    }

}