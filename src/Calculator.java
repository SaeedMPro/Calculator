import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.Objects;

public class Calculator extends Application implements EventHandler<ActionEvent> {

    Stage CalculatorWindow;
    Scene CalculatorViewer;
    GridPane layout;
    TextArea output;
    Button zeroButton;
    Button oneButton;
    Button twoButton;
    Button threeButton;
    Button fourButton;
    Button fiveButton;
    Button sixButton;
    Button sevenButton;
    Button eightButton;
    Button nineButton;
    Button pointButton;
    Button addButton;
    Button subtractButton;
    Button multiplyButton;
    Button divideButton;
    Button equalButton;
    Button changeSignButton;
    Button clearButton;
    Button allClearButton;
    Button sinButton;
    Button cosButton;
    Button tanButton;
    Button cotButton;
    Button powButton;
    Button sqrButton;
    Button logButton;
    Button logNButton;
    Button expButton;
    boolean hasPoint;
    boolean error;
    char operator;
    char lastChar;
    double operand1;
    double operand2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        CalculatorWindow = primaryStage;
        CalculatorWindow.setTitle("Calculator");
        defineLayout();
        defineTextArea();
        defineButtons();
        addTextArea();
        addButtons();
        initializeCalculator();
        CalculatorWindow.setScene(CalculatorViewer);
        CalculatorWindow.show();
    }

    @Override
    public void handle(ActionEvent event) {
        Object source = event.getSource();
        if (error) {
            if (source != allClearButton)
                return;
        }
        if (source == zeroButton) {
            zero();
        } else if (source == oneButton) {
            one();
        } else if (source == twoButton) {
            two();
        } else if (source == threeButton) {
            three();
        } else if (source == fourButton) {
            four();
        } else if (source == fiveButton) {
            five();
        } else if (source == sixButton) {
            six();
        } else if (source == sevenButton) {
            seven();
        } else if (source == eightButton) {
            eight();
        } else if (source == nineButton) {
            nine();
        } else if (source == pointButton) {
            point();
        } else if (source == addButton) {
            add();
        } else if (source == subtractButton) {
            subtract();
        } else if (source == multiplyButton) {
            multiply();
        } else if (source == divideButton) {
            divide();
        } else if (source == equalButton) {
            equal();
        } else if (source == changeSignButton) {
            negate();
        } else if (source == clearButton) {
            clear();
        } else if (source == allClearButton) {
            allClear();
        } else if (source == sinButton) {
            sine();
        } else if (source == cosButton) {
            cosine();
        } else if (source == tanButton) {
            tangent();
        } else if (source == cotButton) {
            cotangent();
        } else if (source == logButton) {
            logarithm();
        } else if (source == logNButton) {
            naturalLog();
        } else if (source == powButton) {
            power();
        } else if (source == sqrButton) {
            squareRoot();
        } else if (source == expButton) {
            exp();
        }

    }

    private void defineLayout() {
        layout = new GridPane();
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.setHgap(15);
        layout.setVgap(15);
    }

    private void defineTextArea() {
        output = new TextArea();
        output.getStyleClass().add("text-area");
        output.setPrefColumnCount(20);
        output.setPrefRowCount(1);
        output.setEditable(false);
        output.setText("0");
        GridPane.setColumnSpan(output, 4);
    }

    private void defineButtons() {
        allClearButton = makeButton("AC");
        clearButton = makeButton("C");
        changeSignButton = makeButton("+/-");
        powButton = makeButton("^");

        sevenButton = makeButton("7");
        eightButton = makeButton("8");
        nineButton = makeButton("9");
        divideButton = makeButton("/");

        fourButton = makeButton("4");
        fiveButton = makeButton("5");
        sixButton = makeButton("6");
        multiplyButton = makeButton("X");

        oneButton = makeButton("1");
        twoButton = makeButton("2");
        threeButton = makeButton("3");
        subtractButton = makeButton("-");

        zeroButton = makeButton("0");
        pointButton = makeButton(".");
        equalButton = makeButton("=");
        addButton = makeButton("+");

        sinButton = makeButton("sin");
        cosButton = makeButton("cos");
        tanButton = makeButton("tan");
        cotButton = makeButton("cot");

        expButton = makeButton("e^x");
        sqrButton = makeButton("sqr");
        logButton = makeButton("log");
        logNButton = makeButton("ln");

    }

    private void addTextArea() {
        layout.add(output, 0, 0);
    }

    private void addButtons() {
        layout.add(allClearButton, 0, 1);
        layout.add(clearButton, 1, 1);
        layout.add(changeSignButton, 2, 1);
        layout.add(powButton, 3, 1);

        layout.add(sevenButton, 0, 2);
        layout.add(eightButton, 1, 2);
        layout.add(nineButton, 2, 2);
        layout.add(divideButton, 3, 2);

        layout.add(fourButton, 0, 3);
        layout.add(fiveButton, 1, 3);
        layout.add(sixButton, 2, 3);
        layout.add(multiplyButton, 3, 3);

        layout.add(oneButton, 0, 4);
        layout.add(twoButton, 1, 4);
        layout.add(threeButton, 2, 4);
        layout.add(subtractButton, 3, 4);

        layout.add(zeroButton, 0, 5);
        layout.add(pointButton, 1, 5);
        layout.add(equalButton, 2, 5);
        layout.add(addButton, 3, 5);

        layout.add(sinButton, 0, 6);
        layout.add(cosButton, 1, 6);
        layout.add(tanButton, 2, 6);
        layout.add(cotButton, 3, 6);

        layout.add(expButton, 0, 7);
        layout.add(sqrButton, 1, 7);
        layout.add(logButton, 2, 7);
        layout.add(logNButton, 3, 7);


    }

    private void initializeCalculator() {
        CalculatorViewer = new Scene(layout, 300, 500);
        layout.getStyleClass().add("calculator-background");
        CalculatorViewer.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styles.css")).toExternalForm());
        CalculatorWindow.setResizable(false);
        hasPoint = false;
        error = false;
        lastChar = '\0';
        operator = '\0';
        operand1 = 0.0;
        operand2 = 0.0;
    }

    private Button makeButton(String s) {
        Button button = new Button(s);
        button.setTextAlignment(TextAlignment.CENTER);
        button.setPrefSize(50, 50);
        button.setOnAction(this);
        button.getStyleClass().add("calculator-button");
        return button;
    }

    private void zero() {
        if (output.getText().matches("[-]0")
                || lastChar == '+'
                || lastChar == '-'
                || lastChar == '*'
                || lastChar == '/'
                || lastChar == '=') {
            output.setText("0");
            hasPoint = false;
        } else if (!output.getText().matches("0")) {
            output.appendText("0");
        }
        lastChar = '0';
    }

    private void one() {
        if (output.getText().matches("0")
                || lastChar == '+'
                || lastChar == '-'
                || lastChar == '*'
                || lastChar == '/'
                || lastChar == '=') {
            output.setText("1");
            hasPoint = false;
        } else {
            output.appendText("1");
        }
        lastChar = '1';
    }

    private void two() {
        if (output.getText().matches("0")
                || lastChar == '+'
                || lastChar == '-'
                || lastChar == '*'
                || lastChar == '/'
                || lastChar == '=') {
            output.setText("2");
            hasPoint = false;
        } else {
            output.appendText("2");
        }
        lastChar = '2';
    }

    private void three() {
        if (output.getText().matches("0")
                || lastChar == '+'
                || lastChar == '-'
                || lastChar == '*'
                || lastChar == '/'
                || lastChar == '=') {
            output.setText("3");
            hasPoint = false;
        } else {
            output.appendText("3");
        }
        lastChar = '3';
    }

    private void four() {
        if (output.getText().matches("0")
                || lastChar == '+'
                || lastChar == '-'
                || lastChar == '*'
                || lastChar == '/'
                || lastChar == '=') {
            output.setText("4");
            hasPoint = false;
        } else {
            output.appendText("4");
        }
        lastChar = '4';
    }

    private void five() {
        if (output.getText().matches("0")
                || lastChar == '+'
                || lastChar == '-'
                || lastChar == '*'
                || lastChar == '/'
                || lastChar == '=') {
            output.setText("5");
            hasPoint = false;
        } else {
            output.appendText("5");
        }
        lastChar = '5';
    }

    private void six() {
        if (output.getText().matches("0")
                || lastChar == '+'
                || lastChar == '-'
                || lastChar == '*'
                || lastChar == '/'
                || lastChar == '=') {
            output.setText("6");
            hasPoint = false;
        } else {
            output.appendText("6");
        }
        lastChar = '6';
    }

    private void seven() {
        if (output.getText().matches("0")
                || lastChar == '+'
                || lastChar == '-'
                || lastChar == '*'
                || lastChar == '/'
                || lastChar == '=') {
            output.setText("7");
            hasPoint = false;
        } else {
            output.appendText("7");
        }
        lastChar = '7';
    }

    private void eight() {
        if (output.getText().matches("0")
                || lastChar == '+'
                || lastChar == '-'
                || lastChar == '*'
                || lastChar == '/'
                || lastChar == '=') {
            output.setText("8");
            hasPoint = false;
        } else {
            output.appendText("8");
        }
        lastChar = '8';
    }

    private void nine() {
        if (output.getText().matches("0")
                || lastChar == '+'
                || lastChar == '-'
                || lastChar == '*'
                || lastChar == '/'
                || lastChar == '=') {
            output.setText("9");
            hasPoint = false;
        } else {
            output.appendText("9");
        }
        lastChar = '9';
    }

    private void point() {
        /* Ensures entry of a new number beginning with "0." is displayed.
         * If a point was not already entered, append.
         * Ensure hasPoint is true. */
        if (output.getText().matches("0")
                || lastChar == '+'
                || lastChar == '-'
                || lastChar == '*'
                || lastChar == '/'
                || lastChar == '=') {
            output.setText("0.");
        } else if (!hasPoint) {
            output.appendText(".");
        }
        hasPoint = true;
        lastChar = '.';
    }

    private void add() {
        lastChar = '+';
        operator = '+';
        operand1 = Double.parseDouble(output.getText());
        output.setText("");
    }

    private void subtract() {
        lastChar = '-';
        operator = '-';
        operand1 = Double.parseDouble(output.getText());
        output.setText("");
    }

    private void multiply() {
        lastChar = '*';
        operator = '*';
        operand1 = Double.parseDouble(output.getText());
        output.setText("");
    }

    private void divide() {
        lastChar = '/';
        operator = '/';
        operand1 = Double.parseDouble(output.getText());
        output.setText("");
    }

    private void equal() {
        double answer = 0.0;
        switch (lastChar) {
            /* If the last button clicked was an operator,
             * the calculator should do nothing.
             * The input should have been a number. */
            case '+':
                return;
            case '-':
                return;
            case '*':
                return;
            case '/':
                return;
            case '=':
                return;
            case '.':
                break;
            case 'p':
                return;
            default:

        }
        switch (operator) {
            case '\0':
                return;
            case '+':
                operand2 = Double.parseDouble(output.getText());
                answer = operand1 + operand2;
                break;
            case '-':
                operand2 = Double.parseDouble(output.getText());
                answer = operand1 - operand2;
                break;
            case '*':
                operand2 = Double.parseDouble(output.getText());
                answer = operand1 * operand2;
                break;
            case '/':
                /* You cannot divide by zero. */
                operand2 = Double.parseDouble(output.getText());
                if (operand2 == 0.0) {
                    output.setText("Cannot divide by zero!");
                    error = true;
                    lastChar = '=';
                    operator = '\0';
                    return;
                }
                answer = operand1 / operand2;
                break;

            case 'p':
                operand2 = Double.parseDouble(output.getText());
                answer = Math.pow(operand1, operand2);
                break;
            default:
                /* Section of code should not be reachable. */
                System.out.println("ERROR: lastChar: " + lastChar);
                System.out.println("ERROR: operator: " + operator);
        }

        if (answer - (int) answer == 0.0) {
            output.setText(Integer.toString((int) answer));
        } else {
            output.setText(Double.toString(answer));
        }
        lastChar = '=';
        operator = '\0';
    }

    private void negate() {
        if (lastChar == '+'
                || lastChar == '-'
                || lastChar == '*'
                || lastChar == '/') {
            return;
        } else if (Double.parseDouble(output.getText()) == 0.0) {
            return;
        } else if (output.getText().charAt(0) == '-') {
            output.setText(output.getText().substring(1, output.getText().length()));
        } else {
            output.setText("-" + output.getText());
        }
    }

    private void clear() {
        /* Clear button on calculator: "C" */
        output.setText("0");
        hasPoint = false;
    }

    private void allClear() {
        /* All clear button on calculator: "AC" */
        clear();
        lastChar = '\0';
        operator = '\0';
        error = false;
    }

    private void sine() {
        double degree = Double.parseDouble(output.getText());
        double radians = Math.toRadians(degree);
        double result = Math.sin(radians);

        if (Math.abs(result - Math.round(result)) < 0.00001) {
            result = Math.round(result);
        }

        if (result - (int) result == 0.0) {
            output.setText(Integer.toString((int) result));
        } else {
            output.setText(Double.toString(result));
        }
    }

    private void cosine() {
        double degree = Double.parseDouble(output.getText());
        double radians = Math.toRadians(degree);
        double result = Math.cos(radians);

        if (Math.abs(result - Math.round(result)) < 0.00001) {
            result = Math.round(result);
        }

        if (result - (int) result == 0.0) {
            output.setText(Integer.toString((int) result));
        } else {
            output.setText(Double.toString(result));
        }
    }

    private void tangent() {
        double degree = Double.parseDouble(output.getText());
        double radians = Math.toRadians(degree);
        double result = Math.tan(radians);

        if (Math.abs(result - Math.round(result)) < 0.00001) {
            result = Math.round(result);
        }

        if (result - (int) result == 0.0) {
            output.setText(Integer.toString((int) result));
        } else {
            output.setText(Double.toString(result));
        }
    }

    private void cotangent() {
        double degree = Double.parseDouble(output.getText());
        double radians = Math.toRadians(degree);
        double result = 1 / Math.tan(radians);

        if (Math.abs(result - Math.round(result)) < 0.00001) {
            result = Math.round(result);
        }

        if (result - (int) result == 0.0) {
            output.setText(Integer.toString((int) result));
        } else {
            output.setText(Double.toString(result));
        }
    }


    private void naturalLog() {
        double result = Math.log(Double.parseDouble(output.getText()));

        if (Math.abs(result - Math.round(result)) < 0.00001) {
            result = Math.round(result);
        }

        if (result - (int) result == 0.0) {
            output.setText(Integer.toString((int) result));
        } else {
            output.setText(Double.toString(result));
        }
    }

    private void logarithm() {
        double result = Math.log10(Double.parseDouble(output.getText()));

        if (Math.abs(result - Math.round(result)) < 0.00001) {
            result = Math.round(result);
        }

        if (result - (int) result == 0.0) {
            output.setText(Integer.toString((int) result));
        } else {
            output.setText(Double.toString(result));
        }
    }

    private void power() {
        operand1 = Double.parseDouble(output.getText());

        lastChar = 'p';
        operator = 'p';
        output.setText("");
    }

    private void squareRoot() {
        double result = Math.sqrt(Double.parseDouble(output.getText()));

        if (result - (int) result == 0.0) {
            output.setText(Integer.toString((int) result));
        } else {
            output.setText(Double.toString(result));
        }
    }

    private void exp() {
        double result = Math.exp(Double.parseDouble(output.getText()));

        if (result - (int) result == 0.0) {
            output.setText(Integer.toString((int) result));
        } else {
            output.setText(Double.toString(result));
        }
    }

}