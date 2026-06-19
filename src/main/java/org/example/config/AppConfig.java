package org.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class AppConfig {

    @Value("${app.config.name:HIS医疗系统默认版}")
    private String name;

    @Value("${app.config.version:v1.0}")
    private String version;

    @Value("${app.config.showMessage:true}")
    private boolean showMessage;

    public String getName() { return name; }
    public String getVersion() { return version; }
    public boolean isShowMessage() { return showMessage; }
}