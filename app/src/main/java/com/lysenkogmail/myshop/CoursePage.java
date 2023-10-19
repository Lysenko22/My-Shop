package com.lysenkogmail.myshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lysenkogmail.myshop.model.Order;

public class CoursePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_page);

        ConstraintLayout courseBg=findViewById(R.id.coursePageBg);
        ImageView courseImage=findViewById(R.id.coursePageImage);
        TextView courseTitle=findViewById(R.id.coursePageTitle);
        TextView courseData=findViewById(R.id.coursePageData);
        TextView courseLevel=findViewById(R.id.coursePageLevel);

        courseBg.setBackgroundColor(getIntent().getIntExtra("courseBg",0));
        courseImage.setImageResource(getIntent().getIntExtra("courseImage",0));
        courseTitle.setText(getIntent().getStringExtra("courseTitle"));
        courseData.setText(getIntent().getStringExtra("courseData"));
        courseLevel.setText(getIntent().getStringExtra("courseLevel"));

    }

    public void addToCart(View view){
        int item_id=getIntent().getIntExtra("courseId",0);
        Order.items_id.add(item_id);
        Toast.makeText(this,"Додано!",Toast.LENGTH_LONG).show();


    }
}