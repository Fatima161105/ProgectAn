package models;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private String group;
    private int totalGradeDz;
    private int totalGradeUp;

    public Student(String name, String group, int totalGradeDz, int totalGradeUp) {
        this.name = name;
        this.group = group;
        this.totalGradeDz = totalGradeDz;
        this.totalGradeUp = totalGradeUp;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getTotalGradeDz() {
        return totalGradeDz;
    }

    public int getTotalGradeUp() {
        return totalGradeUp;
    }
}
