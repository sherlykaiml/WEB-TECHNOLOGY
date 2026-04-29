MainActivity.kt (app->Kotlin+java->MainActivity): 
package com.example.calculatorapp 
 
import android.os.Bundle 
import android.widget.Button 
import android.widget.EditText 
import android.widget.TextView 
import androidx.appcompat.app.AppCompatActivity 
 
class MainActivity : AppCompatActivity() { 
 
    lateinit var num1: EditText 
    lateinit var num2: EditText 
 
    lateinit var add: Button 
    lateinit var sub: Button 
    lateinit var mul: Button 
    lateinit var div: Button 
 
    lateinit var result: TextView 
 
    override fun onCreate(savedInstanceState: Bundle?) { 
        super.onCreate(savedInstanceState) 
        setContentView(R.layout.activity_main) 
 
        num1 = findViewById(R.id.num1) 
        num2 = findViewById(R.id.num2) 
 
        add = findViewById(R.id.add) 
        sub = findViewById(R.id.sub) 
        mul = findViewById(R.id.mul) 
        div = findViewById(R.id.div) 
 
        result = findViewById(R.id.result) 
 
        add.setOnClickListener { 
            val n1 = num1.text.toString().toDoubleOrNull() ?: 0.0 
            val n2 = num2.text.toString().toDoubleOrNull() ?: 0.0 
            result.text = "Result: ${n1 + n2}" 
        } 
 
        sub.setOnClickListener { 
            val n1 = num1.text.toString().toDoubleOrNull() ?: 0.0 
            val n2 = num2.text.toString().toDoubleOrNull() ?: 0.0 
            result.text = "Result: ${n1 - n2}" 
        } 
 
        mul.setOnClickListener { 
            val n1 = num1.text.toString().toDoubleOrNull() ?: 0.0 
            val n2 = num2.text.toString().toDoubleOrNull() ?: 0.0 
            result.text = "Result: ${n1 * n2}" 
        } 
 
        div.setOnClickListener { 
            val n1 = num1.text.toString().toDoubleOrNull() ?: 0.0 
            val n2 = num2.text.toString().toDoubleOrNull() ?: 0.0 
            if (n2 == 0.0) { 
                result.text = "Cannot divide by zero" 
            } else { 
                result.text = "Result: ${n1 / n2}" 
            } 
        } 
    } 
} 
activity_main.xml(res->layout->activity_main): 
<?xml version="1.0" encoding="utf-8"?> 
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android" 
    android:orientation="vertical" 
    android:padding="20dp" 
    android:layout_width="match_parent" 
    android:layout_height="match_parent"> 
 
    <EditText 
        android:id="@+id/num1" 
        android:hint="Enter Number 1" 
        android:inputType="numberDecimal" 
        android:layout_width="match_parent" 
        android:layout_height="wrap_content"/> 
 
    <EditText 
        android:id="@+id/num2" 
        android:hint="Enter Number 2" 
        android:inputType="numberDecimal" 
        android:layout_width="match_parent" 
        android:layout_height="wrap_content"/> 
 
    <Button 
        android:id="@+id/add" 
        android:text="Add" 
        android:layout_width="match_parent" 
        android:layout_height="wrap_content"/> 
 
    <Button 
        android:id="@+id/sub" 
        android:text="Subtract" 
        android:layout_width="match_parent" 
        android:layout_height="wrap_content"/> 
 
    <Button 
        android:id="@+id/mul" 
        android:text="Multiply" 
        android:layout_width="match_parent" 
        android:layout_height="wrap_content"/> 
 
    <Button 
        android:id="@+id/div" 
        android:text="Divide" 
        android:layout_width="match_parent" 
        android:layout_height="wrap_content"/> 
 
    <TextView 
        android:id="@+id/result" 
        android:text="Result" 
        android:textSize="22sp" 
        android:layout_marginTop="20dp" 
        android:layout_width="wrap_content" 
        android:layout_height="wrap_content"/> 
 
</LinearLayout> 
AndroidManifest.xml(app->manifest->AndroidManifest.xml): 
<?xml version="1.0" encoding="utf-8"?> 
<manifest xmlns:android="http://schemas.android.com/apk/res/android" 
    xmlns:tools="http://schemas.android.com/tools"> 
 
    <application 
        android:allowBackup="true" 
        android:dataExtractionRules="@xml/data_extraction_rules" 
        android:fullBackupContent="@xml/backup_rules" 
        android:icon="@mipmap/ic_launcher" 
        android:label="@string/app_name" 
        android:roundIcon="@mipmap/ic_launcher_round" 
        android:supportsRtl="true" 
        android:theme="@style/Theme.CalculatorApp"> 
        <activity 
            android:name=".MainActivity" 
            android:exported="true" 
            android:label="@string/app_name" 
            android:theme="@style/Theme.CalculatorApp"> 
            <intent-filter> 
                <action android:name="android.intent.action.MAIN" /> 
 
                <category android:name="android.intent.category.LAUNCHER" /> 
            </intent-filter> 
        </activity> 
    </application> 
 
</manifest> 
Themes.xml(res->values->themes.xml): 
<resources xmlns:tools="http://schemas.android.com/tools"> 
 
    <style name="Theme.CalculatorApp" 
parent="Theme.AppCompat.Light.DarkActionBar"> 
    </style> 
 
</resources>
