package za.co.bbd.jokeGenerator;

public class Response {
    public String question="";
    public String punchline = "";

    public String getQuestion(){
        return this.question;
    }

    public String getPunchline(){
        return this.punchline;
    }

    public void setQuestion(String question){
        this.question = question;
    }

    public void setPunchline(String punchline){
        this.punchline = punchline;
    }
}
