public class App {
  public static void main(String args[]) {
       
    final int STUDENT_GRADE_AMOUNT = 4;

    InputHandler inputHandler = new InputHandler(args, STUDENT_GRADE_AMOUNT);
    float grades[] = inputHandler.getEnteredValues();

    float gradesSum = 0.0f;
    for(float i: grades) gradesSum += i;

    System.out.println("The average grade was: " + gradesSum / STUDENT_GRADE_AMOUNT);
  }

  static class InputHandler{

    private String args[];

    private int desiredInputAmount;
    private float enteredValues[];

    public InputHandler(String args[], int desiredInputAmount){

      this.args = args;
      this.desiredInputAmount = desiredInputAmount;

      checkInputAmount();
      fillEnteredValuesArray();
    }

    float[] getEnteredValues(){
      return enteredValues;  
    }

    private void checkInputAmount(){
      int enteredInputAmount = args.length;
      if(enteredInputAmount != desiredInputAmount){
        throw new IllegalArgumentException("You need to enter four numbers.");
      }
    }

    private void fillEnteredValuesArray(){
      // positive floats and integers patterns
      Pattern pattern = Pattern.compile("^(\\+?([0-9]+|\\.)\\.?([0-9]+)?\\b)");
      
      float values[] = new float[args.length];

      for(int i = 0; i < args.length; i++){
        Matcher m = pattern.matcher(args[i]);
        if(!m.matches()){
          throw new IllegalArgumentException("The " + (i + 1) + "º value isn't a positive number.");
        }

        values[i] = Float.parseFloat(args[i]);
        enteredValues = values;
      }
    }
  }
}
