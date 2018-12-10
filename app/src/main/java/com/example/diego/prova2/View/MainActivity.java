package com.example.diego.prova2.View;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.diego.prova2.Controller.Loan;
import com.example.diego.prova2.R;

import java.text.NumberFormat;
import java.text.ParseException;

public class MainActivity extends AppCompatActivity {

    private double m, p, i;

    private int t;
    private double billAmount = 0.0;
    private double percent = 0.0;
    private static NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    private static NumberFormat percentFormat = NumberFormat.getPercentInstance();

    private TextView percentTextView;
    private TextView amountText;
    private EditText amountEdit;
    private TextView resultado;
    private SeekBar percentSeekBar;
    private EditText pay;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        percentTextView = (TextView) findViewById(R.id.percentTextView);
        amountEdit = (EditText) findViewById(R.id.amountEdit);
        resultado = (TextView) findViewById(R.id.result);

        percentSeekBar = (SeekBar) findViewById(R.id.percentSeekBar);
        percentSeekBar.setOnSeekBarChangeListener(seekBarListener);
        percentFormat.setMinimumFractionDigits(2);
        resultado.setText(currencyFormat.format(0));

        button = (Button)findViewById(R.id.btSim);
        pay = (EditText) findViewById(R.id.nPay);

    }

    public void syncronyzingSeek(){
        percent = percentSeekBar.getProgress();

        this.percentTextView.setText(percentFormat.format(percent/100));
    }


   private final SeekBar.OnSeekBarChangeListener seekBarListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            syncronyzingSeek();

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

public void simListView(View view) throws ParseException {

   if (amountEdit.getText().length() == 0 || pay.getText().length() == 0){

        emptyForm();

    } else {

        Loan  l = null;
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        currency.setGroupingUsed(true);
        currency.setMinimumFractionDigits(2);

        this.m = 0.0;
        this.t = Integer.parseInt(pay.getText().toString());
        this.i  = 0.1;
        m = Double.parseDouble(amountEdit.getText().toString());
        i = Double.parseDouble(pay.getText().toString());

        Bundle params = new Bundle();
        params.putInt("mounth", t);
        params.putDouble("Amount", m);
        params.putDouble("Rate Interest", i);

        Intent intent = new Intent(this, AmountView.class);
        intent.putExtras(params);
        startActivity(intent);

   }
}

    public void emptyForm() {
        new AlertDialog.Builder(this)
                .setTitle("Campo vazio")
                .setMessage("O campo preço está vazio")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        emptySeekBar();
                    }
                }).show();
    }



        public void emptySeekBar(){
        percentSeekBar.setProgress(0);
    }

}
