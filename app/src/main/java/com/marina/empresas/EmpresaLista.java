package com.marina.empresas;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class EmpresaLista implements Serializable {

    @SerializedName("enterprises")
    private ArrayList<Empresa> lista;

    public EmpresaLista(ArrayList<Empresa> lista) {
        this.lista = lista;
    }

    public ArrayList<Empresa> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Empresa> lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        String empresas="";
        for (Empresa e: lista) {
            empresas = empresas + e.getEnterpriseName()+ "\n";
        }

        return empresas;
    }
}
