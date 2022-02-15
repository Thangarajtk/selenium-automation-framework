package com.automation.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.automation.constants.FrameworkConstants;
import com.automation.utils.dataprovider.ExcelUtils;

public class MethodInterceptor implements IMethodInterceptor {

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

        List<Map<String, String>> list = ExcelUtils.getTestDetails(FrameworkConstants.getRunManagerSheet());
        List<IMethodInstance> result = new ArrayList<>();

        for (IMethodInstance method : methods) {
            for (Map<String, String> stringStringMap : list) {
                if (method.getMethod().getMethodName().equalsIgnoreCase(stringStringMap.get("TestName")) &&
                        stringStringMap.get("Execute").equalsIgnoreCase("yes")) {
                    method.getMethod().setDescription((stringStringMap.get("Description")));
                    result.add(method);
                }
            }
        }
        return result;
    }
}
