package customanimation.com.customanimation;

import android.animation.Animator;
import android.app.ProgressDialog;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private Animator manimator;
    private int mDurationOfAnimation = 500;
    private ImageButton fetchData;
    private HorizontalPicker mHorizontalPicker;
    private ProgressDialog progressDialog;
    CharSequence[] tempachararray = new CharSequence[]{"one","two","three","four","five","six","seven","eight","nine","ten"};
    LinearLayout mContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContainer=(LinearLayout)findViewById(R.id.container);
        mContainer.setVisibility(View.GONE);
        final ImageView thumbOne = (ImageView) findViewById(R.id.thumbone);
        thumbOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zoomFromThumb(thumbOne, R.mipmap.ic_launcher);
            }
        });
        final ImageView thumbtwo = (ImageView) findViewById(R.id.thumbtwo);
        thumbOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zoomFromThumb(thumbtwo, R.mipmap.ic_launcher);
            }
        });

        mHorizontalPicker = (HorizontalPicker) findViewById(R.id.picker);
        CharSequence[] charSequences = new CharSequence[]{"5", "10", "20", "40", "60", "120", "240"};
        mHorizontalPicker.setValues(charSequences);
        mHorizontalPicker.setOnItemClickedListener(new HorizontalPicker.OnItemClicked() {
            @Override
            public void onItemClicked(int index) {
                // Toast.makeText(MainActivity.this, "index" + index, Toast.LENGTH_LONG).show();
            }
        });
        mHorizontalPicker.setOnItemSelectedListener(new HorizontalPicker.OnItemSelected() {
            @Override
            public void onItemSelected(int index) {
                Log.e("HorizontalPicker", "onItemSelected" + index);
                //Toast.makeText(MainActivity.this,"index"+index,Toast.LENGTH_LONG).show();
            }
        });

        //horizontalPicker.setValues(tempachararray);
        fetchData = (ImageButton) findViewById(R.id.fetchslotsgedit);
        fetchData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getForLaterBeam();
            }
        });
        getDuration();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void zoomFromThumb(final View view, int resId) {
        if (manimator != null) {
            manimator.cancel();
        }
        ImageView imageView = (ImageView) findViewById(R.id.expanded_image);
        imageView.setImageResource(resId);
        Rect startBounds = new Rect();
        Rect endBounds = new Rect();
        Point globalOffset = new Point();
        view.getGlobalVisibleRect(startBounds);
        findViewById(R.id.container).getGlobalVisibleRect(endBounds, globalOffset);
        startBounds.offset(-globalOffset.x, -globalOffset.y);
        endBounds.offset(-globalOffset.x, -globalOffset.y);
        float startScale;
        if (((float) endBounds.width() / endBounds.height()) > ((float) startBounds.width() / startBounds.height())) {
            startScale = (float) startBounds.height() / endBounds.height();
            //float startWidth =
        }
    }


    private void getForLaterBeam() {
        Toast.makeText(MainActivity.this, "the selected value" + mHorizontalPicker.getSelectedItem(), Toast.LENGTH_SHORT).show();
    }

    private void getDuration() {
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Loading Durations");
        progressDialog.show();
        try{
            Thread.sleep(4000);
        }catch (InterruptedException iex){

        }
        mHorizontalPicker.setValues(tempachararray);
        mContainer.setVisibility(View.VISIBLE);
        progressDialog.dismiss();
    }

}