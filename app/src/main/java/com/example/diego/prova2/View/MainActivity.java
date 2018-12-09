package com.example.diego.prova2.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.diego.prova2.R;

import java.text.NumberFormat;

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
    private TextView resultado2;
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
        resultado2 = (TextView) findViewById(R.id.resultado2);
        resultado.setText(currencyFormat.format(0));
        amountEdit.addTextChangedListener (resultEditWatcher);
        button = (Button)findViewById(R.id.btSim);
        pay = (EditText) findViewById(R.id.nPay);

    }

    private void calculate() {

        percentTextView.setText(percentFormat.format(percent));

        double tip = billAmount * percent;
        double total = billAmount + tip;

        resultado.setText(currencyFormat.format((tip)));

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

    public void Simulation(View view){


        //resultado2.setText(String.valueOf(m));


        //resultado2.setText(t.toString());
        if ( amountEdit.getText().length() == 0  || pay.getText().length() == 0 ) {
            resultado2.setText("Campos vazios");
        }
        else {
            calculate();
            Double d = Double.parseDouble(amountEdit.getText().toString());
            Double t = Double.parseDouble(pay.getText().toString());

            m = d * (Math.pow((1 + percent), t));
            p = m /t;
            resultado2.setText(String.valueOf(currencyFormat.format(p)));
        }

    }

  private final TextWatcher resultEditWatcher;

    {
        resultEditWatcher = new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s,
                                      int i, int i1, int i2) {

                try {

                    billAmount = Double.parseDouble(s.toString()) ;
                    resultado.setText(currencyFormat.format(billAmount));
                } catch (NumberFormatException e) {

                    resultado.setText(R.string.enter_amount);
                    billAmount = 0.0;
                }
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
