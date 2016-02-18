package hello;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.Currency;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class CountryRepository {
    private static final List<Country> countries = new ArrayList<Country>();

    @PostConstruct
    public void initData() {
        countries.add(new Country() {{
            setName("Spain");
            setCapital("Madrid");
            setCurrency(Currency.EUR);
            setPopulation(46704314);
        }});

        countries.add(new Country() {{
            setName("Poland");
            setCapital("Warsaw");
            setCurrency(Currency.PLN);
            setPopulation(38186860);
        }});

        countries.add(new Country() {{
            setName("United Kingdom");
            setCapital("London");
            setCurrency(Currency.GBP);
            setPopulation(63705000);
        }});
    }

    public Country findCountry(String name) {
        Assert.notNull(name);

        Country result = null;

        for (Country country : countries) {
            if (name.equals(country.getName())) {
                result = country;
            }
        }

        return result;
    }
}