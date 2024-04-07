import javax.swing.*;

public class Calculator implements Runnable {
  public JPanel screen;
  private  JFormattedTextField resultsArea;
  private  JButton pressSeven;
  private  JButton pressOne;
  private  JButton pressFour;
  private  JButton cButton;
  private  JButton divide;
  private  JButton ACButton;
  private  JButton multiply;
  private  JButton pressEight;
  private  JButton pressNine;
  private  JButton sum;
  private  JButton pressFive;
  private JButton pressSix;
  private JButton subtract;
  private JButton pressTwo;
  private JButton pressThree;
  private JButton equals;
  private JButton pressZero;
  private JButton decimal;
  
  
  public static Thread mainThread;
  public String lastResult = "0";
  
  StringBuilder thisInput = new StringBuilder();
  
  public void startThread(){
  mainThread = new Thread(this);
  mainThread.start();
  }
  
  @Override
  public void run() {
    parseInputs();
  }
  
  
  public void resultBoxUpdate(String something){
    SwingUtilities.invokeLater(() -> {
      resultsArea.setText(something);
      resultsArea.repaint();
      resultsArea.revalidate();
    });
  }
  
  public void parseInputs(){
    thisInput  = new StringBuilder();
    
    
    pressOne.addActionListener(e -> {
      thisInput.append(1);
      this.resultBoxUpdate(this.thisInput.toString());
    });
    
    pressTwo.addActionListener(e -> {
      thisInput.append(2);
      this.resultBoxUpdate(thisInput.toString());
    });
    
    pressThree.addActionListener(e -> {
      thisInput.append(3);
      this.resultBoxUpdate(thisInput.toString());
    });
    
    pressFour.addActionListener(e -> {
      thisInput.append(4);
      this.resultBoxUpdate(thisInput.toString());
    });
    
    pressFive.addActionListener(e -> {
      thisInput.append(5);
      this.resultBoxUpdate(thisInput.toString());
    });
    
    pressSix.addActionListener(e -> {
      thisInput.append(6);
      this.resultBoxUpdate(thisInput.toString());
    });
    
    pressSeven.addActionListener(e -> {
      thisInput.append(7);
      this.resultBoxUpdate(thisInput.toString());
    });
    
    pressEight.addActionListener(e -> {
      thisInput.append(8);
      this.resultBoxUpdate(thisInput.toString());
    });
    
    pressNine.addActionListener(e -> {
      thisInput.append(9);
      this.resultBoxUpdate(thisInput.toString());
    });
    
    pressZero.addActionListener(e -> {
      thisInput.append(0);
      this.resultBoxUpdate(thisInput.toString());
    });
    
    decimal.addActionListener(e -> {
      thisInput.append(".");
      this.resultBoxUpdate(thisInput.toString());
    });
    
    
    sum.addActionListener(e -> {
      CalculatorLogic.appendSymbolList('+');
      try{
        CalculatorLogic.numbersToAdd.add(Double.parseDouble(thisInput.toString()));
      } catch(NumberFormatException i){
        thisInput = new StringBuilder(lastResult);
        CalculatorLogic.numbersToAdd.add(Double.parseDouble(thisInput.toString()));
      } finally {
        this.thisInput = new StringBuilder();
      }
    });
    
    
    subtract.addActionListener(e -> {
      CalculatorLogic.appendSymbolList('-');
      
      try{
        CalculatorLogic.numbersToAdd.add(Double.parseDouble(thisInput.toString()));
      } catch(NumberFormatException i){
        thisInput = new StringBuilder(lastResult);
        CalculatorLogic.numbersToAdd.add(Double.parseDouble(thisInput.toString()));
      } finally {
        this.thisInput = new StringBuilder();
      }
    });
    
    
    divide.addActionListener(e -> {
      CalculatorLogic.appendSymbolList('/');
      
      try{
        CalculatorLogic.numbersToAdd.add(Double.parseDouble(thisInput.toString()));
      } catch(NumberFormatException i){
        thisInput = new StringBuilder(lastResult);
        CalculatorLogic.numbersToAdd.add(Double.parseDouble(thisInput.toString()));
      } finally {
        this.thisInput = new StringBuilder();
      }
    });
    
    
    multiply.addActionListener(e -> {
      CalculatorLogic.appendSymbolList('*');
      
      try{
        CalculatorLogic.numbersToAdd.add(Double.parseDouble(thisInput.toString()));
      } catch(NumberFormatException i){
        thisInput = new StringBuilder(lastResult);
        CalculatorLogic.numbersToAdd.add(Double.parseDouble(thisInput.toString()));
      } finally {
        this.thisInput = new StringBuilder();
      }
    });
    
    
    equals.addActionListener(e -> {
      CalculatorLogic.appendSymbolList('=');
      
      try{
        CalculatorLogic.numbersToAdd.add(Double.parseDouble(thisInput.toString()));
      } catch(NumberFormatException i){
        thisInput = new StringBuilder(lastResult);
        CalculatorLogic.numbersToAdd.add(Double.parseDouble(thisInput.toString()));
      } finally {
        this.thisInput = new StringBuilder();
      }
      
      lastResult = String.valueOf(CalculatorLogic.calculate());
      resultBoxUpdate(lastResult);
      CalculatorLogic.resetArrays();
    });
    
    
    cButton.addActionListener(e -> {
      this.thisInput = new StringBuilder();
      resultBoxUpdate("0");
    });
    
    
    ACButton.addActionListener(e -> {
      CalculatorLogic.resetArrays();
      this.thisInput = new StringBuilder();
      resultBoxUpdate("0");
      this.lastResult = "0";
    });
  }
}


