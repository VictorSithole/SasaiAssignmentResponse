package epay.business.services.impl;

import com.econetwireless.epay.business.services.impl.PartnerCodeValidatorImpl;
import com.econetwireless.epay.dao.requestpartner.api.RequestPartnerDao;
import com.econetwireless.epay.domain.RequestPartner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PartnerCodeValidatorImplTest {

    @Mock
    private RequestPartnerDao mockRequestPartnerDao;

    private PartnerCodeValidatorImpl partnerCodeValidatorImplUnderTest;

    @Before
    public void setUp() {
        partnerCodeValidatorImplUnderTest = new PartnerCodeValidatorImpl(mockRequestPartnerDao);
    }

    @Test
    public void testValidatePartnerCode() {
        // Setup

        // Configure RequestPartnerDao.findByCode(...).
        final RequestPartner requestPartner = new RequestPartner();
        requestPartner.setId(0L);
        requestPartner.setCode("code");
        requestPartner.setName("name");
        requestPartner.setDescription("description");
        when(mockRequestPartnerDao.findByCode("code")).thenReturn(requestPartner);

        // Run the test
        final boolean result = partnerCodeValidatorImplUnderTest.validatePartnerCode("partnerCode");

        // Verify the results
        assertTrue(result);
    }
}
