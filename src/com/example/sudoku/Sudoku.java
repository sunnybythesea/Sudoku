package com.example.sudoku;

import android.app.Activity;
import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

// Support for menu
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

// Support for dialog
import android.app.AlertDialog;
import android.content.DialogInterface;

import android.util.Log;

private static final String TAG = "Sudoku";

/** Ask the user what difficulty level they want */ 
private void openNewGameDialog() { 
   new AlertDialog.Builder(this) 
      .setTitle(R.string.new_game_title) 
      .setItems(R.array.difficulty, 
      new DialogInterface.OnClickListener() { 
         public void onClick(DialogInterface dialoginterface,
            int i) { 
            startGame(i); 
         } 
      }) 
      .show(); 
}

/** Start a new game with the given difficulty level */ 
private void startGame(int i) { 
   Log.d(TAG, "clicked on " + i); 
   // Start game here... 
} 



public class Sudoku extends Activity implements OnClickListener 
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

	// Setup click listeners
	View continueBtn = findViewById(R.id.continue_button);
	continueBtn.setOnClickListener(this);

	View newBtn = findViewById(R.id.new_button);
	newBtn.setOnClickListener(this);

	View aboutBtn = findViewById(R.id.about_button);
	aboutBtn.setOnClickListener(this);

	View exitBtn = findViewById(R.id.exit_button);
	exitBtn.setOnClickListener(this);

    }

    public void onClick(View v) {
      switch (v.getId()) {
	   case R.id.about_button:
	      Intent i = new Intent(this, About.class);
	      startActivity(i);
	      break;
	 
      // support for opening new game dialog
      case R.id.new_button:
         openNewGameDialog();
         break;
       
      }
    }

   @Override 
   public boolean onCreateOptionsMenu(Menu menu) { 
      super.onCreateOptionsMenu(menu); 
      MenuInflater inflater = getMenuInflater(); 
      inflater.inflate(R.menu.menu, menu); 
      return true; 
   }

   
   @Override 
   public boolean onOptionsItemSelected(MenuItem item) { 
      switch (item.getItemId()) { 
      case R.id.settings: 
	 startActivity(new Intent(this, Prefs.class)); 
	 return true; 
	 // More items go here (if any) ... 
      } 
      return false; 
   } 


}
