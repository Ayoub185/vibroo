package com.example.vibro;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends AppCompatActivity {

    GraphView graphView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        // Find the graph view by its id
        graphView = findViewById(R.id.graphView);

        // Create a line graph series with some sample data points
        // You can replace this with your own data from the arduino code
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 3),
                new DataPoint(2, 4),
                new DataPoint(3, 9),
                new DataPoint(4, 6),
                new DataPoint(5, 3),
                new DataPoint(6, 6),
                new DataPoint(7, 1),
                new DataPoint(8, 2)
        });

        // Set some properties for the graph view
        graphView.setTitle("Vibration Statistics");
        graphView.setTitleColor(R.color.purple_200);
        graphView.setTitleTextSize(18);

        // Add the series to the graph view
        graphView.addSeries(series);
    }
}
