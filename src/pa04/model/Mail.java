package pa04.model;

public class Mail {
    private String mail;
    
    public String getMail() {
        return mail;
    }

    public String getDomain(){
        return (this.getMail().split("@"))[1];
    }

    public Mail(String mail) {
        this.mail = mail;
    }
}
