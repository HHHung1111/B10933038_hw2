package com.example.b10933038_hw2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class UniversityAdapter extends ArrayAdapter<University> {

    public UniversityAdapter(Context context, ArrayList<University> universities) {
        super(context, 0, universities);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final University university = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_university, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView nameTextView = convertView.findViewById(R.id.nameTextView);
        Button detailButton = convertView.findViewById(R.id.detailButton);

        imageView.setImageResource(university.getImageResourceId());
        nameTextView.setText(university.getName());

        // 将按钮的点击事件改为监听器
        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 执行切换画面的逻辑
                Intent intent = new Intent(getContext(), UniversityDetailActivity.class);
                intent.putExtra("University", university);
                getContext().startActivity(intent);
            }
        });

        return convertView;
    }
}
