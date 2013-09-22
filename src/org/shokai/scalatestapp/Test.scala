package org.shokai.scalatestapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

class Test extends Activity{

  var editTextSource:EditText = _
  var textViewResult:TextView = _
  var btnRun:Button = _

  override def onCreate(savedInstanceState:Bundle){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    editTextSource = findViewById(R.id.editTextSource).asInstanceOf[EditText]
    textViewResult = findViewById(R.id.textViewResult).asInstanceOf[TextView]
    btnRun = findViewById(R.id.btnRun).asInstanceOf[Button]

    btnRun.setOnClickListener( new OnClickListener(){
      override def onClick(v:View){
        val source = editTextSource.getText().toString()
        trace(s"source: $source")
        val result = kana_downcase(source)
        trace(s"result: $result")
        textViewResult.setText(result)
      }
    })
  }

  def kana_downcase(str:String):String = {
    var chars = scala.collection.immutable.Map[String,String](
      "あ" -> "ぁ",
      "い" -> "ぃ",
      "う" -> "ぅ",
      "え" -> "ぇ",
      "お" -> "ぉ",
      "つ" -> "っ",
      "よ" -> "ょ",
      "わ" -> "ゎ")

    return str.split("").
    map(c =>
      if(chars.contains(c)) chars(c) else c
      ).mkString
  }

  def trace(message:String){
    Log.v("ScalaTestApp", message)
  }
}
