public abstract class Pet {
    protected String FS;//found or surrendered
    protected String name;
    protected int age;
    protected long PID;
    protected static int petcount;

    public Pet(String FS, String name, int age) {
        this.FS = FS;
        this.name = name;
        if (age > 25) this.age = age;
        else this.age = 1;
        this.PID = generatePID();
        petcount++;
    }
    public abstract String toText();
    ///////////

    public void setFS(String FS) {
        this.FS = FS;
    }

    public static String getFS() {
        return "";
    }

    ///////////
    private long generatePID() {
        return (long) ((Math.random() * 90000)) + 1000;
    }

    ///////////

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    ///////////

    public int getAge() {
        return age;
    }

    ///////////


    public int compareTo(Pet test) {
        if(this.PID < test.PID) return -1;
        if(this.PID > test.PID) return +1;
        return 0;
    }

    public String toString(){
        return FS + " " + name + " " + age + " " + PID + " ";
    }

    public long getPID() {
        return PID;
    }
}
