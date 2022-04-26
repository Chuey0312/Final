public class Dog extends Pet {
    private String tod; //type of dog

    public Dog(String FS, String name, int age, String tod){
        super(FS, name, age);
        this.tod = tod;
    }

    ///////////////////////////
    public Dog(String[] tepee) {
        super(tepee[1], tepee[2], Integer.parseInt(tepee[3]));
        this.PID = Integer.parseInt(tepee[4]);
        this.FS = tepee[5];

    }

    ///////////////////////////
    public String getTod(){
        return tod;
    }

    ///////////////////////////
    public String toString(){
        return super.toString() + " " + tod;
    }

    ///////////////////////////
    @Override
    public java.lang.String toText() {
        return "Dog\t" + FS + "\t" + age + "\t";
    }
}
