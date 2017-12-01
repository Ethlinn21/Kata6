package pa06.view;

import java.util.ArrayList;
import java.util.List;
import pa06.model.Person;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseList {
    public static List<Person> read() throws ClassNotFoundException, SQLException {
    List<Person> listPerson = new ArrayList<>();
    Class.forName("org.sqlite.JDBC");
    Connection connec = DriverManager.getConnection("jdbc:sqlite:Kata5.DB");
    Statement st = connec.createStatement();
    String query = "SELECT * from PEOPLE;";
    ResultSet rs = st.executeQuery(query);  
    
    while(rs.next()){
        Integer id = rs.getInt(1);
        String name = rs.getString(2);
        Character gender = rs.getString(3).charAt(0);
        String birthDate = rs.getString(4);
        Float weight = rs.getFloat(5);
        String mail = rs.getString(6);
        listPerson.add(new Person(id, name, gender, birthDate, weight, mail));
    }
    return listPerson;
    }
}
