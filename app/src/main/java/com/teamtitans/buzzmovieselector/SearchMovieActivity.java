package com.teamtitans.buzzmovieselector;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.io.InputStreamReader;
import android.widget.TextView;

public class SearchMovieActivity extends AppCompatActivity {

    EditText movieTitle;
    //TextView warningText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_movie);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button searchMovie = (Button) findViewById(R.id.searchMovieButton);
        searchMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchMovieActivity.this, MovieResultsActivity.class);
                String title = movieTitle.getText().toString();

                try {

                    String selectedItem = jListFilms.getSelectedValue().toString().replace("\\s+", "+");

                    InputStream input = new URL("http://www.omdbapi.com/?t=" + URLEncoder.encode(selectedItem, "UTF-8")).openStream();
                    Map<String, String> map = new Gson().fromJson(new InputStreamReader(input, "UTF-8"), new TypeToken<Map<String, String>>() {
                    }.getType());

                    String title = map.get("Title");
                    String year = map.get("Year");
                    String released = map.get("Released");
                    String runtime = map.get("Runtime");
                    String genre = map.get("Genre");
                    String actors = map.get("Actors");
                    String plot = map.get("Plot");
                    String imdbRating = map.get("imdbRating");
                    String poster = map.get("Poster");

                    testForm tf = new testForm(title, year, released, runtime, genre, actors, plot, imdbRating);
                    tf.setVisible(true);

                } catch (JsonIOException | JsonSyntaxException | IOException e){
                    System.out.println(e);
                }

            }
        });
    }

}