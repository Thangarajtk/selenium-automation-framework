package com.automation.config;

import com.automation.config.converter.StringToBrowserRemoteModeTypeConverter;
import com.automation.config.converter.StringToRunTypeConverter;
import com.automation.config.converter.StringToUrlConverter;
import com.automation.enums.BrowserRemoteModeType;
import com.automation.enums.RunType;
import org.aeonbits.owner.Config;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/config/config.properties",
        "file:${user.dir}/src/test/resources/config/dev-config.properties",
        "file:${user.dir}/src/test/resources/config/staging-config.properties"})
public interface FrameworkConfig extends Config {

    @DefaultValue("staging")
    String environment();

    @Key("${environment}.url")
    String url();

    String override_report();

    boolean passed_step_screenshots();

    boolean failed_step_screenshots();

    boolean skipped_step_screenshots();

    boolean retry_failed_tests();

    int retry_count();

    @DefaultValue("LOCAL")
    @ConverterClass(StringToRunTypeConverter.class)
    RunType run_mode();

    @DefaultValue("SELENOID")
    @ConverterClass(StringToBrowserRemoteModeTypeConverter.class)
    BrowserRemoteModeType remote_mode();

    @ConverterClass(StringToUrlConverter.class)
    URL seleniumGridUrl();

    @ConverterClass(StringToUrlConverter.class)
    URL selenoidUrl();
}
