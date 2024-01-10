
This is a desktop calculator application for performing mathematical and scientific computations. Key capabilities:

- Arithmetic operations: Addition, subtraction, multiplication, division
- Scientific functions: Trigonometric, Logs, Exponents 
- Supports decimals and negative numbers
- User interface built with JavaFX

## Core Classes

### Calculator
Main application class that launches the UI window and handles overall program flow.

**Key Methods:**

- `start()` 
  - Initializes JavaFX components like scene, stage, layouts
  - Loads CSS for styling
  - Configures UI elements
  - Displays the window

- `handle(ActionEvent e)`
  - Central button click handler 
  - Invoked when any calculator button is clicked
  - Calls appropriate operation based on source of event

- `defineLayout()/defineTextArea()/defineButtons()`
  - Helper methods to setup the visual components

- `makeButton(String label)` 
  - Creates a button with consistent styling

**Key Fields:**

- `output` - TextArea to display calculation input and results
- `buttons` - All the calculator buttons 
- `operator` - Tracks current arithmetic operator 
- `operand1`, `operand2` - Stored number values
  
### MathOperations
Class containing all the mathematical and scientific operations.

**Key Methods:**

- `add(num1, num2)`: Returns sum of two numbers
- `log(num)`: Calculates logarithm for input number 
- `sin(degrees)`: Returns sine of angle in degrees
- And more for other supported operations...

## Key Functions

### Performing Calculations

**Store operand1**:
When plus, minus etc buttons are clicked, the current number entered in the `output` text area is stored in `operand1` and the `operator` field is set accordingly.

**Get operand2**: 
When the equal button is clicked, take the number currently entered and parse it to get `operand2`.

**Execute operation**:
Apply relevant math function based on the `operator` field using `operand1` and `operand2`. Display the result back in the output area.

### Handling User Input

Functions like `zero()`, `one()`, etc will handle appending the number clicks based on values of `lastChar` and current output. Includes logic for appropriate decimal point insertion.

### Resetting State 
`allClear()` resets entire state by clearing fields and output.
`clear()` only clears current entry and not historical values.


## Implementation Language
This application is implemented in Java, leveraging the JavaFX framework for building desktop GUI applications. Key Java technologies used:

JavaFX - For creating UI visual components like scenes, buttons etc
Event handling - Handle button click events
CSS styling - Styling visual appearance
JavaFX is integrated with Java code so mathematical operations and application logic is written in plain Java. The integration between UI code and business logic enables a rich responsive calculator app.

### Use of CSS
The application applies CSS (Cascading Style Sheets) to uniformly style UI components for visual appeal.

Definitions for fonts, colors, borders etc are specified in an external styles.css file. This is loaded at runtime and applied to JavaFX nodes like buttons and text areas to consistently style their appearance.
