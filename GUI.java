/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
/**
 *
 * @author Anda
 */
public class GUI extends JFrame{
    
       private JButton admin=new JButton("Administrator"); 
      private JButton backadmin1=new JButton("Back"); 
       private JButton backadmin2=new JButton("Back"); 
     
	private JButton user=new JButton("User"); 
        private JButton backuser1=new JButton("Back"); 
       private JButton backuser2=new JButton("Back"); 
        private JButton okadmin=new JButton("Logare admin"); 
	private JButton okuser=new JButton("Logare user");
        
        
        private JButton searchg=new JButton("Search by genre"); 
        private JButton searcha=new JButton("Search by author"); 
        private JButton searcht=new JButton("Search by title"); 
        private JButton sell=new JButton("Sell book"); 
        
        
        private JButton addbook=new JButton("Add book"); 
	private JButton updatebook=new JButton("Update book"); 
        private JButton deletebook=new JButton("Delete book"); 
        private JButton viewbook=new JButton("View book");
	
        
        private JButton adduser=new JButton("Add user"); 
	private JButton updateuser=new JButton("Update user"); 
        private JButton deleteuser=new JButton("Delete user"); 
        private JButton viewuser=new JButton("View user");
        private JButton report1=new JButton("Generate rep"); 
        private JButton report2=new JButton("Generate r2");
        
        
        
        private JPanel mainPanel=new JPanel();
        private JPanel userPanel=new JPanel();
	private JPanel adminPanel=new JPanel();
        
        private JPanel userlogatPanel=new JPanel();
	private JPanel adminlogatPanel=new JPanel();
        
        private JTextField name=new JTextField();
	private JTextField pass=new JTextField();
        
        private JTextField name1=new JTextField();
	private JTextField pass1=new JTextField();
        
        private JTextField idb=new JTextField();
	private JTextField author=new JTextField();
        private JTextField title=new JTextField();
	private JTextField genre=new JTextField();
        private JTextField quantity=new JTextField();
        private JTextField price=new JTextField();
        
        private JTextField idbad=new JTextField();
	private JTextField authorad=new JTextField();
        private JTextField titlead=new JTextField();
	private JTextField genread=new JTextField();
        private JTextField quantityad=new JTextField();
        private JTextField pricead=new JTextField();
        private JTextField yearad=new JTextField();
        
        private JTextField nameu=new JTextField();
        private JTextField ageu=new JTextField();
        private JTextField ide=new JTextField();
         private JTextField ptrep=new JTextField();
        private JLabel ptreplabel=new JLabel("Report format: ");
        
        private JLabel hiall=new JLabel("Hi all !!! ");
             private JLabel hiadmin=new JLabel("Hi admin !!! ");
              private JLabel hiuser=new JLabel("Hi user !!! ");
        private JLabel usernameLabel=new JLabel("Username : ");
        private JLabel passwordLabel=new JLabel("Parola : ");
        private JLabel usernameLabel1=new JLabel("Username : ");
        private JLabel passwordLabel1=new JLabel("Parola : ");
        
         private JLabel idblabel=new JLabel("Id book : ");
        private JLabel authorlabel=new JLabel("Author(book) : ");
        private JLabel titlelabel=new JLabel("Title (book): ");
        private JLabel quantitylabel=new JLabel("Quantity(book) : ");
        private JLabel pricelabel=new JLabel("Price (book) : ");
        private JLabel genrelabel=new JLabel("Genre (book) : ");
        
             private JLabel idbadlabel=new JLabel("Id book : ");
        private JLabel authoradlabel=new JLabel("Author(book) : ");
        private JLabel titleadlabel=new JLabel("Title (book): ");
        private JLabel quantityadlabel=new JLabel("Quantity(book) : ");
        private JLabel priceadlabel=new JLabel("Price (book) : ");
         private JLabel yearadlabel=new JLabel("Year (book) : ");
        private JLabel genreadlabel=new JLabel("Genre (book) : ");
        
         private JLabel nameulabel=new JLabel("Empl/user name : ");
        private JLabel ageulabel=new JLabel("Empl/user age : ");
         private JLabel idelabel=new JLabel("Empl/user id : ");
        
