import android.Keys._

android.Plugin.androidBuild

name := "ScalaTestApp"

platformTarget in Android := "android-18"

run <<= run in Android
 
install <<= install in Android
