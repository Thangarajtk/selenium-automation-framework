package com.automation.fixtures.addusers.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.automation.fixtures.addusers.entity.UserData;

public class AddUserTemplate implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(UserData.class).addTemplate("valid", new Rule() {{
            add("userRole", random("ESS", "Admin"));
            add("employeeName", uniqueRandom("User-1", "User-2"));
            add("userName", random("test_user"));
            add("status", random("Enabled", "Disabled"));
            add("password", random("testPassword@123"));
            add("errorMessage", "Success message is not displayed");
        }});

        Fixture.of(UserData.class).addTemplate("just_employee_name", new Rule() {{
            add("employeeName", random("test_user"));
            add("message", "Error message is not displayed");
        }});
    }
}
