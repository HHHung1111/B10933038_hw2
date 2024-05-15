package com.example.b10933038_hw2;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<University> universities;
    private RecyclerView recyclerView;

    private UniversityAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        universities = new ArrayList<>();
        universities.add(new University("國立臺灣大學", "國立臺灣大學（National Taiwan University, NTU）是臺灣的一所國立綜合性大學，建校於1928年。", R.drawable.ntu));
        universities.add(new University("國立臺北大學", "國立臺北大學（National Taipei University, NTPU）位於臺灣臺北市三峽區，是臺灣的一所國立大學。", R.drawable.ntpu));
        universities.add(new University("國立政治大學", "國立政治大學（National Chengchi University, NCCU）是臺灣一所以社會科學為主的國立綜合性大學。", R.drawable.nccu));
        universities.add(new University("國立臺灣科技大學", "國立臺灣科技大學（National Taiwan University of Science and Technology, NTUST）是臺灣的一所國立大學，簡稱台科大。", R.drawable.ntust));
        universities.add(new University("國立臺北科技大學", "國立臺北科技大學（National Taipei University of Technology, NTUT）是一所位於臺灣臺北市的國立大學。", R.drawable.ntut));

        ListView listView = findViewById(R.id.listView);
        UniversityAdapter adapter = new UniversityAdapter(this, universities);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                University selectedUniversity = universities.get(position);
                Intent intent = new Intent(MainActivity.this, UniversityDetailActivity.class);
                intent.putExtra("University", selectedUniversity);
                startActivity(intent);
            }
        });
    }
}
