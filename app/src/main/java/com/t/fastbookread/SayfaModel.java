package com.t.fastbookread;

public class SayfaModel {
    private String baslik;
    private String icerik;
    private String tarih;

    public SayfaModel() {
    }

    public SayfaModel(String baslik, String icerik) {
        this.baslik = baslik;
        this.icerik = icerik;
    }

    public SayfaModel(String baslik, String icerik, String tarih) {
        this.baslik = baslik;
        this.icerik = icerik;
        this.tarih = tarih;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }
}
