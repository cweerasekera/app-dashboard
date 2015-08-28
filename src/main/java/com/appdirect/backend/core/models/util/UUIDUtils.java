
package com.appdirect.backend.core.models.util;

import java.nio.ByteBuffer;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * @author cweerasekera
 *
 */
public class UUIDUtils {
    
    private static final Logger LOG = LoggerFactory.getLogger(UUIDUtils.class);
    /**
     * 
     * @param uuid
     * @return
     */
    public static byte[] getIdAsByte(UUID uuid) {
        LOG.trace("ENTER getIdAsByte()");
        final ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        try{
            return bb.array();
        }finally{
            LOG.trace("EXIT getIdAsByte()");
        }        
    }

    /**
     * 
     * @param b
     * @return
     */
    public static UUID fromByte(byte[] b) {
        LOG.trace("ENTER fromByte()");
        LOG.debug("Byte {}", b);
        final ByteBuffer bb = ByteBuffer.wrap(b);
        long firstLong = bb.getLong();
        long secondLong = bb.getLong();        
        try{
            return new UUID(firstLong, secondLong);
        }finally{
            LOG.trace("EXIT fromByte()");
        }
    }
    
    /**
     * 
     * @param uuid
     * @return
     */
    public static UUID fromString(String uuid) {
        LOG.trace("ENTER fromString()");        
        try{
            return UUID.fromString(uuid);
        }finally{
            LOG.trace("EXIT fromString()");
        }
    }
    
    
    public static void main(String [] args) {
        final UUID uuid = UUID.randomUUID();
        System.out.println("UUID: " + uuid.toString());
        final byte [] b = getIdAsByte(uuid);
        final UUID newUuuid = fromByte(b);
        System.out.println("New UUID: " + newUuuid.toString());
        System.out.println("String UUID: " + fromString(uuid.toString()).toString());
        
    }
}
