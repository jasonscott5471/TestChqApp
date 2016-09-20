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
import tutorial.core.models.BannerEntities.FYBCHKS;
import tutorial.core.services.exceptions.FYBCHKSExistsException;
import tutorial.core.services.FYBCHKSService;
import tutorial.core.services.util.FYBCHKSList;
import tutorial.rest.exceptions.ConflictException;
import tutorial.rest.resources.FYBCHKSListResource;
import tutorial.rest.resources.FYBCHKSResource;
import tutorial.rest.resources.asm.FYBCHKSListResourceAsm;
import tutorial.rest.resources.asm.FYBCHKSResourceAsm;

import java.net.URI;

/**
 * Created by finwebmailer on 6/7/2016.
 */
@Controller
@RequestMapping("/rest/fybchks")
public class FYBCHKSController {
    private FYBCHKSService fybchksService;

    @Autowired
    public FYBCHKSController(FYBCHKSService fybchksService)
    {
        this.fybchksService = fybchksService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<FYBCHKSListResource> findAllFYBCHKSs()
    {
        FYBCHKSList fybchksList = fybchksService.findAllFYBCHKSs();
        FYBCHKSListResource fybchksListRes = new FYBCHKSListResourceAsm().toResource(fybchksList);
        return new ResponseEntity<FYBCHKSListResource>(fybchksListRes, HttpStatus.OK);
    }

    @RequestMapping(value="/{FYBCHKS_INVH_CODE}",
            method = RequestMethod.GET)
    public ResponseEntity<FYBCHKSResource> getFYBCHKS(@PathVariable String FYBCHKS_INVH_CODE)
    {
        FYBCHKS fybchks = fybchksService.findFYBCHKS(FYBCHKS_INVH_CODE);
        if(fybchks != null)
        {
            FYBCHKSResource res = new FYBCHKSResourceAsm().toResource(fybchks);
            return new ResponseEntity<FYBCHKSResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<FYBCHKSResource>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<FYBCHKSResource> createFYBCHKS(
            @RequestBody FYBCHKSResource sentFYBCHKS
    ) {
        try {
            FYBCHKS createdFYBCHKS = fybchksService.createFYBCHKS(sentFYBCHKS.toFYBCHKS());

            FYBCHKSResource res = new FYBCHKSResourceAsm().toResource(createdFYBCHKS);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(res.getLink("self").getHref()));
            return new ResponseEntity<FYBCHKSResource>(res, headers, HttpStatus.CREATED);
        } catch(FYBCHKSExistsException exception) {
            throw new ConflictException(exception);
        }
    }


    @RequestMapping(value="/{FYBCHKS_INVH_CODE}",
            method = RequestMethod.DELETE)
    public ResponseEntity<FYBCHKSResource> deleteFYBCHKS(
            @PathVariable String FYBCHKS_INVH_CODE) {
        FYBCHKS fybchks = fybchksService.deleteFYBCHKS(FYBCHKS_INVH_CODE);

        if(fybchks != null)
        {
            FYBCHKSResource res = new FYBCHKSResourceAsm().toResource(fybchks);
            return new ResponseEntity<FYBCHKSResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<FYBCHKSResource>(HttpStatus.NOT_FOUND);
        }
    }



    @RequestMapping(value="/{FYBCHKS_INVH_CODE}",
            method = RequestMethod.PUT)
    public ResponseEntity<FYBCHKSResource> updateFYBCHKS(
            @PathVariable String FYBCHKS_INVH_CODE, @RequestBody FYBCHKSResource sentFYBCHKS) {
        FYBCHKS updatedEntry = fybchksService.updateFYBCHKS(FYBCHKS_INVH_CODE, sentFYBCHKS.toFYBCHKS());
        if(updatedEntry != null)
        {
            FYBCHKSResource res = new FYBCHKSResourceAsm().toResource(updatedEntry);
            return new ResponseEntity<FYBCHKSResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<FYBCHKSResource>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/callMethod1/{FYBCHKS_INVH_CODE}",
            method = RequestMethod.POST)
    public ResponseEntity<FYBCHKSResource> callTestAPI(
            @PathVariable String FYBCHKS_INVH_CODE) {
        //fybchksService.deleteFYBCHKS(FYBCHKS_INVH_CODE);

        fybchksService.callTestAPI(FYBCHKS_INVH_CODE);

        return new ResponseEntity<FYBCHKSResource>(HttpStatus.OK);

     /*
        if(fybchks != null)
        {
            FYBCHKSResource res = new FYBCHKSResourceAsm().toResource(fybchks);
            return new ResponseEntity<FYBCHKSResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<FYBCHKSResource>(HttpStatus.NOT_FOUND);
        } */
    }

    @RequestMapping(value="/callMethod2",
            method = RequestMethod.POST)
    public ResponseEntity<FYBCHKSListResource> ValidateFYBCHKS()
    {
        FYBCHKSList fybchksList = fybchksService.ValidateFYBCHKS();
        FYBCHKSListResource fybchksListRes = new FYBCHKSListResourceAsm().toResource(fybchksList);
        return new ResponseEntity<FYBCHKSListResource>(fybchksListRes, HttpStatus.OK);
    }
}


