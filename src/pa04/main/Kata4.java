package pa04.main;

import java.io.IOException;
import java.util.List;
import pa04.model.Histogram;
import pa04.model.Mail;
import pa04.view.HistogramDisplay;
import pa04.view.MailHistogramBuilder;
import pa04.view.MailListReader;

public class Kata4 {
    
    public String filename;
    public List<Mail> mailList;
    Histogram<String> histogram;
    HistogramDisplay histoDisplay;
     
     public static void main(String[] args) throws IOException, Exception {
         Kata4 kata4 = new Kata4();
         kata4.execute();
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
