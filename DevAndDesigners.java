package ExamSbor1;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Comparator;
import java.util.TreeSet;

public class DevAndDesigners {
    static TreeSet<Specialist> specialists;
    static TreeSet<Specialist> hired;
    static int budget;
    StreamTokenizer streamTokenizer;
    public static void main(String[] args) throws IOException {
        new DevAndDesigners().initData();
        //Пока есть бюджет, нанимаем абы кого
        while (budget >= specialists.getFirst().salary){
            budget -= specialists.getFirst().salary;
            if (specialists.getFirst().isDesigner){
                Specialist.numberOfDesignersHired++;
            }
            hired.add(specialists.pollFirst());
        }
        //Пока есть бюджет, увольняем Разработчика с самой высокой зарплатой и нанимаем дизайнера с самой низкой зарплатой.
        while (true) {
            if (!specialists.getFirst().isDesigner) {
                specialists.pollFirst();
                continue;
            }
            if (budget > specialists.getFirst().salary - hired.getFirst().salary) {
                budget -= specialists.getFirst().salary - hired.getFirst().salary;
                hired.pollFirst();
                hired.add(specialists.pollFirst());
                Specialist.numberOfDesignersHired++;
            } else
                break;
        }
        System.out.printf("Нанято дизайнеров: %d. Оставшийся бюджет: %d.", Specialist.numberOfDesignersHired, budget);
    }
    void initData() throws IOException {
        streamTokenizer = new StreamTokenizer(new FileReader("C:\\Users\\User\\Downloads\\26 (12).txt"));
        specialists = new TreeSet<>(Comparator.comparingInt(Specialist:: getSalary).
                thenComparingInt(Specialist:: getId));
        hired = new TreeSet<>(Comparator.comparing(Specialist:: isDesigner).reversed().
                thenComparingInt(Specialist:: getSalary).reversed().
                thenComparingInt(Specialist:: getId));
        int numberOfSpec = nextInt();
        budget = nextInt();
        for (int i = 0; i < numberOfSpec; i++) {
            specialists.add(new Specialist(i, nextInt(), nextString()));
        }
    }
    class Specialist{
        static int numberOfDesignersHired = 0;
        int id;
        int salary;
        boolean isDesigner;

        public Specialist(int id, int salary, String type) {
            this.id = id;
            this.salary = salary;
            this.isDesigner = type.equals("G");
        }

        public int getId() {
            return id;
        }

        public int getSalary() {
            return salary;
        }

        public boolean isDesigner() {
            return isDesigner;
        }

        @Override
        public String toString() {
            return "Specialist{" +
                    "id=" + id +
                    ", salary=" + salary +
                    ", isDesigner=" + isDesigner +
                    '}';
        }
    }
    int nextInt() throws IOException {
        streamTokenizer.nextToken();
        return (int) streamTokenizer.nval;
    }
    String nextString() throws IOException {
        streamTokenizer.nextToken();
        return  streamTokenizer.sval;
    }
}
 /*hired = new TreeSet<>(new Comparator<Specialist>() {
            @Override
            public int compare(Specialist o1, Specialist o2) {
                if (o1.isDesigner ^ o2.isDesigner)
                    return Boolean.compare(o1.isDesigner, o2.isDesigner);
                else if(o2.salary != o1.salary)
                    return Integer.compare(o2.salary, o1.salary);
                else
                    return
                    Integer.compare(o1.id, o2.id);
            }
        });*/
/*specialists = new TreeSet<>(new Comparator<Specialist>() {
            @Override
            public int compare(Specialist o1, Specialist o2) {
                if (o1.salary != o2.salary)
                    return Integer.compare(o1.salary, o2.salary);
                else
                    return Integer.compare(o1.id, o2.id);
            }
        });*/