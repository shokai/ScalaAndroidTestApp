package org.shokai.scalatestapp;

import android.app.Activity;
import android.os.Bundle;

class Test extends Activity{
  override def onCreate(savedInstanceState:Bundle){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
  }
}