        GUI()
        {
            
        
        
           this.setLayout(null);
             this.add(mainPanel);
this.add(userPanel);
this.add(adminPanel);
this.add(adminlogatPanel);
this.add(userlogatPanel);


mainPanel.setBounds(0, 0, 800, 700);
mainPanel.setVisible(true);
mainPanel.setBackground(new Color(255,240,200));
mainPanel.setLayout(null);
admin.setBounds(300,120,150,30);
user.setBounds(300,200, 150, 30);
hiall.setBounds(340,300,400,100);
hiall.setFont(new Font("Serif", Font.BOLD, 20));
hiall.setForeground(Color.ORANGE);
mainPanel.add(admin);
mainPanel.add(user);
mainPanel.add(hiall);


        

userPanel.setBounds(0, 0, 800, 700);
userPanel.setVisible(false);
userPanel.setBackground(new Color(255,230,200));
userPanel.setLayout(null);
okuser.setBounds(330,350,100,40);
backuser1.setBounds(330,400,100,40);
name.setBounds(350,120,100,30);
pass.setBounds(350,190,100,30);
usernameLabel.setBounds(250, 80, 100, 100);
passwordLabel.setBounds(250, 150, 100, 100);
hiuser.setBounds(340,230,400,100);
hiuser.setFont(new Font("Serif", Font.BOLD, 20));
hiuser.setForeground(Color.ORANGE);
userPanel.add(okuser);
userPanel.add(name);
userPanel.add(pass);
userPanel.add(usernameLabel);
userPanel.add(passwordLabel);
userPanel.add(backuser1);
userPanel.add(hiuser);


adminPanel.setBounds(0, 0, 800, 700);
adminPanel.setVisible(false);
adminPanel.setBackground(new Color(255,230,200));
adminPanel.setLayout(null);
okadmin.setBounds(330,350,100,40);
backadmin1.setBounds(330,400,100,40);
name1.setBounds(350,120,100,30);
pass1.setBounds(350,190,100,30);
usernameLabel1.setBounds(250, 80, 100, 100);
passwordLabel1.setBounds(250, 150, 100, 100);
hiadmin.setBounds(340,230,400,100);
hiadmin.setFont(new Font("Serif", Font.BOLD, 20));
hiadmin.setForeground(Color.ORANGE);
adminPanel.add(okadmin);
adminPanel.add(hiadmin);
adminPanel.add(name1);
adminPanel.add(pass1);
adminPanel.add(backadmin1);
adminPanel.add(usernameLabel1);
adminPanel.add(passwordLabel1);


userlogatPanel.setBounds(0, 0, 800, 700);
userlogatPanel.setVisible(false);
userlogatPanel.setBackground(new Color(255,220,200));
userlogatPanel.setLayout(null);


author.setBounds(200,50,100,30);
title.setBounds(200,100,100,30);
genre.setBounds(200,150,100,30);
quantity.setBounds(200,200,100,30);
price.setBounds(200,250,100,30);
idb.setBounds(200,300,100,30);


authorlabel.setBounds(100,50,100,30);
titlelabel.setBounds(100,100,100,30);
genrelabel.setBounds(100,150,100,30);
quantitylabel.setBounds(100,200,100,30);
pricelabel.setBounds(100,250,250,30);
idblabel.setBounds(100,300,250,30);

searcha.setBounds(500,50,150,40);
searcht.setBounds(500,100,150,40);
searchg.setBounds(500,150,150,40);
sell.setBounds(500, 200, 150, 40);


userlogatPanel.add(idb);
userlogatPanel.add(genre);
userlogatPanel.add(title);
userlogatPanel.add(author);
userlogatPanel.add(quantity);
userlogatPanel.add(price);

userlogatPanel.add(idblabel);
userlogatPanel.add(genrelabel);
userlogatPanel.add(titlelabel);
userlogatPanel.add(authorlabel);
userlogatPanel.add(quantitylabel);
userlogatPanel.add(pricelabel);

userlogatPanel.add(searcha);
userlogatPanel.add(searchg);
userlogatPanel.add(searcht);
userlogatPanel.add(sell);
userlogatPanel.add(backuser2);
backuser2.setBounds(620,500,150,30);



////////////admin
 adminlogatPanel.setBounds(0, 0, 800, 700);
adminlogatPanel.setVisible(false);
adminlogatPanel.setBackground(new Color(255,220,200));
adminlogatPanel.setLayout(null);

authorad.setBounds(200,50,100,30);
titlead.setBounds(200,100,100,30);
genread.setBounds(200,150,100,30);
quantityad.setBounds(200,200,100,30);
pricead.setBounds(200,250,100,30);
yearad.setBounds(200,300,100,30);
nameu.setBounds(200,350,100,30);
ageu.setBounds(200,400,100,30);
ide.setBounds(200,450,100,30);
idbad.setBounds(200,500,100,30);
ptrep.setBounds(200,550,100,30);

authoradlabel.setBounds(100,50,100,30);
titleadlabel.setBounds(100,100,100,30);
genreadlabel.setBounds(100,150,100,30);
quantityadlabel.setBounds(100,200,100,30);
priceadlabel.setBounds(100,250,100,30);
yearadlabel.setBounds(100,300,100,30);
nameulabel.setBounds(100,350,100,30);
ageulabel.setBounds(100,400,100,30);
idelabel.setBounds(100,450,100,30);
idbadlabel.setBounds(100,500,100,30);
ptreplabel.setBounds(100,550,100,30);


adduser.setBounds(500,50,100,30);
updateuser.setBounds(500,100,100,30);
deleteuser.setBounds(500,150,100,30);
viewuser.setBounds(500, 200, 100, 30);
addbook.setBounds(500,250,100,30);
updatebook.setBounds(500,300,100,30);
deletebook.setBounds(500,350,100,30);
viewbook.setBounds(500, 400, 100, 30);

report1.setBounds(500,450,100,30);
//report2.setBounds(500, 500, 100, 30);
backadmin2.setBounds(500, 530, 100, 30);

adminlogatPanel.add(genread);
adminlogatPanel.add(titlead);
adminlogatPanel.add(authorad);
adminlogatPanel.add(quantityad);
adminlogatPanel.add(pricead);
adminlogatPanel.add(yearad);
adminlogatPanel.add(nameu);
adminlogatPanel.add(ageu);
adminlogatPanel.add(ide);
adminlogatPanel.add(idbad);
adminlogatPanel.add(ptrep);
adminlogatPanel.add(ptreplabel);
adminlogatPanel.add(genreadlabel);
adminlogatPanel.add(titleadlabel);
adminlogatPanel.add(authoradlabel);
adminlogatPanel.add(quantityadlabel);
adminlogatPanel.add(priceadlabel);
adminlogatPanel.add(yearadlabel);
adminlogatPanel.add(nameulabel);
adminlogatPanel.add(ageulabel);
adminlogatPanel.add(idelabel);
adminlogatPanel.add(idbadlabel);



adminlogatPanel.add(addbook);
adminlogatPanel.add(updatebook);
adminlogatPanel.add(deletebook);
adminlogatPanel.add(viewbook);
adminlogatPanel.add(adduser);
adminlogatPanel.add(updateuser);
adminlogatPanel.add(deleteuser);
adminlogatPanel.add(viewuser);
adminlogatPanel.add(report1);
//adminlogatPanel.add(report2);
adminlogatPanel.add(backadmin2);


admin.addActionListener(new Control());
user.addActionListener(new Control());
okadmin.addActionListener(new Control());
okuser.addActionListener(new Control());
backuser2.addActionListener(new Control());
backadmin2.addActionListener(new Control());
backuser1.addActionListener(new Control());
backadmin1.addActionListener(new Control());

this.setPreferredSize(new Dimension(800, 700));
	this.setTitle("Bookstore");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.pack();
	this.setLocationRelativeTo(null);
	this.setVisible(true);
	
        }
        
     
       public String getName() {
	        return name.getText();
	    }
          public String getPass() {
	        return pass.getText();
	    }
        
