package com.tricks.readjsonfromurl;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	JSONParser jsonparser = new JSONParser();
	JSONObject jobj = null;
	String movieurl;
	String ab;
	Button mButton;
	EditText mEdit;
	
	String title,year,rated,released,runtime,genre,director,writer,actors,plot,language,country,awards;;
	TextView Title,Year,Rated,Released,Runtime,Genre,Director,Writer,Actors,Plot,Language,Country,Awards;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		
	 Title = (TextView) findViewById(R.id.Title);
	 Year = (TextView) findViewById(R.id.Year);
	 Rated = (TextView) findViewById(R.id.Rated);
	 Released = (TextView) findViewById(R.id.Released);
	 Runtime= (TextView) findViewById(R.id.Runtime);
	 Genre= (TextView) findViewById(R.id.Genre);
	 Director= (TextView) findViewById(R.id.Director);
	 Writer= (TextView) findViewById(R.id.Writer);
	 Actors= (TextView) findViewById(R.id.Actors);
	 Plot= (TextView) findViewById(R.id.Plot);
	 Language = (TextView) findViewById(R.id.Language);
	 Country=(TextView) findViewById(R.id.Country);
	 Awards=(TextView) findViewById(R.id.Awards);
	
	  mButton = (Button) findViewById(R.id.search);
	  mButton.setOnClickListener(new View.OnClickListener() {
      	public void onClick(View view) {
      		//mEdit   = (EditText)findViewById(R.id.movie);
      		EditText text = (EditText)findViewById(R.id.go);
      		String value = text.getText().toString();
      		movieurl="http://www.omdbapi.com/?i=&t="+value;
      		Log.d("15",movieurl);
      		new retrievedata().execute();
      		
      	}
      });

	 
		//new retrievedata().execute();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	
	class retrievedata extends AsyncTask<String[], String[], String[]>{
		@Override
		protected String[] doInBackground(String[]... arg0) {
			// TODO Auto-generated method stub
			jobj = jsonparser.makeHttpRequest(movieurl);
			String ar[] = new String[13];
			// check your log for json response
			Log.d("Login attempt", jobj.toString());

			try {
				ar[0] = jobj.getString("Title");
				ar[1] = jobj.getString("Year");
				ar[2]=jobj.getString("Rated");
				ar[3]=jobj.getString("Released");
				ar[4]=jobj.getString("Runtime");
				ar[5]=jobj.getString("Genre");
				ar[6]=jobj.getString("Director");
				ar[7]=jobj.getString("Writer");
				ar[8]=jobj.getString("Actors");
				ar[9]=jobj.getString("Plot");
				ar[10]=jobj.getString("Language");
				ar[11]=jobj.getString("Country");
				ar[12]=jobj.getString("Awards");
				
				
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ar;
		}
		protected void onPostExecute( String[] ar){
			//super.onPostExecute(result);
			Title.setText(ar[0]);
			Year.setText(ar[1]);
			Rated.setText(ar[2]);
			Released.setText(ar[3]);
			Runtime.setText(ar[4]);
			Genre.setText(ar[5]);
			Director.setText(ar[6]);
			Writer.setText(ar[7]);
			Actors.setText(ar[8]);
			Plot.setText(ar[9]);
			Language.setText(ar[10]);
			Country.setText(ar[11]);
			Awards.setText(ar[12]);
			Log.d("first", ar[7]);
			Log.d("first", ar[8]);
			
			//.setText(ar[]);
		}
		

	}
	
	
	
	
	

}
