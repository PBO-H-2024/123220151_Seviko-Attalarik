package Controller;
import javax.swing.JOptionPane;
import Model.Student;

public class Controller {
    Student Student;

    public Controller() {
        Student = new Student();
    }

    public String[][] readData() {
        return Student.readData();
    }

    public void deleteData(int id) {
        Student.deleteData(id);
        JOptionPane.showMessageDialog(null, "Data deleted successfully!");
    }

    public void insertData(int nim, String name, int age) {
        Student.insertData(nim, name, age);
        JOptionPane.showMessageDialog(null, "Data inserted successfully!");
    }

    public void updateData(int id, int nim, String name, int age) {
        Student.updateData(id, nim, name, age);
        JOptionPane.showMessageDialog(null, "Data updated successfully!");
    }
}