            public String getName1() {
	        return name1.getText();
	    }
          public String getPass1() {
	        return pass1.getText();
	    }
          
         public Integer getIdb() {
	      return Integer.parseInt(idb.getText());
	    }
        
         public String getAuthor() {
	        return author.getText();
	    }
        
         public String getTitle() {
	        return title.getText();
	    }
        
         public String getGenre() {
	        return genre.getText();
	    }
        
          public String getPrice() {
	        return price.getText();
	    }
          public Integer getQuantity() {
	         return Integer.parseInt(quantity.getText());
	    }
        
    
         public Integer getIdbad() {
	        return Integer.parseInt(idbad.getText());
	    }
        
          public Integer getYearad() {
	        return Integer.parseInt(yearad.getText());
	    }
         public String getAuthorad() {
	        return authorad.getText();
	    }
        
         public String getTitlead() {
	        return titlead.getText();
	    }
        
         public String getGenread() {
	        return genread.getText();
	    }
        
          public String getFormat() {
	        return ptrep.getText();
	    }
         
           public Integer getAgeu() {
	        return Integer.parseInt(ageu.getText());
	    }
    public String getNameu() {
	        return nameu.getText();
	    }
    
     public Integer getIde() {
	       return Integer.parseInt(ide.getText());
	    }
         public Integer getPricead() {
	        return Integer.parseInt(pricead.getText());
	    }
         
