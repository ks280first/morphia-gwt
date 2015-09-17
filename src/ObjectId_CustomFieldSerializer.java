package org.bson.types;

import java.util.logging.Logger;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

/**
 *
 */
public class ObjectId_CustomFieldSerializer {
  private static final Logger logger = Logger.getGlobal();
  /**
   * @param streamReader
   * @param instance
   * @throws SerializationException
   */
  public static void deserialize(SerializationStreamReader streamReader, ObjectId instance)
      throws SerializationException {
    // already handled in instantiate
  }

  /**
   * @param streamReader
   * @return
   * @throws SerializationException
   */
  public static ObjectId instantiate(SerializationStreamReader streamReader)
      throws SerializationException {
    logger.info("Instantiating ObjectId.......");
    int time = streamReader.readInt();
    int machine = streamReader.readInt();
    Integer inc = streamReader.readInt();
    int counter = streamReader.readInt();

    try{ 
      return new ObjectId( time, machine, inc.shortValue(), counter );
    }catch(Exception e){
      e.printStackTrace();
      return ObjectId.createFromLegacyFormat(time, machine, inc);
    }
  }

  /**
   * @param streamWriter
   * @param instance
   * @throws SerializationException
   */
  public static void serialize(SerializationStreamWriter streamWriter, ObjectId instance)
      throws SerializationException {

    streamWriter.writeInt(instance.getTimestamp());
    streamWriter.writeInt(instance.getMachineIdentifier());
    streamWriter.writeShort(instance.getProcessIdentifier());
    streamWriter.writeInt(instance.getCounter());
  }
}
