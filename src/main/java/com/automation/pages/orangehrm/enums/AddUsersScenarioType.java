package com.automation.pages.orangehrm.enums;

import br.com.six2six.fixturefactory.Fixture;
import com.automation.fixtures.addusers.entity.UserData;
import com.automation.pages.orangehrm.AddUsersPredicateFactory;
import com.automation.pages.orangehrm.pagecomponents.adduserspage.AddUserComponent;
import lombok.Getter;

import java.util.function.BiPredicate;

@Getter
public enum AddUsersScenarioType {
    VALID(AddUsersPredicateFactory.getPredicate("valid") ,
            Fixture.from(UserData.class).gimme("valid")) ,

    JUST_EMPLOYEE_NAME(AddUsersPredicateFactory.getPredicate("just_employee_name")
            , Fixture.from(UserData.class).gimme("just_employee_name"));

    private final BiPredicate<UserData, AddUserComponent> predicate;
    private final UserData userData;

    AddUsersScenarioType(BiPredicate<UserData, AddUserComponent> predicate, UserData userData) {
        this.predicate = predicate;
        this.userData = userData;
    }
}
