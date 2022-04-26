public class Cat extends Pet {
    private String toc;//type of cat

    public Cat(String FS, String name, int age, String toc){
        super(FS, name, age);
        this.toc = toc;
    }

    ///////////////////////////
    public Cat(String[] tepee) {
        super(tepee[1], tepee[2], Integer.parseInt(tepee[3]));
        this.PID = Integer.parseInt(tepee[4]);
        this.FS = tepee[5];

    }

    ///////////////////////////
    public String getTod(){
        return toc;
    }

    ///////////////////////////
    public String toString(){
        return super.toString() + " " + toc;
    }

    ///////////////////////////
    @Override
    public java.lang.String toText() {
        return "Cat\t" + FS + "\t" + age + "\t";
    }
}
