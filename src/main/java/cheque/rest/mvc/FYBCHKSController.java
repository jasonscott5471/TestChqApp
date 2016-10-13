package cheque.rest.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cheque.core.models.BannerEntities.FYBCHKS;
import cheque.core.services.exceptions.FYBCHKSExistsException;
import cheque.core.services.FYBCHKSService;
import cheque.core.services.util.FYBCHKSList;
import cheque.rest.exceptions.ConflictException;
import cheque.rest.resources.FYBCHKSListResource;
import cheque.rest.resources.FYBCHKSResource;
import cheque.rest.resources.asm.FYBCHKSListResourceAsm;
import cheque.rest.resources.asm.FYBCHKSResourceAsm;

//new imports Oct 3, 2016 for authentication

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import cheque.rest.exceptions.ForbiddenException;

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

    /* before locking down Oct 3, 16
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<FYBCHKSListResource> findAllFYBCHKSs()
    {
        FYBCHKSList fybchksList = fybchksService.findAllFYBCHKSs();
        FYBCHKSListResource fybchksListRes = new FYBCHKSListResourceAsm().toResource(fybchksList);
        return new ResponseEntity<FYBCHKSListResource>(fybchksListRes, HttpStatus.OK);
    }

*/
//new locked down code replacing above

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("permitAll") //added Oct 3, 2016

    public ResponseEntity<FYBCHKSListResource> findAllFYBCHKSs()


    {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(principal instanceof UserDetails){


            UserDetails details = (UserDetails)principal;

            if (details.toString() != null)



            //existing code
            {
                FYBCHKSList fybchksList = fybchksService.findAllFYBCHKSs();
                FYBCHKSListResource fybchksListRes = new FYBCHKSListResourceAsm().toResource(fybchksList);
                return new ResponseEntity<FYBCHKSListResource>(fybchksListRes, HttpStatus.OK);
            }

            else {

                //need to return forbidden error not null which is currently raising error 500 (Internal Server Error)

                throw new ForbiddenException();

            }

        }

        else {


            //need to return forbidden error not null which is currently raising error 500 (Internal Server Error)

            throw new ForbiddenException();

        }

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


/* before locking down Oct 3, 16
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
 */
//new locked down code replacing above
    @RequestMapping(value="/{FYBCHKS_INVH_CODE}",
            method = RequestMethod.PUT)
    @PreAuthorize("permitAll") //added Oct 3, 2016

    public ResponseEntity<FYBCHKSResource> updateFYBCHKS(
            @PathVariable String FYBCHKS_INVH_CODE, @RequestBody FYBCHKSResource sentFYBCHKS)

    {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(principal instanceof UserDetails){


            UserDetails details = (UserDetails)principal;

            if (details.toString() != null)



            //existing code
            {
                FYBCHKS updatedEntry = fybchksService.updateFYBCHKS(FYBCHKS_INVH_CODE, sentFYBCHKS.toFYBCHKS());
                if(updatedEntry != null)
                {
                    FYBCHKSResource res = new FYBCHKSResourceAsm().toResource(updatedEntry);
                    return new ResponseEntity<FYBCHKSResource>(res, HttpStatus.OK);
                } else {
                    return new ResponseEntity<FYBCHKSResource>(HttpStatus.NOT_FOUND);
                }

            }

            else {

                //need to return forbidden error not null which is currently raising error 500 (Internal Server Error)

                throw new ForbiddenException();

            }

        }

        else {


            //need to return forbidden error not null which is currently raising error 500 (Internal Server Error)

            throw new ForbiddenException();

        }

    }
/* before locking down Oct 3, 16
    @RequestMapping(value="/callMethod1/{FYBCHKS_INVH_CODE}",
            method = RequestMethod.POST)
    public ResponseEntity<FYBCHKSResource> callTestAPI(
            @PathVariable String FYBCHKS_INVH_CODE) {
        //fybchksService.deleteFYBCHKS(FYBCHKS_INVH_CODE);

        fybchksService.callTestAPI(FYBCHKS_INVH_CODE);

        return new ResponseEntity<FYBCHKSResource>(HttpStatus.OK);


    }
 */
//new locked down code replacing above
@RequestMapping(value="/callMethod1/{FYBCHKS_INVH_CODE}",
        method = RequestMethod.POST)
@PreAuthorize("permitAll") //added Oct 3, 2016

public ResponseEntity<FYBCHKSResource> callTestAPI(
        @PathVariable String FYBCHKS_INVH_CODE)
     {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(principal instanceof UserDetails){


            UserDetails details = (UserDetails)principal;

            if (details.toString() != null)



            //existing code
            {
                fybchksService.callTestAPI(FYBCHKS_INVH_CODE);

                return new ResponseEntity<FYBCHKSResource>(HttpStatus.OK);
            }

            else {

                //need to return forbidden error not null which is currently raising error 500 (Internal Server Error)

                throw new ForbiddenException();

            }

        }

        else {


            //need to return forbidden error not null which is currently raising error 500 (Internal Server Error)

            throw new ForbiddenException();

        }

    }
/* before locking down Oct 3, 16
    @RequestMapping(value="/callMethod2",
            method = RequestMethod.POST)
    public ResponseEntity<FYBCHKSListResource> ValidateFYBCHKS()
    {
        FYBCHKSList fybchksList = fybchksService.ValidateFYBCHKS();
        FYBCHKSListResource fybchksListRes = new FYBCHKSListResourceAsm().toResource(fybchksList);
        return new ResponseEntity<FYBCHKSListResource>(fybchksListRes, HttpStatus.OK);
    }
*/
//new locked down code replacing above
@RequestMapping(value="/callMethod2",
        method = RequestMethod.POST)
@PreAuthorize("permitAll") //added Oct 3, 2016

public ResponseEntity<FYBCHKSListResource> ValidateFYBCHKS()


{
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    if(principal instanceof UserDetails){


        UserDetails details = (UserDetails)principal;

        if (details.toString() != null)



        //existing code
        {
            FYBCHKSList fybchksList = fybchksService.ValidateFYBCHKS();
            FYBCHKSListResource fybchksListRes = new FYBCHKSListResourceAsm().toResource(fybchksList);
            return new ResponseEntity<FYBCHKSListResource>(fybchksListRes, HttpStatus.OK);
        }

        else {

            //need to return forbidden error not null which is currently raising error 500 (Internal Server Error)

            throw new ForbiddenException();

        }

    }

    else {


        //need to return forbidden error not null which is currently raising error 500 (Internal Server Error)

        throw new ForbiddenException();

    }

}

}


