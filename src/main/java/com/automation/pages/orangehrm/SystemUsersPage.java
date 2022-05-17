package com.automation.pages.orangehrm;

import com.automation.pages.base.BasePage;
import com.automation.pages.orangehrm.pagecomponents.adduserspage.SearchComponent;
import com.automation.pages.orangehrm.pagecomponents.adduserspage.UserListComponent;

public final class SystemUsersPage extends BasePage {

    private final SearchComponent searchComponent;
    private final UserListComponent userListComponent;

    public SystemUsersPage() {
        this.userListComponent = new UserListComponent();
        this.searchComponent = new SearchComponent();
    }
    public UserListComponent getUserListComponent() {
        return userListComponent;
    }
}
