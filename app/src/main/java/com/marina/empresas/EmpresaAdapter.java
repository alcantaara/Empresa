package com.marina.empresas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EmpresaAdapter extends BaseAdapter{

    private ArrayList<Empresa> empresas;
    private LayoutInflater layoutInflater;
    private Context context;

    public EmpresaAdapter(ArrayList<Empresa> empresas, Context context) {
        this.empresas = empresas;
        this.layoutInflater = (LayoutInflater.from(context));
        this.context = context;
    }


    @Override
    public int getCount() {
        return empresas.size();
    }

    @Override
    public Object getItem(int position) {
        return empresas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = layoutInflater.inflate(R.layout.empresa,null);

        Empresa empresa = empresas.get(position);


        TextView empresaNome;
        empresaNome = (TextView) view.findViewById(R.id.empresaNome);
        empresaNome.setText(empresa.getEnterpriseName());

        TextView empresaTipo;
        empresaTipo = (TextView) view.findViewById(R.id.empresaTipo);
        empresaTipo.setText(empresa.getEnterpriseType().getEnterprise_type_name());

        TextView empresaPais;
        empresaPais = (TextView) view.findViewById(R.id.empresaPais);
        empresaPais.setText(empresa.getCountry());

        return view;
    }
}
