package com.example.modul2_kel32;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class DetailActivity extends AppCompatActivity {

    private TextView tvNama, tvEmail, tvLast;
    private ImageView ivAvatar;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAbout();
            }
        });

        tvNama = findViewById(R.id.tv_first_name);
        tvLast = findViewById(R.id.tv_last_name);
        tvEmail = findViewById(R.id.tv_email);
        ivAvatar = findViewById(R.id.iv_avatar);

        if (getIntent().hasExtra("name")) {

            String nama = getIntent().getStringExtra("name");
            String last = getIntent().getStringExtra("last");
            String email = getIntent().getStringExtra("email");
            String avatar = getIntent().getStringExtra("avatar");
            Glide.with(this).load(avatar).into(ivAvatar);
            tvLast.setText(last);
            tvEmail.setText(email);
            tvNama.setText(nama);
        }
    }

    public void openAbout(){
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }
}
