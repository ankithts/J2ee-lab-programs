package customer_info;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class swing_JDBC extends JFrame {
	swing_JDBC() {
		super("My Jframe Example");
		JLabel jlcus = new JLabel("Customer Information");
		JLabel jl21 = new JLabel("Enter CustomerNo");
		final JTextField jtf21 = new JTextField();
		JLabel jl22 = new JLabel("Enter CustomerName");
		final JTextField jtf22 = new JTextField();
		JLabel jl23 = new JLabel("Enter State");
		final JTextField jtf23 = new JTextField();
		JLabel jl24 = new JLabel("Enter Credit limit");
		final JTextField jtf24 = new JTextField();
		JLabel jl25 = new JLabel("Enter RepNo");
		final JTextField jtf25 = new JTextField();
		JButton jb2 = new JButton("Submit");
		JPanel panel = new JPanel();
		final JTextArea jta = new JTextArea();
		jta.setRows(10);
		jta.setColumns(5);
		JButton jb3 = new JButton("click");

		panel.add(jl21);
		panel.add(jtf21);
		panel.add(jl22);
		panel.add(jtf22);
		panel.add(jl23);
		panel.add(jtf23);
		panel.add(jl24);
		panel.add(jtf24);
		panel.add(jl25);
		panel.add(jtf25);
		panel.add(jb2);
		panel.add(jta);
		panel.add(jb3);

		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt2;
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "kavan@12");
					if (conn != null) {
						System.out.println("Connection successful !!!");
						String Custno = jtf21.getText();
						String CustName = jtf22.getText();
						String state = jtf23.getText();
						String Credit = jtf24.getText();
						int cr = Integer.parseInt(Credit);
						String Rno = jtf25.getText();
						stmt2 = (Statement) conn.createStatement();
						System.out.println(Custno + CustName + state + cr + Rno);
						String query2 = "insert into Customer values('" + Custno + "','" + CustName + "','" + state
								+ "','" + cr + "','" + Rno + "');";
						stmt2.executeUpdate(query2);
					} else
						System.out.println("Connection not successful!!!");
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				} catch (ClassNotFoundException exx) {
					System.out.println(exx.getMessage());
				}
			}
		});
		
		
		jb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt;
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "kavan@12");
					if (conn != null) {
						stmt = (Statement) conn.createStatement();
						String query3 = "SELECT * FROM Customer WHERE Credit_Limit> 15000 ";
						ResultSet rs = stmt.executeQuery(query3);
						while (rs.next()) {
							jta.append("Customer Information");
							jta.append("\n");
							jta.append("Number:");
							jta.append(rs.getString("CustNo"));
							jta.append("\n");
							jta.append("Name:");
							jta.append(rs.getString("CustName"));
							jta.append("\n");
							jta.append("State:");
							jta.append(rs.getString("State"));
							jta.append("\n");
							jta.append("Comission:");
							jta.append(rs.getString("Credit_Limit"));
							jta.append("\n");
							jta.append("Rate:");
							jta.append(rs.getString("RepNo"));
							jta.append("\n");
						}
						System.out.println("Connection successful !!!");
					} else
						System.out.println("Connection not successful!!!");
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				} catch (ClassNotFoundException exx) {
					System.out.println(exx.getMessage());
				}
			}
		});
		setContentPane(panel);
	}

	public static void main(String[] args) {
		swing_JDBC mf = new swing_JDBC();
		mf.getContentPane().setLayout(new BoxLayout(mf.getContentPane(), BoxLayout.Y_AXIS));
		mf.setVisible(true);
		mf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mf.pack();
	}
}