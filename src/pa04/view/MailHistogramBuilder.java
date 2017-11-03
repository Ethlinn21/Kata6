package pa04.view;

import java.util.List;
import pa04.model.Histogram;
import pa04.model.Mail;

public class MailHistogramBuilder {
    public static Histogram<String> build (List<Mail> list){
        Histogram<String> histo = new Histogram<String>();
        for (Mail mai11 : list) {
            histo.increment(mai11.getDomain(),1);
        }
        return histo;
    }
}
