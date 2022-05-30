package me.elb1to.parcial2_ds6.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import me.elb1to.parcial2_ds6.R;

public class GradeGrid extends BaseAdapter {

    private final Context context;
    private final List<String> courseName;
    private final List<Integer> courseIcon;

    public GradeGrid(Context c, List<String> courseName, List<Integer> courseIcon) {
        context = c;
        this.courseIcon = courseIcon;
        this.courseName = courseName;
    }

    @Override
    public int getCount() {
        return courseName.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            grid = new View(context);
            grid = inflater.inflate(R.layout.grid, null);
            TextView courseName = grid.findViewById(R.id.grid_course_name);
            TextView courseGrade = grid.findViewById(R.id.grid_course_grade);
            ImageView courseIcon = grid.findViewById(R.id.grid_image);
            ImageView courseGradeIcon = grid.findViewById(R.id.grid_course_grade_icon);

            courseName.setText(this.courseName.get(position));
            courseGrade.setText("F");
            courseIcon.setImageResource(this.courseIcon.get(position));
            courseGradeIcon.setImageResource((!courseGrade.getText().equals("D") || !courseGrade.getText().equals("F")) ? R.drawable.approved : R.drawable.failed);
        } else {
            grid = convertView;
        }

        return grid;
    }
}
