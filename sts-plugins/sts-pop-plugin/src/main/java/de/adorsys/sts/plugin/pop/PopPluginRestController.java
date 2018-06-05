package de.adorsys.sts.plugin.pop;

import com.nimbusds.jose.jwk.JWKSet;
import de.adorsys.sts.common.config.TokenResource;
import de.adorsys.sts.pop.PopController;
import de.adorsys.sts.pop.PopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.pf4j.Extension;
import org.pf4j.ExtensionPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Extension
@RestController
@Api(value = "/pop", tags={"Proof of Pocession RFC7800"}, description = "Public key distribution endpoint")
@RequestMapping("/pop")
@TokenResource
public class PopPluginRestController {

    private final PopService popService;

    @Autowired
    public PopPluginRestController(PopService popService) {
        this.popService = popService;
    }

    @GetMapping(produces={MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Read server public keys", response=JWKSet.class, notes = "Fetches publick keys of the target server. Keys are used to encrypt data sent to the server and also send a response encrytpion key to the server. See RFC7800")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Ok")})
    public ResponseEntity<String> getPublicKeys(){
        JWKSet publicKeys = popService.getPublicKeys();
        return ResponseEntity.ok(publicKeys.toJSONObject().toJSONString());
    }
}
