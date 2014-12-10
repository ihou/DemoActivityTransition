package woody.demo.com.demoactivitytransition;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.view.View;
import android.view.Window;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setAllowEnterTransitionOverlap(true);
        Slide slide = new Slide();
        slide.excludeTarget(android.R.id.statusBarBackground, true);
        slide.excludeTarget(android.R.id.navigationBarBackground, true);
        getWindow().setExitTransition(new ChangeBounds());
        getWindow().setEnterTransition(slide);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

//                startActivity(intent,
//                        ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());

                ActivityOptions options = ActivityOptions
                        .makeSceneTransitionAnimation(MainActivity.this, imageView, "sharedImage");
                startActivity(intent,options.toBundle());
            }
        });
    }

}
