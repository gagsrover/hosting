/*
 * System : WeatherApplication
 * Package: de.gags.util
 * Class  : JsonReader
 *
 * Veristrat Software 2013
 */
package de.gags.util;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * This is a utility class to read a url and return a JSON object.
 */
public class JsonReader {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    /**
     * This method takes a url as input and return the output in the form of JSON object.
     *
     * @param url Input url from where the data is to be fetched.
     *
     * @return a JSON object containing the output data.
     *
     * @throws IOException if url can't be accessed.
     * @throws JSONException if JSONObject could not be constructed.
     */
    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

} // End Class JsonReader
