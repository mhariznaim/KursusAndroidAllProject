package com.ftmk.mhariznaim.hellowwduniakotlin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityCounter extends AppCompatActivity {

  TextView txtVNumber;
  int intCurrNum ;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_counter);
    txtVNumber = (TextView) findViewById(R.id.txtVwNumber);
    txtVNumber.setText("0");
  }

  public void fnAdd(View view)
  {
    String strTst= (String) txtVNumber.getText();
    intCurrNum = Integer.parseInt(txtVNumber.getText().toString());
    intCurrNum++;
    txtVNumber.setText(String.valueOf(intCurrNum));
  }

  public void fnDecrease(View view)
  {
    intCurrNum = Integer.parseInt(txtVNumber.getText().toString());
    if(intCurrNum < 1)
    {
      Toast.makeText(getApplicationContext(),"Number cannot be zero", Toast.LENGTH_LONG).show();
    }
    else
    {
      intCurrNum--;
      txtVNumber.setText(String.valueOf(intCurrNum));

    }
  }

  public void fnReset(View view)
  {
    txtVNumber.setText(String.valueOf(0));
  }
}
