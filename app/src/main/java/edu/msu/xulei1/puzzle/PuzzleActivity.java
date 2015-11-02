package edu.msu.xulei1.puzzle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class PuzzleActivity extends AppCompatActivity {
    /**
     * Save the instance state into a bundle
     * @param bundle the bundle to save into
     */
    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        getPuzzleView().saveInstanceState(bundle);
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_puzzle);

        if(bundle != null) {
            // We have saved state
            getPuzzleView().loadInstanceState(bundle);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_puzzle, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_shuffle:
                getPuzzleView().getPuzzle().shuffle();
                getPuzzleView().invalidate();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Get the puzzle view
     * @return PuzzleView reference
     */
    private PuzzleView getPuzzleView() {
        return (PuzzleView)this.findViewById(R.id.puzzleView);
    }

}
