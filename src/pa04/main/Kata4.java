package pa04.main;

import java.io.IOException;
import java.util.List;
import pa04.model.Histogram;
import pa04.model.Mail;
import pa04.view.HistogramDisplay;
import pa04.view.MailHistogramBuilder;
import pa04.view.MailListReader;

public class Kata4 {

    public static void main(String[] args) throws IOException {
        String filename = "C:\\Users\\user\\Desktop\\emails.txt";
        List<Mail> mailList = MailListReader.read(filename);
        Histogram<String> histogram = MailHistogramBuilder.build(mailList);
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
    
}
