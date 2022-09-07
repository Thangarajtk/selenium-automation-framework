package com.automation.pages.orangehrm.validator;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HomePageValidator {

    private String headerName;
    private boolean isMarketPlaceLinkPresent;
    private String logoSourceText;
}
