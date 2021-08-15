package epay.business.services.impl;

import com.econetwireless.epay.business.integrations.api.ChargingPlatform;
import com.econetwireless.epay.business.services.impl.EnquiriesServiceImpl;
import com.econetwireless.epay.dao.subscriberrequest.api.SubscriberRequestDao;
import com.econetwireless.epay.domain.SubscriberRequest;
import com.econetwireless.utils.messages.AirtimeBalanceResponse;
import com.econetwireless.utils.pojo.INBalanceResponse;
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
public class EnquiriesServiceImplTest {

    @Mock
    private ChargingPlatform mockChargingPlatform;
    @Mock
    private SubscriberRequestDao mockSubscriberRequestDao;

    private EnquiriesServiceImpl enquiriesServiceImplUnderTest;

    @Before
    public void setUp() {
        enquiriesServiceImplUnderTest = new EnquiriesServiceImpl(mockChargingPlatform, mockSubscriberRequestDao);
    }

    @Test
    public void testEnquire() {
        // Setup

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

        // Configure ChargingPlatform.enquireBalance(...).
        final INBalanceResponse inBalanceResponse = new INBalanceResponse();
        inBalanceResponse.setResponseCode("responseCode");
        inBalanceResponse.setNarrative("narrative");
        inBalanceResponse.setMsisdn("msisdn");
        inBalanceResponse.setAmount(0.0);
        when(mockChargingPlatform.enquireBalance("partnerCode", "msisdn")).thenReturn(inBalanceResponse);

        // Run the test
        final AirtimeBalanceResponse result = enquiriesServiceImplUnderTest.enquire("partnerCode", "msisdn");

        // Verify the results
        assertNotNull(result);
    }
}
