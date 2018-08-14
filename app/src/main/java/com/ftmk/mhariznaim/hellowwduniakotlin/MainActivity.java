package com.ftmk.mhariznaim.hellowwduniakotlin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  TextView textView;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    textView = (TextView) findViewById(R.id.txtVwHelloww);
  }

  public void fnButtonTekan(View view)
  {
    Log.d("cekDebug","Okay ada buton action");
    textView.setText("wooha dah berubah");
  }
}
