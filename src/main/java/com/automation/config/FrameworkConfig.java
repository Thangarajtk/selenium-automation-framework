package com.automation.config;

import com.automation.enums.ConfigProperties;
import org.aeonbits.owner.Config;

@Config.Sources(value = "file:${user.dir}/src/test/resources/config/config.properties")
public interface FrameworkConfig extends Config {

    String url();

    String overridereports();

    String passed_step_screenshots();

    String failed_step_screenshots();

    String skipped_step_screenshots();

    String retry_failed_tests();

    short retry_count();

    String runmode();
}
