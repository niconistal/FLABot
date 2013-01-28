
import JavaLog.mobility.*;
import JavaLog.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import com.borland.jbcl.layout.*;

public class Test extends JDialog implements ActionListener, WindowListener{
  JPanel panel1 = new JPanel();
  XYLayout xYLayout1 = new XYLayout();
  JButton jButton1 = new JButton();
  JButton jButton2 = new JButton();
  JButton jButton3 = new JButton();
  JComboBox jComboBox1 = new JComboBox();
  JLabel jLabel2 = new JLabel();
  JRadioButton jRadioButton1 = new JRadioButton("",true);
  JRadioButton jRadioButton2 = new JRadioButton();
  JRadioButton jRadioButton3 = new JRadioButton();
  JLabel jLabel3 = new JLabel();
  JEditorPane jEditorPane1 = new JEditorPane();
  JScrollPane scroll;
  JLabel jLabel4 = new JLabel();
  JLabel jLabel1 = new JLabel();
  JTextField jTextField1 = new JTextField();
  ButtonGroup radioGroup;
  String implicitCode = "";
  String explicitCode = "";
  String myAddress = "localhost";
  int myPort = 80;
  String myPath = "/servlets/MARlet";
  JLabel jLabel5 = new JLabel();
  JTextField jTextField2 = new JTextField();
  JButton jButton4 = new JButton();

  public Test(Frame frame, String title, boolean modal)
  {
    super(frame, title, modal);
    try
    {
      jbInit();
      pack();
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
    }
  }

  public Test()
  {
    this(null, "Offers Searcher", true);
  }

  void jbInit() throws Exception
  {
    addWindowListener(this);
    this.setResizable(false);
    panel1.setLayout(xYLayout1);
    jButton1.setToolTipText("Start the search for offers");
    jButton1.setText("Search for Offers!!!");
    jButton1.addActionListener(this);
    jButton2.setToolTipText("Clear the search results\' log");
    jButton2.setText("Clear log");
    jButton2.addActionListener(this);
    jButton3.setToolTipText("Exit application");
    jButton3.setText("Exit");
    jButton3.addActionListener(this);
    jLabel2.setFont(new java.awt.Font("Dialog", 0, 10));
    jLabel2.setText("Article to Buy:");
    jRadioButton1.setText("BrainLet (Implicit Mobility)");
    jRadioButton1.setFont(new java.awt.Font("Dialog", 0, 10));
    jRadioButton2.setText("Client-Server Query");
    jRadioButton2.setEnabled(false);
    jRadioButton2.setFont(new java.awt.Font("Dialog", 0, 10));
    jRadioButton3.setText("BrainLet (Explicit Mobility)");
    jRadioButton3.setFont(new java.awt.Font("Dialog", 0, 10));
    radioGroup = new ButtonGroup();
    jLabel5.setText("Attach hosts (separated by \',\'):");
    jLabel5.setFont(new java.awt.Font("Dialog", 0, 10));
    jTextField2.setEditable(true);
    jButton4.addActionListener(this);
    jButton4.setText("Attach");
    jButton4.setToolTipText("Register other host of the net");
    radioGroup.add(jRadioButton1);
    radioGroup.add(jRadioButton2);
    radioGroup.add(jRadioButton3);
    xYLayout1.setHeight(300);
    xYLayout1.setWidth(515);
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel3.setText("Search Time:");
    jEditorPane1.setEditable(false);
    jEditorPane1.setFont(new java.awt.Font("Dialog", 0, 11));
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel4.setText("Search Results");
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("secs.");
    jTextField1.setEditable(false);
    getContentPane().add(panel1);
    scroll = new JScrollPane(this.jEditorPane1);
    scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    panel1.add(scroll, new XYConstraints(11, 31, 308, 220));
    scroll.getViewport().add(jEditorPane1, null);
    panel1.add(jLabel4, new XYConstraints(18, 10, 94, 20));
    panel1.add(jRadioButton3, new XYConstraints(346, 64, -1, 21));
    panel1.add(jComboBox1, new XYConstraints(404, 32, 90, 20));
    panel1.add(jLabel2, new XYConstraints(332, 29, 77, 23));
    panel1.add(jRadioButton1, new XYConstraints(346, 91, 197, 21));
    panel1.add(jRadioButton2, new XYConstraints(346, 117, 110, -1));
    panel1.add(jTextField1, new XYConstraints(408, 148, 57, -1));
    panel1.add(jLabel3, new XYConstraints(333, 147, 80, 23));
    panel1.add(jLabel1, new XYConstraints(470, 146, 36, 24));
    panel1.add(jButton3, new XYConstraints(434, 223, 57, 28));
    panel1.add(jButton2, new XYConstraints(340, 223, 84, 28));
    panel1.add(jButton1, new XYConstraints(340, 183, 151, 28));
    panel1.add(jLabel5, new XYConstraints(12, 261, 147, 23));
    panel1.add(jTextField2, new XYConstraints(157, 263, 162, -1));
    panel1.add(jButton4, new XYConstraints(340, 259, 84, 28));
    initialize();
  }

