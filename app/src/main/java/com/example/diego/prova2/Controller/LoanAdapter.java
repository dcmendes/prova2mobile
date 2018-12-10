package com.example.diego.prova2.Controller;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import com.example.diego.prova2.Model.Installment;

import java.util.ArrayList;

public class LoanAdapter extends ArrayAdapter <Installment> {

    Context context;
    int nResource;



    public LoanAdapter(@NonNull Context context, int resource, @NonNull ArrayList <Installment> objects) {
        super(context, resource);
        this.context = context;
        this.nResource = resource;
    }
}
