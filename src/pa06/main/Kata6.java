package pa06.main;

import java.io.IOException;
import java.util.List;
import pa06.model.Histogram;
import pa06.model.Mail;
import pa06.view.HistogramDisplay;
import pa06.view.MailHistogramBuilder;
import pa06.view.MailListReader;

public class Kata6 {
    
    public String filename;
    public List<Mail> mailList;
    Histogram<String> histogram;
    HistogramDisplay histoDisplay;
     
     public static void main(String[] args) throws IOException, Exception {
         Kata6 kata6 = new Kata6();
         kata6.execute();
    }
     
    public void execute() throws IOException {
            input();
            process();
            output();
        }

    public void input() throws IOException {
        filename = "C:\\Users\\user\\Desktop\\emails.txt";    
        mailList = MailListReader.read(filename);
    }

    public void process() throws IOException {
        histogram = MailHistogramBuilder.build(mailList);
        
    }

    public void output() {
        histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
}
