Scala Android Test App
======================
- https://github.com/shokai/ScalaAndroidTestApp


Dependencies
------------
- android-18 SDK (for Android4.3)
- sbt


Install Dependencies
--------------------

    % brew update
    % brew install scala sbt


Build
-----

    % android update project --path `pwd`
    % sbt
    > android:package-debug


Install
-------

    % adb devices
    % adb install -r bin/ScalaTestApp-debug.apk
