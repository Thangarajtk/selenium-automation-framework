package com.automation.config;

import com.automation.enums.RunType;
import org.aeonbits.owner.Config;

@Config.Sources(value = "file:${user.dir}/src/test/resources/config/config.properties")
public interface FrameworkConfig extends Config {

    String url();

    String overridereports();

    boolean passed_step_screenshots();

    boolean failed_step_screenshots();

    boolean skipped_step_screenshots();

    boolean retry_failed_tests();

    int retry_count();

    @DefaultValue("LOCAL")
    @ConverterClass(StringToRunTypeConverter.class)
    RunType runmode();
}
