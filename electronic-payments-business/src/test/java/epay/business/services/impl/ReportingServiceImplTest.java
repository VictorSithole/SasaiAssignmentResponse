package epay.business.services.impl;

import com.econetwireless.epay.business.services.impl.ReportingServiceImpl;
import com.econetwireless.epay.dao.subscriberrequest.api.SubscriberRequestDao;
import com.econetwireless.epay.domain.SubscriberRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.*;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReportingServiceImplTest {

    @Mock
    private SubscriberRequestDao mockSubscriberRequestDao;

    private ReportingServiceImpl reportingServiceImplUnderTest;

    @Before
    public void setUp() {
        reportingServiceImplUnderTest = new ReportingServiceImpl(mockSubscriberRequestDao);
    }

    @Test
    public void testFindSubscriberRequestsByPartnerCode() {
        // Setup

        // Configure SubscriberRequestDao.findByPartnerCode(...).
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
        final List<SubscriberRequest> subscriberRequests = Arrays.asList(subscriberRequest);
        when(mockSubscriberRequestDao.findByPartnerCode("partnerCode")).thenReturn(subscriberRequests);

        // Run the test
        final List<SubscriberRequest> result = reportingServiceImplUnderTest.findSubscriberRequestsByPartnerCode("partnerCode");

        // Verify the results
    }

    @Test
    public void testFindSubscriberRequestsByPartnerCode_SubscriberRequestDaoReturnsNoItems() {
        // Setup
        when(mockSubscriberRequestDao.findByPartnerCode("partnerCode")).thenReturn(Collections.emptyList());

        // Run the test
        final List<SubscriberRequest> result = reportingServiceImplUnderTest.findSubscriberRequestsByPartnerCode("partnerCode");

        // Verify the results
        assertNotNull(result);
    }
}
