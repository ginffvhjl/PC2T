package pc2t.cv09;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {
    public Manager(String nickname, String email, char[] password) {
        super(nickname, email, password);
    }

    private List<Employee> listOfEmployees = new ArrayList<>();
    private List<Employee> listOfRelationships = new ArrayList<>();

    public List<Employee> getListOfEmployees() {
        return listOfEmployees;
    }

    public void setListOfEmployees(List<Employee> listOfEmployees) {
        this.listOfEmployees = listOfEmployees;
    }

    public List<Employee> getListOfRelationships() {
        return listOfRelationships;
    }

    public void setListOfRelationships(List<Employee> listOfRelationships) {
        this.listOfRelationships = listOfRelationships;
    }

    public void addRelation(Employee employee) {
        listOfRelationships.add(employee);
    }

    public void addEmployee(Employee employee) {
        listOfEmployees.add(employee);
    }

    public void writeEmployees() {
        for (int i = 0; i < listOfEmployees.size(); i++) {
            System.out.println(listOfEmployees.get(i));
        }
    }

    public void writeRelationships() {
        for (int i = 0; i < listOfRelationships.size(); i++) {
            System.out.println(listOfRelationships.get(i));
        }
    }
}