         public Integer getQuantityad() {
	         return Integer.parseInt(quantityad.getText());
	    }
         
                                    
              public class Control implements ActionListener  {

	
		
		@Override
		public void actionPerformed(ActionEvent e)  {
			  if (e.getSource() == user) {
		userPanel.setVisible(true);
                mainPanel.setVisible(false);
                adminPanel.setVisible(false);
                adminlogatPanel.setVisible(false);
                userlogatPanel.setVisible(false);
                    
                }
                    
			if (e.getSource() == admin) {
				
		 userPanel.setVisible(false);
                mainPanel.setVisible(false);
                adminPanel.setVisible(true);
                  adminlogatPanel.setVisible(false);
                userlogatPanel.setVisible(false);
                
} 
                        
                         if (e.getSource() == backuser1) {
		userPanel.setVisible(false);
                mainPanel.setVisible(true);
                adminPanel.setVisible(false);
                adminlogatPanel.setVisible(false);
                userlogatPanel.setVisible(false);
                    }
                         
                           if (e.getSource() == backuser2) {
		userPanel.setVisible(true);
                mainPanel.setVisible(false);
                adminPanel.setVisible(false);
                adminlogatPanel.setVisible(false);
                userlogatPanel.setVisible(false);
                    }
                              if (e.getSource() == backadmin1) {
		userPanel.setVisible(false);
                mainPanel.setVisible(true);
                adminPanel.setVisible(false);
                adminlogatPanel.setVisible(false);
                userlogatPanel.setVisible(false);
                    }
                          
                          if (e.getSource() == backadmin2) {
		userPanel.setVisible(false);
                mainPanel.setVisible(false);
                adminPanel.setVisible(true);
                adminlogatPanel.setVisible(false);
                userlogatPanel.setVisible(false);
                    }  
                
                 if (e.getSource() == okadmin) {
                            String adminname = name1.getText();
                            String adminpass = pass1.getText();
                      
				if (adminname.equals("admin")&& adminpass.equals("adminpass"))
                                {
		 userPanel.setVisible(false);
                mainPanel.setVisible(false);
                adminPanel.setVisible(false);
                  adminlogatPanel.setVisible(true);
                userlogatPanel.setVisible(false);
                                }
                                else {
                                    JOptionPane.showMessageDialog(null, "Logare esuata !", null, JOptionPane.ERROR_MESSAGE); 
                                }
                } 
                
                if (e.getSource() == okuser) {
                            String username = name.getText();
                            String userpass = pass.getText();
                      
				if (username.equals("user")&& userpass.equals("userpass"))
                                {
		 userPanel.setVisible(false);
                mainPanel.setVisible(false);
                adminPanel.setVisible(false);
                  adminlogatPanel.setVisible(false);
                userlogatPanel.setVisible(true);
                                }
                                else {
                                    JOptionPane.showMessageDialog(null, "Logare esuata !", null, JOptionPane.ERROR_MESSAGE); 
                                }
                }
                }}
              public void searchAuthor(ActionListener au)
	    {
                
	        searcha.addActionListener(au);
	    }
              
              public void searchTitle(ActionListener ti)
	    {
	        searcht.addActionListener(ti);
	    }
      
              public void searchGenre(ActionListener ge)
	    {
	        searchg.addActionListener(ge);
	    }
              public void sellBook(ActionListener bo)
	    {
	        sell.addActionListener(bo);
	    }
              
              
              
              
                     public void addBook(ActionListener user)
	    {
	        addbook.addActionListener(user);
	    }
                 
              public void updateBook(ActionListener user1)
	    {
	        updatebook.addActionListener(user1);
	    }             
              
              
              public void deleteBook(ActionListener user2)
	    {
	        deletebook.addActionListener(user2);
	    }
              
              
                public void viewBook(ActionListener user2)
	    {
	       viewbook.addActionListener(user2);
	    }
              
              
              
              
              
              public void addUser(ActionListener user)
	    {
	        adduser.addActionListener(user);
	    }
                 
              public void updateUser(ActionListener user1)
	    {
	        updateuser.addActionListener(user1);
	    }             
              
              
              public void deleteUser(ActionListener user2)
	    {
	        deleteuser.addActionListener(user2);
	    }
              
              
                 public void viewUser(ActionListener user3)
	    {
	        viewuser.addActionListener(user3);
	    }
                 
                   public void report1(ActionListener r1)
	    {
	        report1.addActionListener(r1);
	    }
              
          
              
              
         
}


