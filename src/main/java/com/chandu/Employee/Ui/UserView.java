package com.chandu.Employee.Ui;

import com.chandu.Employee.EmpRepository.EmployeeRepo;
import com.chandu.Employee.Model.Employee;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("/user")
public class UserView extends VerticalLayout {

    @Autowired
    private EmployeeRepo userService;

    private Grid<Employee> grid = new Grid<>(Employee.class);
    private TextField nameField = new TextField("name");
    private TextField LocationField = new TextField("location");
    private TextField preferenceField = new TextField("preference");
    private Button saveButton = new Button("Save");
    private Button deleteButton = new Button("Delete");

    public UserView() {
        grid.setColumns("id", "name", "location", "preference");

        FormLayout formLayout = new FormLayout();
        formLayout.add(nameField, LocationField, preferenceField);

        saveButton.addClickListener(e -> saveUser());
        deleteButton.addClickListener(e -> deleteUser());

        add(grid, formLayout, saveButton, deleteButton);

        refreshGrid();
    }

    private void saveUser() {
        Employee user = new Employee(null, nameField.getValue(), LocationField.getValue(), preferenceField.getValue());
        userService.save(user);
        clearForm();
        refreshGrid();
        Notification.show("User saved successfully");
    }

    private void deleteUser() {
        Employee selectedUser = grid.asSingleSelect().getValue();
        if (selectedUser != null) {
            userService.deleteById(selectedUser.getId());
            clearForm();
            refreshGrid();
            Notification.show("User deleted successfully");
        }
    }

    private void refreshGrid() {
        grid.setItems(userService.findAll());
    }

    private void clearForm() {
        nameField.clear();
        LocationField.clear();
        preferenceField.clear();
    }
}
