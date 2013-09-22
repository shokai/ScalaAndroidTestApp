package org.shokai.scalatestapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

class Test extends Activity{
  override def onCreate(savedInstanceState:Bundle){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    for(i <- 1.to(10)){
      Log.v("ScalaTestApp", s"start $i")
    }
  }
}
