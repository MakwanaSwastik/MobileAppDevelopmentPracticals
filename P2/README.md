# P2_21012011046
# Practical 2 - Android Activity with Lifecycle Demonstrations

This repository contains an Android Activity project that aims to display a "Hello World" message in a `TextView` at the center of the activity screen. The layout background of the activity is set to yellow (`#FFFF00`). The `TextView` has the following properties:

- Text Color: Holo Blue (`@android:color/holo_blue_bright`)
- Font Size: 27sp
- Text Style: Bold and Italic

Additionally, this project demonstrates various functions of the Android Activity Lifecycle by using Log messages, Toast messages, and Snackbar messages. All Activity lifecycle methods are printed in Logcat for reference.

## Activity Layout

The layout for this activity is defined in XML, as shown below:

```xml
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/myConstraintLayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#FFFF00"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/Swastik"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World"
        android:textColor="@android:color/holo_blue_bright"
        android:textSize="27sp"
        android:textStyle="bold|italic"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

## Activity Class

The Java class for the activity, named `MainActivity`, demonstrates Activity Lifecycle methods and displays messages through Logcat, Toast messages, and Snackbar messages.

```java
package com.example.practical_2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showMessage("onCreate method is called");
    }

    private void showMessage(String message) {
        Log.i(TAG, message);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        ConstraintLayout v = findViewById(R.id.myConstraintLayout);
        if (v != null) {
            Snackbar.make(v, message, Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        showMessage("onStart method is called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        showMessage("onResume method is called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        showMessage("onPause method is called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showMessage("onStop method is called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showMessage("onDestroy method is called");
    }
}
```

This project serves as a practical demonstration of creating an Android Activity with a specific UI layout and showcasing the Activity Lifecycle. You can build and run this project to observe the Activity Lifecycle methods in action, along with the "Hello World" message displayed on the activity screen.
## Screenshot

![Screenshot Practical-2](Screenshot.png)
