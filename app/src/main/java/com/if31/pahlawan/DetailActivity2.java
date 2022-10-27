package com.if31.pahlawan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity2 extends AppCompatActivity {

    private ImageView ivfoto;
    private TextView tvNama , tvTentang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);

        ivfoto = findViewById(R.id.iv_foto);
        tvNama = findViewById(R.id.tv_nama);
        tvTentang = findViewById(R.id.tv_tentang);

        Intent intent = getIntent();
        String nama = intent.getStringExtra("varNama");
        String tentang = intent.getStringExtra("varTentang");
        String foto = intent.getStringExtra("varFoto");

        setTitle(nama);
        tvNama.setText(nama);
        tvTentang.setText(tentang);
        Glide.with(this).load(foto).into(ivfoto);



    }
}