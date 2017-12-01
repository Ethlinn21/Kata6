package pa06.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import pa06.model.Histogram;
import pa06.model.Mail;
import pa06.model.Person;
import pa06.view.DataBaseList;
import pa06.view.HistogramDisplay;
import pa06.view.HistogramBuilder;
import pa06.view.MailListReader;

public class Kata6 {
    
    public String filename;
    public List<Mail> mailList;
    Histogram<String> histogram;
    HistogramDisplay histoDisplay;
    Histogram<Character> letters;
    Histogram<String> domains; 
    Histogram<Character> gender;
     HistogramBuilder<Person> builderPerson;
     
     public static void main(String[] args) throws IOException, Exception {
         Kata6 kata6 = new Kata6();
         kata6.execute();
    }
     
    public void execute() throws IOException, ClassNotFoundException, SQLException {
            input();
            process();
            output();
        }

    //
    public void input() throws IOException {
        filename = "C:\\Users\\user\\Desktop\\emails.txt";    
        mailList = MailListReader.read(filename);
    }

    public void process() throws IOException, ClassNotFoundException, SQLException {
        List <Person> people = DataBaseList.read();	
	builderPerson = new HistogramBuilder<>(people);
        
        HistogramBuilder<Mail> builder	= new HistogramBuilder<>(mailList);
        domains = builder.build(new Attribute<Mail, String>() {
            public String get(Mail item){
                return item.getMail().split("@")[1];
            }
        });
        
        letters = builder.build(new Attribute<Mail, Character>() {
            public Character get (Mail item){
                return item.getMail().charAt(0);
            }
        });    
        
        gender = builderPerson.build(new Attribute<Person,Character>(){
        public Character get (Person item){
            return item.getGender();
        }
        });
    }

    public void output() {         
        new HistogramDisplay(domains, "Dominios").execute();
        new HistogramDisplay(letters, "Primer character").execute();
        new HistogramDisplay(gender, "Gender").execute();
    }
}
