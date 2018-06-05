package de.adorsys.sts.pluginexample;

import de.adorsys.sts.common.util.ImmutableLists;
import de.adorsys.sts.resourceserver.service.EncryptionService;
import org.pf4j.Extension;
import org.pf4j.ExtensionPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Extension
@RestController
@RequestMapping
public class ExamplePluginRestController implements ExtensionPoint {

    @Autowired
    private EncryptionService encryptionService;

    @Autowired
    private ExamplePluginLoginAdapter loginAdapter;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody @Valid LoginRequest login) {
        String secretToken = loginAdapter.getSecret(login.getUsername(), login.getPassword());

        List<String> audiences = ImmutableLists.of(login.getAudiences(), "sts");

        return encryptionService.encryptFor(audiences, secretToken);
    }
}
