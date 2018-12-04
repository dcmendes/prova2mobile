package com.example.diego.prova2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private double billAmount = 0.0;
    private double percent = 0.15;
    private static NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    private static NumberFormat percentFormat = NumberFormat.getPercentInstance();

    private TextView percentTextView;
    private TextView amountText;
    private  EditText amountEdit;
    private TextView resultado;
    private SeekBar percentSeekBar;

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

        /*percentSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                double valor= seekBar.getProgress();
                percentTextView.setText((percentFormat.format(valor/1000.00).toString()));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });*/


        resultado.setText(currencyFormat.format(0));
        amountEdit.addTextChangedListener (resultEditWatcher);

    }

    private void calculate() {
        // formata e mostra a percentagem correta na percentTextView da tela
        percentTextView.setText(percentFormat.format(percent));

        // calcula o valor da gorjeta e o novo valor total
        double tip = billAmount * percent;
        double total = billAmount + tip;
        // formata e mostra os novos valores do troco e total na tela
    //    tipTextView.setText(currencyFormat.format(tip));
        resultado.setText(currencyFormat.format((total)));

    }


   private final SeekBar.OnSeekBarChangeListener seekBarListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            percent = progress/100.0;
            calculate();

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private final TextWatcher resultEditWatcher;

    {
        resultEditWatcher = new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s,
                                      int i, int i1, int i2) {
                // tratamento de exceção para prevenção de erros
                try {
                    // obtem o valor da conta e mostra em valor de moeda na
                    // amountTextView
                    billAmount = Double.parseDouble(s.toString()) ;
                    resultado.setText(currencyFormat.format(billAmount));
                } catch (NumberFormatException e) {
                    // se a entrada for um valor em branco ou não numérico, o cálculo
                    // dará errado e disparará a exceção NumberFormatException
                    resultado.setText(R.string.enter_amount);
                    billAmount = 0.0;
                }
                // invoca o método calculate para atualizar a nova percentagem
                // (re) calcular o valor do troco e total
                calculate();
            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        };
    }

}
