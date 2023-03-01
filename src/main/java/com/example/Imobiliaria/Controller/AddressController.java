package com.example.Imobiliaria.Controller;

import com.example.Imobiliaria.Model.Address;
import com.example.Imobiliaria.Service.AddressService;
import com.example.Imobiliaria.Service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;
@RestController
@RequestMapping("address")
public class AddressController extends CrudController<Address, UUID> {
    @Autowired
    private AddressService addressService;
    @Override
    protected CrudService<Address, UUID> getService() {
        return addressService;
    }
}
