import java.util.ArrayList;


public class CalculatorLogic {
  
  static ArrayList<Double> numbersToAdd = new ArrayList<>();
  static ArrayList<Character> symbols = new ArrayList<>();
  
  public static void appendNumberList(double number){
    numbersToAdd.add(number);
  }
  
  public static void appendSymbolList(char symbol){
    symbols.add(symbol);
  }
  
  
  
  
  
  
  public static double calculate(){
    int i = 0;
    double result = numbersToAdd.get(i);
    
    for (i = 0; i<numbersToAdd.size() - 1; i++){
      if (symbols.get(i) == '+'){
        result += numbersToAdd.get(i + 1);
      }
      else if (symbols.get(i) == '-'){
        result -= numbersToAdd.get(i + 1);
      }
      else if (symbols.get(i) == '*'){
        result *= numbersToAdd.get(i + 1);
      }
      else if (symbols.get(i) == '/'){
        result /= numbersToAdd.get(i + 1);
      }
      else {
        result += 0;
      }
    }
    return result;
  }
  
  public static void resetArrays(){
    numbersToAdd = new ArrayList<>();
    symbols = new ArrayList<>();
  }
  
  
  
//  public static void main(String[] args) {
//
////    StringTest st = new StringTest();
//    Scanner input = new Scanner(System.in);
//
//    ArrayList<Character> myChar = new ArrayList<>();
//    ArrayList<Double> myIntList= new ArrayList<>();
//
//    while (true){
//      double i = input.nextDouble();
//      myIntList.add(i);
//      input.nextLine();
//      char s = input.nextLine().charAt(0);
//      if (s == '='){
//        break;
//      } else{
//        myChar.add(s);
//      }
//    }
//
//    System.out.println(st.parseSymbols(myIntList, myChar));

}
