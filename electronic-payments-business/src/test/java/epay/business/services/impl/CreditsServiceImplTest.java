package epay.business.services.impl;

import com.econetwireless.epay.business.integrations.api.ChargingPlatform;
import com.econetwireless.epay.business.services.impl.CreditsServiceImpl;
import com.econetwireless.epay.dao.subscriberrequest.api.SubscriberRequestDao;
import com.econetwireless.epay.domain.SubscriberRequest;
import com.econetwireless.utils.messages.AirtimeTopupRequest;
import com.econetwireless.utils.messages.AirtimeTopupResponse;
import com.econetwireless.utils.pojo.INCreditRequest;
import com.econetwireless.utils.pojo.INCreditResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreditsServiceImplTest {

    @Mock
    private ChargingPlatform mockChargingPlatform;
    @Mock
    private SubscriberRequestDao mockSubscriberRequestDao;

    private CreditsServiceImpl creditsServiceImplUnderTest;

    @Before
    public void setUp() {
        creditsServiceImplUnderTest = new CreditsServiceImpl(mockChargingPlatform, mockSubscriberRequestDao);
    }

    @Test
    public void testCredit() {
        // Setup
        final AirtimeTopupRequest airtimeTopupRequest = new AirtimeTopupRequest();
        airtimeTopupRequest.setMsisdn("msisdn");
        airtimeTopupRequest.setAmount(0.0);
        airtimeTopupRequest.setReferenceNumber("referenceNumber");
        airtimeTopupRequest.setPartnerCode("partnerCode");

        // Configure SubscriberRequestDao.save(...).
        final SubscriberRequest subscriberRequest = new SubscriberRequest();
        subscriberRequest.setId(0L);
        subscriberRequest.setRequestType("requestType");
        subscriberRequest.setPartnerCode("partnerCode");
        subscriberRequest.setMsisdn("msisdn");
        subscriberRequest.setBalanceBefore(0.0);
        subscriberRequest.setBalanceAfter(0.0);
        subscriberRequest.setAmount(0.0);
        subscriberRequest.setDateCreated(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        subscriberRequest.setDateLastUpdated(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        subscriberRequest.setVersion(0L);
        when(mockSubscriberRequestDao.save(any(SubscriberRequest.class))).thenReturn(subscriberRequest);

        // Configure ChargingPlatform.creditSubscriberAccount(...).
        final INCreditResponse inCreditResponse = new INCreditResponse();
        inCreditResponse.setResponseCode("responseCode");
        inCreditResponse.setNarrative("narrative");
        inCreditResponse.setMsisdn("msisdn");
        inCreditResponse.setBalance(0.0);
        when(mockChargingPlatform.creditSubscriberAccount(any(INCreditRequest.class))).thenReturn(inCreditResponse);

        // Run the test
        final AirtimeTopupResponse result = creditsServiceImplUnderTest.credit(airtimeTopupRequest);

        // Verify the results
        assertNotNull(result);

    }
}
