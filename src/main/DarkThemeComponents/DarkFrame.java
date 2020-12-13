package DarkThemeComponents;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/*
 * a dark-themed CSV File Processing UI with tabular representation of data
 *  Initial version May 2020
 */

/**
 *
 * @author Vilrose Daquiado
 */

public  class  DarkFrame extends JFrame implements ActionListener{

    private static final long serialVersionUID = 1L;
    
    private JButton BTNExit, BTNMinimize, BTNMaximize, BTNReduceSize, BTNImport,button, BTNTable;   
    private  JPanel topRightPanel, topPanel,dashboard, centerPanel,rightPanel, bottomPanel;
    private final Color DARKER_GRAY = Color.decode("#212121"), LIGHTER_GRAY = Color.decode("#424242");
    private final Container pane = this.getContentPane();    
    private Dimension preferredSize;
    private String applicatioName;
    
    public DarkFrame( String appName) throws IOException {
        super("CSV Data Processing App");
        this.setForeground(Color.white);
        applicatioName = appName;
//        createFrame();


        
        //set Location at the center of the screen
        this.setLocationRelativeTo(null);
        setResizable(true);


    }

    public Container getPane() {
        return pane;
    }
   
    // create a JFrame instance and set its property
    public void createFrame() throws IOException {
        // JFrame´s property set-up      
       
//        Dimension screenSize =  Toolkit.getDefaultToolkit().getScreenSize();
//        preferredSize = new Dimension((int)(screenSize.getWidth()*0.5),  (int)(screenSize.getHeight()*0.5));
//        setPreferredSize(preferredSize);


        //set JFrame´s bounds to center of the screen
        
        pane.setBackground(DARKER_GRAY);
        setLayout(new BorderLayout(10,3));
        setUndecorated(true);



        
        /*add a mouse and mouseMotion listeners to the frame receive the mouse events on this frame*/
       FrameDragListener frameragListener = new FrameDragListener(this);
       this.addMouseListener(frameragListener);
       this.addMouseMotionListener(frameragListener);
       
       //add the 5 panels of the frame
//       addFrameComponents();

    }
    public void addFrameComponents() throws IOException {
        //create a topPanel Upper part of the frame
        topPanel = addPanel(pane,pane.getWidth(),20, new BorderLayout(),DARKER_GRAY,BorderLayout.NORTH);
        topPanel.add(createTitlePanel(applicatioName), BorderLayout.LINE_START);
        //add the Exit, minimize, maximize and reduce buttons on the upper-right side of the frame
        topPanel.add(addBTNExitMinMaxPanel(),BorderLayout.LINE_END);
        
        //Add letfPanel on the frame
        dashboard = addPanel(pane,new BorderLayout(),LIGHTER_GRAY,BorderLayout.WEST);
        
        
        //Add centerPanel to the frame
        centerPanel = addPanel(pane,new GridLayout(1,1),LIGHTER_GRAY,BorderLayout.CENTER);
       
        //add the rightPanel to the right of the Frame by calling the addRightPanel method which returns a JPanel instance component
        rightPanel =  addPanel(pane, null,LIGHTER_GRAY,BorderLayout.EAST);
        bottomPanel = addPanel(pane, new FlowLayout(),LIGHTER_GRAY, BorderLayout.PAGE_END);
        //add the bottomPanel to the bottom of the Frame by calling the addBottomPanel method which returns a JPanel instance component
        pane.add(bottomPanel, BorderLayout.PAGE_END);
    }   
   
