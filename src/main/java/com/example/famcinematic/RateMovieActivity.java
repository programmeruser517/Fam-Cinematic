package com.example.famcinematic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RateMovieActivity extends Activity {

    private TextView movieNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rate_activity_movie);

        movieNameTextView = findViewById(R.id.movie_name_text_view);

        Intent intent = getIntent();
        String movieName = intent.getStringExtra("movieName");

        if (movieName != null) {
            movieNameTextView.setText(movieName);
        }
    }
}
