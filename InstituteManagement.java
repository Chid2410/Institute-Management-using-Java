import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InstituteManagement extends JFrame {

    private JTextField idField, collegenameField, naacField, locationField, searchField;
    private JButton addButton, showButton, searchButton;
    private JTextArea outputArea;
    private Connection connection;

    public InstituteManagement() {
        super("Institute Management");
        setSize(1000, 500);
 
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newtable", "root", "chid2410");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        
        idField = new JTextField(10);
        collegenameField = new JTextField(10);
        naacField = new JTextField(10);
        locationField = new JTextField(10);
        searchField = new JTextField(10);
        addButton = new JButton("Add Institute");
        showButton = new JButton("Show Institute");
        searchButton = new JButton("Search");
        outputArea = new JTextArea(20, 40);
        outputArea.setEditable(false);

        
        setLayout(new FlowLayout());

        
        add(new JLabel("CollegeID:"));
        add(idField);
        add(new JLabel("CollegeName:"));
        add(collegenameField);
        add(new JLabel("NAACGrade:"));
        add(naacField);
        add(new JLabel("Location:"));
        add(locationField);
        add(addButton);
        add(showButton);
        add(new JLabel("Search:"));
        add(searchField);
        add(searchButton);
        add(new JScrollPane(outputArea));

        
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addInstitute();
            }
        });

        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showInstitutes();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchInstitutes();
            }
        });
    }

    private void addInstitute() {
        int id = Integer.parseInt(idField.getText());
        String collegename = collegenameField.getText();
        String naac = naacField.getText();
        String location = locationField.getText();

        try {
            
            PreparedStatement statement = connection.prepareStatement("INSERT INTO new_table (id, Name, Naacgrade, Location) VALUES (?, ?, ?, ?)");
            statement.setInt(1, id);
            statement.setString(2, collegename);
            statement.setString(3, naac);
            statement.setString(4, location);
            statement.executeUpdate();
            statement.close();

            
            idField.setText("");
            collegenameField.setText("");
            naacField.setText("");
            locationField.setText("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showInstitutes() {
        try {
            
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM new_table");

            
            outputArea.setText("");

            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String collegename = resultSet.getString("Name");
                String naac = resultSet.getString("Naacgrade");
                String location = resultSet.getString("Location");
                outputArea.append("ID: " + id + "\n");
                outputArea.append("Name: " + collegename + "\n");
                outputArea.append("Grade: " + naac + "\n");
                outputArea.append("Location: " + location + "\n");
                outputArea.append("\n");
            }
            

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void searchInstitutes() {
        String searchText = searchField.getText();

        try {
            
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM new_table WHERE Name LIKE ?");
            statement.setString(1, "%" + searchText + "%");
            ResultSet resultSet = statement.executeQuery();

            
            outputArea.setText("");

            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String collegename = resultSet.getString("Name");
                String naac = resultSet.getString("Naacgrade");
                String location = resultSet.getString("Location");
                outputArea.append("ID: " + id + "\n");
                outputArea.append("Name: " + collegename + "\n");
                outputArea.append("Grade: " + naac + "\n");
                outputArea.append("Location: " + location + "\n");
                outputArea.append("\n");
            }
            

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        InstituteManagement instituteInfo = new InstituteManagement();
        instituteInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        instituteInfo.setVisible(true);
    }
}