package com.lysenkogmail.myshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lysenkogmail.myshop.adapter.CategoryAdapter;
import com.lysenkogmail.myshop.model.Category;
import com.lysenkogmail.myshop.model.Course;
import com.lysenkogmail.myshop.model.CourseAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView categoryRecycler,courceRecycler;
    CategoryAdapter categoryAdapter;
   static CourseAdapter courseAdapter;
   static List<Course> courseList=new ArrayList<>();
    static List<Course> fullCourseList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList=new ArrayList<>();
        categoryList.add(new Category(1,"Ігри"));
        categoryList.add(new Category(2,"Сайти"));
        categoryList.add(new Category(3,"Мови"));
        categoryList.add(new Category(4,"Інше"));

        setCategoryRecycler(categoryList);

        courseList.add(new Course(1,"java","Професія Java\nрозробник","1 вересня","Початковий","#424345","test",1));
        courseList.add(new Course(2,"python","Професія Python\nрозробник","10 вересня","Початковий","#9FA52D","test",2));


        setCourseRecycler(courseList);
    }
public void openShoppingCart(View view)
{
    Intent intent=new Intent(this,OrderPage.class);
    startActivity(intent);
}
    private void setCourseRecycler(List<Course> courseList) {


            RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
            courceRecycler=findViewById(R.id.courceRecycler);
            courceRecycler.setLayoutManager(layoutManager);
            courseAdapter=new CourseAdapter(this,courseList);
            courceRecycler.setAdapter(courseAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryList) {
RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
categoryRecycler=findViewById(R.id.categoryRecycler);
categoryRecycler.setLayoutManager(layoutManager);
categoryAdapter=new CategoryAdapter(this,categoryList);
categoryRecycler.setAdapter(categoryAdapter);

fullCourseList.addAll(courseList);

setCourseRecycler(courseList);

    }
    public static void showCoursesByCategory(int category)
    {
        courseList.clear();
        courseList.addAll(fullCourseList);


     List<Course> filterCourses=new ArrayList<>();
for (Course c : courseList){

    if (c.getCategory() == category)
        filterCourses.add(c);
}
courseList.clear();
courseList.addAll(filterCourses);

courseAdapter.notifyDataSetChanged();

}
    }
