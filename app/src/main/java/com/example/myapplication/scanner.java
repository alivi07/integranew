package com.example.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.api.ScanService;
import com.example.myapplication.dialog.LoadingDialog;
import com.example.myapplication.model.ScanResponse;
import com.example.myapplication.model.User;
import com.example.myapplication.util.PrefUtil;
import com.google.zxing.Result;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class scanner extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;
    private ScanResponse scanResponse;
    ScanService scanService;
    String email, tanggal;
    LoadingDialog loadingDialog;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        Log.v("TAG", result.getText()); // Prints MainActivity results
        Log.v("TAG", result.getBarcodeFormat().toString());

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //  builder.setTitle("Scan Result");
        builder.setMessage("Scan Success !");
        AlertDialog alert1 = builder.create();
        alert1.show();

        tanggal = result.getText();
        cek cek = new cek();
        cek.setDataScanner(tanggal);
        if (tanggal != null) {
            cek.cek();
        }
        // mScannerView.resumeCameraPreview(this);
        scannerAct();


    }

    void scannerAct() {
        User user = PrefUtil.getUser(this, PrefUtil.USER_SESSION);
        email = user.getEmail();
        scanService = new ScanService(this);
        scanService.doScanner(email, tanggal, new Callback() {
            @Override
            public void onResponse(retrofit2.Call call, retrofit2.Response response) {
                ScanResponse scanResponse = (ScanResponse) response.body();

                if (scanResponse != null) {
                    if (!scanResponse.isError()) {
                        //PrefUtil.putUser(MainActivity.this, PrefUtil.USER_SESSION, user);
                        Toast.makeText(scanner.this, scanResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        MainActivity2.start(scanner.this);
                        scanner.this.finish();
                    }
                    loadingDialog.dismissDialog();
                    Toast.makeText(scanner.this, scanResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(retrofit2.Call call, Throwable t) {
                Toast.makeText(scanner.this, "An error occurred!", Toast.LENGTH_SHORT).show();
//                progressDialog.dismiss();
                loadingDialog.dismissDialog();
            }

        });
    }

}
