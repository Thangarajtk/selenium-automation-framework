package com.automation.pages.orangehrm;

import com.automation.pages.base.BasePage;
import com.automation.pages.orangehrm.pagecomponents.adduserspage.AddUserComponent;
import com.automation.pages.orangehrm.pagecomponents.adduserspage.SearchComponent;

public final class SystemUsersPage extends BasePage {

    private final SearchComponent searchComponent;
    private final AddUserComponent addUserComponent;

    public SystemUsersPage() {
        this.addUserComponent = new AddUserComponent();
        this.searchComponent = new SearchComponent();
    }
    public AddUserComponent getAddUserComponent() {
        return addUserComponent;
    }
}
