package com.example.egzamin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int liczby;
    String action;

    Button dodawanie;
    Button odejmowanie;
    Button mnozenie;
    Button dzielenie;
    Button wynik;

    Button numer1;
    Button numer2;
    Button numer3;
    Button numer4;
    Button numer5;
    Button numer6;
    Button numer7;
    Button numer8;
    Button numer9;
    Button numer0;

    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Zdefiniowanie przycisków od działań do zmiennych
         */
        dodawanie = findViewById(R.id.dodawanie);
        odejmowanie = findViewById(R.id.odejmowanie);
        mnozenie = findViewById(R.id.mnozenie);
        dzielenie = findViewById(R.id.dzielenie);
        wynik = findViewById(R.id.wynik);

        /*
        Przypisanie funkcji do przycisków
         */
        dodawanie.setOnClickListener(view -> akcja("+"));
        odejmowanie.setOnClickListener(view -> akcja("-"));
        mnozenie.setOnClickListener(view -> akcja("*"));
        dzielenie.setOnClickListener(view -> akcja("/"));
        wynik.setOnClickListener(view -> akcja("="));

        /*
        Przypisanie przycisków liczb do zmiennych
         */
        numer1 = findViewById(R.id.liczba1);
        numer2 = findViewById(R.id.liczba2);
        numer3 = findViewById(R.id.liczba3);
        numer4 = findViewById(R.id.liczba4);
        numer5 = findViewById(R.id.liczba5);
        numer6 = findViewById(R.id.liczba6);
        numer7 = findViewById(R.id.liczba7);
        numer8 = findViewById(R.id.liczba8);
        numer9 = findViewById(R.id.liczba9);
        numer0 = findViewById(R.id.liczba0);

        /*
        Przypisanie funkcji do przycisków od liczb
         */
        numer1.setOnClickListener(view -> liczba(1));
        numer2.setOnClickListener(view -> liczba(2));
        numer3.setOnClickListener(view -> liczba(3));
        numer4.setOnClickListener(view -> liczba(4));
        numer5.setOnClickListener(view -> liczba(5));
        numer6.setOnClickListener(view -> liczba(6));
        numer7.setOnClickListener(view -> liczba(7));
        numer8.setOnClickListener(view -> liczba(8));
        numer9.setOnClickListener(view -> liczba(9));
        numer0.setOnClickListener(view -> liczba(0));

        /*
        Przypisanie przycisku reset do zmiennej i przypisanie funkcji do przycisku reset
         */
        reset = findViewById(R.id.reset);
        reset.setOnClickListener(view -> reset());
    }



    /*
    Dodawanie klikniętej liczby do wyświetlacza
     */
    private void liczba(int number){
        TextView text = findViewById(R.id.dzialanie);
        if(text.getText().equals("+") || text.getText().equals("-") || text.getText().equals("*") || text.getText().equals("/")){
            text.setText("");
        }
        text.setText(text.getText()+""+number);
    }

    /*
    Wykonywanie działań dodawania, odejmowania, mnożenia i dzielenia
    Wyświetlanie wyniku
     */
    private void akcja(String type){
        TextView text = findViewById(R.id.dzialanie);
        if(type == "=") {
            int result = 0;
            int value = Integer.parseInt((String) text.getText());

            switch (action) {
                case "+":
                    result = liczby + value;
                    break;
                case "-":
                    result = liczby - value;
                    break;
                case "*":
                    result = liczby * value;
                    break;
                case "/":
                    result = liczby / value;
                    break;
            }
            text.setText(String.valueOf(result));
            action = "";
        }else{
            liczby = Integer.parseInt((String) text.getText());
            text.setText(type);
            action = type;
        }
    }

    /*
    Resetowanie zmiennych i wyświetlacza
     */
    private void reset(){
        TextView text = findViewById(R.id.dzialanie);
        text.setText("");
    }
}