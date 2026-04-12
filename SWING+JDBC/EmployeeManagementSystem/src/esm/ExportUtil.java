package esm;

import java.io.FileWriter;
import java.util.List;

public class ExportUtil {

    public static void export(List<Employee> list) {
        try {
            FileWriter fw = new FileWriter("employees.csv");

            fw.write("ID,Name,Department,Salary\n");

            for(Employee e : list) {
                fw.write(e.getId()+","+e.getName()+","+e.getDepartment()+","+e.getSalary()+"\n");
            }

            fw.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}