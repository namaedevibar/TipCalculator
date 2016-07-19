package com.activity.devibar.prelimexam;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import javax.crypto.ExemptionMechanismException;

public class MainActivity extends AppCompatActivity {

    private EditText mBill;
    private EditText mNum;
    private SeekBar mTip;
    private TextView mTipPerson;
    private TextView mTotalTip;
    private TextView mSeekVal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBill = (EditText) findViewById(R.id.etBill);
        mNum = (EditText) findViewById(R.id.etNumOfPeople);
        mTip = (SeekBar) findViewById(R.id.skTip);
        mTipPerson = (TextView) findViewById(R.id.txtTip);
        mTotalTip = (TextView) findViewById(R.id.txtTotal);
        mSeekVal = (TextView) findViewById(R.id.txtSbVal);


       listeners();


    }

    public void listeners(){
        try{
            mTip.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress,
                                              boolean fromUser) {
                    int skVal = mTip.getProgress();
                    String x =Integer.toString(skVal);
                    mSeekVal.setText(x);

                    compute();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {


                }
            });

            mBill.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    compute();


                }
            });

            mNum.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    compute();
                }
            });



        }catch(Exception e){}


    }

    public void compute(){

        try{

            int tip = Integer.parseInt(mSeekVal.getText().toString());
            double bill;
            bill = Double.parseDouble(mBill.getText().toString());
            int num = Integer.parseInt(mNum.getText().toString());

            double initialBill;
            initialBill = bill/num;

            double tipPerPerson = 0.00f;
            tipPerPerson = initialBill * tip/100;

            mTipPerson.setText(String.format("%.2f", tipPerPerson));

            double totalPerPerson = 0.00f;
            totalPerPerson = initialBill +tipPerPerson;
            mTotalTip.setText((String.format("%.2f", totalPerPerson)));

        }catch(Exception e){

        }



    }

}
