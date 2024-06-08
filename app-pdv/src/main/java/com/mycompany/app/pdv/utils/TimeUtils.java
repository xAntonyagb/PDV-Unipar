package com.mycompany.app.pdv.utils;

import java.sql.Timestamp;
import java.time.Instant;

/**
 *
 * @author Antony
 */
public class TimeUtils {
    
    public static Timestamp getTimestampNow() {
        Instant now = Instant.now();
        
        Timestamp timestamp = Timestamp.from(now);
        return timestamp;
    }
    
    public static String getStringNow() {
        Instant now = Instant.now();
        
        Timestamp timestamp = Timestamp.from(now);
        return timestamp.toString();
    }
    
    public static Timestamp stringToTimestamp(String data) {
        if(data == null)
            return null;
        
        Instant converter = Instant.parse(data);
        return Timestamp.from(converter);
    }
    
}
