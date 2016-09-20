package tutorial.rest.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tutorial.core.models.BannerEntities.FATCKIN;
import tutorial.core.services.exceptions.FATCKINExistsException;
import tutorial.core.services.FATCKINService;
import tutorial.core.services.util.FATCKINList;
import tutorial.rest.exceptions.ConflictException;
import tutorial.rest.resources.FATCKINListResource;
import tutorial.rest.resources.FATCKINResource;
import tutorial.rest.resources.asm.FATCKINListResourceAsm;
import tutorial.rest.resources.asm.FATCKINResourceAsm;

import java.net.URI;
/**
 * Created by finwebmailer on 6/20/2016.
 */
@Controller
@RequestMapping("/rest/fatckins")
public class FATCKINController {
    private FATCKINService fatckinService;

    @Autowired
    public FATCKINController(FATCKINService fatckinService) {
        this.fatckinService = fatckinService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<FATCKINListResource> findAllFATCKINs()
    {
        FATCKINList fatckinList = fatckinService.findAllFATCKINs();
        FATCKINListResource fatckinListRes = new FATCKINListResourceAsm().toResource(fatckinList);
        return new ResponseEntity<FATCKINListResource>(fatckinListRes, HttpStatus.OK);
    }

    @RequestMapping(value="/{FATCKIN_INVH_CODE}",
            method = RequestMethod.GET)
    public ResponseEntity<FATCKINResource> getFATCKIN(@PathVariable String FATCKIN_INVH_CODE)
    {
        FATCKIN fatckin = fatckinService.findFATCKIN(FATCKIN_INVH_CODE);
        FATCKINResource res = new FATCKINResourceAsm().toResource(fatckin);
        return new ResponseEntity<FATCKINResource>(res, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<FATCKINResource> createFATCKIN(
            @RequestBody FATCKINResource sentFATCKIN
    ) {
        try {
            FATCKIN createdFATCKIN = fatckinService.createFATCKIN(sentFATCKIN.toFATCKIN());
            FATCKINResource res = new FATCKINResourceAsm().toResource(createdFATCKIN);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(res.getLink("self").getHref()));
            return new ResponseEntity<FATCKINResource>(res, headers, HttpStatus.CREATED);
        } catch(FATCKINExistsException exception) {
            throw new ConflictException(exception);
        }

        //new code
    }



}
