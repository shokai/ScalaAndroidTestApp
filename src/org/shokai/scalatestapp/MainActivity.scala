package org.shokai.scalatestapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.{TextView, EditText, Button};
import android.view.View;
import android.view.View.OnClickListener;

class MainActivity extends Activity{

  lazy val editTextSource:EditText = findViewById(R.id.editTextSource).asInstanceOf[EditText]
  lazy val textViewResult:TextView = findViewById(R.id.textViewResult).asInstanceOf[TextView]
  lazy val btnRun:Button = findViewById(R.id.btnRun).asInstanceOf[Button]

  override def onCreate(savedInstanceState:Bundle){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

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
    import scala.collection.immutable.Map
    val chars = Map[String,String](
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
