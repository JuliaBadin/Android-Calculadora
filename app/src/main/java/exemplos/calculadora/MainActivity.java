package exemplos.calculadora;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//biblioteca para expressões matemáticas
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button bt0, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, btsoma, btsubtrai, btmultiplica, btdivide, btresultado, btclear, btponto;
    TextView tvresultado, tvexpressao;
    ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicial(); //pega o id dos elementos do xml

        //define eventos de onclick
        bt0.setOnClickListener(this);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
        bt9.setOnClickListener(this);
        btsoma.setOnClickListener(this);
        btdivide.setOnClickListener(this);
        btsubtrai.setOnClickListener(this);
        btmultiplica.setOnClickListener(this);
        btponto.setOnClickListener(this);
        btclear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tvresultado.setText("");
                tvexpressao.setText("");
            }
        });
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valor = tvexpressao.getText().toString();

                if(!valor.isEmpty()) {
                    int var = valor.length() - 1;
                    String exp = valor.substring(0, var); //tira o ultimo digito da expressao
                    tvexpressao.setText(exp); //redefine a string
                }
                tvresultado.setText("");
            }
        });
        btresultado.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                try {
                    Expression exp = new ExpressionBuilder(tvexpressao.getText().toString()).build(); //pega tudo que foi clicado e monta a expressão
                    double res = exp.evaluate(); //dá o resultado
                    long longResult = (long) res;

                    if (res == (double) longResult) { //decimal
                        tvresultado.setText(String.valueOf(longResult));
                        tvexpressao.setText("");
                    } else { //inteiro
                        tvresultado.setText(String.valueOf(res));
                        tvexpressao.setText("");
                    }
                } catch (Exception e) {
                }
            }
        });
    }

    void inicial (){
        bt0 = findViewById(R.id.bt0);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);
        bt6 = findViewById(R.id.bt6);
        bt7 = findViewById(R.id.bt7);
        bt8 = findViewById(R.id.bt8);
        bt9 = findViewById(R.id.bt9);

        btsoma = findViewById(R.id.btsoma);
        btdivide = findViewById(R.id.btdivide);
        btsubtrai = findViewById(R.id.btsubtrai);
        btmultiplica = findViewById(R.id.btmultiplica);
        btresultado = findViewById(R.id.btresultado);
        btclear = findViewById(R.id.btclear);
        btponto = findViewById(R.id.btponto);

        tvresultado = findViewById(R.id.tvresultado);
        tvexpressao = findViewById(R.id.tvexpressao);
        backspace = findViewById(R.id.btdelete);
    }

    public void addExpression(String valor, boolean ehNumero) {
        if (ehNumero) { //numeros
            tvresultado.setText("");
            tvexpressao.append(valor);
        } else { //operadores
            if(!tvresultado.getText().toString().isEmpty()){ //continua a expressao a partir do resultado da anterior
                tvexpressao.append(tvresultado.getText());
            }
            tvexpressao.append(valor);
            tvresultado.setText("");
        }
    }

    @Override
    public void onClick(View view) { //passa os valores clicados pra expressão
        switch (view.getId()) {
            case R.id.bt0:
                addExpression("0",true);
                break;
            case R.id.bt1:
                addExpression("1",true);
                break;
            case R.id.bt2:
                addExpression("2",true);
                break;
            case R.id.bt3:
                addExpression("3",true);
                break;
            case R.id.bt4:
                addExpression("4",true);
                break;
            case R.id.bt5:
                addExpression("5",true);
                break;
            case R.id.bt6:
                addExpression("6",true);
                break;
            case R.id.bt7:
                addExpression("7",true);
                break;
            case R.id.bt8:
                addExpression("8",true);
                break;
            case R.id.bt9:
                addExpression("9",true);
                break;
            case R.id.btponto:
                addExpression(".",true);
                break;
            case R.id.btsoma:
                addExpression("+",false);
                break;
            case R.id.btsubtrai:
                addExpression("-",false);
                break;
            case R.id.btmultiplica:
                addExpression("*",false);
                break;
            case R.id.btdivide:
                addExpression("/",false);
                break;
        }
    }
}