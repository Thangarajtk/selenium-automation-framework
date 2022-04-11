package com.automation.utils.zerocell;

import com.creditdatamw.zerocell.annotation.Column;
import lombok.Getter;
import lombok.ToString;
import org.aeonbits.owner.Config;

@Getter
@ToString
public class TestData {

    //POJO
    @Column(name = "TestName", index = 0)
    private String TestName;

    @Column(name = "Execute", index = 1)
    private String Execute;

    @Column(name = "browser", index = 2)
    private String browser;

    @Column(name = "version", index = 3)
    private String version;

    @Column(name = "username", index = 4)
    private String username;

    @Column(name = "password", index = 5)
    private String password;

    @Column(name = "MenuToSelect", index = 6)
    private String MenuToSelect;
}
