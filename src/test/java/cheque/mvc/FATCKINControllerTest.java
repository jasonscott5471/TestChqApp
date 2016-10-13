package cheque.mvc;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import cheque.core.models.BannerEntities.Account;
//import cheque.core.models.BannerEntities.FYBCHKSEntry;
import cheque.core.models.BannerEntities.FATCKIN;
import cheque.core.services.FATCKINService;
import cheque.rest.mvc.FATCKINController;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by finwebmailer on 6/21/2016.
 */
public class FATCKINControllerTest {
    @InjectMocks
    private FATCKINController controller;

    @Mock
    private FATCKINService fatckinService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    /* SELEMENT Removing for now because I made so many changes to this class
    @Test
    public void findAllFATCKINs() throws Exception {
        List<FATCKIN> list = new ArrayList<FATCKIN>();

        FATCKIN fatckinA = new FATCKIN();
        fatckinA.setFATCKIN_INVH_CODE("I0157967");
        fatckinA.setFATCKIN_VEND_INV("P0051048+157966");
        fatckinA.setFATCKIN_VEND_FULL_NAME("Test Vendor Name Here");
        fatckinA.setFATCKIN_CURR_CODE("");
        fatckinA.setFATCKIN_GROSS_AMT(BigDecimal.valueOf(-874));
        fatckinA.setFATCKIN_NET_AMT(BigDecimal.valueOf(-874));

        list.add(fatckinA);

        /*
        FATCKIN fatckinB = new FATCKIN();
        fatckinB.setFATCKIN_INVH_CODE("I0157928");
        fatckinB.setFATCKIN_VEND_INV("P0051048+157966");
        fatckinB.setFATCKIN_VEND_FULL_NAME("Test Vendor Name Here");
        fatckinB.setFATCKIN_CURR_CODE("");
        fatckinB.setFATCKIN_GROSS_AMT(BigDecimal.valueOf(874));
        fatckinB.setFATCKIN_NET_AMT(BigDecimal.valueOf(874));

        list.add(fatckinB);

        FATCKINList allFATCKINs = new FATCKINList();
        allFATCKINs.setFatckins(list);

        when(fatckinService.findAllFATCKINs()).thenReturn(allFATCKINs);


        mockMvc.perform(get("/rest/fatckins"))
                .andExpect(jsonPath("$.fatckins[*].FATCKIN_INVH_CODE",
                        hasItems(endsWith("I0157967"))))
                .andExpect(status().isOk());


    }
        */

    @Test
    public void getFATCKIN() throws Exception {
        FATCKIN fatckin = new FATCKIN();
        fatckin.setFATCKIN_INVH_CODE("GetInvTest");
        fatckin.setFATCKIN_VEND_INV("P0051048+157966");
        fatckin.setFATCKIN_VEND_FULL_NAME("Test Vendor Name Here");
        fatckin.setFATCKIN_CURR_CODE("");
        fatckin.setFATCKIN_GROSS_AMT(BigDecimal.valueOf(874));
        fatckin.setFATCKIN_NET_AMT(BigDecimal.valueOf(874));

        when(fatckinService.findFATCKIN("GetInvTest")).thenReturn(fatckin);

        mockMvc.perform(get("/rest/fatckins/GetInvTest"))
                .andExpect(jsonPath("$.links[*].href",
                        hasItem(endsWith("/fatckins/GetInvTest"))))
                .andExpect(jsonPath("$.links[*].href",
                        hasItem(endsWith("/fatckins/GetInvTest/entries"))))
               // .andExpect(jsonPath("$.FATCKIN_INVH_CODE", is("GetInvTest")))
                .andExpect(status().isOk());
    }
/* SELEMENT Removing for now because I made so many changes to this class
    @Test
    public void createFATCKINEntryExistingFATCKIN() throws Exception {
        FATCKIN fatckin = new FATCKIN();
        fatckin.setFATCKIN_INVH_CODE("GetInvTest");


        FYBCHKSEntry entry = new FYBCHKSEntry();
        entry.setFATCKIN_INVH_CODE("GetInvTest");
        // entry.setId(GetInvTestL);

        when(fatckinService.createFATCKINEntry(eq("GetInvTest"), any(FYBCHKSEntry.class))).thenReturn(entry);

        mockMvc.perform(post("/rest/fatckins/GetInvTest/fatckin-entries")
                .content("{\"FATCKIN_INVH_CODE\":\"GetInvTest\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.FATCKIN_INVH_CODE", is(entry.getFATCKIN_INVH_CODE())))
                .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("rest/fatckin-entries/GetInvTest"))))
                .andExpect(header().string("Location", endsWith("rest/fatckin-entries/GetInvTest")))
                .andExpect(status().isCreated());
    }


    @Test
    public void createFATCKINEntryNonExistingFATCKIN() throws Exception {
        when(fatckinService.createFATCKINEntry(eq("GetInvTest"), any(FYBCHKSEntry.class))).thenThrow(new FATCKINNotFoundException());

        mockMvc.perform(post("/rest/fatckins/GetInvTest/fatckin-entries")
                .content("{\"FATCKIN_VEND_FULL_NAME\":\"Generic Title\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void listFATCKINEntriesForExistingFATCKIN() throws Exception {

        FYBCHKSEntry entryA = new FYBCHKSEntry();
        entryA.setFATCKIN_INVH_CODE("I0157967");
        entryA.setFATCKIN_VEND_FULL_NAME("Test Vendor Name Here");

        FYBCHKSEntry entryB = new FYBCHKSEntry();
        entryB.setFATCKIN_INVH_CODE("I0157928");
        entryB.setFATCKIN_VEND_FULL_NAME("Test Vendor Name Here");

        List<FYBCHKSEntry> fatckinListings = new ArrayList();
        fatckinListings.add(entryA);
        fatckinListings.add(entryB);

        FYBCHKSEntryList list = new FYBCHKSEntryList();
        list.setEntries(fatckinListings);
        list.setFATCKIN_INVH_CODE("I0157967");

        when(fatckinService.findAllFATCKINEntries("I0157967")).thenReturn(list);

        mockMvc.perform(get("/rest/fatckins/I0157967/fatckin-entries"))
                .andDo(print())
                .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/fatckins/I0157967/fatckin-entries"))))
                .andExpect(jsonPath("$.entries[*].FATCKIN_VEND_FULL_NAME", hasItem(is("Test Vendor Name Here"))))
                .andExpect(status().isOk());
    }

    @Test
    public void listFATCKINEntriesForNonExistingFATCKIN() throws Exception {
        when(fatckinService.findAllFATCKINEntries("GetInvTest")).thenThrow(new FATCKINNotFoundException());

        mockMvc.perform(get("/rest/fatckins/GetInvTest/fatckin-entries"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
*/
}





