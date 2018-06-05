package de.adorsys.sts.plugin.mongo;

import de.adorsys.sts.keymanagement.service.KeyManagementProperties;
import org.pf4j.Extension;
import org.pf4j.ExtensionPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Extension
@RestController
@RequestMapping
public class ExamplePluginRestController implements ExtensionPoint {

//    @Autowired
//    private KeyManagementProperties keyManagementProperties;

    @GetMapping("/mongo")
    public String login() {
//
//        System.out.println("password: " + keyManagementProperties.getKeystore().getPassword());

        return "it works";
    }
}
