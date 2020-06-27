package com.example.myasysctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class MyprogressBar extends AsyncTask<Void,Integer,String> {

    Context context;
    ProgressDialog progressDialog;
    public MyprogressBar(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Downloading.....");
        progressDialog.setMessage("Please wait");
        //Max is 0 to 100 but we put 10 here so it will be 0 to 10
        progressDialog.setMax(10);

        //default style is spinner and that will not let you know the progression of percentage.
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        progressDialog.setButton(ProgressDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

                //it will cancel totally the execution otherwise it will still running background even if you press the cancel button
                cancel(true);

            }
        });

        progressDialog.show();


    }

    @Override
    protected String doInBackground(Void... voids) {

        try {
            for (int i = 1; i <= 10; i++) {

                Thread.sleep(8000);
                Log.i("Thread", "Execute" + i);

                publishProgress(i);

            } return "Successful";

        } catch (Exception e) {

            Log.i("Exception", e.getMessage());
            return "Failure";
        }

    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        int value=values[0];
        progressDialog.setProgress(value);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
        progressDialog.dismiss();
    }
}
