package com.ftmk.mhariznaim.hellowwduniakotlin;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChooseRandomActivity extends AppCompatActivity {

    EditText edtGuess;
    int intCnt = 0, intRandom;
    Button btnGuess, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_random);
        edtGuess = findViewById(R.id.edtTxtNum);
        btnGuess = findViewById(R.id.btnGuess);
        btnReset = findViewById(R.id.btnReset);

        intRandom = (int) (Math.random() * 100);
        Log.d("NomborTeka", intRandom + "");

        if (intCnt < 3) {
            btnReset.setVisibility(View.INVISIBLE);
        }
    }

    public void fnGuess(View view) {
        Log.d("NomborTeka", intRandom + "");
        if (intCnt < 3) {

            int intUserNum = Integer.valueOf(edtGuess.getText().toString());
            if (intUserNum == intRandom) {
                Toast.makeText(getApplicationContext(), "Fuyoo betul teka", Toast.LENGTH_LONG).show();
            } else if (intUserNum < intRandom) {
                Toast.makeText(getApplicationContext(), "Kurang sangat tu nombor", Toast.LENGTH_LONG).show();
                intCnt++;
            } else if (intUserNum > intRandom) {
                Toast.makeText(getApplicationContext(), "Besauu sangat tu nombor", Toast.LENGTH_LONG).show();
                intCnt++;
            }
        } else {
            btnReset.setVisibility(View.VISIBLE);
            btnGuess.setVisibility(View.INVISIBLE);
            Toast.makeText(getApplicationContext(), "Dah Teka Lebih 3 la bang", Toast.LENGTH_LONG).show();
        }


    }

    public void fnReset(View view) {
        btnGuess.setVisibility(View.VISIBLE);
        btnReset.setVisibility(View.INVISIBLE);
        intCnt = 0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_pilih,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.menuAboutUs:
                //go to new Page ; Web Activity/ Web View.
                Intent intent = new Intent(ChooseRandomActivity.this, WebActivity.class);
                startActivity(intent);
                break;

            case R.id.menuContactUs:
                //display Toast message
                Toast.makeText(getApplicationContext(),"You can contact us at 014444 tekan tak dapat",Toast.LENGTH_LONG).show();
                break;

            case R.id.menuShare:
                //share by Dialog
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ChooseRandomActivity.this);
                alertDialogBuilder.setTitle("Nak Kongsi kepada Masyarakat?");
                alertDialogBuilder.setMessage("Betul ni nak kongsi kepada masyakat?");
                alertDialogBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alertDialogBuilder.setNegativeButton("NO!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alertDialogBuilder.show();
                break;

            case R.id.menuExit:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
