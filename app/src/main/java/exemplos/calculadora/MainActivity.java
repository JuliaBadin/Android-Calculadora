package exemplos.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Integer num1 = -1, num2 = -1, resultado = 0;
    char op = ' ';
    boolean semMaisNumeros = false;
    Button bt0, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, btsoma, btsubtrai, btmultiplica, btdivide, btresultado, btclear;
    TextView tvresultado, tvnumeros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariaveis();


        OnClickListener ListenerB0 = new OnClickListener() {
            public void onClick(View v) {
                NumeroPressionado(0);
            }
        };
        OnClickListener ListenerB1 = new OnClickListener() {
            public void onClick(View v) {
                NumeroPressionado(1);
            }
        };
        OnClickListener ListenerB2 = new OnClickListener() {
            public void onClick(View v) {
                NumeroPressionado(2);
            }
        };
        OnClickListener ListenerB3 = new OnClickListener() {
            public void onClick(View v) {
                NumeroPressionado(3);
            }
        };
        OnClickListener ListenerB4 = new OnClickListener() {
            public void onClick(View v) {
                NumeroPressionado(4);
            }
        };
        OnClickListener ListenerB5 = new OnClickListener() {
            public void onClick(View v) {
                NumeroPressionado(5);
            }
        };
        OnClickListener ListenerB6 = new OnClickListener() {
            public void onClick(View v) {
                NumeroPressionado(6);
            }
        };
        OnClickListener ListenerB7 = new OnClickListener() {
            public void onClick(View v) {
                NumeroPressionado(7);
            }
        };
        OnClickListener ListenerB8 = new OnClickListener() {
            public void onClick(View v) {
                NumeroPressionado(8);
            }
        };
        OnClickListener ListenerB9 = new OnClickListener() {
            public void onClick(View v) {
                NumeroPressionado(9);
            }
        };
        OnClickListener ListenerBSoma = new OnClickListener() {
            public void onClick(View v) {
                OperadorPressionado("+");
            }
        };
        OnClickListener ListenerBSubtrai = new OnClickListener() {
            public void onClick(View v) {
                OperadorPressionado("-");
            }
        };
        OnClickListener ListenerBMultiplica = new OnClickListener() {
            public void onClick(View v) {
                OperadorPressionado("*");
            }
        };
        OnClickListener ListenerBDivide = new OnClickListener() {
            public void onClick(View v) {
                OperadorPressionado("/");
            }
        };
        OnClickListener ListenerBClear = new OnClickListener() {
            public void onClick(View v) {
                LimparTudo();
            }
        };
        OnClickListener ListenerBResultado = new OnClickListener() {
            public void onClick(View v) {
                if (num1 != -1 && num2 != -1) {
                    switch (op) {
                        case ('+'):
                            resultado = num1 + num2;
                            MostrarResultado();
                            break;
                        case ('-'):
                            resultado = num1 - num2;
                            MostrarResultado();
                            break;
                        case ('*'):
                            resultado = num1 * num2;
                            MostrarResultado();
                            break;
                        case ('/'):
                            resultado = num1 / num2;
                            MostrarResultado();
                            break;
                    }
                }
                num1 = resultado;
                num2 = -1;
                op = ' ';
                semMaisNumeros = false;
            }
        };

        bt0.setOnClickListener(ListenerB0);
        bt1.setOnClickListener(ListenerB1);
        bt2.setOnClickListener(ListenerB2);
        bt3.setOnClickListener(ListenerB3);
        bt4.setOnClickListener(ListenerB4);
        bt5.setOnClickListener(ListenerB5);
        bt6.setOnClickListener(ListenerB6);
        bt7.setOnClickListener(ListenerB7);
        bt8.setOnClickListener(ListenerB8);
        bt9.setOnClickListener(ListenerB9);
        btsoma.setOnClickListener(ListenerBSoma);
        btdivide.setOnClickListener(ListenerBDivide);
        btsubtrai.setOnClickListener(ListenerBSubtrai);
        btmultiplica.setOnClickListener(ListenerBMultiplica);
        btresultado.setOnClickListener(ListenerBResultado);
        btclear.setOnClickListener(ListenerBClear);

    }

    void initVariaveis (){
        bt0 = (Button) findViewById(R.id.bt0);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        bt5 = (Button) findViewById(R.id.bt5);
        bt6 = (Button) findViewById(R.id.bt6);
        bt7 = (Button) findViewById(R.id.bt7);
        bt8 = (Button) findViewById(R.id.bt8);
        bt9 = (Button) findViewById(R.id.bt9);

        btsoma = (Button) findViewById(R.id.btsoma);
        btdivide = (Button) findViewById(R.id.btdivide);
        btsubtrai = (Button) findViewById(R.id.btsubtrai);
        btmultiplica = (Button) findViewById(R.id.btmultiplica);
        btresultado = (Button) findViewById(R.id.btresultado);
        btclear = (Button) findViewById(R.id.btclear);

        tvresultado = (TextView) findViewById(R.id.tvresultado);
        tvnumeros = (TextView) findViewById(R.id.tvnumeros);
    }

    void NumeroPressionado (int btPressionado) {
        if(op == ' '){
            if (num1 == -1 && resultado == 0){
                num1 = btPressionado;
                tvnumeros.setText(Integer.toString(btPressionado));
            } else {
                num1 = num1 * 10 + btPressionado;
                tvnumeros.append(Integer.toString(btPressionado));
            }
        } else {
            if (num2 == -1){
                num2 = btPressionado;
                tvnumeros.append(Integer.toString(btPressionado));
            } else{
                num2 = num2 * 10 + btPressionado;
                tvnumeros.append(Integer.toString(btPressionado));
            }
        }
    }

    void OperadorPressionado(String opPressionado) {
        while (!semMaisNumeros) {
            if (tvnumeros.getText().toString().equals(Integer.toString(resultado))) {
                num1 = resultado;
            }
            if (num1 == -1) {
                num1 = 0;
            }

            tvnumeros.append(opPressionado);
            op = opPressionado.charAt(0);
            semMaisNumeros = true;
        }
    }

    void MostrarResultado() {
        tvresultado.setText(Integer.toString(resultado));
        tvnumeros.setText(Integer.toString(resultado));
    }

    void LimparTudo (){
        num1 = -1;
        num2 = -1;
        resultado = 0;
        tvresultado.setText("");
        tvnumeros.setText("");
    }
}