  public void initialize()
  {
    try
    {
      Properties prop = new Properties();
      FileInputStream in = new FileInputStream("searcher.properties");
      prop.load(in);
      myAddress = prop.getProperty("hostAddress");
      myPort = Integer.parseInt(prop.getProperty("servletPort"));
      myPath = prop.getProperty("servletPath");
      implicitCode = prop.getProperty("implicitCode");
      explicitCode = prop.getProperty("explicitCode");
      implicitCode = loadCode(implicitCode);
      explicitCode = loadCode(explicitCode);
      String articles = prop.getProperty("articles");
      StringTokenizer tokenizer = new StringTokenizer(articles,",");
      while (tokenizer.hasMoreTokens())
      {
        String article = tokenizer.nextToken();
        jComboBox1.addItem(article);
      }
    }
    catch(IOException e)
    {
    }
  }

  public String loadCode(String fileName)
  {
    try
    {
      FileInputStream stream = new FileInputStream(fileName);
      String result = "";
      int in = 0;
      while ((in = stream.read()) != -1)
        result = result + String.valueOf((char)in);
      return result;
    }
    catch(IOException e)
    {
      return "";
    }
  }

  public void windowOpened(WindowEvent e){}
  public void windowIconified(WindowEvent e){}
  public void windowDeiconified(WindowEvent e){}
  public void windowActivated(WindowEvent e){}
  public void windowDeactivated(WindowEvent e){}
  public void windowClosed(WindowEvent e){}

  public void windowClosing(WindowEvent e)
  {
    System.exit(0);
  }

  public void actionPerformed(ActionEvent e)
  {
    Object source = e.getSource();
    if (source instanceof JButton)
    {
      JButton button = (JButton)source;
      String text = button.getText();
      if (text.equals("Attach"))
        attachHosts();
      else
      if (text.equals("Clear log"))
        jEditorPane1.setText("");
      else
      if (text.equals("Exit"))
      {
        this.setVisible(false);
        System.exit(0);
      }
      else
      {
        Timestamp timeStart = new Timestamp(System.currentTimeMillis());
        boolean result;
        if (jRadioButton1.isSelected())
          result = doImplicitSearch();
        else
        if (jRadioButton3.isSelected())
          result = doExplicitSearch();
        else
          result = doClientServerSearch();
        if (result)
        {
          Timestamp timeFinish = new Timestamp(System.currentTimeMillis());
          putDifference(timeStart, timeFinish);
        }
      }
    }
  }

  public void putDifference(Timestamp t1, Timestamp t2)
  {
    long msecs1 = t1.getTime() + t1.getNanos()/1000000;
    long msecs2 = t2.getTime() + t2.getNanos()/1000000;
    jTextField1.setText(String.valueOf((msecs2 - msecs1)/1000.0));
  }

  private void addText(String text)
  {
    this.jEditorPane1.setText(this.jEditorPane1.getText() + "\n" + text);
  }

  protected boolean doSearch(String code)
  {
    MarletMessenger messenger = new MarletMessenger(myAddress,myPort,myPath);
    String articleToBuy = (String)jComboBox1.getSelectedItem();
    if (articleToBuy.trim().equals(""))
    {
      addText("No article selected.");
      return false;
    }
    else
    {
      Pair result = messenger.doQuery("buy(" + articleToBuy + ",R).", code);
      if (result != null)
      {
        Boolean value = (Boolean)result.getFirstElement();
        Hashtable hash = (Hashtable)result.getSecondElement();
        addText("Query Result: " + value.toString());
        if (!value.booleanValue())
        {
          addText("No matching found.");
          return false;
        }
        PlList list = (PlList)hash.get("R");
        if (list.isEmpty())
          addText("No matching found.");
        else
        {
          addText("Results Found");
          addText("-------------------");
          do
          {
            PlObject obj = list.car();
            addText(obj.toString());
            list = (PlList)list.cdr();
          }
          while (!list.isEmpty());
          return true;
        }
      }
      else
      {
        addText("There was an error executing the query.");
        return false;
      }
    }
    return false;
  }

  public boolean doImplicitSearch()
  {
    return doSearch(implicitCode);
  }

  public boolean doExplicitSearch()
  {
    return doSearch(explicitCode);
  }

  public boolean doClientServerSearch()
  {
    return false;
  }

  /*
   * Se espera recibir la lista de sitios (enum) a los cuáles
   * los agentes pueden ir por artículos. Esta lista se comunica
   * al servlet local.
   *
  */
  protected void publish(Enumeration enum){
    while (enum.hasMoreElements()){
      String host = (String)enum.nextElement();
      MarletMessenger mess = new MarletMessenger(myAddress, myPort, myPath);
      // Le dice al servlet local que el sitio args[i] implementa
      // el protocolo de artículos, para moverse a éste en el futuro
      mess.registerMARlet(host,"protocol(article,4).");
    }
  }

  protected void attachHosts(){
    StringTokenizer tokenizer = new StringTokenizer(jTextField2.getText().trim(),",");
    Vector v = new Vector();
    while (tokenizer.hasMoreTokens()){
      v.addElement(tokenizer.nextToken().trim());
    }
    this.publish(v.elements());
    jTextField2.setText("");
  }

  public static void main(String[] args)
  {
    try{
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch(Exception e){}
    Test test = new Test();
    test.show();
  }
}
