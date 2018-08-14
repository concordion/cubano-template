package example.service;

import java.io.IOException;

import org.concordion.cubano.template.driver.services.ExampleRestApi;

import example.CubanoDemoFixture;

public class RestRequestFixture extends CubanoDemoFixture {

    public boolean callService() throws IOException {
        return new ExampleRestApi()
                .getIPAddress() != null;
    }
}
