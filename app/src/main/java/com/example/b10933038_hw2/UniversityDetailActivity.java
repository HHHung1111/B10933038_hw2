package com.example.b10933038_hw2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class UniversityDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_detail);

        ImageView imageView = findViewById(R.id.imageView);
        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);
        Button mapButton = findViewById(R.id.mapButton);
        Button backButton = findViewById(R.id.backButton); // 添加返回按鈕

        Intent intent = getIntent();
        University university = (University) intent.getSerializableExtra("University");

        imageView.setImageResource(university.getImageResourceId());
        nameTextView.setText(university.getName());
        descriptionTextView.setText(university.getDescription());

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + university.getName());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                } else {
                    // 如果用户设备上没有安装Google Maps，则可以打开浏览器并搜索
                    String mapUrl = "https://www.google.com/maps/search/?api=1&query=" + university.getName();
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mapUrl));
                    startActivity(browserIntent);
                }
            }
        });


        backButton.setOnClickListener(new View.OnClickListener() { // 返回按鈕的點擊事件
            @Override
            public void onClick(View v) {
                finish(); // 結束當前 Activity，返回上一個 Activity 或主頁
            }
        });
    }
}
