package com.company.businessProcess;

import org.junit.Test;


public class CookingSchedulerTest
{
    @Test
    public void testRun() throws Exception
    {
        Thread thread = new Thread(new CookingScheduler(StoreManager.getInstance()));
        thread.start();
    }
}