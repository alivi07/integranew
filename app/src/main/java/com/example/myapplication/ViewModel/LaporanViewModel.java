package com.example.myapplication.ViewModel;

import com.example.myapplication.api.LaporanService;
import com.example.myapplication.model.AbsenItem;
import com.example.myapplication.model.LaporanResponse;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LaporanViewModel extends ViewModel {
    private LaporanService laporanService;
    //private MutableLiveData<List<AbsenItem>> listMutableLiveData = new MutableLiveData<List<AbsenItem>>();
    //private MutableLiveData<List<AbsenItem>> listMutableLiveData;
    private MutableLiveData<List<AbsenItem>> listMutableLiveData = new MutableLiveData();

    public void setDataLaporan(String email, String tanggal) {
        if (this.laporanService == null) {
            laporanService = new LaporanService();
        }
        laporanService.getAPILaporan().getAllLaporan("get", email, tanggal).enqueue(new Callback<LaporanResponse>(){
            @Override
            public void onResponse (Call<LaporanResponse> call, Response<LaporanResponse> response) {
                LaporanResponse laporanResponse = response.body();
                if (laporanResponse != null && !laporanResponse.isError()) {
                    List<AbsenItem> absenItems = laporanResponse.getAbsen();
                    listMutableLiveData.postValue(absenItems);
                }
            }

            @Override
            public void onFailure (Call<LaporanResponse> call, Throwable t){

        }
        });
    }

    public LiveData<List<AbsenItem>> getAbsen() {
        return listMutableLiveData;
    }
}
