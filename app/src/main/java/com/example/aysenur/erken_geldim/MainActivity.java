package com.example.aysenur.erken_geldim;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends AppCompatActivity {
private String ulkeler[]={"Turkiye","Suriye","Amerika","Ukrayna","Macarisrtan"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         ListView listemiz= (ListView) findViewById(R.id.listview);//1.adım
        ArrayAdapter<String>veriAdaptoru=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                android.R.id.text1, ulkeler);
        listemiz.setAdapter(veriAdaptoru);
        listemiz.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder alertdiyalog=new AlertDialog.Builder(MainActivity.this);
                alertdiyalog.setMessage(ulkeler[position]).setCancelable(false)
                        /*
                        Burada oluşturacağımız diyalogun göstereceği yazıyı ayarlıyoruz.
                        Parametre olarak ulkeler dizisinin position indisli öğesini veriyoruz.
                         position, onItemClick() metoduyla bize geliyor. Tıklanan öğenin listedeki sırasını elde etmiş oluyoruz.
                         */
                             .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                                 @Override
                                 public void onClick(DialogInterface dialog, int which) {
                                     dialog.dismiss();
                                 }
                             });
                alertdiyalog.create().show();
            }
        });
    }
}
