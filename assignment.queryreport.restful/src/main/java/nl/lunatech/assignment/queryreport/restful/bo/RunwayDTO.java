package nl.lunatech.assignment.queryreport.restful.bo;


public class RunwayDTO {

    private String a;

    private String b;


    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "RunwayDTO{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }
}
