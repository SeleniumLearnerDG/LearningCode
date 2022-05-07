enum EnumStatus {

    PASSED(40L, "Has Passed"),
    AVERAGE(60L, "Has Average Marks"),
    GOOD(80L, "Has Good Marks");

    private java.lang.String name;

    private java.lang.Long id;

    EnumStatus(Long id, java.lang.String name) {
        this.name = name;
        this.id = id;
    }

    public java.lang.String getName() {
        return name;
    }

    public java.lang.Long getId() {
        return id;
    }
    public static EnumStatus getById(Long id) {
        for(EnumStatus e : values()) {
            if(e.id.equals(id)) return e;
        }
        throw  new NullPointerException();
    }

    public static Long getById(String Name) {
        for(EnumStatus e : values()) {
            if(e.name.equals(Name)) return e.id;
        }
        throw  new NullPointerException();
    }

    public static void main(String[] args) {
        System.out.println( EnumStatus.getById("Has Passed"));
    }
}