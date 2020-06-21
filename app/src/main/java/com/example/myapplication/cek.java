package com.example.myapplication;

public class cek {
    private String data;

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    private String dataScanner;
    private String dataQr;

    public void setDataScanner(String x) {
        this.dataScanner = x;
    }

    public void setDataQr(String y) {
        this.dataQr = y;
    }

    public String getDataScanner() {
        return dataScanner;
    }

    public String getDataQr() {
        return dataQr;
    }


    private Integer id_presensi = 1;
    private Integer id;

    public Integer getId_presensi() {
        return id_presensi;
    }

    public void setId_presensi(Integer id_presensi) {
        this.id_presensi = id_presensi;
    }

    public void cek() {
        String dataQr = getDataQr();
        String dataScan = getDataScanner();

        if (dataQr == dataScan) {
            id = getId_presensi();
            Integer ini = id++;
            setId_presensi(ini);
        }
    }
}
