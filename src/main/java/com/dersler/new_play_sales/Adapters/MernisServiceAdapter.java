package com.dersler.new_play_sales.Adapters;

import com.dersler.new_play_sales.Entities.Customer;
import com.dersler.new_play_sales.Mernis.CUNKPSPublicSoap;
import com.dersler.new_play_sales.Services.abstracts.ICustomerCheckService;
import org.springframework.stereotype.Service;

@Service
public class MernisServiceAdapter implements ICustomerCheckService {

    @Override
    public boolean CheckIfRealPerson(Customer customer) throws Exception {

        CUNKPSPublicSoap client = new CUNKPSPublicSoap();
        return client.TCKimlikNoDogrula( Long.valueOf(customer.getNationalityId() ), customer.getFirstName().toUpperCase(), customer.getLastName().toUpperCase(), customer.getYearOfBirth() );

    }

}
