package com.automation.pages.orangehrm;

import com.automation.fixtures.addusers.entity.UserData;
import com.automation.pages.orangehrm.pagecomponents.adduserspage.AddUserComponent;
import java.util.Map;
import java.util.function.BiPredicate;

public class AddUsersPredicateFactory {

    private static final BiPredicate<UserData, AddUserComponent> VALID_PREDICATE = (userData, addUserComponent) -> {
        addUserComponent.setUserRoleDropDown(userData.getUserRole())
                .setUserNameTextBox(userData.getUserName())
                .setPasswordTextBox(userData.getPassword())
                .setConfirmPasswordTextBox(userData.getPassword())
                .setStatusDropDown(userData.getStatus())
                .setEmployeeNameTextBox(userData.getEmployeeName());
        return addUserComponent.isSuccessMessageDisplayed();
    };

    private static final BiPredicate<UserData, AddUserComponent> JUST_EMPLOYEE_NAME_PREDICATE = (userData, addUserComponent) -> {
        addUserComponent.setEmployeeNameTextBox(userData.getEmployeeName());
        return addUserComponent.isErrorDisplayedForEmployeeName();
    };

    private static final Map<String, BiPredicate<UserData, AddUserComponent>> MAP = Map.of(
            "valid", VALID_PREDICATE,
            "just_employee_name", JUST_EMPLOYEE_NAME_PREDICATE
    );

    public static BiPredicate<UserData, AddUserComponent> getPredicate(String value){
        return MAP.get(value);
    }
}
