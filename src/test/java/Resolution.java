import java.util.ArrayList;

public enum Resolution {
    SD(1,"SD"),
    HD(2,"HD"),
    FHD(3,"FHD"),
    _4K(4,"4K");
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    Resolution(int id, String name) {
        this.id=id;
        this.name=name;
    }

    public static int getResolutionByName(String name) {
        if(name != null) {
            for (Resolution resolution : Resolution.values()) {
                if (name.equalsIgnoreCase(resolution.getName().toString())) {
                    return resolution.getId();
                }
            }
        }
        return Resolution.values().length;
    }
    public static ArrayList<String> getResolutionLowerAndEquals(String name) {
        ArrayList<String> value= new ArrayList<String>();
        int indexId=getResolutionByName(name);
        for (Resolution resolution : Resolution.values()) {
            if (indexId >= resolution.getId()) {
                value.add(resolution.getName());
            }
        }
        return value;
    }
    public static ArrayList<String> getResolutionHigherThan(String name) {
        ArrayList<String> value= new ArrayList<String>();
        int indexId=getResolutionByName(name);
        for (Resolution resolution : Resolution.values()) {
            if (indexId < resolution.getId()) {
                value.add(resolution.getName());
            }
        }
        return value;
    }

}
