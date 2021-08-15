package epay.business.integrations.impl;

import com.econetwireless.epay.business.integrations.impl.ChargingPlatformImpl;
import com.econetwireless.utils.pojo.INBalanceResponse;
import com.econetwireless.utils.pojo.INCreditRequest;
import com.econetwireless.utils.pojo.INCreditResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class ChargingPlatformImplTest {

    @Mock
    private IntelligentNetworkService mockIntelligentNetworkService;

    private ChargingPlatformImpl chargingPlatformImplUnderTest;

    @Before
    public void setUp() {
        chargingPlatformImplUnderTest = new ChargingPlatformImpl(mockIntelligentNetworkService);
    }

    @Test
    public void testEnquireBalance() {
        // Setup

        // Run the test
        final INBalanceResponse result = chargingPlatformImplUnderTest.enquireBalance("partnerCode", "msisdn");

        // Verify the results
    }

    @Test
    public void testCreditSubscriberAccount() {
        // Setup
        final INCreditRequest inCreditRequest = new INCreditRequest();
        inCreditRequest.setMsisdn("msisdn");
        inCreditRequest.setAmount(0.0);
        inCreditRequest.setReferenceNumber("referenceNumber");
        inCreditRequest.setPartnerCode("partnerCode");

        // Run the test
        final INCreditResponse result = chargingPlatformImplUnderTest.creditSubscriberAccount(inCreditRequest);

        assertNotNull(result);
    }
}
