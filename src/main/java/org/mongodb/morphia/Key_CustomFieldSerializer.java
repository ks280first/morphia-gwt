package org.mongodb.morphia;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Key_CustomFieldSerializer {
  public static void deserialize(SerializationStreamReader streamReader, Key instance)
      throws SerializationException {
    // already handled in instantiate
  }

  public static Key instantiate(SerializationStreamReader streamReader)
      throws SerializationException {
	  Object id = (Serializable) streamReader.readObject();
      String collection = streamReader.readString();
      Class klass = (Class) streamReader.readObject();
    return new Key( klass, collection, id);
  }

  public static void serialize(SerializationStreamWriter streamWriter, Key instance)
      throws SerializationException {
	  	streamWriter.writeObject(instance.getId());
		streamWriter.writeString(instance.getCollection());
		streamWriter.writeObject(instance.getType());
  }
}