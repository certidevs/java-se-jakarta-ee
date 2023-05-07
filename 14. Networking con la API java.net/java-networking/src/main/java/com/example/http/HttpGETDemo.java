package com.example.http;

import javax.net.ssl.SSLPeerUnverifiedException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.PublicKey;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.time.Duration;
import java.util.HexFormat;
import java.util.stream.Stream;

public class HttpGETDemo {

    public static void main(String[] args) throws IOException, InterruptedException {

        // legacy
//        URL url = new URL("");
//        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();

        // new (>= JDK 11)
        HttpClient client = HttpClient.newBuilder()
//                .sslContext()
//                .sslParameters()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(30))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://dummy.restapiexample.com/api/v1/employees"))
                .setHeader("User-Agent", "Firefox")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());

        response.headers().map().forEach((k, v) -> {
            System.out.println("Key: " + k);
            v.forEach(System.out::println);
        });

        System.out.println(response.body());

        response.sslSession().ifPresent(ssl -> {
            System.out.println(ssl.getCipherSuite());
            System.out.println(ssl.getProtocol());
            try {
                Stream.of(ssl.getPeerCertificates())
                        .map(cert -> (X509Certificate)cert)
                        .forEach(c -> {
                            try {
                                c.checkValidity();
                                PublicKey key = c.getPublicKey();
                                System.out.println(HexFormat.of().formatHex(key.getEncoded()));

                            } catch (CertificateExpiredException | CertificateNotYetValidException e) {
                                throw new RuntimeException(e);
                            }
                        });


            } catch (SSLPeerUnverifiedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
