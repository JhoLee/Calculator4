package io.github.jholee.calculator4;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected TextView resultTextView;
    protected Button[] numBtn;
    protected Button clearBtn;
    protected Button clearEntryBtn;
    protected Button deleteBtn;
    protected Button[] opBtn;
    protected Button pointBtn;

    private double result;
    private String expression;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Result TextView */
        resultTextView = (TextView) findViewById(R.id.textView_result);
        /* End of Result TextView */

        /* Number Buttons */
        int[] numBtnIDs = {
                R.id.button_0, R.id.button_1, R.id.button_2, R.id.button_3, R.id.button_4,
                R.id.button_5, R.id.button_6, R.id.button_7, R.id.button_8, R.id.button_9
        };
        numBtn = new Button[10];
        for (int i = 0; i < numBtn.length; i++) {
            numBtn[i] = findViewById(numBtnIDs[i]);
        }

        for (Button aNumBtn : numBtn) {
            aNumBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Button btn = (Button) v;
                    String s = btn.getText().toString();
                    String sValue = resultTextView.getText().toString();
                    char lastChar = sValue.charAt(sValue.length() - 1);
                    if (sValue.length() < 2 && lastChar == '0') {
                        resultTextView.setText(s);
                    } else {
                        resultTextView.append(s);
                    }
                }
            });
        }
        /* End of Number Buttons */

        /* Point Button */
        pointBtn = findViewById(R.id.button_point);
        pointBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                /* TODO: non-duplicated point. */


                Button btn = (Button) v;
                String s = btn.getText().toString();
                String sValue = resultTextView.getText().toString();
                char lastChar = sValue.charAt(sValue.length() - 1);

                switch (lastChar) {
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        resultTextView.append(s);
                        break;
                    default:
                        break;
                }
            }
        });
        /* End of Point Button */

        /* Operator Buttons */
        int[] opBtnIDs = {
                R.id.button_plus, R.id.button_minus,
                R.id.button_multiply, R.id.button_divide
        };
        opBtn = new Button[4];
        for (int i = 0; i < opBtn.length; i++) {
            opBtn[i] = findViewById(opBtnIDs[i]);
        }


        for (Button anOpBtn : opBtn) {
            anOpBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Button btn = (Button) v;
                    String s = btn.getText().toString();
                    String sValue = resultTextView.getText().toString();
                    char lastChar = sValue.charAt(sValue.length() - 1);

                    switch (lastChar) {
                        case '+':
                        case '-':
                        case '*':
                        case '/':
                            // op button
                            sValue = sValue.substring(0, sValue.length() - 1) + s;
                            resultTextView.setText(sValue);
                            break;
                        case '.':
                            break;
                        default:
                            resultTextView.append(s);
                            break;
                    }
                }
            });
        }
        /* End of Operator Buttons */



        /* Clear Buttons */
        clearBtn = findViewById(R.id.button_clear);
        clearEntryBtn = findViewById(R.id.button_clear);
        deleteBtn = findViewById(R.id.button_delete);

        clearBtn.setOnClickListener(new View.OnClickListener() {
            /* @TODO Make a Clear function */

            @Override
            public void onClick(View v) {

                resultTextView.setText(R.string._0);
            }
        });

        clearEntryBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                resultTextView.setText(R.string._0);
            }
        });

        /* End of Clear Buttons */
    }
}

