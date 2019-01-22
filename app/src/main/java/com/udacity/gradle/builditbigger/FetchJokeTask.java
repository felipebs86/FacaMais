package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import com.fbs.jokedisplay.*;
import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

import com.udacity.gradle.builditbigger.backend.libjoke.Libjoke;

class FetchJokeTask extends AsyncTask<Void, Void, String> {
    private static Libjoke myApiService = null;
    private Context mContext;
    private String mResult;

    public FetchJokeTask(Context context) {
        mContext = context;
    }

    @Override
    protected final String doInBackground(Void... params) {
        if (myApiService == null) {  // Only do this once
            Libjoke.Builder builder = new Libjoke.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://udacity-jokebackend.appspot.com/_ah/api/");
            myApiService = builder.build();
        }

        try {
            return myApiService.getRandomJoke().execute().getText();
        } catch (IOException e) {
            Log.e(FetchJokeTask.class.getSimpleName(), e.getMessage());
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        mResult = result;
        startJokeDisplayActivity();
    }

    private void startJokeDisplayActivity() {
        Intent intent = new Intent(mContext, ViewJokeActivity.class);
        intent.putExtra(ViewJokeActivity.INTENT_EXTRA_JOKE, mResult);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }

}