     //A method that requires a String, Color, and ImageIcon objects as parameters; instantiates a JButton object, set its properties, and returns a JButton Object
    public JButton createButton( String text, Color bgColor,  ImageIcon icon, String toolTipText){
        JButton newButton = new JButton(text);
      
        newButton.setBackground(bgColor);
        newButton.setHorizontalAlignment(SwingConstants.CENTER);
        newButton.setForeground(new Color(250,250,250));
        newButton.setIcon(icon);
        newButton.setToolTipText(toolTipText);
        newButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        newButton.setFocusPainted(false);
        newButton.addActionListener(this);



        if (newButton.isFocusPainted() == true){
            setBackground(Color.red);
        }
      
        return newButton;
    }
      //A method to add all the buttons on the top-right corner of the menu bar such as Exit, maximize, minimize and reduce-screen-size buttons
    public JPanel addBTNExitMinMaxPanel() throws IOException {
        ImageIcon icon;
        
        topRightPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        topRightPanel.setOpaque(false);

        //create a Minimize button
         icon = new ImageIcon( getClass().getResource("../resources/images/minimize_white_18dp.png"));
        BTNMinimize = createButton( null, DARKER_GRAY, icon,"Minimieren");

        //create a Close button
        icon = new ImageIcon(DarkFrame.class.getResource("images/close_white_18dp.png"));
        BTNExit = createButton( null, DARKER_GRAY, icon, "Schließen" );
        BTNExit.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        
        icon = new ImageIcon(DarkFrame.class.getResource("images/maximize.png"));
        BTNMaximize = createButton( null, DARKER_GRAY, icon, "Maximieren" );

      
        icon =  new ImageIcon(DarkFrame.class.getResource("images/reduceSize.png"));
        BTNReduceSize = createButton( null, DARKER_GRAY,icon, "Verkleinern" );
        BTNReduceSize.setVisible(false);
        
         //adding the buttons on the panel        
        topRightPanel.add(BTNMinimize);
        topRightPanel.add(BTNMaximize);  
        topRightPanel.add(BTNReduceSize);
        topRightPanel.add( BTNExit);
        topRightPanel.setVisible(true);
    
        return topRightPanel;    
    }
    public JPanel createTitlePanel(String title){
        JPanel titlePanel = new JPanel();
        JLabel titleLabel ;
        
        titlePanel.setOpaque(false);
        
        titlePanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 5, 20));
        
        titleLabel =  new JLabel(title, SwingConstants.CENTER);
        titleLabel.setForeground(Color.decode("#EEEEEE"));
        
        titlePanel.add(titleLabel);
        return titlePanel;    
    }
    
    //a method that adds a JPanel instance that contains centerPanel components    
    
    public JPanel addPanel(Container host, LayoutManager layout, Color bgColor, String position){
        
        JPanel panel = new JPanel(layout);
        panel.setBackground(bgColor);
//        panel.setSize(width, height);
        panel.revalidate();
        panel.repaint();        
        panel.setVisible(true);  
        host.add(panel, position);
        return panel;
    }    

     public JPanel getTopPanel() {
        return topPanel;
    }

    //A method that allows access of the JPanel object variable named dashboard 
    public JPanel getDashboardPanel() {
        return dashboard;
    }
    
    //A method that allows access of the JPanel object  named centerPanel 
    public JPanel getCenterPanel() {
        return centerPanel;
    }
    //A method that sets the properties of a JButton object that requires a string parameter to set as the button variable´s text; and returns a JButton object´s variable
    public JButton addBTN( String text ){
        button = new JButton(text);
        
        return button; 
    }
    
    //A method that allows access of the JPanel object variable named rightPanel 
    public JPanel getRightPanel() {
        return rightPanel;
    }
    
     //A method that allows access of the JPanel object variable named bottomPanel 
    public JPanel getBottomPanel() {
        return bottomPanel;
    }
    
     public JButton getBTNExit() {
        return BTNExit;
    }

    public JButton getBTNMinimize() {
        return BTNMinimize;
    }

    public JButton getBTNMaximize() {
        return BTNMaximize;
    }

    public JButton getBTNReduceSize() {
        return BTNReduceSize;
    }

    public JButton getBTNImport() {
        return BTNImport;
    }
    
      // Action to be performed when one of the JButtons on the upper right panel has been clicked
    @Override
     public void actionPerformed(ActionEvent e){
         //get the source or identify which button has been clicked
        Object source = e.getSource();
          
          //if the user has clicked the exit (X) button, the JFrame state will be disposed
        if(source.equals(BTNExit)){
            try {
                setBackground(Color.red);
                Thread.sleep(10);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }

            repaint();
            super.dispose();
        }
          // if the source is the minimize  (-) button has been clicked, the JFrame´s state will be iconified or hidden but keeps running on the background
        else if(source.equals(BTNMinimize)){
            super.setState(Frame.ICONIFIED);
        }
          // if the source is the reducescreensiuze or double-square icon, the JFrame screen size will be reduced to Dimension(800, 500);
        else if(source.equals(BTNReduceSize)){
            super.setExtendedState(JFrame.NORMAL);
            //after it had been clicked, the button´s visible state is changed to false making it invisible on the Frame
            BTNReduceSize.setVisible(false);
            //the MAX Button or one-square icon will replace the double square button´s position
            BTNMaximize.setVisible(true);       
        }
          
        else if(source.equals(BTNMaximize)){
            super.setExtendedState(JFrame.MAXIMIZED_BOTH);
            //after it had been clicked, the button´s visible state is changed to false making it invisible on the Frame
            BTNMaximize.setVisible(false);
            //the reduce screen size Button or two-square icon will replace the double square button´s position
            BTNReduceSize.setVisible(true);
        }
        
    }
  
     
    
    
}
