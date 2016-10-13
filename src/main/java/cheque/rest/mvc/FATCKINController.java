package cheque.rest.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cheque.core.models.BannerEntities.FATCKIN;
import cheque.core.services.exceptions.FATCKINExistsException;
import cheque.core.services.FATCKINService;
import cheque.core.services.util.FATCKINList;
import cheque.rest.exceptions.ConflictException;
import cheque.rest.resources.FATCKINListResource;
import cheque.rest.resources.FATCKINResource;
import cheque.rest.resources.asm.FATCKINListResourceAsm;
import cheque.rest.resources.asm.FATCKINResourceAsm;

//new imports Oct 3, 2016 for authentication

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import cheque.rest.exceptions.ForbiddenException;


import java.net.URI;
/**
 * Created by finwebmailer on 6/20/2016.
 *
 * Audit Notes Selement
 *
 * Note in this module I only need to expose and allow access to method GET as this is the only requirement
 * for this application
 *
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
    @PreAuthorize("permitAll") //added Oct 3, 2016

    public ResponseEntity<FATCKINListResource> findAllFATCKINs()

    {
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

       if(principal instanceof UserDetails){


        UserDetails details = (UserDetails)principal;

        if (details.toString() != null)
        //if (details.getUsername().toString() != null)


        //Account loggedIn = accountService.findByAccountName(details.getUsername());
        //if(loggedIn.getId() == accountId) {

        //existing code
        {
            FATCKINList fatckinList = fatckinService.findAllFATCKINs();
            FATCKINListResource fatckinListRes = new FATCKINListResourceAsm().toResource(fatckinList);
            return new ResponseEntity<FATCKINListResource>(fatckinListRes, HttpStatus.OK);
        }

        else {
            throw new ForbiddenException();

            //need to return forbidden error not null which is currently raising error 500 (Internal Server Error)
            //return null;
        }

       }

       else {
           throw new ForbiddenException();

           //need to return forbidden error not null which is currently raising error 500 (Internal Server Error)
           //return null;
       }

    }



    @RequestMapping(value="/{FATCKIN_INVH_CODE}",
            method = RequestMethod.GET)
   // @PreAuthorize("permitAll") //added Oct 3, 2016
    public ResponseEntity<FATCKINResource> getFATCKIN(@PathVariable String FATCKIN_INVH_CODE)
    {
        FATCKIN fatckin = fatckinService.findFATCKIN(FATCKIN_INVH_CODE);
        FATCKINResource res = new FATCKINResourceAsm().toResource(fatckin);
        return new ResponseEntity<FATCKINResource>(res, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
   // @PreAuthorize("permitAll") //added Oct 3, 2016
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
