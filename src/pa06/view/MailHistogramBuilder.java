package pa06.view;

import java.util.List;
import pa06.model.Histogram;
import pa06.model.Mail;

public class MailHistogramBuilder {
    public static Histogram<String> build (List<Mail> list){
        Histogram<String> histo = new Histogram<String>();
        for (Mail mai11 : list) {
            histo.increment(mai11.getDomain(),1);
        }
        return histo;
    }
}
