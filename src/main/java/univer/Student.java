package univer;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Student {
    @Getter
    private int id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String group;

    @Getter @Setter
    private double rating;

    public static Student parseFromString(String s) {
        String[] strs = s.split(":::");
        int id = Integer.parseInt(strs[0]);
        String name = strs[1];
        String group = strs[2];
        double rating = Double.parseDouble(strs[3].replace(',','.'));

        return new Student(id, name, group, rating);
    }
}
