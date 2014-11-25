package Entities;

import Interface.IModul;

/**
 * Created by KamikazeOnRoad on 03.11.2014.
 */
public class Modul implements IModul {
    // Declaration
    private String name;
    private String department;

    // Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Constructor
    private Modul(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public Modul valueOf(String name, String department) {
        return new Modul(name, department);
    }
}
