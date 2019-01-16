package udacity.example.com.libandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class AndroidLibActivity extends AppCompatActivity {

    public static String JOKE_INTENT_KEY = "joke_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_lib);

        String jokeArgument = getIntent().getExtras().getString(JOKE_INTENT_KEY);

        if (jokeArgument == null || jokeArgument.isEmpty()) finish();
        else {
            TextView tvJokeContent = findViewById(R.id.joke_tv);
            tvJokeContent.setText(jokeArgument);
        }

    }

    public static void startActivity(Context context, @NonNull String jokeArgument) {
        Intent intent = new Intent(context, AndroidLibActivity.class);
        intent.putExtra(JOKE_INTENT_KEY, jokeArgument);
        context.startActivity(intent);
    }
}
