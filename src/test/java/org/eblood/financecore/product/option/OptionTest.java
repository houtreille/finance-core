package org.eblood.financecore.product.option;

import org.eblood.financecore.asset.Asset;
import org.eblood.financecore.exceptions.UnknownProductException;
import org.eblood.financecore.product.enums.BuySellEnum;
import org.eblood.financecore.product.enums.OptionTypeEnum;
import org.eblood.financecore.valuation.Valuation;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class OptionTest {

    @Test
    void getMtm() throws UnknownProductException {

        Valuation val90 = new Valuation(90., "USD", new Date());
        Valuation val91 = new Valuation(91., "USD", new Date());
        Valuation val92 = new Valuation(92., "USD", new Date());
        Valuation val93 = new Valuation(93., "USD", new Date());
        Valuation val94 = new Valuation(94., "USD", new Date());
        Valuation val95 = new Valuation(95., "USD", new Date());
        Valuation val96 = new Valuation(96., "USD", new Date());
        Valuation val97 = new Valuation(97., "USD", new Date());
        Valuation val98 = new Valuation(98., "USD", new Date());
        Valuation val99 = new Valuation(99., "USD", new Date());
        Valuation val100 = new Valuation(100., "USD", new Date());
        Valuation val101 = new Valuation(101., "USD", new Date());
        Valuation val102 = new Valuation(102., "USD", new Date());
        Valuation val103 = new Valuation(103., "USD", new Date());

        List<Valuation> valuations = Arrays.asList(val90, val91);

        Valuation val = mock(Valuation.class);
        Asset mockAsset = mock(Asset.class);

        when(mockAsset.getValuation(any())).thenReturn(val90,
                val91, val92, val93, val94, val95, val96, val97, val98, val99,
                val100, val101, val102, val103);

        Option<Asset> dummyOption = new Option<Asset>();
        dummyOption.setAsset(mockAsset);
        dummyOption.setK(95.);
        dummyOption.setOptionType(OptionTypeEnum.CALL);
        dummyOption.setBuySell(BuySellEnum.SELL);
        dummyOption.setMaturityDate(new Date());

        for (int i = 1; i <= 14; i++) {
            Valuation valX = dummyOption.getPayoff(new Date());
            System.out.println(((Valuation)valX.getDetails().get("St")).getMtm() + ";" + valX.getMtm());
        }


    }
}