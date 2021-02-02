package com.company.businessProcess;

import com.company.domain.Ingredients;
import org.json.simple.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IngredientsServiceTest {

    @Test
    public void makeServiceCallTest() throws Exception
    {
        List<Ingredients> list = new ArrayList();
        list.add(new Ingredients("Ham", 110));
        IngredientsService.initializeRemoteDatabasewithSupplies(list);
    }

}