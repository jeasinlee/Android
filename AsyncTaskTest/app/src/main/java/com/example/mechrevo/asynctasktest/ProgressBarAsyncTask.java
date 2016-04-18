package com.example.mechrevo.asynctasktest;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by mechrevo on 2016/4/18.
 */
public class ProgressBarAsyncTask extends AsyncTask<Integer,Integer,String>{

    private TextView textView;
    private ProgressBar progressBar;

    public ProgressBarAsyncTask(TextView textView,ProgressBar progressBar){
        super();
        this.textView = textView;
        this.progressBar = progressBar;
    }

    @Override
    protected String doInBackground(Integer... params){
        NetOperator netOperator = new NetOperator();
        int i=0;
        for(i=1;i<=100;i++){
            netOperator.operator();
            publishProgress(i);
        }
        return i+params[0].intValue()+"";
    }

    @Override
    protected void onPostExecute(String result){
        textView.setText("异步操作执行"+result);
    }

    @Override
    protected void onPreExecute(){
        textView.setText("开始执行异步线程");
    }
    @Override
    protected void onProgressUpdate(Integer...values){
        int value = values[0];
        progressBar.setProgress(value);
    }

}
