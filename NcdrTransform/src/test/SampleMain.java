package test;

import java.io.*;
import java.net.*;

public class SampleMain {

    public static void main(String[] args) throws IOException {
        URLConnection conn = new URL("https://opendata.cwb.gov.tw/api/v1/rest/datastore/O-A0001-001?Authorization=rdec-key-123-45678-011121314").openConnection();

        /** Modify connection */
        //TrustModifier.trust(conn);

        String inputLine;
        try(InputStreamReader stream = new InputStreamReader(conn.getInputStream());
            BufferedReader in = new BufferedReader(stream)) {
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
        }
    }
}