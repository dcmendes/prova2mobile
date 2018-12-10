package com.example.diego.prova2.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.diego.prova2.Controller.Loan;
import com.example.diego.prova2.Controller.LoanAdapter;
import com.example.diego.prova2.Model.Installment;
import com.example.diego.prova2.R;

public class AmountView extends AppCompatActivity {

    ListView list;
    Loan loan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amount_view);

        list = (ListView) findViewById(R.id.list);

        Intent intent = getIntent();
        int mounths = intent.getExtras().getInt("meses");
        double amountValue = intent.getExtras().getDouble("amountValue");
        double rateInterest = intent.getExtras().getDouble("txJuros");

        Loan l = new Loan(amountValue , rateInterest , mounths);
        LoanAdapter adapter = new LoanAdapter(this, R.layout.template, l.getListInstallments());

        list.setAdapter(adapter);
        double sum = 0;
        for (Installment in: l.getListInstallments()){
            sum += in.getValue();
        }



    }
}
