package com.essejose.metrosp.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by essejose on 26/06/2017.
 */

public class Linha implements Parcelable {

    protected Linha(Parcel in) {
        cor = in.readString();
        numero = in.readString();
        urlImagem = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cor);
        dest.writeString(numero);
        dest.writeString(urlImagem);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Linha> CREATOR = new Creator<Linha>() {
        @Override
        public Linha createFromParcel(Parcel in) {
            return new Linha(in);
        }

        @Override
        public Linha[] newArray(int size) {
            return new Linha[size];
        }
    };

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getUrlImage() {
        return urlImagem;
    }

    public void setUrlImage(String urlImage) {
        this.urlImagem = urlImage;
    }

    private String cor;
    private String numero;
    private String urlImagem;
}
