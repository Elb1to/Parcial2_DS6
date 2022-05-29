package me.elb1to.parcial2_ds6.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import me.elb1to.parcial2_ds6.R;

public class GradeGrid extends BaseAdapter {

    private final Context context;
    private final String[] web;
    private final int[] imageId;

    public GradeGrid(Context c, String[] web, int[] imageId) {
        context = c;
        this.imageId = imageId;
        this.web = web;
    }

    @Override
    public int getCount() {
        return web.length;
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

            courseName.setText(web[position]);
            courseGrade.setText("F");
            courseIcon.setImageResource(imageId[position]);
            courseGradeIcon.setImageResource((!courseGrade.getText().equals("D") || !courseGrade.getText().equals("F")) ? R.drawable.approved : R.drawable.failed);
        } else {
            grid = convertView;
        }

        return grid;
    }
}
