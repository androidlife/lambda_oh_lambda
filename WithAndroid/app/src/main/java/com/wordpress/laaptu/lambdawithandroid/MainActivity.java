package com.wordpress.laaptu.lambdawithandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

  TextView infoTextView;
  Button btnPrintWithLambda, btnPrintWithoutLambda, btnPrintWithMethodRef;
  Random random;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    random = new Random();
    initViews();
  }

  private void initViews() {
    btnPrintWithLambda = (Button) findViewById(R.id.btn_print_lambda);
    btnPrintWithoutLambda = (Button) findViewById(R.id.btn_print);
    btnPrintWithMethodRef = (Button) findViewById(R.id.btn_print_method_reference);
    infoTextView = (TextView) findViewById(R.id.txt_info);
    //printing without lambda expn
    btnPrintWithoutLambda.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        infoTextView.setText("Printing WITHOUT lambda expn @".concat(getRandomValue()));
      }
    });
    //printing with lambda expn
    btnPrintWithLambda.setOnClickListener(
        v -> infoTextView.setText("Printing WITH lambda expn @".concat(getRandomValue())));
    //printing with instance method reference
    btnPrintWithMethodRef.setOnClickListener(this::goOnClickButton);
  }

  private void goOnClickButton(View v) {
    infoTextView.setText("Printing with INSTANCE METHOD REFERENCE @".concat(getRandomValue()));
  }

  private String getRandomValue() {
    return String.valueOf(random.nextInt());
  }
}
